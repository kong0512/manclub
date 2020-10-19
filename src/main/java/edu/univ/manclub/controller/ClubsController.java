package edu.univ.manclub.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import edu.univ.manclub.service.ClubCategoryService;
import edu.univ.manclub.service.ClubsService;
import edu.univ.manclub.service.StudentsService;

@Controller
public class ClubsController extends AbstractController {
	@Autowired
	private StudentsService studentsService;

	@Autowired
	private ClubsService clubsService;
	
	@Autowired
	private ClubCategoryService categoryService;


	private ClubsController() {
		super(ClubsController.class);
	}

	@RequestMapping(value = "/club/createClub")
	public String createClub(Model model) {
		model.addAttribute("navigation", "club");
		model.addAttribute("sidebar", "createClub");

		return "createClub";
	}

	@RequestMapping(value = "/club/registerClub", method = RequestMethod.POST)
	public ModelAndView registerClub(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();


		Clubs club2 = clubsService.getClubByClubID(request.getParameter("clubID"));
		
		
		 if (request.getParameter("clubID") == "") {
				out.println("<script> alert('동아리 ID를 입력해주세요'); </script>");
				out.println("<script> history.go(-1); </script>");

		}  else if (club2 != null) {
			out.println("<script> alert('이미존재하는 ClubID 입니다.'); </script>");
			out.println("<script> history.go(-1); </script>");

		} else if (request.getParameter("club_name") == "") {
			out.println("<script> alert('동아리 이름을 입력해주세요'); </script>");
			out.println("<script> history.go(-1); </script>");

		} else if (request.getParameter("club_information") == "") {
			out.println("<script> alert('동아리 정보를 입력해주세요'); </script>");
			out.println("<script> history.go(-1); </script>");

		} else if (Integer.parseInt(request.getParameter("club_category")) >= 8
				|| Integer.parseInt(request.getParameter("club_category")) <= 0) {
			out.println("<script> alert('동아리 카테고리를 선택해 주세요.'); </script>");
			out.println("<script> history.go(-1); </script>");
		} else {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			Clubs club1 = new Clubs();
			Students student =new Students();
			student=studentsService.getStudentByStudentID(getCurrentUserID());
			
			JoinedList join = new JoinedList();
			club1.setAccepted(false);
			club1.setClubID(request.getParameter("clubID"));
			club1.setClub_name(request.getParameter("club_name"));
			club1.setClub_information(request.getParameter("club_information"));
			club1.setClub_category(Integer.parseInt(request.getParameter("club_category")));
			club1.setCreated_date(formatter.format(date));
			clubsService.insertClub(club1);

			student.setLevel(1);
			studentsService.updateStudent(student);	
			String registerID = new String(getCurrentUserID()+"+"+club1.getClubID());
			join.setRegisterID(registerID);
			join.setStudentID(getCurrentUserID());
			join.setClubID(club1.getClubID());
			join.setMember_grade(4);
			studentsService.insertStudentToJoinedList(join);
			out.println("<script> alert('동아리 생성을 완료하였습니다.'); </script>");
			out.println("<script> history.go(-1); </script>");
		}
		return null;
	}

