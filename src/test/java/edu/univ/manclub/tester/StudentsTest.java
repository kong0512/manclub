package edu.univ.manclub.tester;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.univ.manclub.domain.JoinedList;
import edu.univ.manclub.domain.Students;
import edu.univ.manclub.service.StudentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:edu/univ/manclub/config/testContext.xml","classpath:edu/univ/manclub/config/test-context.xml"})
public class StudentsTest {
	@Resource(name = "StudentsService")
	private StudentsService studentsService;

	@Test
	public void setStudent(){
		Students student1 = new Students();
		student1.setName("이경준");
		student1.setStudentID("test1");
		student1.setPassword("password");
		student1.setLevel(0);
		student1.setAssociation(0);
		
		studentsService.deleteStudentByStudentID(student1.getStudentID());
		studentsService.insertStudent(student1);
		Students student2 = studentsService.getStudentByStudentID(student1.getStudentID());
		
		assertNotNull(student2);
		}
	
	@Test
	public void updatingStudnet(){
		Students student2 = new Students();
		student2.setName("bee");
		student2.setStudentID("test1");
		student2.setPassword("passord");
		student2.setLevel(0);
		student2.setAssociation(0);
				
		studentsService.updateStudent(student2);
		
		}
	

	@Test
	public void instStudentTojoinedlist(){
		JoinedList joinedlist1 = new JoinedList();
		joinedlist1.setRegisterID("test1+111");
		joinedlist1.setMember_grade(0);
		joinedlist1.setStudentID("test1");
		joinedlist1.setClubID("111");
		
				studentsService.insertStudentToJoinedList(joinedlist1);
		
		}
	
	@Test
	public void testinggetRegisteringStudentByclub(){
				
		ArrayList<Students> list = studentsService.getRegisteringStudentByClubID("111");
		assertEquals(list.size(),2);
			
			
		}
		
	@Test
	public void testinggetJoinedListByRegisterID(){
		JoinedList joinedlist1 = new JoinedList();
		joinedlist1 = studentsService.getJoinedListByRegisterID("55+111");
		assertNotNull(joinedlist1);
			
			
	}
	
	@Test
	public void testingupdateStudentToJoinedList(){
		JoinedList joinedlist1 = studentsService.getJoinedListByRegisterID("55+111");
		joinedlist1.setMember_grade(1);
		studentsService.updateStudentToJoinedList(joinedlist1);
		assertNotNull(joinedlist1);
		}
}
