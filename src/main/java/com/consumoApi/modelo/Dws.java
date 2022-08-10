package com.consumoApi.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tbl_medidad")
@Data
public class Dws {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String barcode;
	private String weight;
	private String length;
	private String width;
	private String height;
}
