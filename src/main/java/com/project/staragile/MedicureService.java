package com.project.staragile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicureService {

	@Autowired
	MedicureRepository doctorRepository;

	public Doctor registerDoctor(Doctor doctor) {
		return doctorRepository.save(doctor);
	}

	public Doctor createDoctor() {
		Doctor doctor = new Doctor("MP1110", "Shubham", "Neurologist", "15 Years");
		return doctorRepository.save(doctor);
	}

	public Doctor getDoctorDetails(String doctorRegistrationId) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(doctorRegistrationId).get();
	}

	public Doctor registerDummyDoctor() {
		Doctor doctor = new Doctor("MP1110", "Shubham", "Neurologist", "15 Years");
		return doctor;
	}

	public String sayHello() {
		return "Hello from Doctor Shubham";
	}

	public Doctor updateDoctor(Doctor doctor, String doctorRegistrationId) {
		Doctor dc = doctorRepository.findById(doctorRegistrationId).get();
		dc.setDoctorExperience(doctor.getDoctorExperience());
		dc.setDoctorName(doctor.getDoctorName());
		dc.setDoctorSpeciality(doctor.getDoctorSpeciality());
		dc.setDoctorExperience(doctor.getDoctorExperience());

		doctorRepository.save(dc);
		return dc;
	}

	public Doctor searchDoctorbyName(String doctorRegistrationId) {
		return doctorRepository.findById(doctorRegistrationId).get();
	}

	public String deleteDoctorDetails(String doctorRegistrationId) {
		doctorRepository.deleteById(doctorRegistrationId);
		return "Doctor Deleted Successfully";
	}

}
