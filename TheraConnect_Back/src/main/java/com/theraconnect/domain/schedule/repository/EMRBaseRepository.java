package com.theraconnect.domain.schedule.repository;

import com.theraconnect.domain.schedule.entity.EmrBase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EMRBaseRepository extends JpaRepository<EmrBase, Long> {
}
