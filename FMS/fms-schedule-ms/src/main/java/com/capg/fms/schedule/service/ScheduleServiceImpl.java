package com.capg.fms.schedule.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.fms.schedule.exceptions.ScheduleAlreadyExistsException;
import com.capg.fms.schedule.exceptions.ScheduledFlightNotFound;
import com.capg.fms.schedule.model.Airport;
import com.capg.fms.schedule.model.Flight;
import com.capg.fms.schedule.model.Schedule;
import com.capg.fms.schedule.model.ScheduledFlight;
import com.capg.fms.schedule.model.ScheduledFlightList;
import com.capg.fms.schedule.repository.IScheduleRepo;



@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	IScheduleRepo repo;

	@Autowired
	RestTemplate restTemplate;


	Logger logger = LoggerFactory.getLogger(ScheduleServiceImpl.class);
	
	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {

		String sourceAirportName = scheduledFlight.getSchedule().getSourceAirport();
		String destinationAirportName = scheduledFlight.getSchedule().getDestinationAirport();
		long flightNumber = scheduledFlight.getFlightNumber();

		
		Airport sourceAirport = restTemplate.getForObject("http://airport-ms/airport/airportname/" + sourceAirportName,
				Airport.class);
		Airport destinationAirport = restTemplate
				.getForObject("http://airport-ms/airport/airportname/" + destinationAirportName, Airport.class);
		Flight flightNumberFromFlight = restTemplate.getForObject("http://flight-ms/flights/id/" + flightNumber,
				Flight.class);

		if (sourceAirport.equals(destinationAirport)) {
			
			logger.error("Same Source And Destination Airport Error "); 
			  
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
		if (sourceAirport == null || destinationAirport == null) {
			
			logger.error(" Source And Destination Airport Cannot be NULL "); 
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

		if (flightNumberFromFlight == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		if (repo.existsById(scheduledFlight.getScheduledFlightId())) {

			logger.info("Scheduled Flight ID already Exists."); 
			throw new ScheduleAlreadyExistsException("ScheduledFlightId already exists");

		}
		if (repo.existsById(scheduledFlight.getSchedule().getScheduleId())) {

			logger.info("Schedule ID already Exists."); 
			throw new ScheduleAlreadyExistsException("Schedule Id Already Exists");

		}


		return repo.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight viewScheduledFlight(int scheduleId) {

		if (!repo.existsById(scheduleId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		return repo.findById(scheduleId).get();
	}

	@Override
	public ScheduledFlightList viewScheduledFlight() {

		return new ScheduledFlightList(repo.findAll());
	}

	@Override
	public void deleteScheduledFlight(int scheduledFlightId) {
		if (!repo.existsById(scheduledFlightId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		repo.deleteById(scheduledFlightId);

	}

	@Override
	public ScheduledFlight modifyScheduledFlight(int scheduledFlightId, int availableSeats, long flightNumber,
			Schedule schedule) {

		if (!repo.existsById(scheduledFlightId)) {
			throw new ScheduledFlightNotFound("Scheduled Flight not found");
		}
		ScheduledFlight scheduledFlight = repo.getOne(scheduledFlightId);
		scheduledFlight.setAvailableSeats(availableSeats);
		scheduledFlight.setFlightNumber(flightNumber);
		scheduledFlight.setSchedule(schedule);
		repo.save(scheduledFlight);

		return scheduledFlight;
	}

}
