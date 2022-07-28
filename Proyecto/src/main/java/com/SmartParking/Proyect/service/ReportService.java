package com.SmartParking.Proyect.service;

import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.Spot;
import com.SmartParking.Proyect.domain.User_Smart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;

@Service
public class ReportService {

    private List<User_Smart> listUsers;
    private List<Parking_Lot> listParking;
    private List<Spot> listSpot;
    private int cuentaAdmin;
    private int cuentaOpe;
    private int cuentaClient;

    public ReportService(List<User_Smart> listUsers, List<Parking_Lot> listParking, List<Spot> listSpot) {
        this.listUsers = listUsers;
        this.listParking = listParking;
        this.listSpot = listSpot;
    }

    public ReportService() {

    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("User ID", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Identification", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Telephone", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Role", font));
        table.addCell(cell);
    }

    private void writeTableData(PdfPTable table) {
        for (User_Smart user : listUsers) {
            table.addCell(String.valueOf(user.getId_User()));
            table.addCell(user.getIdentification());
            table.addCell(user.getName()+" "+user.getLast_Name());
            table.addCell(user.getTel_Number());
            table.addCell(user.getRole().getName());

            if(user.getRole().getId_Role() == 1){
                cuentaAdmin = cuentaAdmin + 1;
            }
            if(user.getRole().getId_Role() == 2){
                cuentaOpe = cuentaOpe + 1;
            }
            if(user.getRole().getId_Role() == 3){
                cuentaClient = cuentaClient + 1;
            }
        }
    }

    public void export1(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Primer Reporte", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph1 = new Paragraph("El siguiente reporte nos sera de utilidad para saber" +
                                                    " la cantidad de roles por usurarios de la empresa:", fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph1);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        Font fontParagraph1 = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph2 = new Paragraph("La cantidad de administradores en el sistema: "+cuentaAdmin+
                "La cantidad de operadores en el sistema: "+cuentaOpe+
                "La cantidad de clientes en el sistema: "+cuentaClient, fontParagraph1);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph2);

        document.close();

    }


    //////////////////////Reporte 2////////////////////

    private void writeTableHeader2(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Name", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Capacity", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Province", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("City", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("District", font));
        table.addCell(cell);

    }


    private void writeTableData2(PdfPTable table) {

        for (Parking_Lot parkingLot : listParking) {
            if(parkingLot.getCapacity() >= 55) {
                table.addCell(parkingLot.getName());
                table.addCell(String.valueOf(parkingLot.getCapacity()));
                table.addCell(parkingLot.getProvince());
                table.addCell(parkingLot.getCity());
                table.addCell(parkingLot.getDistrict());
            }
        }
    }


    public void export2(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Segundo Reporte", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph1 = new Paragraph("El siguiente reporte nos sera de utilidad para conocer los parqueos disponibles que tengan una cantidad de espacios disponibles mayor a 55:", fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph1);


        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader2(table);
        writeTableData2(table);

        document.add(table);

        document.close();
    }



//////////////////////////reporte 3/////////////////////////


    private void writeTableHeader3(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Number Spot", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Type", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Vehicle License", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Vehicle Brand", font));
        table.addCell(cell);
    }

    private void writeTableData3(PdfPTable table) {

        for (Parking_Lot parkingLot : listParking) {
            for (Spot spot : listSpot){
                if(parkingLot.getId_Parking_Lot() == spot.getParking_lot().getId_Parking_Lot()) {
                    if(spot.getVehicle().getId_Vehicle() != 0) {
                        table.addCell(String.valueOf(spot.getNumber()));
                        table.addCell(spot.getType());
                        table.addCell(spot.getStatus());
                        table.addCell(spot.getVehicle().getLicense_Plate());
                        table.addCell(spot.getVehicle().getBrand());
                    }
                }
            }
        }
    }



    public void export3(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph paragraph = new Paragraph("Tercer Reporte", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);

        Paragraph paragraph1 = new Paragraph("El siguiente reporte nos sera de utilidad para saber cuales son los vehiculos con sus respectivos espacios en los diferentes parqueos", fontParagraph);
        paragraph1.setAlignment(Paragraph.ALIGN_LEFT);

        document.add(paragraph);
        document.add(paragraph1);

        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);

        writeTableHeader3(table);
        writeTableData3(table);

        document.add(table);

        document.close();
    }

}
