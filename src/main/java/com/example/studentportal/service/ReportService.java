package com.example.studentportal.service;

import com.example.studentportal.dao.ReportDao;
import com.example.studentportal.model.Report;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    public int addReport(MultipartFile file,Report r) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Report rt = new Report(r.getrId(),r.getStudentId(),r.getReportNo(),
                file.getBytes(),r.getReportName(), file.getContentType(),r.getReportDate(),
                r.getExternalStatus(),r.getInternalStatus());
        reportDao.save(rt);
        return 1;
    }

    public int addAppReport(MultipartFile file,Report r) throws IOException {
        //System.out.println("obj "+r);
        for (int element: r.getReportData()) {
            System.out.print(element);
        }
        //String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Report rt = new Report(r.getrId(),r.getStudentId(),r.getReportNo(),
                r.getReportData(),r.getReportName(), r.getReportType(),r.getReportDate(),
                r.getExternalStatus(),r.getInternalStatus());
        reportDao.save(rt);
        return 1;
    }



    public Report findReportById(String id) {
        return reportDao.findById(id).orElse(null);
    }

    public List<Report> findReportByStudentId(String id) {
        for (Report report : reportDao.findReportByStudentId(id)) {
            byte[] encoded = Base64.getEncoder().encode(report.getReportData());
            System.out.println("Report Name : "+report.getReportName()+
                    "\n Report Data : " + new String(encoded));
        }
        return reportDao.findReportByStudentId(id);
    }

    public int deleteReportById(String id) {
        reportDao.deleteById(id);
        return 1;
    }

    public void updateReport(Report r) {
        reportDao.findById(r.getrId()).map(s -> {
            s.setStudentId(r.getStudentId());
            s.setReportName(r.getReportName());
            s.setInternalStatus(r.getInternalStatus());
            s.setReportNo(r.getReportNo());
            s.setExternalStatus(r.getExternalStatus());
            s.setReportData(r.getReportData());
            s.setReportDate(r.getReportDate());
            s.setReportType(r.getReportType());
            reportDao.save(s);
            return 1;
        });
    }
}
