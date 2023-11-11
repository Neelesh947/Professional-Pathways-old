package com.jobportal.users.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	private String userid;
	private String password;
	private String name;
	private String emailid;
	private String contactnumber;
	private String skills;
	private String qualifications;
	private String university;
	private String yearofpassing;			
	private String experience;				//user total experience
	private String currentcompany;			//user current company name
	private String companycontact;			//user current company contact number
	private String companywebsite;			//user current company website
	private String rate;					//user rate his current company
	private String address;                 //address of the job hunter
	
	
	//list of applied jobs
	@Transient
	private List<JobPost> JobPost=new ArrayList<>();
	
}
