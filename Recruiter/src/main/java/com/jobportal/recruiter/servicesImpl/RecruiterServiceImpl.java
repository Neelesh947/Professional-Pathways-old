package com.jobportal.recruiter.servicesImpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.recruiter.exception.ResourceNotFoundException;
import com.jobportal.recruiter.model.Recruiter;
import com.jobportal.recruiter.repository.RecruiterRepository;
import com.jobportal.recruiter.services.RecruiterService;

@Service
public class RecruiterServiceImpl implements RecruiterService{

	@Autowired
	private RecruiterRepository recruiterRepository;

	//creating recruiter
	
	@Override
	public Recruiter createRecruiter(Recruiter recruiter) {
		String randomuuid=UUID.randomUUID().toString();
		recruiter.setRecruiterid(randomuuid);
		return recruiterRepository.save(recruiter);
	}

	//Get All Recruiter list
	
	public List<Recruiter> getAllRecruiter() {
		// TODO Auto-generated method stub
		return recruiterRepository.findAll();
	}

	//get recruiter by id
	
	@Override
	public Recruiter getRecruiter(String recruiterid) {
		Recruiter recruiter=recruiterRepository.findById(recruiterid).orElseThrow(()->new ResourceNotFoundException("Recruiter with the given id is not found"));
		return recruiter;
	}
}
