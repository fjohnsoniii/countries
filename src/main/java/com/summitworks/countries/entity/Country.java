package com.summitworks.countries.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "countries")
public class Country {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@NotNull
	private int id;
	
	@Column
	@NotNull
	@Size(min = 4, max = 20)
	private String name;
	
	@Column
	@NotNull
	@Size(min = 4, max = 20)
	private String capital;
	
	@Column
	@NotNull
	@Min(value = 200000)
	private long population;
	
	public Country() {
		super();
	}
	
	public Country(String name, String capital, long population) {
		this.name = name;
		this.capital = capital;
		this.population = population;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", capital=" + capital + ", population=" + population + "]";
	}
}
