package com.spri.secureapi.repository;

import com.spri.secureapi.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    //to pass query
    //@Query(value ="" ,nativeQuery = true)
    public Department findByDepartmentName(String departmentName);

    //to ignore case comparision
    public Department findByDepartmentNameIgnoreCase(String departmentName);


}
