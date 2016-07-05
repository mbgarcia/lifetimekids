package com.ninart.controllers;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import com.ninart.models.Child;
import com.ninart.repository.IChildRepository;

public class ChildControllerTest {
	
	
	@InjectMocks
	ChildController controller;
	
	@Mock
	IChildRepository repository;
	
	@Before
	public void setUp(){
		controller = new ChildController();
		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testChildHome() throws Exception{
		List<Child> children = new ArrayList<Child>();
		when(repository.findAll()).thenReturn(children);
		
		MockMvc mockMvc = standaloneSetup(controller)
				.setSingleView(new InternalResourceView("doesn't matter"))
				.build();
		
		mockMvc.perform(get("/child"))
		.andExpect(view().name("children/index"))
		.andExpect(model().attributeExists("children"))
		.andExpect(model().attribute("children", hasItems(children.toArray())));
	}
	
	@Test
	public void testNewChild() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(get("/child/new"))
			.andExpect(view().name("children/form"))
			.andExpect(model().attributeExists("child"));
	}
	
	@Test
	public void testSaveChildWithError() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/child/save"))
			.andExpect(model().hasErrors())
			.andExpect(model().attributeHasFieldErrors("child", "name", "birthday"))
			.andExpect(view().name("children/form"));
	}
	
	@Test
	public void testSaveChildWithErrorOnlyInBirthday() throws Exception{
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(post("/child/save").param("name", "Someone"))
		.andExpect(model().hasErrors())
		.andExpect(model().attributeHasFieldErrors("child", "birthday"))
		.andExpect(view().name("children/form"));
	}
	
	@Test
	public void testSaveChildWithSuccess() throws Exception{
		Child child = new Child();
		when(repository.save(child)).thenReturn(child);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(
				post("/child/save")
				.param("name", "Someone")
				.param("birthday", "01/01/2016")
			)
			.andExpect(redirectedUrl("/child"));
	}
	
	@Test
	public void testShowChildWithSuccess() throws Exception{
		Child child = new Child();
		when(repository.findOne(1L)).thenReturn(child);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		mockMvc.perform(
				get("/child/show/1")
			)
			.andExpect(view().name("children/show"));
	}
}
