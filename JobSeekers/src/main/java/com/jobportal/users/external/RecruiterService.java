package com.jobportal.users.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jobportal.users.models.Recruiter;

@FeignClient(name="RECRUITERS")
public interface RecruiterService {

	@GetMapping("recruiter/{recruiterid}")
	Recruiter getRecruiter(@PathVariable String recruiterid);

}
