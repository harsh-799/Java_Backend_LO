package com.spring.security.basics.controller;

import com.spring.security.basics.dto.AllLabourResponse;
import com.spring.security.basics.service.LabourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LabourController {

    private LabourService labourService;

    @Autowired
    public LabourController(LabourService labourService) {
        this.labourService = labourService;
    }

    @GetMapping("/labours")
    public List<AllLabourResponse> getAllLabours() {
        return labourService.getAllLabours();
    }
}
