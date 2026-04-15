package com.spring.security.basics.service;

import com.spring.security.basics.dto.AllLabourResponse;
import com.spring.security.basics.model.Labour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LabourService {

    private List<Labour> labourList;

    public LabourService() {
        labourList = new ArrayList<>(
                List.of(
                        (new Labour(1,"Harsh",10000, 22)),
                        (new Labour(2,"Varun",20000,23))
                )
        );
    }

    public List<AllLabourResponse> getAllLabours() {
        List<AllLabourResponse> resp = new ArrayList<>();
        labourList.forEach(x -> {
            AllLabourResponse response = new AllLabourResponse();
            response.setLabourId(x.getLabourId());
            response.setLabourName(x.getLabourName());
            response.setAge(x.getAge());
            response.setSalary(x.getSalary());
            resp.add(response);
        });
        return resp;
    }


}
