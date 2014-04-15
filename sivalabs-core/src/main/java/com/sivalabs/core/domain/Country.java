/**
 * 
 */
package com.sivalabs.core.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author skatam
 *
 */
public class Country {
	private int id;
	private String name;
	private List<State> states = new ArrayList<State>();
	
	public Country() {
	}
	
	public Country(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<State> getStates() {
		return states;
	}

	public void addStates(List<State> states) {
		this.states.addAll(states);
	}
	public void addState(State state) {
		this.states.add(state);
	}
}
