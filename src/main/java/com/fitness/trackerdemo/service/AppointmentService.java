package com.fitness.trackerdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fitness.trackerdemo.entity.Appointment;
import com.fitness.trackerdemo.repository.IAppointmentRepository;


@Service
public class AppointmentService implements IAppointmentService {
	@Autowired
	IAppointmentRepository appointmentRepository;

	@Override
	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
		System.out.println("saved");
	}

	@Override
	public Iterable<Appointment> getAllUsers() {
		return appointmentRepository.findAll();
		
	}
	@Override
	public Optional<Appointment> getUser(Integer id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public void update(Appointment appointment, Integer id) {
		Optional<Appointment> appointmentFromDB = appointmentRepository.findById(id);
		Appointment appointment1 = appointmentFromDB.get();
		if(StringUtils.hasText(appointment.getName()))
			appointment1.setName(appointment.getName());
		appointmentRepository.save(appointment1);
		
	}
}
