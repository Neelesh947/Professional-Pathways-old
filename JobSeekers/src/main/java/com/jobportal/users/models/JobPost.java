package com.jobportal.users.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobPost {

	
	private String jobid;
	private String jobdescription;
	private String numberofvacancies;
	private String skills;
	private String applytill;
	private String experiencerequired;
	private String postingdate;
	private String userid;
	private String recruiterid;
	
	private Recruiter recruiter;
}
