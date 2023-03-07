package com.spri.secureapi.controller;

import com.spri.secureapi.error.DepartmentNotFoundException;
import com.spri.secureapi.model.Department;
import com.spri.secureapi.service.DepartmentService;
import com.spri.secureapi.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private  final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of Department Controller");
        return  departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartment of Department Controller");

        return  departmentService.fetchDepartmentList();

    }

    @GetMapping("/departments/{id}")
    public  Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartmentById of Department Controller");

        return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentById(@PathVariable("id") Long departmentid){
         departmentService.deleteDepartmentById(departmentid);
        LOGGER.info("Inside fetchDepartment of Department Controller");

        return ("Successfullydeleted");
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
    return departmentService.updateDepartment(departmentId,department);
    }


    @GetMapping("/departments/name/{name}")
    public  Department fetchDepartmentByName(@PathVariable("name") String departmentName){
    return  departmentService.fetchDepartmentByName(departmentName);
    }
}
