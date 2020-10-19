package edu.univ.manclub.service;

import java.util.List;

import edu.univ.manclub.persistence.ClubCategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import edu.univ.manclub.domain.ClubCategory;

@Service
public class ClubCategoryService {
	@Autowired
    ClubCategoryMapper clubcategoryMapper;
	@Transactional
	public void insertCategory(ClubCategory Category)
	{
		clubcategoryMapper.insertCategory(Category);
	}
	@Transactional
	public void updateCategory(ClubCategory Category)
	{
		clubcategoryMapper.updateCategory(Category);
	}
	@Transactional
	public void deleteCategory(int CategoryID)
	{
		clubcategoryMapper.deleteCategory(CategoryID);
	}
	@Transactional
	public List<ClubCategory> getAllCategory()
	{
		return clubcategoryMapper.getAllCategory();
	}

}
