package com.bridgelabz.inventory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;

public class Clinique {
	//Function to write clinic data into json file
	public void writeintofile(ArrayList<Doctor> doctor, ArrayList<Patient> patients, ArrayList<Appointment> appoints) {
		JSONObject obj = new JSONObject();
		obj.put("Doctors", doctor);
		obj.put("Patients", patients);
		obj.put("Appointment", appoints);
		FileWriter file;
		try {
			file = new FileWriter("/home/bridgeit/Documents/Dhiresh/programs/Clinic.json");//file path
			file.write(new Gson().toJson(obj));//writing data into json file
			file.flush();
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args)
			throws FileNotFoundException, IOException, ParseException, java.text.ParseException {
		Scanner sc = new Scanner(System.in);
		Search search = new Search();
		char ch, ch1, ch2;
		JSONParser parser = new JSONParser();
		ArrayList<Doctor> doctorList = new ArrayList<Doctor>();						//Arraylist for doctors data
		ArrayList<Patient> patientList = new ArrayList<Patient>();					//Arraylist for patients data
		ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();		//Arraylist for appointments data

		Object obj = parser.parse(new FileReader("/home/bridgeit/Documents/Dhiresh/programs/Clinic.json"));

		// Creates a JSONObject
		JSONObject JObj = (JSONObject) obj;

		// Creates the Array of doctors data present in the file
		JSONArray ArrayObj = (JSONArray) JObj.get("Doctors");
		for (int i = 0; i < ArrayObj.size(); i++) {
			JSONObject doctoyArray = (JSONObject) ArrayObj.get(i);
			Doctor doctor = new Doctor();
			doctor.setDoctorName(doctoyArray.get("doctorName").toString());
			doctor.setSpecializtion(doctoyArray.get("Specializtion").toString());
			doctor.setDoctorId(Integer.parseInt(doctoyArray.get("doctorId").toString()));
			doctor.setAvailability(doctoyArray.get("availability").toString());
			doctorList.add(doctor);
		}
		// Creates the Array of patients data present in the file
		ArrayObj = (JSONArray) JObj.get("Patients");
		for (int i = 0; i < ArrayObj.size(); i++) {
			JSONObject patientArray = (JSONObject) ArrayObj.get(i);
			Patient patient = new Patient();
			patient.setPatientName(patientArray.get("patientName").toString());
			patient.setPatientId(Integer.parseInt(patientArray.get("patientId").toString()));
			patient.setMobileNo(Long.parseLong(patientArray.get("mobileNo").toString()));
			patient.setPatientAge(Integer.parseInt(patientArray.get("patientAge").toString()));
			patientList.add(patient);
		}
		// Creates the Array of appointments data present in the file
		ArrayObj = (JSONArray) JObj.get("Appointment");
		for (int i = 0; i < ArrayObj.size(); i++) {
			JSONObject appointArray = (JSONObject) ArrayObj.get(i);
			Appointment appoint = new Appointment();
			appoint.setDocId(Integer.parseInt(appointArray.get("docId").toString()));
			appoint.setPatName(appointArray.get("patName").toString());
			appoint.setPatMobile(Long.parseLong(appointArray.get("patMobile").toString()));
			appoint.setDate(appointArray.get("date").toString());
			appointmentList.add(appoint);
		}
		//creating object of Details class
		Details d = new Details();
		do {
			System.out.println(" Welcome to ClinicManagement System ");
			System.out.println("Select Your Operation from the list of operations:");
			System.out.println("1.Add Doctor");
			System.out.println("2.Add Patient");
			System.out.println("3.Print doctor");
			System.out.println("4.Print Patients");
			System.out.println("5.Take Appoinment");
			System.out.println("6.Print Appoinment");
			System.out.println("7.Search Doctor by name ,id or Availability");
			System.out.println("8.Search Patients by name ,id ");
			System.out.println("Enter Your Choice here ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				// call add Doctor function from Add all details class
				doctorList = d.addDoctor(doctorList);
				new Clinique().writeintofile(doctorList, patientList, appointmentList);
				break;
			}
			case 2: {
				// call add patient function to add all patient
				patientList = d.addPatient(patientList);
				new Clinique().writeintofile(doctorList, patientList, appointmentList);
				break;
			}
			case 3: {
				// displays all doctor details
				System.out.println("All doctor details are");
				d.displayDoctor(doctorList);
				break;
			}
			case 4: {
				// displays all patient details
				System.out.println("All Patient details are");
				d.displayPatient(patientList);

				break;
			}
			case 5: {
				// Schedule the appointment for the available doctors
				appointmentList = new AppointmentMethods().scheduleAppointment(doctorList, patientList, appointmentList);
				new Clinique().writeintofile(doctorList, patientList, appointmentList);
				break;
			}
			case 6: {
				// Display the list of Appointments for the day
				System.out.println("Apppointments are:");
				d.displayApponitments(appointmentList);
				break;
			}
			case 7: {
				do {
					// Search for the doctor Starts Here
					System.out.println("1.Search Doctor by Name ");
					System.out.println("2.Search Doctor By Id");
					System.out.println("3.Search Doctor by Specialization ");
					System.out.println(
							"Press 1 to search By Name.  Press 2 to search By Id. Press 3 to search by Specialization ");
					int searchChoice = sc.nextInt();

					switch (searchChoice) {

					case 1: {
						// Search the doctor by his name
						System.out.println("Enter the doctor Name to search Doctor");
						String dname = sc.next();
						// call search doctor name function to search doctor by
						// name
						search.SearchDocName(doctorList, dname);
						break;
					}
					case 2: {
						// search the doctor by his id
						System.out.println("Enter the Doctor Id to search Doctor");
						int doctid = sc.nextInt();
						// call search doctor Id function to search doctor by Id
						search.SearchDoctId(doctorList, doctid);
						break;
					}
					case 3: {
						// Search the doctor by Specialization
						System.out.println("Search Doctor by Specialization");
						String docSpec = sc.next();
						// call search doctor Specialization function to search
						// doctor by Specialization
						search.SearchDocSpec(doctorList, docSpec);
						break;
					}
					default:
						System.out.println("You have entered Wrong Choice");
					}
					System.out.println("Do you want to Continue with Doctor Search");
					ch1 = sc.next().charAt(0);
				} while (ch1 == 'y' || ch1 == 'Y');
				break;
			}
			case 8: {
				// Search for the patient begins here

				do {
					System.out.println("Search of the patient begins from here ");
					System.out.println("1.Search Patient by name ");
					System.out.println("2.Search Patient by Id");
					System.out.println("3.Search Patient by Mobile Number");
					System.out.println("4.Search Patient by Age");
					System.out.println("Enter Your Choice Here");
					int patchoice = sc.nextInt();

					switch (patchoice) {
					case 1: {
						// Search Patient by his name
						System.out.println("Enter the Patient name to search Patient ");
						String patname = sc.next();
						// call Search Patient Name function to search Patient
						// by name
						search.SearchPatName(patientList, patname);
						break;

					}
					case 2: {
						// search Patient by his Id
						System.out.println("Enter the patient Id to Search Patient");
						int patid = sc.nextInt();
						// call Search Patient Id function to search Patient by
						// ID
						search.SearchPatId(patientList, patid);
						break;
					}
					case 3: {
						// search Patient by his Mobile number
						System.out.println("Enter the mobile number to Search patient");
						int patmob = sc.nextInt();
						// call Search Patient mobile function to search Patient
						// by his mobile number
						search.SearchPatMob(patientList, patmob);
						break;
					}
					case 4: {
						// Search Patient by his Age
						System.out.println("Enter the Age of the Patient to Search ");
						int patage = sc.nextInt();
						// call Search Patient Age function to search Patient by
						// his Age
						search.SearchpatAge(patientList, patage);
						break;
					}
					default:
						System.out.println("Your Have Entered invalid choice ");
						break;
					}
					System.out.println("Do you want to continue With Patient Search");
					ch2 = sc.next().charAt(0);

				} while (ch2 == 'y' || ch2 == 'Y');
			}
			default:
				System.out.println("Your Have Entered invalid choice ");
				break;
			}
			System.out.println("Do you want to continue with Clinic management System");
			ch = sc.next().toString().charAt(0);
		} while (ch == 'y' || ch == 'Y');
	}
}