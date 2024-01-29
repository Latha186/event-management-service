package com.bnch.assignmnt.eventmanagementservice;

import com.bnch.assignmnt.eventmanagementservice.controller.EventController;
import com.bnch.assignmnt.eventmanagementservice.entity.Event;
import com.bnch.assignmnt.eventmanagementservice.service.EventService;


import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class EventControllerTest {
    @InjectMocks
    EventController eventController;
    @Mock
    EventService eventService;

    @Test
    public void testCreateEvent() throws Exception{
        Event eventRes = new Event();
        Mockito.when(eventService.createEvent(new Event())).thenReturn(eventRes);
        assertNotNull(eventController.createEvent(new Event()));
    }
}


