package edu.univ.manclub.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.univ.manclub.domain.JoinedList;
import edu.univ.manclub.domain.Students;
import edu.univ.manclub.service.ClubsService;
import edu.univ.manclub.service.StudentsService;

@Controller
public class StudentsController extends AbstractController {
	@Autowired
	StudentsService studentsService;
	@Autowired
	ClubsService clubsService;

	private StudentsController(){
		super(StudentsController.class);
	}

	@RequestMapping(value = "/registerStudent", method = RequestMethod.POST)
	public ModelAndView doRegisterStudent(Students student, HttpServletResponse response)
			throws Exception {
		// set level and association
		Students oldStd;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(student.getName().equals("")){
			out.println("<script> alert('이름을 입력해주세요.'); </script>");
		}
		else if(student.getStudentID().equals("")){
			out.println("<script> alert('학생ID를 입력해주세요.'); </script>");
		}
		else if(student.getStudentID().equals("")){
			out.println("<script> alert('암호를 입력해주세요.'); </script>");
		}
		else if(student.getDepartment() == 0){
			out.println("<script> alert('학과를 선택해주세요.'); </script>");
		}
		else {
			// Now get the student
			oldStd = studentsService.getStudentByStudentID(student.getStudentID());
			if (oldStd == null) {
				student.setLevel(0);
				student.setAssociation(0);
				studentsService.insertStudent(student);
				
				out.println("<script> alert('" + studentsService.getStudentByStudentID(student.getStudentID()).getName()
						+ "님 가입되셨습니다.'); </script>");
			} else {
				out.println("<script> alert('이미 가입된 학생 ID입니다.'); </script>");
				out.println("<script> history.go(-1); </script>");
			}
			out.println("<script> history.go(-2); </script>");
			return null;
			//String url = "redirect:/login";
			//return new ModelAndView(url);
		}
		out.println("<script> history.go(-1); </script>");
		return null;
	}

	@RequestMapping(value = "/club/askToJoinClub/{studentID}/{clubID}", method = RequestMethod.GET)
	public ModelAndView askToJoinClub(@PathVariable String studentID,
			@PathVariable String clubID, Model model,
			HttpServletResponse response) throws Exception {
		String registerID = new String(studentID+"+"+clubID);
		JoinedList isJoin = studentsService.getJoinedListByRegisterID(registerID);

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		if (isJoin == null) {
			JoinedList askjoinList = new JoinedList();
			askjoinList.setRegisterID(registerID);
			askjoinList.setStudentID(studentID);
			askjoinList.setClubID(clubID);
			askjoinList.setMember_grade(0);
			studentsService.insertStudentToJoinedList(askjoinList);
			out.println("<script> alert('동아리 "
					+ clubsService.getClubByClubID(clubID).getClub_name()
					+ "에 입부신청 되었습니다.'); </script>");
		} else {
			out.println("<script> alert('이미 가입(신청)된 동아리입니다.'); </script>");
		}
		out.println("<script> history.go(-1); </script>");
		return null;
	}

}
