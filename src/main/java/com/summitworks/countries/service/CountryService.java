package com.summitworks.countries.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.summitworks.countries.entity.Country;
import com.summitworks.countries.repo.CountryRepo;

@Service
public class CountryService implements CountryServiceInterface {

	@Autowired
	CountryRepo cRepo;
	
	@Override
	public Country findByCountryId(int id) {
		return cRepo.getById(id);
	}

	@Override
	public Country findByCountryName(String name) {
		return cRepo.findByName(name);
	}

	@Override
	public List<Country> findAllCountries() {
		return cRepo.findAll();
	}

	@Override
	public void saveCountry(Country country) {
		cRepo.save(country);
	}
	
	@Override
	public Country editCountry(int id, Country country) {
		Country c = cRepo.getById(id);
		c.setId(country.getId());
		c.setName(country.getName());
		c.setCapital(country.getCapital());
		c.setPopulation(country.getPopulation());
		
		final Country updatedCountry = cRepo.save(c);
		return updatedCountry;
	}

	@Override
	public void deleteCountry(int id) {
		cRepo.deleteById(id);
	}
}
