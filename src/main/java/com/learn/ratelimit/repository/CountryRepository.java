package com.learn.ratelimit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.ratelimit.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>{

}
