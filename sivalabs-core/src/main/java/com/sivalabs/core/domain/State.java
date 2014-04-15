/**
 * 
 */
package com.sivalabs.core.domain;


/**
 * @author skatam
 *
 */
public class State {
	private int id;
	private String name;
	
	public State() {
	}
	
	public State(int id, String name) {
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
	
}
