package com.Backspace.ComplaintManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Backspace.ComplaintManagement.Entity.Complaint;

public interface ComplaintRepository extends JpaRepository<Complaint,Long>{

}
