/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import MODEL.UrunModel;
import UTILS.DB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Uğurcann
 */
public class AdisyonBLL {

    DB db = new DB();
    Connection con = db.CreateConnection();

    long millis = System.currentTimeMillis();
    java.sql.Date date = new java.sql.Date(millis);

    public boolean AdisyonAç(int MasaId) throws SQLException {

        String sql = "insert into tblAdisyon(MasaId,Tarih) values(?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, MasaId);
        pst.setDate(2, date);
        return pst.executeUpdate() > 0;
    }

    public boolean AdisyonKapat(float ToplamHesap, int MasaId) throws SQLException {

        String proc = "{call spAdisyonKapat(?,?)}";
        CallableStatement cs = con.prepareCall(proc);
        cs.setFloat(1, ToplamHesap);
        cs.setInt(2, MasaId);
        return cs.executeUpdate() > 0;
    }

    public ResultSet AdisyonGetir(int MasaId) throws SQLException {

        String proc = "{call spAdisyonGetir(?)}";
        CallableStatement cs = con.prepareCall(proc);
        cs.setInt(1, MasaId);
        ResultSet rs = cs.executeQuery();
        return rs;

    }

    public boolean AdisyonUrunEkle(int MasaId, UrunModel u, float Miktar) throws SQLException {
        String proc = "{call spAdisyonUrunEkle(?,?,?,?)}";
        CallableStatement cs = con.prepareCall(proc);
        cs.setInt(1, MasaId);
        cs.setInt(2, u.urunId);
        cs.setFloat(3, u.urunBirimFiyati);
        cs.setFloat(4, Miktar);
        return cs.executeUpdate() > 0;
    }

    public boolean AdisyonUrunSil(int HesapId) throws SQLException {
        String sql = "delete tblHesap where HesapId=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, HesapId);
        return ps.executeUpdate() > 0;
    }

    public boolean AdisyonUrunGuncelle(int HesapId, UrunModel u, float Miktar) throws SQLException {
        String proc = "{call spAdisyonUrunGuncelle(?,?,?,?)}";
        CallableStatement cs = con.prepareCall(proc);
        cs.setInt(1, HesapId);
        cs.setInt(2, u.urunId);
        cs.setFloat(3, u.urunBirimFiyati);
        cs.setFloat(4, Miktar);
        return cs.executeUpdate() > 0;
    }

    public boolean AdisyonVarMı(int MasaId) throws SQLException {
        boolean Adisyon = false;
        String sql = "select * from tblAdisyon a where a.MasaId=? and a.Aktif=1";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, MasaId);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            Adisyon = true;
        }
        return Adisyon;
    }

}
