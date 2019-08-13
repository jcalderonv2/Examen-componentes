package com.cenfotec.examen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Rig {

	@Id
	private String IDENTIFICATION;
	private String NAME;
	private String CONTINENT;
	private Integer LAND;
	private Integer SEA;

}
