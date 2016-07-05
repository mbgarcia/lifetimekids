package com.ninart.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import com.ninart.models.Child;
import com.ninart.models.Event;
import com.ninart.repository.IEventRepository;

public class EventControllerTest {
	
	@InjectMocks
	EventController controller;
	
	@Mock
	IEventRepository repository;
		
	@Before
	public void init(){
		controller = new EventController();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShowEventsFromChild() throws Exception{
		Child child = new Child();
		child.setId(1L);
		
		List<Event> events = new ArrayList<>();
		when(repository.findByChild(child)).thenReturn(events);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(
			get("/child/1/events")
		).andExpect(view().name("events/index"));
	}
	
	@Test
	public void testShowFormEvent() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(
			get("/child/1/events/new")
		).andExpect(view().name("events/form"));
	}
	
	@Test
	public void testSaveEventWithErrors() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(
			post("/child/1/events/save")
		)
		.andExpect(model().hasErrors())
		.andExpect(model().attributeHasFieldErrors("event", "message", "date"))
		.andExpect(view().name("events/form"));
	}
	
	@Test
	public void testSaveEventWithSuccess() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(
				post("/child/1/events/save")
				.param("message", "New Event")
				.param("date", "01/01/2011")
				)
		.andExpect(redirectedUrl("/child/1/events"));
	}	
}
