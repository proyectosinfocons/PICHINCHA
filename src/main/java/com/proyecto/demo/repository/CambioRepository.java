package com.proyecto.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.demo.model.tipodeCambio;

public interface CambioRepository extends JpaRepository<tipodeCambio,Integer>{
//findByMonedadeOrigenAndMonedadeDestino
	  tipodeCambio findByMonedadeOrigenAndMonedadeDestino(String monedaOrigen, String monedaDestino);
}
