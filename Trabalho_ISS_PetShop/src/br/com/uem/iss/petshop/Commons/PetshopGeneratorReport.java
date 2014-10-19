/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.uem.iss.petshop.Commons;

import java.util.Collection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author EDUARDO
 */
public class PetshopGeneratorReport {

    public PetshopGeneratorReport() {
    }

    public Boolean generateReport(String reportName, Collection<?> collection) {
        JasperReport report;
        try {
            report = JasperCompileManager.compileReport("reports/"+reportName+".jrxml");
            JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(collection));
            JasperExportManager.exportReportToPdfFile(print,"reports/"+reportName+".pdf");
        } catch (JRException e) {
            e.printStackTrace();
            System.out.println("Erro ao gerar o relatorio");
            return false;
        }
        return true;
    }

}
