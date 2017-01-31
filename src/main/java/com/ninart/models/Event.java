package com.ninart.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="event", schema="domain")
public class Event {

	@Id
	@SequenceGenerator(name="seq_event", sequenceName="domain.seq_event", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_event")
	private Long id;

	@NotBlank
	@Size(max = 144)
	private String message;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@NotNull
	@Temporal(TemporalType.DATE)
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