	@RequestMapping(value = "/club/listClubs", method = RequestMethod.GET)
	public String listClub(Model model) {
		// list only accepted clubs
		List<Clubs> clubList;
		List<ClubCategory> categoryList;
		model.addAttribute("navigation", "club");
		model.addAttribute("sidebar", "listClubs");
		try {
			clubList = clubsService.getAllAcceptedClubs();
			String currentStudentID = getCurrentUserID();
			categoryList = categoryService.getAllCategory();
			model.addAttribute("clubList", clubList);
			model.addAttribute("mystudentID", currentStudentID);
			model.addAttribute("categoryList", categoryList);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return "listClubs";
	}

	@RequestMapping(value = "/club/retrieveClub/{clubID}", method = RequestMethod.GET)
	public String retrieveClub(@PathVariable String clubID, Model model, HttpServletResponse response) {
		List<Students> studentslist;
		List<JoinedList> joinedlist;
		JoinedList registered;
		Clubs thisclub;
		String registerID = new String(getCurrentUserID()+"+"+clubID);
		model.addAttribute("clubID", clubID);
		model.addAttribute("navigation", "club");
		model.addAttribute("sidebar", "myClubs");
		try {
			registered = studentsService.getJoinedListByRegisterID(registerID);
			if(registered == null){
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script> alert('해당 동아리 조회 권한이 없습니다.'); </script>");
				out.println("<script> history.go(-1); </script>");
				return null;
			}
			
			studentslist = studentsService.getAllStudentsByClubID(clubID);
			joinedlist = clubsService.getJoinedListByClubID(clubID);
			thisclub = clubsService.getClubByClubID(clubID);
			model.addAttribute("studentslist", studentslist);
			model.addAttribute("joinedlist", joinedlist);
			model.addAttribute("thisclub", thisclub);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return "retrieveClub";
	}
	
	@RequestMapping(value = "/club/visitClub/{clubID}", method = RequestMethod.GET)
	public String visitClub(@PathVariable String clubID, Model model) {
		List<Students> studentslist;
		List<JoinedList> joinedlist;
		Clubs thisclub;
		model.addAttribute("clubID", clubID);
		model.addAttribute("navigation", "club");
		model.addAttribute("sidebar", "listClubs");
		try {
			studentslist = studentsService.getExcutiveStudentsByClubID(clubID);
			joinedlist = clubsService.getJoinedListByClubID(clubID);
			thisclub = clubsService.getClubByClubID(clubID);
			model.addAttribute("studentslist", studentslist);
			model.addAttribute("joinedlist", joinedlist);
			model.addAttribute("thisclub", thisclub);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return "visitClub";
	}

	@RequestMapping(value = "/club/searchedClub", method = RequestMethod.POST)
	public String searchClub(Clubs club, Model model){
		List<Clubs> searchedlist;
		String clubname = club.getClub_name();
		
		
		model.addAttribute("navigation", "club");
		model.addAttribute("sidebar", "listClubs");
		try {
			searchedlist = clubsService.getClubByClubName(clubname);
			model.addAttribute("searchedList",searchedlist);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "searchedClub";
		

	}

	@RequestMapping(value = "/club/manageClub/{clubID}", method = RequestMethod.GET)
	public String manageClub(@PathVariable String clubID, Model model,
			HttpServletResponse response) {
		// manageMyclub
		List<Students> studentslist;
		ArrayList<JoinedList> joinedlist;
		String clubname;
		String registerID = new String(getCurrentUserID()+"+"+clubID);
		JoinedList isChief = studentsService.getJoinedListByRegisterID(registerID);
		if (isChief.getMember_grade() == 4) {
			try {
				model.addAttribute("navigation", "club");
				model.addAttribute("sidebar", "myClubs");
				joinedlist = clubsService.getJoinedListByClubID(clubID);
				studentslist = studentsService
						.getRegisteringStudentByClubID(clubID);
				clubname = clubsService.getClubByClubID(clubID).getClub_name();
				model.addAttribute("clubname", clubname);
				model.addAttribute("studentslist", studentslist);
				model.addAttribute("joinedlist", joinedlist);
				model.addAttribute("joinedlist", joinedlist);

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out;
				out = response.getWriter();
				out.println("<script> alert('회장권한이 없습니다.'); </script>");
				out.println("<script> history.go(-1); </script>");

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return "manageMyClub";

	}

	@RequestMapping(value = "/club/myClubs", method = RequestMethod.GET)
	public String myClubs(Model model, HttpServletResponse response) {
		// list myclubs
		List<Clubs> myclublist;
		model.addAttribute("navigation", "club");
		model.addAttribute("sidebar", "myClubs");
		try {
			// get currently logged-in user ID
			String currentStudentID = getCurrentUserID();
			myclublist = clubsService.getClubsByStudentID(currentStudentID);
			if(myclublist.size() == 0){
				try {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out;
					out = response.getWriter();
					out.println("<script> alert('가입한 동아리가 없습니다.'); </script>");
					out.println("<script> history.go(-1); </script>");

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
			model.addAttribute("myclublist", myclublist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "myClubs";
	}

	@RequestMapping(value = "/club/acceptMember/{studentID}/{clubID}", method = RequestMethod.GET)
	public ModelAndView acceptMember(@PathVariable String studentID,
			@PathVariable String clubID, Model model) {
		// acceptMember
		try {
			String registerID = new String(studentID+"+"+clubID);
			JoinedList isJoin = studentsService.getJoinedListByRegisterID(registerID);
			isJoin.setMember_grade(1);
			studentsService.updateStudentToJoinedList(isJoin);

			Students changelevel = studentsService.getStudentByStudentID(studentID);
			changelevel.setLevel(1);
			studentsService.updateStudent(changelevel);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "redirect:/club/manageClub/{clubID}";
		return new ModelAndView(url);

	}

	@RequestMapping(value = "/club/declineMember/{studentID}/{clubID}", method = RequestMethod.GET)
	public ModelAndView declineMember(@PathVariable String studentID,
			@PathVariable String clubID, Model model) {
		// declineMember
		try {
			String registerID = new String(studentID+"+"+clubID);
			studentsService.deleteStudentToJoinedList(registerID);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "redirect:/club/manageClub/{clubID}";
		return new ModelAndView(url);

	}

	@RequestMapping(value = "/club/changeRole/{studentID}/{clubID}/{Role}", method = RequestMethod.GET)
	public ModelAndView changeRole(@PathVariable String studentID,
			@PathVariable String clubID, @PathVariable int Role, Model model) {
		// changeRole
		String registerID = new String(studentID+"+"+clubID);
		try {
			if (Role == 0) {
				// 퇴부
				studentsService.deleteStudentToJoinedList(registerID);
			} else if (Role == 4) {
				// 회장을 바꾸면 회장을 일반회원으로 되돌림
				List<JoinedList> clubJoinedlist = clubsService
						.getJoinedListByClubID(clubID);
				for (int i = 0; i < clubJoinedlist.size(); i++) {
					if (clubJoinedlist.get(i).getMember_grade() == 4) {
						clubJoinedlist.get(i).setMember_grade(1);
						studentsService
								.updateStudentToJoinedList(clubJoinedlist
										.get(i));
					}
				}

				JoinedList changeRole = studentsService
						.getJoinedListByRegisterID(registerID);
				changeRole.setMember_grade(Role);
				studentsService.updateStudentToJoinedList(changeRole);

			} else {
				JoinedList changeRole = studentsService
						.getJoinedListByRegisterID(registerID);
				changeRole.setMember_grade(Role);
				studentsService.updateStudentToJoinedList(changeRole);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String url = "redirect:/club/manageClub/{clubID}";
		return new ModelAndView(url);

	}
}
