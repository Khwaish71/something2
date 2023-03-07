package com.spri.secureapi.service;

import com.spri.secureapi.model.Department;
import com.spri.secureapi.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;


    @MockBean
    private DepartmentRepository departmentRepository;
    //for earch test case
    //@Before All once for
    @BeforeEach
    void setUp() {
        //builder used instead of constructors and passing everything
        //even for all different parameterised constructors
    Department department=Department.builder()
            .departmentId(1L)
            .departmentAddress("Pune")
            .departmentCode("IT_09")
            .departmentName("IT")
            .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    //@Disabled for disabling test case
    //for report generation
    @DisplayName("Get Data based on valid department case")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName="IT";
        Department found= departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }

    @Test
    @DisplayName("Get No Data when invalid department")
    public void whenInvalidDepartmentName_thenDepartmentNotFound(){
        String departmentName="FY";
        Department found=departmentService.fetchDepartmentByName(departmentName);
        assertNull(found);
    }

}