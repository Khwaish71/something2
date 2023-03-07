package com.spri.secureapi.service;

import com.spri.secureapi.error.DepartmentNotFoundException;
import com.spri.secureapi.model.Department;

import java.util.List;

public interface DepartmentService {
    public  Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentid);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
