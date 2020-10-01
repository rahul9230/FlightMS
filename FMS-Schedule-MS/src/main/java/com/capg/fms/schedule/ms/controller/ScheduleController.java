 package com.capg.fms.schedule.ms.controller;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.fms.schedule.ms.model.ScheduledFlight;
import com.capg.fms.schedule.ms.model.ScheduledFlightList;
import com.capg.fms.schedule.ms.service.ScheduleServiceImpl;

@RestController
@RequestMapping("/scheduleflight")
public class ScheduleController {
	@Autowired
	ScheduleServiceImpl service;

	@PostMapping("/add")
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		

		ScheduledFlight scheduledFlight1 = service.addScheduleFlight(scheduledFlight);

		return scheduledFlight1;

	}

	@GetMapping("/id/{scheduleId}")
//	@ResponseStatus
	public ResponseEntity<ScheduledFlight> viewScheduledFlight(@PathVariable int scheduleId) {

		ScheduledFlight scheduledFlight = service.viewScheduledFlight(scheduleId);

		return new ResponseEntity<ScheduledFlight>(scheduledFlight, HttpStatus.OK);
	}

	@GetMapping("/viewall")
	public ResponseEntity<ScheduledFlightList> viewScheduledFlight() {

		ScheduledFlightList scheduledFlight = service.viewScheduledFlight();

		return new ResponseEntity<ScheduledFlightList>(scheduledFlight, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{scheduledFlightId}")
	public ResponseEntity<ScheduledFlight> deleteScheduledFlight(@PathVariable int scheduledFlightId) {
		System.err.println("schedule-controller"+scheduledFlightId);
		service.deleteScheduledFlight(scheduledFlightId);
		return new ResponseEntity<ScheduledFlight>(HttpStatus.OK);
	}

	@PostMapping("/modify")
	public ResponseEntity<ScheduledFlight> modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {

		ScheduledFlight scheduledFlight1 = service.modifyScheduledFlight(scheduledFlight.getScheduledFlightId(),
				scheduledFlight.getAvailableSeats(), scheduledFlight.getFlightNumber(), scheduledFlight.getSchedule());

		return new ResponseEntity<ScheduledFlight>(scheduledFlight1, HttpStatus.OK);
	}

}
