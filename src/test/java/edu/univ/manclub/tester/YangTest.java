package edu.univ.manclub.tester;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.univ.manclub.domain.Clubs;
import edu.univ.manclub.domain.JoinedList;
import edu.univ.manclub.service.ClubsService;
import edu.univ.manclub.service.StudentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:edu/univ/manclub/config/testContext.xml","classpath:edu/univ/manclub/config/test-context.xml"})
public class YangTest {
	@Resource(name = "StudentsService")
	private StudentsService studentsService;

	//myclub목록 가져오는 testing
	@Test
	public void testinggetJoinedListByStudentID(){
		ArrayList<JoinedList> joinedlist1  = studentsService.getJoinedListByStudentID("2007312245");
		assertEquals(joinedlist1.size(),2);
	}
	
	@Resource(name = "ClubsService")
	private ClubsService clubsService;
	
	//전체 listclub 가져오는 testing
	@Test
	public void testinggetAllClubs(){
		ArrayList<Clubs> list = clubsService.getAllClubs();
		assertEquals(list.size(),10);
	}
	
}
