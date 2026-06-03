package com.Backspace.ComplaintManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backspace.ComplaintManagement.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
