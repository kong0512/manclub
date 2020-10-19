package edu.univ.manclub.controller;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController extends AbstractController {
	
	private MainController(){
		super(MainController.class);
	}
	
	@RequestMapping(value = "/login")
	public String viewLogin() throws ServletException {
		logger.info("Go to the login page");
		return "login";
	}
	
	@RequestMapping(value = "/denied")
	public String viewDenied(){
		logger.info("User Login Process Denied");
		return "denied";
	}
	@RequestMapping(value = "/registerForm")
	public String viewRegisterForm() {

		return "registerForm";
	}
	
	@RequestMapping(value = "/main/univclub", method = RequestMethod.GET)
	public String viewMain(Model model){
		logger.info("It is time to view the main page");
		model.addAttribute("navigation", "main");
		model.addAttribute("Hello", "message");
		
		return "univclub";
	}
}
