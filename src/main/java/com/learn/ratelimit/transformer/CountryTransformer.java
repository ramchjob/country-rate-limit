package com.learn.ratelimit.transformer;

import com.learn.ratelimit.entity.Country;
import com.learn.ratelimit.model.CountryDto;

public class CountryTransformer {

	public static Country mapCountry(CountryDto countryDto) {
	    Country country = new Country();
	    country.setName(countryDto.getName());
		return country;
	}

	public static CountryDto mapCountryDto(Country country) {
		CountryDto dto = new CountryDto();
		dto.setId(country.getId());
		dto.setName(country.getName());
		return dto;
	}
	
	

}
