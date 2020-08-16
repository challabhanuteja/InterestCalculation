package com.wipro.eb.entity;

public class Domestic extends Connection {

	public Domestic(int previousReading, int currentReading, float[] slabs) {
		super(previousReading, currentReading, slabs);
	}
	public float computeBill()
	{
		float bill = 0;
		int units = currentReading - previousReading;
//		System.out.println(currentReading);
		for(int i=0;i<2;i++)
		{
			if(units>50)
			{
				bill += 50*slabs[i];
				units -= 50;
			}
			else if(units>0)
			{
				bill += units*slabs[i];
				units = 0;
				break;
			}
		}
		bill+=units*slabs[2];
		return bill;
	}
	
}
