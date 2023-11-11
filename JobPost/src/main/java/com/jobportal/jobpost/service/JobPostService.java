package com.jobportal.jobpost.service;

import java.util.List;

import com.jobportal.jobpost.model.JobPost;

public interface JobPostService {

	//create job post
	JobPost createJobPost(JobPost jobpost);

	//list of job postings
	
	List<JobPost> getallJobPost();

	
	// get job by job id
	JobPost getJobById(String jobid);

	//List of recruiter 
	
	List<JobPost> getallbyRecruiterId(String recruiterid);
	
	//list of all by jobseeker id
	List<JobPost> findByUserId(String userid);
}
