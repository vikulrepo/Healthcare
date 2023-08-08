package com.project.staragile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMedicureService {
	
	@Autowired
	MedicureService doctorService;
	
	@Test
	public void testRegisterDoctor() {
		Doctor doctor = new Doctor("MP1110","Shubham","Neurologist","15 Years");
		assertEquals(doctor.getDoctorRegistrationId(), doctorService.registerDummyDoctor().getDoctorRegistrationId());
	}
	
	@Test
    public void testUpdateDoctor() {
        Doctor doctorUpdated = new Doctor("MP1110", "vikul Updated", "MBBS", "15 Years");
        Doctor doctor = new Doctor("MP1110", "vikul", "MBBS", "15 Years");
        doctorService.registerDoctor(doctor);
        assertEquals(doctorService.updateDoctor(doctorUpdated, "MP1110").getDoctorName(), doctorUpdated.getDoctorName());

    }

    @Test
    public void testSearchDoctor() {
        Doctor doctor = new Doctor("MP1110", "vikul", "MBBS", "15 Years");
        doctorService.registerDoctor(doctor);
        assertEquals(doctorService.searchDoctorbyName("MP1110").getDoctorName(), doctor.getDoctorName());
    }

    @Test
    public void testDeleteDoctor() {
        Doctor doctor = new Doctor("MP1110", "vikul", "MBBS", "15 Years");
        doctorService.registerDoctor(doctor);
        String expect = "Doctor Deleted Successfully";
        assertEquals(expect, doctorService.deleteDoctorDetails("MP1110"));
    }

}
