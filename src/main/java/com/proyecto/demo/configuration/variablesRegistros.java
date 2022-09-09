package com.proyecto.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Data;

@Configuration
@Data
public class variablesRegistros {

	  @Value("${prue.total-cambio}")
	  private String tipodecambio;
}
