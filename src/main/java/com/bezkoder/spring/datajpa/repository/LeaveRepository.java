package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

}

