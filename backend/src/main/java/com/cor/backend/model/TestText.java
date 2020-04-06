package com.cor.backend.model;

import java.io.Serializable;

public class TestText implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text;
	private boolean working;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
	public TestText(String text, boolean working) {
		super();
		this.text = text;
		this.working = working;
	}
	public TestText() {
		super();
	}
	@Override
	public String toString() {
		return "TestText [text=" + text + ", working=" + working + "]";
	}
	
	
	
}
