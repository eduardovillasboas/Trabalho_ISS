/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Utils;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author EDUARDO
 */
public class DateUtil {

    public DateUtil() {
    }
    
    public String toString(Date date){
        String year;
        String month;
        String day;
        if (date.getYear() == -1 &&
                date.getMonth() == 11 &&
                date.getDate() == 31)
            return "";
        
        year = Integer.toString(date.getYear()).trim();
        month = Integer.toString(date.getMonth()+1).trim();
        day = Integer.toString(date.getDate()).trim();
        
        if (month.length() == 1)
            month = "0"+month;
        
        if (day.length() == 1)
            day = "0"+day;
        
        
        return day+"/"+month+"/"+year;
    }
    
    public Date getCurrentDate(){
        Date date;
        Calendar c = Calendar.getInstance();
        date = c.getTime();
        return date;
    }
    
    public Date toDate(String string){
        String values[];
        if (string.trim().length() == 0)
            return new Date(0, 0, 0);
        
        values = string.split("/");
        
        return new Date(Integer.parseInt(values[2]),
                        Integer.parseInt(values[1])-1,
                        Integer.parseInt(values[0]));
    }
 
    public Boolean isValid(String string){
        String values[];
        values = string.split("/");
        if (values.length != 3)
            return false;
        int year = Integer.parseInt(values[2]);
        int month = Integer.parseInt(values[1]);
        int day = Integer.parseInt(values[0]);

        return !(year < 1900 || day < 1 || day > 31 || month < 1 || month > 12);
    }

    public boolean before(Date date, Date currentDate) {
        Date data = toDate(toString(currentDate));
        return date.before(data);
    }
}
