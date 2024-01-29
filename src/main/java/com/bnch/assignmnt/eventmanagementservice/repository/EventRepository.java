package com.bnch.assignmnt.eventmanagementservice.repository;

import com.bnch.assignmnt.eventmanagementservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.sql.Date;


public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByDateCreatedBetween(Date dateCreatedFrom, Date dateCreatedTo);

    List<Event> findByTitleIgnoreCaseContaining(String title);

}

