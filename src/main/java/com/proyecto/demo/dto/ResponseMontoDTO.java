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
public class ResponseMontoDTO {
	
	@ApiModelProperty(notes = "El monto actual")
	  private Double monto;
	
	@ApiModelProperty(notes = "El monto total cambiado")
	  private Double montototaltipoCambio;

	@ApiModelProperty(notes = "La moneda de origen")
	  private String monedadeOrigen;

	  @ApiModelProperty(notes = "La moneda Destino")
	  private String monedadeDestino;

	  @ApiModelProperty(notes = "El tipo de cambio")
	  private Double tipodecambio;
}
