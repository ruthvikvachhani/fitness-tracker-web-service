package com.fitness.trackerdemo.service;

import java.security.InvalidParameterException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fitness.trackerdemo.entity.Appointment;
import com.fitness.trackerdemo.exception.AppointmentNotFoundException;
import com.fitness.trackerdemo.repository.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {
	@Autowired
	IAppointmentRepository appointmentRepository;

	@Override
	public void save(Appointment appointment) {
		if(appointment.getName().isEmpty() || appointment.getPhone()<1000000000 || appointment.getEmail().isEmpty() || appointment.getPackage_choose().isEmpty() )
			throw new InvalidParameterException("Please Provide Your Name");
		else
			appointmentRepository.save(appointment);
	}

	@Override
	public Iterable<Appointment> getAllUsers() {
		return appointmentRepository.findAll();

	}

	@Override
	public Optional<Appointment> getUser(Integer id) {
		Optional<Appointment> appointment = appointmentRepository.findById(id);
		if (!appointment.isPresent())
			throw new AppointmentNotFoundException("Appointment Not Found");
		return appointment;

	}

	@Override
	public void delete(Integer id) {
		appointmentRepository.deleteById(id);
	}

	@Override
	public void update(Appointment appointment, Integer id) {
		Optional<Appointment> appointmentFromDB = appointmentRepository.findById(id);
		Appointment appointment1 = appointmentFromDB.isPresent() ? appointmentFromDB.get() : null;
		if (StringUtils.hasText(appointment.getName()))
			appointment1.setName(appointment.getName());
		appointmentRepository.save(appointment1);

	}
}
