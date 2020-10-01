package com.capg.fms.schedule.ms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capg.fms.schedule.ms.model.ScheduledFlight;

public interface IScheduleRepo extends JpaRepository<ScheduledFlight, Integer> {

}
