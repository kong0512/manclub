package edu.univ.manclub.persistence;

import edu.univ.manclub.domain.Departments;

public interface DepartmentsMapper {
	public void insertDepartment(Departments department);
	public void updateDepartment(Departments department);
	public void deleteDepartment(int DepartmentID);
	
}
