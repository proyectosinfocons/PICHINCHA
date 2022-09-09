package com.proyecto.demo.controller;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.demo.dto.RequestMontoDTO;
import com.proyecto.demo.dto.ResponseMontoDTO;
import com.proyecto.demo.model.tipodeCambio;
import com.proyecto.demo.service.cambioService;

import lombok.AllArgsConstructor;



@AllArgsConstructor
@RestController
@RequestMapping("/principal")
public class cambioController {

	
	  private cambioService montoService;

  @ApiOperation(value = "Devolver el monto total de tipo cambio")
	  @PostMapping(value = "/tipodecambio")
	  public ResponseEntity<Single<ResponseMontoDTO>> montototaldetipocambio(@RequestBody RequestMontoDTO requestCambioMontoDto) {
	    Single<ResponseMontoDTO> cambioMontoDtoSingle = montoService.listatipodecambio(requestCambioMontoDto);
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(cambioMontoDtoSingle);
	  }
	
	
	  
	  
	  
	  @ApiOperation(value = "todos los tipos de montos de cambios")
	  @GetMapping(value = "/listadotodos")
	  public ResponseEntity<Observable<tipodeCambio>> listartodostipos() {
	    Observable<tipodeCambio> listTipoCambio = montoService.findAll();
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(listTipoCambio);
	  }
	
	  
	  
	  
	  @ApiOperation(value = "Listado de los montos por id")
	  @GetMapping(value = "/tipodecambio/{id}")
	  public Maybe<ResponseEntity<tipodeCambio>> listadodetipocambioID(@PathVariable Integer id) {
	    return montoService.findById(id).map(responsemontotipocambio ->ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(responsemontotipocambio)).defaultIfEmpty(ResponseEntity.notFound().build());
	  }
	  
	  
	  
	  
	  @ApiOperation(value = "Actualizar el tipo de cambio")
	  @PutMapping(value = "/actualizartipo/{id}")
	  public ResponseEntity<Single<tipodeCambio>> actualizartipocambio(@RequestBody tipodeCambio montotipo, @PathVariable Integer id) {
	    Single<tipodeCambio> tipoCambioMaybe = montoService.findById(id).toSingle().flatMap(responsetipo -> {montotipo.setCodigo(responsetipo.getCodigo());
	    return montoService.update(montotipo);
	        });
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_STREAM_JSON).body(tipoCambioMaybe);
	  }
	  
	  
	  
	  
}
