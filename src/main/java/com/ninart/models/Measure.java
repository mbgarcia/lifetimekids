package com.ninart.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="measure", schema="domain")
public class Measure {

	@Id
	@SequenceGenerator(name="seq_measure", sequenceName="domain.seq_measure", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_measure")
	private Long id;

	@Column
	private BigDecimal height;
	
	@Column
	private BigDecimal weight;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	public Date date;

	@ManyToOne
	@JoinColumn(name = "child_id", referencedColumnName = "id")
	private Child child;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Child getChild() {
		return child;
	}

	public void setChild(Child child) {
		this.child = child;
	}
}
