package mx.com.bbva.mapeador.entity.tgm507bitacora;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm503usuario.Tgm503Usuario;
import mx.com.bbva.mapeador.entity.tgm508eventomapa.Tgm508EventoMapa;

import java.util.Date;


/**
 * The persistent class for the TGM507_BITACORA database table.
 * 
 */
public class Tgm507Bitacora implements Serializable {
	private static final long serialVersionUID = 1L;
	private long cdBitacora;
	private Date fhBitacora;
	private String nbBitacora;
	private Date tmBitacora;
	private String txBitacora;
	private Tgm503Usuario tgm503Usuario;
	private Tgm508EventoMapa tgm508EventoMapa;

	public Tgm507Bitacora() {
	}

	public long getCdBitacora() {
		return this.cdBitacora;
	}

	public void setCdBitacora(long cdBitacora) {
		this.cdBitacora = cdBitacora;
	}

	public Date getFhBitacora() {
		return this.fhBitacora;
	}

	public void setFhBitacora(Date fhBitacora) {
		this.fhBitacora = fhBitacora;
	}

	public String getNbBitacora() {
		return this.nbBitacora;
	}

	public void setNbBitacora(String nbBitacora) {
		this.nbBitacora = nbBitacora;
	}

	public Date getTmBitacora() {
		return this.tmBitacora;
	}

	public void setTmBitacora(Date tmBitacora) {
		this.tmBitacora = tmBitacora;
	}

	public String getTxBitacora() {
		return this.txBitacora;
	}

	public void setTxBitacora(String txBitacora) {
		this.txBitacora = txBitacora;
	}

	public Tgm503Usuario getTgm503Usuario() {
		return this.tgm503Usuario;
	}

	public void setTgm503Usuario(Tgm503Usuario tgm503Usuario) {
		this.tgm503Usuario = tgm503Usuario;
	}

	public Tgm508EventoMapa getTgm508EventoMapa() {
		return this.tgm508EventoMapa;
	}

	public void setTgm508EventoMapa(Tgm508EventoMapa tgm508EventoMapa) {
		this.tgm508EventoMapa = tgm508EventoMapa;
	}

}