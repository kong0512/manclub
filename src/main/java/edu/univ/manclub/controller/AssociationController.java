package edu.univ.manclub.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import edu.univ.manclub.service.ClubCategoryService;
import edu.univ.manclub.service.ClubsService;
import edu.univ.manclub.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.univ.manclub.domain.ClubCategory;
import edu.univ.manclub.domain.Clubs;
import edu.univ.manclub.domain.JoinedList;
import edu.univ.manclub.domain.Students;

@Controller
public class AssociationController extends AbstractController {
	@Autowired
	private ClubsService clubsService;

	@Autowired
	private ClubCategoryService categoryService;

	@Autowired
	private StudentsService studentsService;

	private AssociationController(){
		super(AssociationController.class);
	}
	
	@RequestMapping(value = "/association/manageAssociation")
	public String manageAssociation(Model model, HttpServletResponse response) {
		List<Students> studentslist;
		Students currentStudent;
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "manageAssociation");
		try {
			studentslist = studentsService.getStudentsInAssosiation();
			currentStudent = studentsService.getStudentByStudentID(getCurrentUserID());
			if(currentStudent.getAssociation() == 0){
				// if the student does not have association authority
				// print error and goes back to where he/she was
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('접근 권한이 없습니다.');");
				out.println("</script>");
				out.println("<script> history.go(-1); </script>");
				return null;
			}
			model.addAttribute("studentslist", studentslist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "manageAssociation";

	}

	@RequestMapping(value = "/association/manageClubs", method = RequestMethod.GET)
	public String manageClubs(Model model) {
		// list ask accept clubs
		List<Clubs> askAcceptclubList;
		List<Clubs> AcceptedclubList;
		List<ClubCategory> categoryList;
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "manageClubs");
		try {
			askAcceptclubList = clubsService.getAskAcceptClubs();
			AcceptedclubList = clubsService.getAllAcceptedClubs();
			categoryList = categoryService.getAllCategory();
			model.addAttribute("askAcceptclubList", askAcceptclubList);
			model.addAttribute("AcceptedclubList", AcceptedclubList);
			model.addAttribute("categoryList", categoryList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "manageClubs";
	}

	@RequestMapping(value = "/association/manageClubs/accept/{clubID}", method = RequestMethod.GET)
	public ModelAndView acceptClub(@PathVariable String clubID, Model model,
			HttpServletResponse response) {
		List<Clubs> clubList;
		Clubs acceptClub;
		try {
			// accept club
			acceptClub = clubsService.getClubByClubID(clubID);
			if (acceptClub.isAccepted()) {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('이미 승인되었습니다.');");
				out.println("</script>");
				out.println("<script> history.go(-1); </script>");
			} else {
				acceptClub.setAccepted(true);
				clubsService.updateClub(acceptClub);
				clubList = clubsService.getAskAcceptClubs();
				model.addAttribute("clubList", clubList);

				String url = "redirect:/association/manageClubs";
				return new ModelAndView(url);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	@RequestMapping(value = "/association/manageClubs/decline/{clubID}", method = RequestMethod.GET)
	public ModelAndView declineClub(@PathVariable String clubID, Model model) {
		List<Clubs> clubList;
		try {

			// decline club
			clubsService.deleteClub(clubID);

			clubList = clubsService.getAskAcceptClubs();
			model.addAttribute("clubList", clubList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		String url = "redirect:/association/manageClubs";
		return new ModelAndView(url);

	}

	@RequestMapping(value = "/association/addMember")
	public String addMember(Model model) {
		List<Students> studentslist;
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "manageAssociation");
		try {
			studentslist = studentsService.getStudentOutAssosiation();
			model.addAttribute("studentslist", studentslist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "addMember";

	}

	@RequestMapping(value = "/association/doAddMember/{studentID}")
	public ModelAndView doAddMember(@PathVariable String studentID, Model model) {
		try {
			//System.out.println(studentID);
			studentsService.updateStudentAssosiation(studentsService
					.getStudentByStudentID(studentID));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String url = "redirect:/association/manageAssociation";
		return new ModelAndView(url);
	}
	
	@RequestMapping(value = "/association/meeting")
	public String meeting(Model model){
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "meeting");
		return "meeting";
	}
	
	@RequestMapping(value = "/association/voting")
	public String voting(Model model){
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "voting");
		return "voting";
	}
	
	@RequestMapping(value = "/association/facilities")
	public String facilities(Model model){
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "facilities");
		return "facilities";
	}

	public void deleteMember() {
		
	}
	
	@RequestMapping(value = "/association/setMemberGrade/{studentID}")
	public String setMemberGrade(@PathVariable String studentID, Model model, HttpServletResponse response){
		Students student;
	
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "manageAssociation");
		
		try {
			//System.out.println(studentID);
			Students currentStudent = studentsService.getStudentByStudentID(getCurrentUserID());
			if(currentStudent.getAssociation() != 1){
				// if the student does not have association authority
				// print error and goes back to where he/she was
				System.out.println(currentStudent.getAssociation());
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정 권한이 없습니다.');");
				out.println("</script>");
				out.println("<script> history.go(-1); </script>");
				return null;
			}
			
			student = studentsService.getStudentByStudentID(studentID);
		
			model.addAttribute("student", student);
	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "setMemberGrade";
	}
	
	@RequestMapping(value = "/association/modifyMemberGrade",method = RequestMethod.POST)
	public ModelAndView modifyMemberGrade(Students student) {
		try {
			//System.out.println(student.getStudentID());
			//System.out.println(student.getAssociation());
			
			// get currently logged-in user ID
			String currentStudentID = getCurrentUserID();
			Students student1 = studentsService.getStudentByStudentID(currentStudentID);
			if(student1.getAssociation()==student.getAssociation()){
				
				//System.out.println(student1.getStudentID());
				studentsService.updateStudentAssosiation(student1);
				//student1 = studentsService.getStudentByStudentID(currentStudentID);
				//System.out.println(student1.getAssociation());
			}
			Students temp=studentsService.getStudentByStudentID(student.getStudentID());
			temp.setAssociation(student.getAssociation());
			studentsService.updateStudent(temp);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String url = "redirect:/association/manageAssociation";
		return new ModelAndView(url);
	}
	@RequestMapping(value = "/association/viewClub/{clubID}", method = RequestMethod.GET)
	public String viewClub(@PathVariable String clubID, Model model) {
		List<Students> studentslist;
		List<JoinedList> joinedlist;
		Clubs thisclub;
		model.addAttribute("clubID", clubID);
		model.addAttribute("navigation", "association");
		model.addAttribute("sidebar", "manageClubs");
		try {
			studentslist = studentsService.getAllStudentsByClubID(clubID);
			joinedlist = clubsService.getJoinedListByClubID(clubID);
			thisclub = clubsService.getClubByClubID(clubID);
			model.addAttribute("studentslist", studentslist);
			model.addAttribute("joinedlist", joinedlist);
			model.addAttribute("thisclub", thisclub);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return "viewClub";
	}
}
