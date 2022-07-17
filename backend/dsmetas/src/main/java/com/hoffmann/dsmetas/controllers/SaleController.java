package com.hoffmann.dsmetas.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hoffmann.dsmetas.entities.Sale;
import com.hoffmann.dsmetas.services.SaleService;
import com.hoffmann.dsmetas.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@Autowired
	private SmsService smsService;
	
	//@GetMapping
	//public List<Sale> findSalesAll(){
		//return service.findSalesAll();
	//} Buscando todos dados de uma vez
	
	//@GetMapping
	//public Page<Sale> findSalesPage(Pageable pageable){
		//return service.findSalesPage(pageable);
	//}buscando parcialmente os resultados do banco de dados através de paginação(20)
	
	@GetMapping
	public Page<Sale> findSalesPage(
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate,
			Pageable pageable){
		return service.findSalesDate(minDate, maxDate, pageable);
	}
	
	//@GetMapping("/notification")
	//public void notifySms() {
		//smsService.sendSms();
	//} testando serviço de sms
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
