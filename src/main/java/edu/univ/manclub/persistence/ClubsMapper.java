package edu.univ.manclub.persistence;

import java.util.ArrayList;
import java.util.List;

import edu.univ.manclub.domain.Clubs;
import edu.univ.manclub.domain.JoinedList;

public interface ClubsMapper {

	public ArrayList<Clubs> getAllClubs();
	public List<Clubs> getAllAcceptedClubs();
	public ArrayList<Clubs> getAskAcceptClubs();
	public Clubs getClubByClubID(String clubID);
	public List<Clubs> getClubByClubName(String club_name);

	public void insertClub(Clubs club);
	public void updateClub(Clubs club);
	public void deleteClub(String clubID);
	public List<Clubs> getClubsByStudentID(String studentID);
	public ArrayList<JoinedList> getJoinedListByClubID(String clubID);
	
}
