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
	private String id;
	private String name;
	private String continent;
	private int land;
	private int sea;

}
