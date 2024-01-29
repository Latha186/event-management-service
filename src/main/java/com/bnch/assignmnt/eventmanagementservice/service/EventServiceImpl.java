package com.bnch.assignmnt.eventmanagementservice.service;

import com.bnch.assignmnt.eventmanagementservice.entity.Event;
import com.bnch.assignmnt.eventmanagementservice.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class EventServiceImpl implements EventService{
    private EventRepository eventRepository;
    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        Event existingEvent = eventRepository.findById(event.getId()).get();
        existingEvent.setTitle(event.getTitle());
        existingEvent.setDescription(event.getDescription());
        existingEvent.setDateUpdated(event.getDateUpdated());
        return eventRepository.save(existingEvent);
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getAllEventsByCreatedDateBetween(Date  dateCreatedFrom, Date dateCreatedTo) {
        return eventRepository.findAllByDateCreatedBetween(dateCreatedFrom,dateCreatedTo);
    }

    @Override
    public List<Event> getAllEventsBasedOnTitle(String title) {
        return eventRepository.findByTitleIgnoreCaseContaining(title);
    }


}
