/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Utils;

/**
 *
 * @author Lucas
 */
public class NumberUtil {
    
    public NumberUtil(){
        
    }
    
    public static Float toFloat(String s){
               
        return new Float( s.replace(",", ".") );
        
    }
            
    
    
}
