package com.bnch.assignmnt.eventmanagementservice.controller;

import com.bnch.assignmnt.eventmanagementservice.entity.Event;
import com.bnch.assignmnt.eventmanagementservice.service.EventService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/events")
public class EventController {

    private EventService eventService;

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event saveEvent = eventService.createEvent(event);
        return new ResponseEntity<>(saveEvent, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Long eventId,
                                             @RequestBody Event event) {

        Event updatedEvent = eventService.updateEvent(event);
        return new ResponseEntity<>(updatedEvent, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long eventId) {
        eventService.deleteEvent(eventId);
        return new ResponseEntity<>("Event successfully deleted!", HttpStatus.OK);
    }

    @GetMapping("/eventsByDate")
    public ResponseEntity<List<Event>> eventsByDate(
            @RequestParam(name = "dateCreatedFrom", defaultValue = "") Date dateCreatedFrom,
            @RequestParam(name = "dateCreatedTo", defaultValue = "") Date dateCreatedTo) {
        List<Event> events = eventService.getAllEventsByCreatedDateBetween(dateCreatedFrom, dateCreatedTo);
        return new ResponseEntity<>(events, HttpStatus.CREATED);
    }
    @GetMapping("/eventsByTitle")
    public ResponseEntity<List<Event>> eventsByTitle(
            @RequestParam(name = "title", defaultValue = "") String title){
        List<Event> events = eventService.getAllEventsBasedOnTitle(title);
        return new ResponseEntity<>(events, HttpStatus.CREATED);
    }

}
