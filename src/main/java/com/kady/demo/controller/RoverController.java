package com.kady.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kady.demo.model.Rover;
import com.kady.demo.service.RoverService;

@RestController
@RequestMapping(RoverController.PATH)
public class RoverController {

	public static final String PATH = "v1/api";
	@Autowired
	private RoverService service;

	@GetMapping
	public Rover start(@RequestParam String move) {
		return service.process(move);
	}
}
