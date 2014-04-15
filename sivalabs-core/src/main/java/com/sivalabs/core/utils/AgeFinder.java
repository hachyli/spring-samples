/**
 * 
 */
package com.sivalabs.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author skatam
 *
 */
public class AgeFinder
{
	private Date dob;
	private Date today;
	
	private int dobYear;
	private int dobMonth;
	private int dobDay;
	private int thisYear;
	private int thisMonth;
	private int thisDay;
	
	private AgeFinder(Date date)
	{
		this.dob = date;
		this.today = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.setTime(dob);
		this.dobYear = calendar.get(Calendar.YEAR);
		this.dobMonth = calendar.get(Calendar.MONTH);
		this.dobDay = calendar.get(Calendar.DATE);
		
		calendar.clear();
		calendar.setTime(today);
		this.thisYear = calendar.get(Calendar.YEAR);
		this.thisMonth = calendar.get(Calendar.MONTH);
		this.thisDay = calendar.get(Calendar.DATE);
		
	}
	public static AgeFinder build(Date date)
	{
		if(date == null){
			throw new RuntimeException("Invalid Date :"+date);
		}
		return new AgeFinder(date);
	}
	
	public static AgeFinder build(String MMddyyyyDate)
	{
		if(MMddyyyyDate == null){
			throw new RuntimeException("Invalid Date :"+MMddyyyyDate);
		}
		Date dt = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		try {
			dt = dateFormat.parse(MMddyyyyDate);
			Date today = new Date();
			if(today.before(dt)){
				throw new RuntimeException("Given Date is a future date :"+MMddyyyyDate);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid Date :"+MMddyyyyDate);
		}
		return new AgeFinder(dt);
	}
	
	public Date getDob(){
		return this.dob;
	}
	
	public int getAgeInYears() {
		int years = thisYear - dobYear;
		
		return years;
	}
	
	public int getAgeInMonths(){
		return 1;
	}
	
	public int getAgeInDays(){
		return 1;
	}
	
	public void printAge() {
		System.out.println("DOB:"+this.dob);
		System.out.println("Today: "+this.today);
		
		int years = this.thisYear - this.dobYear;
		
		if(this.dobMonth > this.thisMonth){
			years--;
		}
	
		if(this.dobMonth == this.thisMonth && this.dobDay > this.thisDay){
			years--;
		}
		System.out.println("AgeFinder = "+years+" years");
	}
	public static void main(String[] args) throws Exception
	{
		AgeFinder age = AgeFinder.build("06/25/1983");
		age.printAge();
	}

}
