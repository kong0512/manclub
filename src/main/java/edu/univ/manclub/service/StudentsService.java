package edu.univ.manclub.service;

import java.util.ArrayList;

import edu.univ.manclub.persistence.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.univ.manclub.domain.JoinedList;
import edu.univ.manclub.domain.Students;

@Service
public class StudentsService{
	@Autowired
    StudentsMapper studentsMapper;
	
	@Transactional
	public ArrayList<Students> getAllStudents(){
		return studentsMapper.getAllStudents();
	}
	
	@Transactional
	public ArrayList<Students> getAllStudentsByClubID(String ClubID){
		return studentsMapper.getAllStudentsByClubID(ClubID);
	}
	
	@Transactional
	public ArrayList<Students> getExcutiveStudentsByClubID(String ClubID){
		return studentsMapper.getExcutiveStudentsByClubID(ClubID);
	}
	
	@Transactional
	public ArrayList<Students> getStudentsInAssosiation(){
		return studentsMapper.getStudentsInAssosiation();
	}
	
	@Transactional
	public void insertStudent(Students student){
		studentsMapper.insertStudent(student);
	}
	@Transactional
	public Students getStudentByStudentID(String studentID){
		return studentsMapper.getStudentByStudentID(studentID);
	}
	@Transactional
	public void deleteStudentByStudentID(String studentID){
		studentsMapper.deleteStudentByStudentID(studentID);
	}
	
	@Transactional
	public void updateStudent(Students student){
		studentsMapper.updateStudent(student);
	}
	@Transactional
	public void updateStudentToJoinedList(JoinedList joined){
		studentsMapper.updateStudentToJoinedList(joined);
	}

	@Transactional
	public void deleteStudentToJoinedList(String registerID){
		studentsMapper.deleteStudentToJoinedList(registerID);
	}
	
	@Transactional
	public void insertStudentToJoinedList(JoinedList joined){
		studentsMapper.insertStudentToJoinedList(joined);
	}
	@Transactional
	public ArrayList<Students> getRegisteringStudentByClubID(String clubID){
		return studentsMapper.getRegisteringStudentByClubID(clubID);
	}
	@Transactional
	public JoinedList getJoinedListByRegisterID(String registerID){
		return studentsMapper.getJoinedListByRegisterID(registerID);
	}
	
	
	@Transactional
	public ArrayList<Students> getStudentOutAssosiation(){
		return studentsMapper.getStudentOutAssosiation();
	}
	@Transactional
	public void updateStudentAssosiation(Students student){
		studentsMapper.updateStudentAssociation(student);
	}

	@Transactional
		public ArrayList<JoinedList> getJoinedListByStudentID(String studentID){
		return studentsMapper.getJoinedListByStudentID(studentID);
	}
}
