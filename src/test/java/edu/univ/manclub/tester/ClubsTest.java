package edu.univ.manclub.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.univ.manclub.domain.Clubs;
import edu.univ.manclub.service.ClubsService;
import edu.univ.manclub.service.StudentsService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:edu/univ/manclub/config/testContext.xml","classpath:edu/univ/manclub/config/test-context.xml"})


public class ClubsTest {
	@Resource(name = "ClubsService")
	private ClubsService clubsService;
	@Resource(name = "StudentsService")
	private StudentsService studentservice;
	
	@Test
	public void insertClub(){
		
		//insertClub test 
		Clubs club1 = new Clubs();
		
		club1.setClub_name("sdkf");
		club1.setClubID("1115");
		club1.setCreated_date("2013.11.13");	
		club1.setClub_information("testinfo");
		club1.setClub_category(1);
		club1.setAccepted(true);
		
		clubsService.insertClub(club1);
		assertNotNull(club1);
	}
	
	@Test
	public void updateClub(){
		
		// updateClub test
	
		Clubs club1 = clubsService.getClubByClubID("1113");
		club1.setClub_name("testcase11");
		club1.setCreated_date("2013.11.19");
		club1.setClub_information("updated");
		club1.setClub_category(3);
		club1.setAccepted(true);
		clubsService.updateClub(club1);
	}
	
	@Test
	public void deleteClub(){
		// deleteClub test 
		clubsService.deleteClub("1115");
	}
		
	@Test
	public void getAllClubs(){
		// getAllClubs test 
		ArrayList<Clubs> list = clubsService.getAllClubs();
		//assertEquals(list.size(),12);
	}
		

	@Test
	public void getClubbyClubID(){
		//  getClubByClubID test 
		Clubs club2 = clubsService.getClubByClubID("1113");
		assertNotNull(club2);
	}
		
	/*@Test
	public void getClubByClubName(){
		//getClubByClubName test 
		Clubs club2 = clubsService.getClubByClubName("net");
		assertNotNull(club2);
	}*/
	
	@Test
	public void getClubsByStudentID(){
		//getClubsByStudentID test 
		List<Clubs> list = clubsService.getClubsByStudentID("2009312789");
		assertEquals(list.size(),6);
	}
	/*	
	@Test
	public void clublistTest2(){
		getClubByClubName();
	}*/
	@Test
	public void clublistTest4(){
		
	}
	@Test
	public void acceptingtest()
	{
		ArrayList<Clubs> list = clubsService.getAskAcceptClubs();
		//assertEquals(list.size(),3);
	}
	
	
	
		
}
