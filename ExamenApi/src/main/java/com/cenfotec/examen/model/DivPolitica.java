package com.cenfotec.examen.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "divpolitica")

public class DivPolitica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODE;
	private Integer COUNTRY;
	private Integer DIVREGBIO;
	private String NAME;

}
