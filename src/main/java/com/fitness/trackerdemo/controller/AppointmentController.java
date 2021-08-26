package com.fitness.trackerdemo.controller;

import java.security.InvalidParameterException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitness.trackerdemo.entity.Appointment;
import com.fitness.trackerdemo.exception.AppointmentNotFoundException;
import com.fitness.trackerdemo.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	private static final Logger logger =  LoggerFactory.getLogger(AppointmentController.class); 

	@Autowired
	AppointmentService appointmentService;

	@GetMapping()
	private Iterable<Appointment> getAppointment() {
		return appointmentService.getAllUsers();
	}

	@GetMapping("/{id}")
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

	@PostMapping()
	@Transactional(rollbackFor = Exception.class)
	private void saveAppointment(@RequestBody @Valid Appointment appointment) {

		appointmentService.save(appointment);
		logger.debug(appointment.getName());
	}

	@DeleteMapping("/{id}")
	@Transactional(rollbackFor = Exception.class)
	private void deleteAppointment(@PathVariable("id") Integer id) {
		appointmentService.delete(id);
	}

	@PutMapping("/{id}")
	@Transactional(rollbackFor = Exception.class)
	private void updateUser(@RequestBody @Valid Appointment appointment, @PathVariable("id") Integer id) {
		appointmentService.update(appointment, id);
	}

}
