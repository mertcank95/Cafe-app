/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import MODEL.KategoriModel;
import MODEL.UrunModel;
import UTILS.DB;
import VIEW.frmMain;
import java.awt.Label;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;


public class MenuBLL {

    public UrunModel Secilen;

    public void CreateTree(JPanel p, JTextField BirimFiyat, JLabel UrunAd, JLabel MiktarTip) throws SQLException {
        DefaultMutableTreeNode Menu = new DefaultMutableTreeNode("Menü");
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "select * from tblKategori";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        KategoriModel km = null;
        DefaultMutableTreeNode Kategori = null;
        DefaultMutableTreeNode Urun = null;
        while (rs.next()) {
            km = new KategoriModel();
            km.kategoriId = rs.getInt("KategoriId");
            km.kategoriAd = rs.getString("KategoriAd");
            Kategori = new DefaultMutableTreeNode(km);
            Menu.add(Kategori);

            String sql2 = "select * from tblUrun where KategoriId=?";
            PreparedStatement ps = con.prepareStatement(sql2);
            ps.setInt(1, km.kategoriId);
            ResultSet dr = ps.executeQuery();
            while (dr.next()) {
                UrunModel u = new UrunModel();
                u.urunAdi = dr.getString("Urunadi");
                u.urunId = dr.getInt("UrunId");
                u.urunBirimFiyati = dr.getFloat("UrunBirimFiyati");
                u.kategoriId = dr.getInt("KategoriId");
                u.miktarTipi = dr.getString("MiktarTipi");
                Urun = new DefaultMutableTreeNode(u);
                Kategori.add(Urun);

            }
        }

        JTree tree = new JTree(Menu);
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                    Object nodeInfo = node.getUserObject();
                    if (node.isLeaf()) {
                        Secilen = (UrunModel) nodeInfo;
                        UrunAd.setText(Secilen.urunAdi);
                        BirimFiyat.setText(String.valueOf(Secilen.urunBirimFiyati));
                        MiktarTip.setText(Secilen.miktarTipi);
                    }
                }

            }
        });

        tree.setBackground(new java.awt.Color(204, 255, 255));
        tree.setSize(200, 500);
        p.add(tree);

    }

    public boolean KategoriGuncelle(KategoriModel km) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "update tblKategori set KategoriAd=? where  KategoriId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, km.kategoriAd);
        ps.setInt(2, km.kategoriId);
        return ps.executeUpdate() > 0;
    }

    public boolean KategoriEkle(String kategoriAdi) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "insert into  tblKategori(KategoriAd) values(?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setNString(1, kategoriAdi);
        return ps.executeUpdate() > 0;
    }

    public boolean KategoriSil(int KategoriId) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "delete from tblKategori where KategoriId=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, KategoriId);
        return ps.executeUpdate() > 0;
    }

    public boolean UrunEkle(UrunModel um) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "insert into tblUrun(KategoriId,Urunadi,UrunBirimFiyati,MiktarTipi) values (?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, um.kategoriId);
        ps.setString(2, um.urunAdi);
        ps.setFloat(3, um.urunBirimFiyati);
        ps.setString(4, um.miktarTipi);
        return ps.executeUpdate() > 0;
    }

    public boolean UrunGuncelle(UrunModel um) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "update tblUrun set KategoriId=?,Urunadi=?,UrunBirimFiyati=?,MiktarTipi=? where UrunId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, um.kategoriId);
        ps.setString(2, um.urunAdi);
        ps.setFloat(3, um.urunBirimFiyati);
        ps.setString(4, um.miktarTipi);
        ps.setInt(5, um.urunId);
        return ps.executeUpdate() > 0;
    }

    public boolean UrunSil(int UrunId) throws SQLException {
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "delete from tblUrun where UrunId=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, UrunId);
        return ps.executeUpdate() > 0;
    }

    public static java.util.List<KategoriModel> loadKategori() throws SQLException {
        java.util.List<KategoriModel> KategoriList;
        KategoriList = new ArrayList<KategoriModel>();
        DB db = new DB();
        Connection con = db.CreateConnection();
        String sql = "select * from tblKategori";

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            KategoriModel km = new KategoriModel();
            km.kategoriAd = rs.getString("KategoriAd");
            km.kategoriId = rs.getInt("KategoriId");
            KategoriList.add(km);

        }
        rs.close();
        return KategoriList;

    }

    public KategoriModel getKategori(int katid) {
        KategoriModel xkat = null;
        String sql = "Select * from tblKategori where KategoriId = ?";
        DB db = new DB();
        Connection con = db.CreateConnection();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, katid);
            rs = ps.executeQuery();
            if (rs.next()) {
                xkat = new KategoriModel();
                xkat.kategoriId = rs.getInt("KategoriId");
                xkat.kategoriAd = rs.getString("KategoriAd");
            }
        } catch (SQLException ex) {
            System.out.println("BLL.MenuBLL.getKategori()" + ex.getMessage());
        }

        return xkat;
    }
}
