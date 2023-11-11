package com.jobportal.recruiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.recruiter.model.Recruiter;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, String>{

}
