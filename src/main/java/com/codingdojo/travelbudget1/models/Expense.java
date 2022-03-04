package com.codingdojo.travelbudget1.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank(message="Name required")
	private String name;
	
	@NotBlank(message="Vendor required")
	private String vendor;
	
	@NotNull(message="Amount required")
    @Min(value=0, message="Please enter a valid amount.")
    private Float amount;

	@NotBlank(message="Decription required")
	private String description;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    public Expense() {
	}
    
   


	public Expense(@NotBlank(message = "Name required") String name,
			@NotBlank(message = "Vendor required") String vendor,
			@NotNull(message = "Amount required") @Min(value = 0, message = "Please enter a valid amount.") Float amount,
			@NotBlank(message = "Decription required") String description, Date createdAt, Date updatedAt) {

		this.name = name;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}


	

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getVendor() {
		return vendor;
	}




	public void setVendor(String vendor) {
		this.vendor = vendor;
	}




	public Float getAmount() {
		return amount;
	}




	public void setAmount(Float amount) {
		this.amount = amount;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Date getCreatedAt() {
		return createdAt;
	}




	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}




	public Date getUpdatedAt() {
		return updatedAt;
	}




	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}




	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

