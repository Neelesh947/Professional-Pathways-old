package com.jobportal.users.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recruiter {

	private String recruiterid;
	private String password;
	private String email;
	private String name;
	private String companydetails;
	private String contactnumber;
	private String address;
}
