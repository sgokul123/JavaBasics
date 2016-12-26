package com.bridgelabz.inventory;


import java.awt.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Details {
	Scanner sc = new Scanner(System.in);

	// Function to displayDoctor Details
	public void displayDoctor(ArrayList<Doctor> doc) {
		for (Doctor doctor : doc) {
			System.out.println("Doctor Name: " + doctor.getDoctorName() + " " + "Doctor Id : " + doctor.getDoctorId()
					+ " " + " Specializtion : " + doctor.getSpecializtion() + " " + " Availability : "
					+ doctor.getAvailability());
		}

	}
	// Function to add doctor details
	public ArrayList<Doctor> addDoctor(ArrayList<Doctor> doc) {
		
			Doctor doct = new Doctor();
			System.out.println("Enter the Doctor Details");

			// Enter Doctor Name here
			System.out.println("Enter doctor name");
			doct.setDoctorName(sc.next());

			// Enter Doctor Id here
			System.out.println("Enter Doctor Id");
			doct.setDoctorId(sc.nextInt());

			// Enter Specialization of the doctor
			System.out.println("Specialization of the Doctor is");
			doct.setSpecializtion(sc.next());

			// Enter Availability of the doctor
			System.out.println("Enter the Availabilty of the doctor");
			doct.setAvailability(sc.next());
			doc.add(doct);
		return doc;
	}

	// function to Display the Patient details
	public void displayPatient(ArrayList<Patient> pat) {
		for (Patient patient : pat) {
			System.out.println("Patient Name is: " + patient.getPatientName() + " " + "PatientId is: "
					+ patient.getPatientId() + " " + " " + "Patient Mobile no : " + patient.getMobileNo() + " "
					+ " Patient age is : " + patient.getPatientAge());
		}
	}

	// Function to add patient details
	public ArrayList<Patient> addPatient(ArrayList<Patient> pat) {

			Patient patient = new Patient();
			System.out.println("Enter the patient Details");

			// Enter the patient name
			System.out.println("Enter the patient Name ");
			patient.setPatientName(sc.next());

			// Enter the patient ID
			System.out.println("Enter the Patient id");
			patient.setPatientId(sc.nextInt());

			// Enter the patient Mobile Number
			System.out.println("Enter the Patient Mobile Number");
			patient.setMobileNo(sc.nextLong());

			// Enter the patient Age
			System.out.println("Enter the Age Of Patient");
			patient.setPatientAge(sc.nextInt());

			pat.add(patient);
		return pat;
	}
	public void displayApponitments(ArrayList<Appointment> appoints) {
		for (Appointment app :appoints ) {
			System.out.println("Doctor Id is: " + app.getDocId() + " " + "Patient name is: "
					+ app.getPatName() + " " + " " + "Patient Mobile no : " + app.getPatMobile() + " "
					+ " appointment date is : " + app.getDate());
		}
	}
}