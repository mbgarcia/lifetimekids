package com.ninart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ninart.models.Child;
import com.ninart.models.Event;

public interface IEventRepository extends JpaRepository<Event, Long>{
	public List<Event> findByChild(Child child);

}
