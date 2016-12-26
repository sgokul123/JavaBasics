package com.bridgelabz.inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class AppointmentMethods implements Comparator<Date> {
	int totalnumberofAppointment = 0;
	int nextTotalnumberofAppointment = 0;

	String patientName;
	long mobileNo;
	int doctorId;
	String appdate;
	Details details = new Details();
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	// date = df.format(new Date());
	Calendar calendar = Calendar.getInstance();

	// Function to compare date
	public int compare(Date d1, Date d2) {
		if (d1.getYear() != d2.getYear())
			return d1.getYear() - d2.getYear();
		if (d1.getMonth() != d2.getMonth())
			return d1.getMonth() - d2.getMonth();
		return d1.getDate() - d2.getDate();
	}

	// function to count total appointment for the date
	public int totalappointment(ArrayList<Appointment> appoints, int id) throws ParseException {
		totalnumberofAppointment = 0;
		appdate = df.format(calendar.getTime());
		for (int i = 0; i < appoints.size(); i++) {
			if (id == appoints.get(i).getDocId()) {
				if (compare(df.parse(appdate), df.parse(appoints.get(i).getDate())) == 0)
				{
					totalnumberofAppointment++;
				}
			}
		}
		if (totalnumberofAppointment > 4) {
			 //If appointment is full of for the current date than take the appointment of the next date
			System.out.println("Appointments list is full for the date "+appdate);
			calendar.add(Calendar.DATE, 1);//add the next date of the calendar
			totalappointment(appoints, id);
		}
		return totalnumberofAppointment;
	}

	// Function to schedule appointment
	public ArrayList<Appointment> scheduleAppointment(ArrayList<Doctor> doctor, ArrayList<Patient> patients,
			ArrayList<Appointment> appoints) throws ParseException {
		boolean found = false;
		// date format is specified
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Appointment appoint = new Appointment();

		// The list of doctors available in hospital
		System.out.println("The list of doctors availabale in Clinic are :-");
		details.displayDoctor(doctor);

		// Max number of appointment per doctor is 5
		System.out.println("The Max number of appointment you can take is 5");
		// Doctor Name whose appointment you want to take

		System.out.println("Enter The doctor name from the above list to take appointment");
		String doctname = sc.next();

		for (Doctor doctor2 : doctor) {
			if (doctor2.getDoctorName().equalsIgnoreCase(doctname)) {
				found = true;
				doctorId = doctor2.getDoctorId();
				totalnumberofAppointment = totalappointment(appoints, doctor2.getDoctorId());
			}
		}
		boolean status = false;
		if (found == true) {
			//Displays total appointments for the date
			System.out.println("Number of appointments of date " + appdate + " are " + totalnumberofAppointment);
			//Enter patient name for taking appointment
			System.out.println("Enter patient name :");
			patientName = sc.next();
			for (Patient patient2 : patients) {
				//checking patient is available in list 
				if (patient2.getPatientName().equalsIgnoreCase(patientName)) {
					mobileNo = patient2.getMobileNo();
					status = true;
				}
			}
		}
		if (status == true) {
			totalnumberofAppointment++;
			//Displays the date of appointment and appointment number
			System.out.println("The appointment for " + doctname + " " + "your appointment number is "
					+ totalnumberofAppointment + " " + " and your appointment date is " + " " + appdate);
			appoint.setDocId(doctorId);
			appoint.setPatName(patientName);
			appoint.setPatMobile(mobileNo);
			appoint.setDate(appdate);
			appoints.add(appoint);
		} else
			//patient name is not in patients list
			System.out.println("Please register your details");
		appdate=sdf.format(new Date());
		return appoints;
	}
}
