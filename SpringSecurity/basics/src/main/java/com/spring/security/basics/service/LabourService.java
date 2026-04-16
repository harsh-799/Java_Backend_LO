package com.spring.security.basics.service;

import com.spring.security.basics.dto.AddLabourRequest;
import com.spring.security.basics.dto.AllLabourResponse;
import com.spring.security.basics.model.Labour;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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


    public void addLabour(AddLabourRequest labourRequest) {
        Labour labour = new Labour(labourRequest.getLabourId(), labourRequest.getLabourName(), labourRequest.getSalary(), labourRequest.getAge());
        labourList.add(labour);
    }

    public Labour getSpecificLabour(int id) {
        for (Labour lab : labourList) {
            if (lab.getLabourId() == id) return lab;
        }

        return null;
    }

    public String deleteLabour(int id) {
        ListIterator<Labour> it = labourList.listIterator();
        while (it.hasNext()) {
            Labour curr = it.next();
            if (curr.getLabourId() == id ) {
                it.remove();
            return curr.getLabourId() + " " + curr.getLabourName() + " "+ "Removed";
            }
        }
        return "Not found ";
    }
}
