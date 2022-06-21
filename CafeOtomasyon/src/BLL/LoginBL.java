/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import MODEL.UserModel;
import UTILS.DB;
import java.sql.*;


public class LoginBL {
    
    
    public UserModel LoginControl(String userName,String password) throws SQLException{
        DB db=new DB();
        Connection con=db.CreateConnection();
        String query = "select * from tblUser u where u.UserName=? and u.Password=?";
        
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, password);
            
            
            ResultSet rs=ps.executeQuery();
            UserModel user=null;

             while(rs.next())
            {
                user=new UserModel();
                user.name=rs.getString("Name");
                user.surname=rs.getString("SurName");
                
            }
             rs.close();
             return user;
        } catch (SQLException ex) {
            throw ex;
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
