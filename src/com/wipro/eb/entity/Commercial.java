package com.wipro.eb.entity;

public class Commercial extends Connection{

	public Commercial(int previousReading, int currentReading, float[] slabs) {
		super(previousReading, currentReading, slabs);
	}
	public float computeBill()
	{
		float bill = 0;
		int units = currentReading - previousReading;
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
		float electricityDuty = 0;
		if(bill>=10000)
		{
			electricityDuty = (float) 0.09;
		}
		else if(bill>=5000)
		{
			electricityDuty = (float) 0.06;
		}
		else
		{
			electricityDuty = (float) 0.02;
		}
		bill += bill*electricityDuty;
//		System.out.println(bill);
		return bill;
	}
	
}
