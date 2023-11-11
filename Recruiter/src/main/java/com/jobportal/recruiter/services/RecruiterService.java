package com.jobportal.recruiter.services;

import java.util.List;

import com.jobportal.recruiter.model.Recruiter;

public interface RecruiterService {

	//creating recruiter
	
	Recruiter createRecruiter(Recruiter recruiter);

	//get list of recruiter
	
	List<Recruiter> getAllRecruiter();

	//get recruiter list by id
	
	Recruiter getRecruiter(String recruiterid);

}
