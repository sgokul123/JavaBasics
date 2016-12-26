package com.bridgelabz.inventory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class Appointment1 implements Comparator<Date> {
	int totalnumberofAppointment = 0;
	int nextTotalnumberofAppointment = 0;

	String patientName;
	long mobileNo;
	int doctorId;
	String date;
	String nextdate;
	Details details = new Details();
	Scanner sc = new Scanner(System.in);
	//Function to compare date
	public int compare(Date d1, Date d2) {
		if (d1.getYear() != d2.getYear())
			return d1.getYear() - d2.getYear();
		if (d1.getMonth() != d2.getMonth())
			return d1.getMonth() - d2.getMonth();
		return d1.getDate() - d2.getDate();
	}

	//function to count total appointment
	public int totalappointment(ArrayList<Appointment> appoints, int id) throws ParseException {
		totalnumberofAppointment = 0;
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		date = df.format(new Date());
		for (int i = 0; i < appoints.size(); i++) {
			// for (int j=0;j<appoints.size();j++ ) {
			if (id == appoints.get(i).getDocId()) {
				if (compare(df.parse(date), df.parse(appoints.get(i).getDate())) == 0)

				{
					totalnumberofAppointment++;
				}
			}
		}
		return totalnumberofAppointment;
	}
	//Function to schedule appointment
	public ArrayList<Appointment> scheduleAppointment(ArrayList<Doctor> doctor, ArrayList<Patient> patients,
			ArrayList<Appointment> appoints) throws ParseException {
		boolean found = false;
		// date format is specified
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		Calendar calendar = Calendar.getInstance();
		Appointment appoint = new Appointment();

		// The list of doctors available in hospital
		System.out.println("The list of doctors availabale in Clinic are :-");
		details.displayDoctor(doctor);

		// Max number of appointment per doctor is 5
		System.out.println("The Max number of appointment you can take is 5");
		// Doctor Name whose appointment you want to take

		date = sdf.format(new Date());

		System.out.println("Enter The doctor name from the above list to take appointment");
		String doctname = sc.next();

		for (Doctor doctor2 : doctor) {
			if (doctor2.getDoctorName().equalsIgnoreCase(doctname)) {
				found = true;
				doctorId = doctor2.getDoctorId();
				totalnumberofAppointment = totalappointment(appoints, doctor2.getDoctorId());
			}
		}

		if (found == true) { // Display total number of appointment of the same
								// day
			System.out.println("Number of appointment " + totalnumberofAppointment);
			System.out.println("Enter your name :");
			patientName = sc.next();
			boolean status = false;
			for (Patient patient2 : patients) {
				if (patient2.getPatientName().equalsIgnoreCase(patientName)) {
					mobileNo = patient2.getMobileNo();
					status = true;
				}
			} // If doctor found increase appointment till the limit of 5
			if (status == true && totalnumberofAppointment < 5) {
				totalnumberofAppointment++;
				System.out.println("The appointment for " + doctname + " " + "your appointment number is "
						+ totalnumberofAppointment + " " + " and your appointment date is " + " " + date);
				appoint.setDocId(doctorId);
				appoint.setPatName(patientName);
				appoint.setPatMobile(mobileNo);
				appoint.setDate(date);
				appoints.add(appoint);
			} else if (status == true && totalnumberofAppointment >= 5) {
				System.out.println("The Appointment for the day is Full ");
				// If appointment is full of for the current date than take the
				// appointment of the next date
				nextTotalnumberofAppointment++;
				System.out.println("Number of appointment " + nextTotalnumberofAppointment);
				// add the next date of the calendar
				calendar.add(Calendar.DATE, 1);
				// Displays the next date of appointment and appointment number
				nextdate = sdf.format(calendar.getTime());
				System.out.println(" Your Appointment is Schedule for the next date that is " + nextdate
						+ " and appointment number is " + nextTotalnumberofAppointment);
				appoint.setDocId(doctorId);
				appoint.setPatName(patientName);
				appoint.setPatMobile(mobileNo);
				appoint.setDate(nextdate);
				appoints.add(appoint);

			} else
				System.out.println("Please register your details");

		}
		return appoints;
	}
}