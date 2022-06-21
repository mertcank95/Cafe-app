
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILS;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author LAB2-OGR19
 */
public class DB {
    String constr="jdbc:sqlserver://localhost:1433;databasename=DB_Cafe";
    String user="sa";
    String psw="123";
    public Connection con=null;
    public DB(){
        CreateConnection();
    }
    public Connection CreateConnection(){
       
        try {
            con=DriverManager.getConnection(constr,user,psw);
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Bir Hata Oluştu.Oluştu"+e.getMessage());
           
        }
        return con;
    }
    
    
       public Connection getConnection(){
           
        return con;
    }
    
            
}

