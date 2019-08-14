package com.cenfotec.examen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Biodiversity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODE;
	private String TYPE;
	private String POPULARNAME;
	private String SCIENTIFICNAME;
	private String INDANGER;
	private Integer POPULATION;
	private Integer COUNTRY;

}
