package edu.univ.manclub.service;

import java.util.ArrayList;
import java.util.List;

import edu.univ.manclub.persistence.ClubsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.univ.manclub.domain.Clubs;
import edu.univ.manclub.domain.JoinedList;


@Service
public class ClubsService {
	@Autowired
    ClubsMapper clubsMapper;
	
	@Transactional
	public ArrayList<Clubs> getAllClubs(){
		return clubsMapper.getAllClubs();
	}
	@Transactional
	public List<Clubs> getAllAcceptedClubs(){
		return clubsMapper.getAllAcceptedClubs();
	}
	@Transactional
	public ArrayList<Clubs> getAskAcceptClubs(){
		return clubsMapper.getAskAcceptClubs();
	}
	@Transactional
	public Clubs getClubByClubID(String clubID){
		return clubsMapper.getClubByClubID(clubID);
	}
	@Transactional
	public List<Clubs> getClubByClubName(String club_name){
		return clubsMapper.getClubByClubName(club_name);
	}
	@Transactional
	public List<Clubs> getClubsByStudentID(String studentID){
		return clubsMapper.getClubsByStudentID(studentID);
	}
	@Transactional
	public void insertClub(Clubs club){
		clubsMapper.insertClub(club);
	}
	@Transactional
	public void  updateClub(Clubs club){
		clubsMapper.updateClub(club);
	}
	@Transactional
	public void deleteClub(String clubID){
		clubsMapper.deleteClub(clubID);
	}
	@Transactional
	public ArrayList<JoinedList> getJoinedListByClubID(String clubID){
		return clubsMapper.getJoinedListByClubID(clubID);
	}
}
