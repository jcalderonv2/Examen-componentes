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
public class DivPolitica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer CODE;
	private String COUNTRY;
	private String NAME;

}
