package com.fitness.trackerdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	private String name;
	
	@NotNull
	@Digits(integer = 10,fraction = 0)
	private long phone;
	
	@Email
	private String email;
	
	@NotNull
	private byte age;
	
	@Size(max = 100)
	private String address;
	
	private char trainerPref;
	
	private boolean physio;
	private String package_choose;
	private float amount;

}
