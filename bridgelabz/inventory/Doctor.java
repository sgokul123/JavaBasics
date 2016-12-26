package com.bridgelabz.inventory;


public class Doctor 
{
	private String doctorName;
	private String Specializtion;
	private int doctorId;
	private String availability;
		
	public String getDoctorName() 
	{
		return doctorName;
	}

	public void setDoctorName(String doctorName)
	{
		this.doctorName = doctorName;
	}

	public String getSpecializtion() 
	{
		return Specializtion;
	}

	public void setSpecializtion(String specializtion) 
	{
		Specializtion = specializtion;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) 
	{
		this.doctorId = doctorId;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	
	
}
