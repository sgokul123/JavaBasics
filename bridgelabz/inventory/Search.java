package com.bridgelabz.inventory;

import java.util.ArrayList;


public class Search 
{
	Doctor doctor=new Doctor();
	Details a=new Details();
	//function to search doctor Id from the list of doctors
	public void SearchDoctId(ArrayList<Doctor> Doctlist,int doctorId)
	{
		boolean found=false;
		for (Doctor doctor : Doctlist)
		{
			//Doctor id in array list equals to doctor id 
			if(doctor.getDoctorId()==doctorId)
				found=true;
		}
		if(found)
		{
			//if doctor id found in ArrayList
			System.out.println("The doctor id "+doctorId+" found in clinic management system ");

		}
		else
			//if doctor id not found in ArrayList
			System.out.println("The doctor id "+doctorId+" not found in clinic management system");
	}
	
	//function to search doctor Name from the list of doctors
	public void SearchDocName(ArrayList<Doctor>doc,String DoctName)
	{
		boolean found=false;
		for (Doctor doctor : doc) 
		{
			if(doctor.getDoctorName().equals(DoctName))
				found=true;
			
		}
		if(found)
		{
			//Doctor name found in Array list
			System.out.println("The Doctor "+DoctName+"  Found in the Clinic Management System");
		}
		else
			//Doctor name Does not exit in array list
			System.out.println("The doctor name "+DoctName+" not found in Clinic Management System");
		}
		
	
	
	//function to search doctor by Specialization from the list of doctors
	public void SearchDocSpec(ArrayList<Doctor> Doctlist,String Spec)
	{
		boolean found=false;
		for (Doctor doctor : Doctlist)
		{
			if(doctor.getSpecializtion().equalsIgnoreCase(Spec))
				found=true;
		}
		if(found)
		{
			//Doctor specialization found
			System.out.println("The doctor Specialization "+Spec+" found in clinic management system");
		}
		else
			//Doctor specialization not found
			System.out.println("The doctor Specialization "+Spec+" not found in clinic management system");
	}
	
	//function to search Patient Name from the list of Patients
	public void SearchPatName(ArrayList<Patient> Patlist,String PatName)
	{
		boolean found=false;
		for (Patient patient : Patlist)
		{
			if(patient.getPatientName().equals(PatName))
				found=true;
		}
		if(found)
		{
			//Patient name found in Clinic
			System.out.println("The Patient name "+PatName+" found in clinic management system");
		}
		else
			//patient name not found 
			System.out.println("The Patient name "+PatName+" not found in clinic management system");
	}
	
	//function to search Patient Id from the list of patients
	public void SearchPatId(ArrayList<Patient> Patlist,int PatId)
	{
		boolean found=false;
		for (Patient patient : Patlist) 
		{
			if(patient.getPatientId()==PatId)
				found=true;
		}
		if(found)
		{
			//patient Id found in Clinic
			System.out.println("The Patient Id "+PatId+" found in clinic management system");
		}
		else
			//patient Id not found in Clinic
			System.out.println("The Patient Id "+PatId+" not found in clinic management system");
	}
	
	//function to search Patient mobile from the list of patients
	public void SearchPatMob(ArrayList<Patient> Patlist,int Mobno)
	{
		boolean found=false;
		for (Patient patient : Patlist) 
		{
			if(patient.getMobileNo()==Mobno)
				found=true;
		}
		if(found)
		{
			//patient mobile no found in Clinic
			System.out.println("The Patient mobile no"+" "+Mobno+" found in clinic management system");
		}
		else
			//patient mobile no not found in Clinic
			System.out.println("The Patient mobile no "+" "+Mobno+" found in clinic management system");
	}
	
	//function to search Patient age from the list of patients
	public void SearchpatAge(ArrayList<Patient> Patlist,int age)
	{
		boolean found=false;
		for (Patient patient : Patlist) 
		{
			if(patient.getPatientAge()==age)
				found=true;
		}
		if(found)
		{
			//Patient age found in Clinic
			System.out.println("The of Patient Age "+age+" found in clinic management system");
		}
		else
			//Patient age not found in Clinic
			System.out.println("The Patient Age "+age +" found in clinic management system");
	}
}