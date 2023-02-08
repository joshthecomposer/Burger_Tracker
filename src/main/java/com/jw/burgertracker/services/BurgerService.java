package com.jw.burgertracker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jw.burgertracker.models.Burger;
import com.jw.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository r;
	
	public BurgerService(BurgerRepository r) {
		this.r = r;
	}
	
	public List<Burger> findAll(){
		return r.findAll();
	}
	
	public Burger create(Burger burger) {
		return r.save(burger);
	}
}
