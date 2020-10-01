package com.capg.fms.schedule.ms.service;

import com.capg.fms.schedule.ms.model.Schedule;
import com.capg.fms.schedule.ms.model.ScheduledFlight;
import com.capg.fms.schedule.ms.model.ScheduledFlightList;

public interface IScheduleService {

	public ScheduledFlight addScheduleFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight viewScheduledFlight(int scheduleId);

	public ScheduledFlightList viewScheduledFlight();

	public ScheduledFlight modifyScheduledFlight(int scheduledFlightId, int availableSeats, long flightNumber,
			Schedule schedule);

	public void deleteScheduledFlight(int scheduledFlightId);

}
