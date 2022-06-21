/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTILS;

import javax.swing.DefaultComboBoxModel;


public class MyComboBoxModel {
     public static DefaultComboBoxModel getComboModel(Object[] xliste){
        DefaultComboBoxModel mymodel = new DefaultComboBoxModel(xliste);
        //return mymodel;        
        return new DefaultComboBoxModel(xliste);
    }
    
}
