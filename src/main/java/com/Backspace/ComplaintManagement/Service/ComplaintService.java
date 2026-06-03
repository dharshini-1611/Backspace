package com.Backspace.ComplaintManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Backspace.ComplaintManagement.Entity.Complaint;
import com.Backspace.ComplaintManagement.Entity.User;
import com.Backspace.ComplaintManagement.Exception.ResourceNotFoundException;
import com.Backspace.ComplaintManagement.Repository.ComplaintRepository;
import com.Backspace.ComplaintManagement.Repository.UserRepository;

@Service
public class ComplaintService 
{
     @Autowired
     private ComplaintRepository complaintRepo;
     
     @Autowired
     private UserRepository userRepo;
     
     //save complaint
     public Complaint saveComplaint(Complaint complaint)
     {
    	 return complaintRepo.save(complaint);
     }
     
     //get all complaint
     public List<Complaint> getAllComplaints()
     {
    	 return complaintRepo.findAll();
     }
     
     //get complaint by id
     public Complaint getComplaintById(long id)
     {
    	 return complaintRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Complaint not Found"));
     }
     
     //update complaint
     public Complaint updateComplaint(long id,Complaint complaint)
     {
    	 Complaint existingComplaint=complaintRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Complaint not Found"));
    	 existingComplaint.setCategory(complaint.getCategory());
    	 existingComplaint.setType(complaint.getType());
    	 existingComplaint.setDescription(complaint.getDescription());
         return complaintRepo.save(existingComplaint);
     }
     
     //delete complaint
     public String deleteComplaint(long id)
     {
    	 Complaint complaint=complaintRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Complaint not Found"));
    	 complaintRepo.delete(complaint);
    	 return "Complaint Deleted Successfully";
     }
     
     //Assign the user
     public String assignUser(long userId,List<Long> complaintId)
     {
    	 User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not Found"));
    	 List<Complaint> complaints=complaintRepo.findAllById(complaintId);
    	 for(Complaint complaint : complaints)
    	 {
    		 complaint.setUser(user);
    	 }
    	 complaintRepo.saveAll(complaints);
    	 return "Assigned Successfully";
     }
     
}
