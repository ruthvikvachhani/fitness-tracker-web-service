package com.fitness.trackerdemo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private long phone;
	private String email;
	private byte age;
	private String address;
	private char trainerPref;
	private boolean physio;
	private String package_choose;
	private float amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public char getTrainerPref() {
		return trainerPref;
	}

	public void setTrainerPref(char trainerPref) {
		this.trainerPref = trainerPref;
	}

	public boolean isPhysio() {
		return physio;
	}

	public void setPhysio(boolean physio) {
		this.physio = physio;
	}

	public String getPackage_choose() {
		return package_choose;
	}

	public void setPackage_choose(String package_choose) {
		this.package_choose = package_choose;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
}
