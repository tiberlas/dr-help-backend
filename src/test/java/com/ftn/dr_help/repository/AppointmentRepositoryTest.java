package com.ftn.dr_help.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

public class AppointmentRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Test
	public void test() {
		
	}

}
