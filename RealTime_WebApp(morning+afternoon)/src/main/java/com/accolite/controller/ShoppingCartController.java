package com.accolite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.model.Quantity;
import com.accolite.model.ShoppingCart;
import com.accolite.services.ShoppingCartService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


@RestController
public class ShoppingCartController {
	
	@CrossOrigin
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<String> allDetails() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		List<ShoppingCart> response = ShoppingCartService.getDetails();
		String arrayToJson = objectMapper.writeValueAsString(response);
		System.out.println("Get Request Reached");
		return new ResponseEntity<>(arrayToJson, HttpStatus.CREATED);
	}

	
	@CrossOrigin
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json") 
	public ResponseEntity<String> allDetails(@RequestBody List<Quantity> quantity) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		List<Quantity> response = ShoppingCartService.updateQuantity(quantity);
				
		String arrayToJson = objectMapper.writeValueAsString(response);
		System.out.println("Post Request Reached");
		return new ResponseEntity<>(arrayToJson, HttpStatus.CREATED);
	}
	
	
}
