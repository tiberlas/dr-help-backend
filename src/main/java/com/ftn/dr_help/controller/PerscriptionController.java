package com.ftn.dr_help.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftn.dr_help.repository.PerscriptionRepository;

@Service
public class PerscriptionController {

	@Autowired
	private PerscriptionRepository perscription;
	
	
	
}
