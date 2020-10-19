package edu.univ.manclub.tester;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.univ.manclub.service.ClubCategoryService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:edu/univ/manclub/config/testContext.xml","classpath:edu/univ/manclub/config/test-context.xml"})



public class ClubCategoryTest {
	@Resource(name = "ClubCategoryService")
	private ClubCategoryService categoryService;
	
	@Test
	public void setClubCategory(){
		
		
		/*insertClubCategory test 
		 
		ClubCategory category1 = new ClubCategory();
		category1.setCategoryID('4');
		category1.setCategory_name("soccer");
		
		categoryService.insertCategory(category1);
		assertNotNull(category1);*/
		
		/*updateClubCategory test
		
		ClubCategory category1 = new ClubCategory();
		category1.setCategoryID('4');
		category1.setCategory_name("soccer");
		
		categoryService.insertCategory(category1);
		assertNotNull(category1);
		category1.setCategory_name("basketball");
		
		categoryService.updateCategory(category1);
		assertNotNull(category1);*/
		
		/*deleteClubCategory test
		 categoryService.deleteCategory('1');*/
		
		/*List<ClubCategory> list = categoryService.getAllCategory();
		assertEquals(list.size(),7);*/
		 
		 
	}

}
