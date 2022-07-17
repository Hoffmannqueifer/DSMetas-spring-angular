package com.hoffmann.dsmetas.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hoffmann.dsmetas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :minD AND :maxD ORDER BY obj.amount DESC")
	Page<Sale> findSalesPageDate(LocalDate minD, LocalDate maxD, Pageable pageable);
}
