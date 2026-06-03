package com.Backspace.ComplaintManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backspace.ComplaintManagement.Entity.User;
import com.Backspace.ComplaintManagement.Exception.ResourceNotFoundException;
import com.Backspace.ComplaintManagement.Repository.UserRepository;

@Service
public class UserService 
{
      @Autowired 
      private UserRepository userRepo;
      
      //save user
      public User saveUser(User  user)
      {
    	  return userRepo.save(user);
      }
      
      //get all the user
      public List<User> getAllUsers()
      {
    	  return userRepo.findAll();
      }
      
      //get user by using an id
      public User getUserById(long id)
      {
    	  return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
      }
      
      //update user
      public User updateUser(long id,User user)
      {
    	  User existingUser = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    	  existingUser.setUsername(user.getUsername());
    	  return userRepo.save(existingUser);
      }
      
      //delete user
      public String deleteUser(long id)
      {
    	  User user=userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not Found"));
    	  userRepo.delete(user);
    	  return "User Deleted Successfully";
      }
}
