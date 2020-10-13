package com.capg.fms.flight.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.fms.flight.model.Schedule;


@Repository
public interface IAvailabilityScheduleRepo extends JpaRepository<Schedule, String> {

	@Query(value = "from Schedule where sourceAirport=:sourceAirport")
	public Schedule existsSourceAirport(String sourceAirport);
	
	@Query(value = "from Schedule where destinationAirport=:destinationAirport")
	public Schedule existsDestinationAirport(String destinationAirport);
}
