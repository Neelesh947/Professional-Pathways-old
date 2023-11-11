package com.jobportal.recruiter.exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException (String s)
	{
		super();
	}
	
	public ResourceNotFoundException()
	{
		super("resource not found");
	}
}
