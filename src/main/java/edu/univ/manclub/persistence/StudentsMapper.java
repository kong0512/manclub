package edu.univ.manclub.persistence;

import java.util.ArrayList;

import edu.univ.manclub.domain.JoinedList;
import edu.univ.manclub.domain.Students;

public interface StudentsMapper {
	public ArrayList<Students> getAllStudents();
	public ArrayList<Students> getAllStudentsByClubID(String clubID);
	public ArrayList<Students> getExcutiveStudentsByClubID(String clubID);
	public ArrayList<Students> getStudentsInAssosiation();
	public void insertStudent(Students student);
	public Students getStudentByStudentID(String studentID);
	public void deleteStudentByStudentID(String studentID);
	public void updateStudent(Students student);
	public ArrayList<Students> getRegisteringStudentByClubID(String clubID);
	public void insertStudentToJoinedList(JoinedList joined);
	public void updateStudentToJoinedList(JoinedList joined);
	public JoinedList getJoinedListByRegisterID(String registerID);
	public ArrayList<JoinedList> getJoinedListByStudentID(String studentID);
	public ArrayList<Students> getStudentOutAssosiation();
	public void updateStudentAssociation(Students student);
	public void deleteStudentToJoinedList(String registerID);
}

