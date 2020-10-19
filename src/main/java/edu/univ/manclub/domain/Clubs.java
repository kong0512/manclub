package edu.univ.manclub.domain;

public class Clubs {
	String clubID;
	String club_name;
	String created_date;
	String club_information;
	int club_category;
	boolean accepted;
	
	public String getClubID() {
		return clubID;
	}
	public void setClubID(String clubID) {
		this.clubID = clubID;
	}
	public String getClub_name() {
		return club_name;
	}
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getClub_information() {
		return club_information;
	}
	public void setClub_information(String club_information) {
		this.club_information = club_information;
	}
	public int getCategory(){
		return club_category;
	}
	public void setClub_category(int club_category){
		this.club_category = club_category;
	}
	public int getClub_category() {
		return club_category;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public boolean isAccepted() {
		return accepted;
	}
	
}
