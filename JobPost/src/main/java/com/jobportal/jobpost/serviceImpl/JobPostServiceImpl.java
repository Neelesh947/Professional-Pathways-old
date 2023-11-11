package com.jobportal.jobpost.serviceImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.jobpost.exception.ResourceNotFoundException;
import com.jobportal.jobpost.model.JobPost;
import com.jobportal.jobpost.repository.JobPostRepository;
import com.jobportal.jobpost.service.JobPostService;

@Service
public class JobPostServiceImpl implements  JobPostService{

	@Autowired
	private JobPostRepository jobpostRepository;

	//create job post
	
	@Override
	public JobPost createJobPost(JobPost jobpost) {
		String randomuuid=UUID.randomUUID().toString();
		jobpost.setJobid(randomuuid);
		return jobpostRepository.save(jobpost);
	}

	
	//list of job posting
	@Override
	public List<JobPost> getallJobPost() {
		
		return jobpostRepository.findAll();
	}

	//get job  by job id
	@Override
	public JobPost getJobById(String jobid) {
		JobPost job=jobpostRepository.findById(jobid).orElseThrow(() -> new ResourceNotFoundException("Job Post Not found"));
		
		return job;
	} 
	
	//get all by the recruiter	
	public List<JobPost> getallbyRecruiterId(String recruiterid)
	{
		return jobpostRepository.findByRecruiterid(recruiterid);
	} 

	//get all by user id
	@Override
	public List<JobPost> findByUserId(String userid) {
		// TODO Auto-generated method stub
		return jobpostRepository.findByUserid(userid);
	} 
	
}
