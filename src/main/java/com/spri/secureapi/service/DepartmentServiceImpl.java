package com.spri.secureapi.service;

import com.spri.secureapi.error.DepartmentNotFoundException;
import com.spri.secureapi.model.Department;
import com.spri.secureapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        //returns optional toh convert it to get

        //return departmentRepository.findById(departmentId).get();
        Optional<Department> department=departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("Department Unavailable");

        }
        return  department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentid) {
        departmentRepository.deleteById(departmentid);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB=departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName()))
        {
            depDB.setDepartmentAddress(department.getDepartmentAddress());

        }
        depDB.setDepartmentCode(department.getDepartmentCode());
        depDB.setDepartmentName(department.getDepartmentName());
    return departmentRepository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }



}
