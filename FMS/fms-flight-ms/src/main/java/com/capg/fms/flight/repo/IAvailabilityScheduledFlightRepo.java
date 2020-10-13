package com.capg.fms.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.fms.flight.model.ScheduledFlight;

@Repository
public interface IAvailabilityScheduledFlightRepo extends JpaRepository<ScheduledFlight, Long> {

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ScheduledFlight c WHERE c.flightNumber = :flightNumber")
	public boolean existsByFlightNumber(long flightNumber);
	
	@Query(value = "SELECT CASE WHEN COUNT(c) < 0 THEN true ELSE false END FROM ScheduledFlight c WHERE c.availableSeats = :availableSeats")
	public boolean existsAvailableSeats(int availableSeats);

	@Query(value = "SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM ScheduledFlight c WHERE c.availableSeats < :availableSeats")
	public boolean exists(int availableSeats);

	@Query(value = "select availableSeats from ScheduledFlight where flightNumber = 102")
	public int getAvailableSeats(long flightNumber , int availableSeats);
	
	
	
}
