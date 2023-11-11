package com.jobportal.jobpost.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.jobpost.model.JobPost;


@Repository
public interface JobPostRepository extends JpaRepository<JobPost, String>{

	//custom finder method
	List<JobPost> findByRecruiterid(String recruiterid);

	List<JobPost> findByUserid(String userid);

}
