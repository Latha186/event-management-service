package com.bnch.assignmnt.eventmanagementservice.service;

import com.bnch.assignmnt.eventmanagementservice.entity.Event;

import java.sql.Date;
import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event updateEvent(Event event);

    void deleteEvent(Long eventId);

    List<Event> getAllEventsByCreatedDateBetween(Date CreationDateFrom, Date creationDateTo);

    List<Event> getAllEventsBasedOnTitle(String title);
}
