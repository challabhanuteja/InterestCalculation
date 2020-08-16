package com.wipro.eb.service;

import com.wipro.eb.entity.Commercial;
import com.wipro.eb.entity.Connection;
import com.wipro.eb.entity.Domestic;
import com.wipro.eb.exception.InvalidConnectionException;
import com.wipro.eb.exception.InvalidReadingException;

public class ConnectionService {
	public boolean validate(int previousReading, int currentReading, String type) throws InvalidReadingException, InvalidConnectionException
	{
//		System.out.println(previousReading);
		if(currentReading<previousReading || currentReading<0 || previousReading<0)
		{
			throw new InvalidReadingException();
		}
		if(type.equals("Domestic") || type.equals("Commercial"))
		{
			
		}
		else
		{
			throw new InvalidConnectionException();
		}
		return true;
	}
	public float calculateBillAmt(int previousReading, int currentReading, String type)
	{
		boolean x;
		try
		{
			x = this.validate(previousReading, currentReading, type);
		}
		catch(InvalidReadingException e)
		{
			return -1;
		}
		catch(InvalidConnectionException e)
		{
			return -2;
		}
			Connection ob;
			if(type.equals("Commercial"))
			{
				ob = new Commercial(previousReading, currentReading, new float[]{(float)5.2,(float) 6.8,(float) 8.3});
			}
			else
			{
				ob = new Domestic(previousReading, currentReading, new float[]{(float) 2.3,(float) 4.2,(float) 5.5});
			}
			
			return ob.computeBill();
		
	}
	public String generateBill(int previousReading, int currentReading, String type)
	{
		float bill = this.calculateBillAmt(previousReading, currentReading, type);
		if(bill == -1)
		{
			return "Incorrect Reading";
		}
		else if(bill==-2)
		{
			return "Invalid ConnectionType";
		}
		else
		{
			return "Amount to be paid:"+bill;
		}
	}
}
