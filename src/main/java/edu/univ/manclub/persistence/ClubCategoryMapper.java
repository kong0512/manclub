package edu.univ.manclub.persistence;

import java.util.List;

import edu.univ.manclub.domain.ClubCategory;

public interface ClubCategoryMapper {
	
	public void insertCategory(ClubCategory Category);
	public void updateCategory(ClubCategory Category);
	public void deleteCategory(int CategoryID);
	public List<ClubCategory> getAllCategory();
}
