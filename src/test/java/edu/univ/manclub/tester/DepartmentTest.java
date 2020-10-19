package edu.univ.manclub.tester;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.univ.manclub.domain.Departments;
import edu.univ.manclub.service.DepartmentsService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:edu/univ/manclub/config/testContext.xml","classpath:edu/univ/manclub/config/test-context.xml"})


public class DepartmentTest {
	@Resource(name = "DepartmentsService")
	private DepartmentsService departmentsService;
	
	@Test
	public void setDepartment(){
		
		//insert Department Test
		Departments department = new Departments();
		department.setDepartmentID(123);
		department.setName("computer");
		
		departmentsService.insertDepartment(department);
		assertNotNull(department);
		
		//update Department Test
		Departments department1;
		department1 = department;
		department1.setName("mathematics");
		
		departmentsService.updateDepartment(department1);
		assertEquals(department1.getName(),"mathematics");
		
		//Delete Department Test
		departmentsService.deleteDepartment(department.getDepartmentID());
		
	}
}