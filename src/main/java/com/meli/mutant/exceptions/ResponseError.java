package com.meli.mutant.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseError {

	@JsonProperty("CodigoError")
	int CodigoEstadoTransaccion;
	@JsonProperty("EstadoTransaccion")
	String EstadoTransaccion;
	
   public ResponseError(int codigoEstadoTransaccion, String estadoTransaccion) {
		CodigoEstadoTransaccion = codigoEstadoTransaccion;
		EstadoTransaccion = estadoTransaccion;
	}
	@JsonProperty("CodigoError")
	public int getCodigoEstadoTransaccion() {
		return CodigoEstadoTransaccion;
	}
	@JsonProperty("CodigoError")
	public void setCodigoEstadoTransaccion(int codigoEstadoTransaccion) {
		CodigoEstadoTransaccion = codigoEstadoTransaccion;
	}
	@JsonProperty("EstadoTransaccion")
	public String getEstadoTransaccion() {
		return EstadoTransaccion;
	}
	@JsonProperty("EstadoTransaccion")
	public void setEstadoTransaccion(String estadoTransaccion) {
		EstadoTransaccion = estadoTransaccion;
	}
}
