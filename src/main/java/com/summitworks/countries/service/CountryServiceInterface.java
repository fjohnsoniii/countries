package com.summitworks.countries.service;

import java.util.List;

import com.summitworks.countries.entity.Country;

public interface CountryServiceInterface {

	public Country findByCountryId(int id);
	public Country findByCountryName(String name);
	public List<Country> findAllCountries();
	public void saveCountry(Country country);
	public Country editCountry(int id, Country country);
	public void deleteCountry(int id);
}
