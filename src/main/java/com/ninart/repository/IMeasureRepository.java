package com.ninart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninart.models.Child;
import com.ninart.models.Measure;

public interface IMeasureRepository extends JpaRepository<Measure, Long>{
	public List<Measure> findByChild(Child child);

}
