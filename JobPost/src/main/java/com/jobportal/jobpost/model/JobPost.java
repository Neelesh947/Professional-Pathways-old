package com.jobportal.jobpost.model;

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
public class JobPost {

	@Id
	private String jobid;
	private String jobdescription;
	private String numberofvacancies;
	private String skills;
	private String applytill;
	private String experiencerequired;
	private String postingdate;
	private String userid;
	private String recruiterid;
}
