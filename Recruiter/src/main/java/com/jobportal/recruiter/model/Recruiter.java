package com.jobportal.recruiter.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {

	@Id
	private String recruiterid;
	private String password;
	private String email;
	private String name;
	private String companydetails;
	private String contactnumber;
	private String address;
}
