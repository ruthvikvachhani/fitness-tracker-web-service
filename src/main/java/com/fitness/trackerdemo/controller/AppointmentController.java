package com.fitness.trackerdemo.controller;

import java.security.InvalidParameterException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.trackerdemo.entity.Appointment;
import com.fitness.trackerdemo.exception.AppointmentNotFoundException;
import com.fitness.trackerdemo.service.AppointmentService;

@RestController
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/appointment")
	private Iterable<Appointment> getAppointment() {
		return appointmentService.getAllUsers();
	}

	@GetMapping("/appointment/{id}")
	private Optional<Appointment> getAppointment(@PathVariable("id") Integer id) {
		return appointmentService.getUser(id);
	}

	@ExceptionHandler(value = { AppointmentNotFoundException.class, IllegalStateException.class })
	public ResponseEntity<Appointment> exception(AppointmentNotFoundException appointmentNotFoundException) {
		return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = { InvalidParameterException.class, IllegalArgumentException.class })
	public ResponseEntity<Appointment> exception(InvalidParameterException invalidParameterException) {
		return new ResponseEntity<Appointment>(HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/appointment")
	private void saveAppointment(@RequestBody Appointment appointment) {

		appointmentService.save(appointment);
		System.out.println(appointment.getName());
	}

	@DeleteMapping("/appointment/{id}")
	private void deleteAppointment(@PathVariable("id") Integer id) {
		appointmentService.delete(id);
	}

	@PutMapping("/appointment/{id}")
	private void updateUser(@RequestBody Appointment appointment, @PathVariable("id") Integer id) {
		appointmentService.update(appointment, id);
	}

}
