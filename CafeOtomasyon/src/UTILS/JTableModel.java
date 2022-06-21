/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILS;

import MODEL.UserModel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class JTableModel extends AbstractTableModel {
    
    
    static String[] sutunlar = {"id",  "Ad", "Soyad", "kullanici ad", "sifre"};
    public static List<UserModel> xliste;
            
    public JTableModel(){
        if(xliste == null)
            xliste = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        if(xliste != null)
            return xliste.size();
        else
            return 0;
    }

    @Override
    public int getColumnCount() {
        return sutunlar.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        
        return sutunlar[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {        
        Object value = null;        
        UserModel a = xliste.get(rowIndex);
        
        switch (columnIndex) {
            case 0: value = a.id;
            break;
            
            case 1: value = a.name;
            break;
            
            case 2: value = a.surname;
            break;  
            
            case 3: value = a.username;
            break;              
                
            case 4: value = a.password;
            break;             
           
        }        
        return value;
    }
    
}