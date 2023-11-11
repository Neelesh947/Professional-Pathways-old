package com.jobportal.jobpost.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.jobpost.model.JobPost;
import com.jobportal.jobpost.service.JobPostService;

@RestController
@RequestMapping("/jobpost")
public class JobPostController {

	@Autowired
	private JobPostService jobpostService;
	
	//create jobpost
	@PostMapping
	public ResponseEntity<JobPost> createJobPost(@RequestBody JobPost jobpost)
	{
		JobPost job=jobpostService.createJobPost(jobpost);
		return ResponseEntity.status(HttpStatus.CREATED).body(job);
	}
	
	//find all job post
	
	@GetMapping
	public ResponseEntity<List<JobPost>> getAllJobPost ()
	{
		List<JobPost> joblist=jobpostService.getallJobPost();
		return ResponseEntity.ok(joblist);
	}
	
	//find job on the basis of ratings
	@GetMapping("/{jobid}")
	public ResponseEntity<JobPost> findjobByJobid(@PathVariable String jobid)
	{
		JobPost job=jobpostService.getJobById(jobid);
		return ResponseEntity.ok(job);
	}
	
	//list of all the jobpost by userid
	@GetMapping("/users/{userid}")
	public ResponseEntity<List<JobPost>> getAllByUserId(@PathVariable String userid)
	{
		List<JobPost> userlist=jobpostService.findByUserId(userid);
		return ResponseEntity.ok(userlist);
	}
	
	//list of all the jobpost by recruiter
	@GetMapping("/recruiter/{recruiterid}")
	public ResponseEntity<List<JobPost>> getAllByRecruiterId(@PathVariable String recruiterid)
	{
		List<JobPost> recruiterlist=jobpostService.getallbyRecruiterId(recruiterid);
		return ResponseEntity.ok(recruiterlist);
	}
}
