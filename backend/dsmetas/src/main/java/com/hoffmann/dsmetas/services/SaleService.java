package com.hoffmann.dsmetas.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hoffmann.dsmetas.entities.Sale;
import com.hoffmann.dsmetas.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	public List<Sale> findSalesAll(){
		return repository.findAll();
	}
	
	public Page<Sale> findSalesDate(String minDate, String maxDate, Pageable pageable){
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate minD = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate maxD = maxDate.equals("")? today : LocalDate.parse(maxDate);
		return repository.findSalesPageDate(minD, maxD,pageable);
	}

}
