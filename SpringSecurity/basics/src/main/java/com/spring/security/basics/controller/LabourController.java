package com.spring.security.basics.controller;

import com.spring.security.basics.dto.AddLabourRequest;
import com.spring.security.basics.dto.AllLabourResponse;
import com.spring.security.basics.service.CustomUserDetailsService;
import com.spring.security.basics.model.Labour;
import com.spring.security.basics.model.User;
import com.spring.security.basics.service.LabourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/labour")
    public void addNewLabour(@RequestBody AddLabourRequest labourRequest) {
        labourService.addLabour(labourRequest);
    }

    @GetMapping("/labour/{id}")
    public Labour viewSpecificLabour(@PathVariable(name = "id") int id) {
        return labourService.getSpecificLabour(id);
    }

    @DeleteMapping("/labour/{id}")
    public String viewDelete(@PathVariable(name = "id") int id) {
        return labourService.deleteLabour(id);
    }
}
