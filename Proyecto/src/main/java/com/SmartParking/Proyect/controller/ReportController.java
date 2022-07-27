package com.SmartParking.Proyect.controller;

import com.SmartParking.Proyect.domain.Parking_Lot;
import com.SmartParking.Proyect.domain.Spot;
import com.SmartParking.Proyect.domain.User_Smart;
import com.SmartParking.Proyect.service.ParkingService;
import com.SmartParking.Proyect.service.ReportService;
import com.SmartParking.Proyect.service.SpotService;
import com.SmartParking.Proyect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/api/pdf")
@CrossOrigin(origins = "http://localhost:4200")
public class ReportController {
    @Autowired
    private UserService service;
    @Autowired
    private ParkingService serviceParking;
    @Autowired
    private SpotService serviceSpot;

    @GetMapping("/generate1")
    public void generatePDF1(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf"+currentDateTime+".pdf";

        response.setHeader(headerKey, headerValue);
        List<User_Smart> listUsers = service.listAllUser();
        List<Parking_Lot> listParking = serviceParking.listAll();
        List<Spot> listSpot = serviceSpot.listAll();

        ReportService exporter = new ReportService(listUsers, listParking, listSpot);
        exporter.export1(response);

    }

    @GetMapping("/generate2")
    public void generatePDF2(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf" +currentDateTime+ ".pdf";

        response.setHeader(headerKey, headerValue);

        List<Parking_Lot> listParking = serviceParking.listAll();
        List<User_Smart> listUsers = service.listAllUser();
        List<Spot> listSpot = serviceSpot.listAll();

        ReportService exporter = new ReportService(listUsers, listParking, listSpot);

        exporter.export2(response);
    }

    @GetMapping("/generate3")
    public void generatePDF3(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf" +currentDateTime+ ".pdf";

        response.setHeader(headerKey, headerValue);

        List<Parking_Lot> listParking = serviceParking.listAll();
        List<User_Smart> listUsers = service.listAllUser();
        List<Spot> listSpot = serviceSpot.listAll();

        ReportService exporter = new ReportService(listUsers, listParking, listSpot);

        exporter.export3(response);
    }


}
