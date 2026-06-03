package com.Backspace.ComplaintManagement.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="complaints")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Complaint 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long complaintId;
	
	@NotBlank(message="Category is required")
	private String category;
	
	@NotBlank(message="Type is required")
	private String type;
	
	@NotBlank(message="Description is required")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Long getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(Long complaintId) {
		this.complaintId = complaintId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
