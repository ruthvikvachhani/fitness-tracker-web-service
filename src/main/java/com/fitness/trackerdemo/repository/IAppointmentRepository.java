package com.fitness.trackerdemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.fitness.trackerdemo.entity.Appointment;


public interface IAppointmentRepository extends CrudRepository<Appointment, Integer>{

}
