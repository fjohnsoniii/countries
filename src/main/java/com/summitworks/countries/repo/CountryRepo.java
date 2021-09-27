package com.summitworks.countries.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.summitworks.countries.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Integer>{

	@Query(value = "SELECT c FROM Country c WHERE c.name= :name")
	public Country findByName(@Param ("name") String name);
}
