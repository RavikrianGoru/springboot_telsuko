package com.example.webapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.webapp.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
	// CrudRepository supports basic curd operations
	// We can access custom query by declaring methods with some rules.
	//findBy<Property>();
	//findBy<Property>GreaterThan();
	//findBy<Property>();
	//
	//jql || hql || sql
	//@Query("from Alien where tech=? order by aname")
	//List<Alien> findByTechSorted(String tech);
	
	
	public List<Alien> findByAname(String name);
	public List<Alien> findByTech(String tech);
	public List<Alien> findByAidGreaterThan(Integer aid);//GreaterThan or LessThan...
	
	@Query("from Alien where tech=?1 order by aname")//SELECT * FROM Alien  where tech='java' order by aname
	public List<Alien> findByTechSorted(String name);
	
}
