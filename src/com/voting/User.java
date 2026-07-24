package com.voting;
	public class User {

	    private String username;
	    private String password;
	    private boolean voted;

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	        this.voted = false;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getPassword() {
	        return password;
	    }

	    public boolean hasVoted() {
	        return voted;
	    }

	    public void setVoted(boolean voted) {
	        this.voted = voted;
	    }
	}

