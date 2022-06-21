/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILS;

import MODEL.KategoriModel;
import MODEL.UrunModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author Uğurcann
 */
public class MyTreeModel {

  
    public static DefaultTreeModel CreateTree() throws SQLException {
        
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
        return new DefaultTreeModel(Menu);
    }
}
