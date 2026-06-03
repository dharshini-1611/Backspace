package com.Backspace.ComplaintManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Backspace.ComplaintManagement.Entity.Complaint;
import com.Backspace.ComplaintManagement.Service.ComplaintService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/complaints")
public class ComplaintController 
{
      @Autowired
      private ComplaintService complaintService;
      
      @PostMapping
      public Complaint saveComplaint(@Valid @RequestBody Complaint complaint)
      {
    	  return complaintService.saveComplaint(complaint);
      }
      
      @GetMapping
      public List<Complaint> getAllComplaints()
      {
    	  return complaintService.getAllComplaints();
      }
      
      @GetMapping("/{id}")
      public Complaint getComplaintById(@PathVariable long id)
      {
    	  return complaintService.getComplaintById(id);
      }
      
      @PutMapping("/update/{id}")
      public Complaint updateComplaint(@PathVariable long id,@Valid @RequestBody Complaint complaint)
      {
    	  return complaintService.updateComplaint(id, complaint);
      }
      
      @DeleteMapping("/{id}")
      public String deleteComplaint(@PathVariable long id)
      {
    	  return complaintService.deleteComplaint(id);
      }
      
      @PutMapping("/assign/{userId}")
      public String assignUser(@PathVariable long userId,@RequestBody List<Long> complaintId)
      {
    	  return complaintService.assignUser(userId, complaintId);
      }
}
