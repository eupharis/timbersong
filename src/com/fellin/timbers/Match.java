package com.fellin.timbers;

public class Match {
	public String match_time;
	public String opponent;
	public Boolean atHome;
	
	public Match(String dateIn, String opponentIn, Boolean homeIn) {
		match_time = dateIn; 
		opponent = opponentIn;
		atHome = homeIn;
	}
}
