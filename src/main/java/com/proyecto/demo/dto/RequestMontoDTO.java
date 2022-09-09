package com.proyecto.demo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestMontoDTO {
	
	@ApiModelProperty(notes = "El monto actual")
	  private Double monto;
	
	@ApiModelProperty(notes = "La moneda origen")
	  private String monedadeOrigen;

	@ApiModelProperty(notes = "La moneda destino")
	  private String monedadeDestino;

}
