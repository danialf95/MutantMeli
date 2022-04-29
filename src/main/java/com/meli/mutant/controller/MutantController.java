package com.meli.mutant.controller;

import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.meli.mutant.model.LogAuditAdn;
import com.meli.mutant.repository.LogAuditAdnDao;
import com.meli.mutant.service.impl.MutantMeli;
import com.meli.mutant.utils.Helper;
@Component
public class MutantController {
		
	@Autowired
	LogAuditAdnDao PersistenceLog;
	@Autowired
	MutantMeli service;

	
	public MutantController() {
			super();
		}
	
	public boolean verificationMutant(String[] input) {
		    boolean verification = false;
		try {
			    //Registrar Log
		        LogAuditAdn log = new LogAuditAdn();
		        log.setRequest(Helper.generatePersistenceInput(input));
		        
		        verification = service.isMutant(service.generateMatrix(input));
	            
		        log.setResponse(verification);
		        Timestamp fechaActual = new Timestamp(Helper.obtenerFechaLocal().getTime());
		        log.setTime(fechaActual);
		        log= PersistenceLog.save(log);		      
				return verification;
			} catch (Exception e) {		
				throw new Error("Error in the controller: "+ e.getMessage());
			}
			
		}		
}
