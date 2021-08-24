package com.fitness.trackerdemo;

import org.springframework.data.repository.CrudRepository;


public interface IAppointmentRepository extends CrudRepository<Appointment, Integer>{

}
