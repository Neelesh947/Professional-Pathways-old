package com.jobportal.users.serviceimpl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jobportal.users.exception.ResourceNotFoundException;
import com.jobportal.users.external.RecruiterService;
import com.jobportal.users.models.JobPost;
import com.jobportal.users.models.Recruiter;
import com.jobportal.users.models.User;
import com.jobportal.users.repository.UserRepository;
import com.jobportal.users.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired
	private RecruiterService frecruiter;
	

	//create and save users
		
	@Override
	public User saveUser(User user) {
		String randomUserId=UUID.randomUUID().toString();
		user.setUserid(randomUserId);
		return userRepository.save(user);
	}

	// get all the users
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	// find user by userid
	@Override
	public User getUserById(String userid) {
		User user=userRepository.findById(userid).orElseThrow(()->new ResourceNotFoundException("User with given ID is not found in data"));
		
		// fetch job applied of the above user from the Job Post service
		JobPost[] jobapplied=restTemplate.getForObject("http://JOBPOST/jobpost/users/"+user.getUserid(), JobPost[].class);
		log.info("{} "+jobapplied);
		
		List<JobPost> appliedJobs=  Arrays.stream(jobapplied).toList();
		
		// find the job posted by the recruiter
		// first of all we have to set recruiter to the job Post
		
		List<JobPost> jobappliedlist=  appliedJobs.stream().map(jobapply ->{
			//api call to recruiter to get the recruiter details
			
			//ResponseEntity<Recruiter> recruiterdetails=restTemplate.getForEntity("http://RECRUITERS/recruiter/"+jobapply.getRecruiterid(), Recruiter.class);
					
			
			Recruiter recruiter=frecruiter.getRecruiter(jobapply.getRecruiterid());  //feign client used
			
			//set the details to the jobpost
			jobapply.setRecruiter(recruiter);
			
			//return recruiter details
			return jobapply;
			
		}).collect(Collectors.toList());
				
		
		user.setJobPost(jobappliedlist);		
		return user;
	}
	
	
	
}
