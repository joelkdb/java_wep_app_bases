/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joel.webapp.excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import org.primefaces.event.FileUploadEvent;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletContext;

/**
 *
 * @author Mikel
 */
@ManagedBean
@ViewScoped
public class ExcelManagedBean implements Serializable {

   

   

    private InputStream inptStrm;


    public ExcelManagedBean() {
        
    }

   

//    public void handleFileUpload(FileUploadEvent event) {
//        try {
//            String image = String.valueOf((int) (Math.random() * 10000000));
//            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//            String newFileName = servletContext.getRealPath("") + File.separator + "resources" + File.separator + "images" + File.separator + image + event.getFile().getFileName();
//            InputStream inputStream = event.getFile().getInputstream();
//            inptStrm = event.getFile().getInputstream();
//            cheminAbsolu = "/resources/images/" + image + event.getFile().getFileName();
//            ImageOutputStream out = new FileImageOutputStream(new File(newFileName));
//            int read = 0;
//            byte[] bytes = new byte[1024];
//            while ((read = inputStream.read(bytes)) != -1) {
//                out.write(bytes, 0, read);
//            }
//            inputStream.close();
//            out.flush();
//            out.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void importer() throws IOException {
//        if (inptStrm != null) {
//            ArrayList<String> values = new ArrayList<String>();
//            try {
//                InputStream input = inptStrm;
//                XSSFWorkbook wb = new XSSFWorkbook(input);
//                XSSFSheet sheet = wb.getSheetAt(0);
//                XSSFRow v = sheet.getRow(0);
//                Iterator rows = sheet.rowIterator();
//                while (rows.hasNext()) {
//                    values.clear();
//                    XSSFRow row = (XSSFRow) rows.next();
//                    //if (row.getRowNum() > 0) {
//                    Iterator cells = row.cellIterator();
//
//                    while (cells.hasNext()) {
//                        XSSFCell cell = (XSSFCell) cells.next();
//
//                        if (XSSFCell.CELL_TYPE_NUMERIC == cell.getCellType()) {
//                            values.add(Integer.toString((int) cell.getNumericCellValue()));
//                        } else if (XSSFCell.CELL_TYPE_STRING == cell.getCellType()) {
//                            values.add(cell.getStringCellValue());
//                        }
//                    }
//
//                    //Les données se retrouve dans un tableau de String
//                    //NB: chaque valeur du tableau values correspond aux données d'une ligne du fichier excel
//                }
//
//                inptStrm = null;
//            } catch (Exception ex) {
//                System.out.println("Erreur");
//                ex.printStackTrace();
//            }
//        } else {
//            Mtm.mikiMessageWarn("Veuillez choisir le fichier a importer svp !");
//        }
//
//    }

    public void annulerImporter() {
        inptStrm = null;
    }

    public InputStream getInptStrm() {
        return inptStrm;
    }

    public void setInptStrm(InputStream inptStrm) {
        this.inptStrm = inptStrm;
    }

}
