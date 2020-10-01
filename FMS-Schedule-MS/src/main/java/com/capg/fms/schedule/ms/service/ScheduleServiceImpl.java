package com.capg.fms.schedule.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.capg.fms.schedule.ms.exception.ScheduleAlreadyExistsException;
import com.capg.fms.schedule.ms.exception.ScheduledFlightNotFound;
import com.capg.fms.schedule.ms.model.Airport;
import com.capg.fms.schedule.ms.model.Flight;
import com.capg.fms.schedule.ms.model.Schedule;
import com.capg.fms.schedule.ms.model.ScheduledFlight;
import com.capg.fms.schedule.ms.model.ScheduledFlightList;
import com.capg.fms.schedule.ms.repo.IScheduleRepo;

@Service
public class ScheduleServiceImpl implements IScheduleService {

	@Autowired
	IScheduleRepo repo;

	@Override
	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight) {

		
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
