package edu.univ.manclub.service;

import edu.univ.manclub.domain.Departments;
import edu.univ.manclub.persistence.DepartmentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentsService {
	@Autowired
    DepartmentsMapper departmentMapper;
	@Transactional
	public void insertDepartment(Departments department){
		departmentMapper.insertDepartment(department);
	}
	@Transactional
	public void updateDepartment(Departments department){
		departmentMapper.updateDepartment(department);
	}
	@Transactional
	public void deleteDepartment(int departmentID){
		departmentMapper.deleteDepartment(departmentID);
	}
	
}
