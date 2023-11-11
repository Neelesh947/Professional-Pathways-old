package com.jobportal.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobportal.users.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}
