package com.wipro.eb.entity;

public abstract class Connection {
	int previousReading;
	int currentReading;
	float[] slabs;
	public Connection(int previousReading, int currentReading, float[] slabs) {
		this.previousReading = previousReading;
		this.currentReading = currentReading;
		this.slabs = slabs;
	}
	public abstract float computeBill();

}
