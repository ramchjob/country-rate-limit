package com.learn.ratelimit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learn.ratelimit.model.CountryDto;
import com.learn.ratelimit.service.CountryService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RateLimiter(name = "basic")
public class CountryController {

	@Autowired
	CountryService service;
	
	@PostMapping( value = "/country")
	ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {
		CountryDto dto =  service.createCountry(countryDto);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/country/{id}")
	ResponseEntity<CountryDto> getCountry(@PathVariable("id") Integer countryId) {
		CountryDto dto =  service.getCountry(countryId);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping(value = "/country")
	ResponseEntity<List<CountryDto>> getCountry() {
		List<CountryDto> dtos =  service.getCountries();
		return ResponseEntity.ok(dtos);
	}
	
}
