package com.fitness.trackerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@GetMapping("/getappointment")
	private String getAppointment() {
		System.out.println("called");
		return "hello";
	}
	@PostMapping("/appointment")
	private void saveUser(@RequestBody Appointment appointment) {
		
		appointmentService.save(appointment);
		System.out.println(appointment.getName());
	}
}
