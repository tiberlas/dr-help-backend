package com.ftn.dr_help.controller;

import java.util.List;

import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ftn.dr_help.dto.AppointmentListDTO;
import com.ftn.dr_help.dto.PatientHistoryDTO;
import com.ftn.dr_help.service.AppointmentService;

@SpringBootTest
public class AppointmentControllerGetPredefinedTest {

	@InjectMocks
	@Autowired
	private AppointmentController appointmentController;
	
	@MockBean 
	private AppointmentService appointmentService;
	
	private AppointmentListDTO appointmentListDTO;
	private List<PatientHistoryDTO> appointmentList;
	
	
	
	
}
