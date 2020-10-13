package com.capg.fms.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.fms.user.model.Airport;
import com.capg.fms.user.model.AirportList;
import com.capg.fms.user.model.Flight;
import com.capg.fms.user.model.FlightList;
import com.capg.fms.user.model.ScheduledFlight;
import com.capg.fms.user.model.ScheduledFlightList;
import com.capg.fms.user.service.AdminService;

@RestController
@RequestMapping("/users/admin")

public class AdminController {

	@Autowired
	AdminService service;

	@GetMapping("/flights/all")
	public FlightList viewAllFlights() {
		return service.viewAllFlights();
	}

	@PostMapping("/flights/add")
	public Flight addFlight(@RequestBody Flight flight) {
		return service.addFlight(flight);
	}

	@GetMapping("/flights/id/{flightNumber}")
	public Flight viewFlight(@PathVariable long flightNumber) {
		return service.viewFlight(flightNumber);
	}

	@DeleteMapping("/flights/deleteById/{flightNumber}")
	public void cancelFlight(@PathVariable long flightNumber) {
		service.cancelFlight(flightNumber);
	}

	@PostMapping("/flights/modify")
	public Flight modifyFlight(@RequestBody Flight flight) {
		return service.modifyFlight(flight);
	}

	@PostMapping("/scheduleflight/add")
	public ScheduledFlight addScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		return service.addScheduledFlight(scheduledFlight);
	}

	@GetMapping("/scheduleflight/id/{scheduledFlightId}")
	public ScheduledFlight viewScheduledFlight(@PathVariable long scheduledFlightId) {
		return service.viewScheduledFlight(scheduledFlightId);
	}

	@DeleteMapping("/scheduleflight/delete/{scheduledFlightId}")
	public void cancelScheduledFlight(@PathVariable long scheduledFlightId) {
		service.cancelScheduledFlight(scheduledFlightId);

	}

	@PostMapping("/scheduleflight/modify")
	public ScheduledFlight modifyScheduledFlight(@RequestBody ScheduledFlight scheduledFlight) {
		return service.modifyScheduledFlight(scheduledFlight);
	}

	@GetMapping("/scheduleflight/viewall")
	public ScheduledFlightList viewAllScheduledFlight() {
		return service.viewAllScheduledFlight();
	}

	@GetMapping("/airport/all")
	public AirportList getAllAirports() {
		return service.getAllAirports();
	}

	@GetMapping("/airport/{airportCode}")
	public Airport getAirportByCode(@PathVariable String airportCode) {
		return service.getAirportByCode(airportCode);
	}

	@PostMapping("/airport/add")
	public Airport addAirport(@RequestBody Airport airport) {
		return service.addAirport(airport);
	}

	@DeleteMapping("/airport/delete/{airportCode}")
	public void deleteAirport(@PathVariable String airportCode) {
		service.deleteAirport(airportCode);
	}

}
