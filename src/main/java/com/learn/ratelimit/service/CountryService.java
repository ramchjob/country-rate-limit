package com.learn.ratelimit.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.ratelimit.entity.Country;
import com.learn.ratelimit.model.CountryDto;
import com.learn.ratelimit.repository.CountryRepository;
import com.learn.ratelimit.transformer.CountryTransformer;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository repository;

	public CountryDto createCountry(CountryDto countryDto) {
		Country country = CountryTransformer.mapCountry(countryDto);
		repository.save(country);
		CountryDto updated = CountryTransformer.mapCountryDto(country);
		return updated;
	}

	public CountryDto getCountry(Integer countryId) {
		Optional<Country> country = repository.findById(countryId);
		if (country.isEmpty()) {
			return null;
		}
		CountryDto updated = CountryTransformer.mapCountryDto(country.get());
		return updated;
	}

	public List<CountryDto> getCountries() {
		List<Country> objs= repository.findAll();
		return objs.stream().map( o -> {CountryDto dto = new CountryDto();
		   dto.setId(o.getId());
		   dto.setName(o.getName());
		   return dto;
		}).collect(Collectors.toList());
	}
	
	

}
