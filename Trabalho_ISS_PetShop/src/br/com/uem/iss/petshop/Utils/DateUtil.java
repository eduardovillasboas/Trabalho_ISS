/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Utils;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author EDUARDO
 */
public class DateUtil {

    private Date today;
    final private String DATE_FORMAT = "dd/MM/yyyy";
    public DateUtil() {
        today = Calendar.getInstance().getTime();
    }
    
    public String toString(Date date){
        String dateString = "";
        DateFormat df = new SimpleDateFormat(DATE_FORMAT);
        try {
            dateString = df.format(date);
        } catch (Exception e) {
            System.out.printf("erro ao converter a data", date);
        }
        return dateString;
    }
    
    public Date getCurrentDate(){
        Date date;
        Calendar c = Calendar.getInstance();
        date = c.getTime();
        return date;
    }
    
    public Date toDate(String string){
        Date date = today;
        DateFormat df = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        try {
            date = df.parse(string);
        } catch (Exception e) {
            System.out.println("Erro ao converter a string "+string);
        }
        return date;
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
