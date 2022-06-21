/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import MODEL.MasaModel;
import UTILS.DB;
import UTILS.MyMasaPanel;
import UTILS.MyTableModel;
import VIEW.frmMain;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author LAB2-OGR10
 */
public class MasaBL {

    public static MasaModel mx;

    public void loadMasa(JPanel pnl) {
        //clearAllMasa();
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "select * from tblMasa";
        //AdisyonBLL abl = new AdisyonBLL();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                MasaModel m = new MasaModel();

                m.masaId = rs.getInt("MasaId");
                m.masaAdi = rs.getString("MasaNo");
                m.dolu = rs.getBoolean("DoluBos");
                mx = m;

                MyMasaPanel px = new MyMasaPanel(m);
                px.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        if (evt.getClickCount() == 2) {
                            frmMain.lblSecilenMasa.setText(m.masaAdi);
                            frmMain.SecilenMasaId = m.masaId;
                            mx = m;

                            frmMain.TableSetModel();

                            // frmMain.txtToplamFiyat.setText(String.valueOf(frmMain.ToplamHesap()));
                        }
//                        

                    }
                });

                pnl.add(px);
                pnl.invalidate();
                pnl.validate();
                pnl.repaint();
            }

        } catch (Exception e) {
        }

    }

    public void updateMasa(MasaModel mm) {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "update  tblMasa set doluBos = ? where MasaId = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setBoolean(1, mm.dolu);
            pst.setInt(2, mm.masaId);
            pst.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hata: " + e.getMessage());
        }

    }

    public void clearAllMasa(JPanel pnl) {
        Component[] components = pnl.getComponents();
        pnl.removeAll();
        /*
        for (Component component : components) {
            if (component.getClass().equals(JPanel.class)) {
                pnlMasa.remove(component);
            }
        }
         */
        pnl.invalidate();
        pnl.validate();
        pnl.repaint();

    }

    public boolean MasaEkle(MasaModel m) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "insert into tblMasa(MasaNo) values (?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, m.masaAdi);
        return ps.executeUpdate() > 0;

    }

    public boolean MasaGüncelle(MasaModel m) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "update tblMasa set MasaNo=? where MasaId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, m.masaAdi);
        ps.setInt(2, m.masaId);
        return ps.executeUpdate() > 0;

    }

    public boolean MasaSil(int MasaId) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "delete tblMasa where MasaId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, MasaId);
        return ps.executeUpdate() > 0;

    }

}
