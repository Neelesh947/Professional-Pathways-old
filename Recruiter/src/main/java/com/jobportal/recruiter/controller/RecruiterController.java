package com.jobportal.recruiter.controller;

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

import com.jobportal.recruiter.model.Recruiter;
import com.jobportal.recruiter.services.RecruiterService;

@RestController
@RequestMapping("/recruiter")
public class RecruiterController {

	@Autowired
	private RecruiterService recruiterService;
	
	//create Recruiter
	
	@PostMapping
	public ResponseEntity<Recruiter> createRecruiter(@RequestBody Recruiter recruiter)
	{
		Recruiter recruiter2=recruiterService.createRecruiter(recruiter);
		return ResponseEntity.status(HttpStatus.CREATED).body(recruiter2);
	}
	
	//get all recruiter
	
	@GetMapping
	public ResponseEntity<List<Recruiter>> findAllRecruiter()
	{
		List<Recruiter> recruiterlist=recruiterService.getAllRecruiter();
		return ResponseEntity.ok(recruiterlist);
	}
	
	
	// get recruiter by id
	@GetMapping("/{recruiterid}")
	public ResponseEntity<Recruiter> findRecruiterById(@PathVariable String recruiterid)
	{
		Recruiter recruiterlist=recruiterService.getRecruiter(recruiterid);
		return ResponseEntity.ok(recruiterlist);
	}
}
