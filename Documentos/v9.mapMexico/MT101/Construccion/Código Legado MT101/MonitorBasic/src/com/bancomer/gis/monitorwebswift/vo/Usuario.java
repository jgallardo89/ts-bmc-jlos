package com.bancomer.gis.monitorwebswift.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long nuUsuario;
	private long nuPais;
	private String cdCveUsuario;
	private String cdContrasenia;
	private String nbNombreUsr;
	private String nbApellPat;
	private String nbApellMat;
	private long nuExtension;
	private String txCorreoElectr;
	private long ctConexLimite;
	private long ctLogeoErroneo;
	private long ctConexActivas;
	private Date tmCambioContrasen;
	private Date tmUltimoAcceso;
	private String [] groups;
	private int [] links;
	private int[] linksByGroup;
	private ArrayList asociatedGroups;
	private ArrayList unasociatedGroups;
	
	
	public Usuario(){}
	
	public Usuario(int id, String name, String password){
		this.cdContrasenia = password;
		this.nuUsuario = id;
		this.cdCveUsuario =  name;
	}
	
	public Usuario(int id, String area, String name, String pais, String  telefono, String mail, String directorio){
		this.nuUsuario = id;
		this.cdContrasenia = area;
		this.cdCveUsuario = name;
		this.nbNombreUsr = pais;
		this.nbApellPat = telefono;
		this.txCorreoElectr = mail;
		this.nbApellMat = directorio;
	}
	
	public long getNuUsuario() {
		return nuUsuario;
	}
	public void setNuUsuario(long nuUsuario) {
		this.nuUsuario = nuUsuario;
	}
	public long getNuPais() {
		return nuPais;
	}
	public void setNuPais(long nuPais) {
		this.nuPais = nuPais;
	}
	public String getCdCveUsuario() {
		return cdCveUsuario;
	}
	public void setCdCveUsuario(String cdCveUsuario) {
		this.cdCveUsuario = cdCveUsuario;
	}
	public String getCdContrasenia() {
		return cdContrasenia;
	}
	public void setCdContrasenia(String cdContrasenia) {
		this.cdContrasenia = cdContrasenia;
	}
	public String getNbNombreUsr() {
		return nbNombreUsr;
	}
	public void setNbNombreUsr(String nbNombreUsr) {
		this.nbNombreUsr = nbNombreUsr;
	}
	public String getNbApellPat() {
		return nbApellPat;
	}
	public void setNbApellPat(String nbApellPat) {
		this.nbApellPat = nbApellPat;
	}
	public String getNbApellMat() {
		return nbApellMat;
	}
	public void setNbApellMat(String nbApellMat) {
		this.nbApellMat = nbApellMat;
	}
	public long getNuExtension() {
		return nuExtension;
	}
	public void setNuExtension(long nuExtension) {
		this.nuExtension = nuExtension;
	}
	public String getTxCorreoElectr() {
		return txCorreoElectr;
	}
	public void setTxCorreoElectr(String txCorreoElectr) {
		this.txCorreoElectr = txCorreoElectr;
	}
	public long getCtConexLimite() {
		return ctConexLimite;
	}
	public void setCtConexLimite(long ctConexLimite) {
		this.ctConexLimite = ctConexLimite;
	}
	public long getCtLogeoErroneo() {
		return ctLogeoErroneo;
	}
	public void setCtLogeoErroneo(long ctLogeoErroneo) {
		this.ctLogeoErroneo = ctLogeoErroneo;
	}
	public long getCtConexActivas() {
		return ctConexActivas;
	}
	public void setCtConexActivas(long ctConexActivas) {
		this.ctConexActivas = ctConexActivas;
	}
	public Date getTmCambioContrasen() {
		return tmCambioContrasen;
	}
	public void setTmCambioContrasen(Date tmCambioContrasen) {
		this.tmCambioContrasen = tmCambioContrasen;
	}
	public Date getTmUltimoAcceso() {
		return tmUltimoAcceso;
	}
	public void setTmUltimoAcceso(Date tmUltimoAcceso) {
		this.tmUltimoAcceso = tmUltimoAcceso;
	}

	public String[] getGroups() {
		return groups;
	}

	public void setGroups(String[] groups) {
		this.groups = groups;
	}

	public int[] getLinks() {
		return links;
	}

	public void setLinks(int[] links) {
		this.links = links;
	}

	public ArrayList getAsociatedGroups() {
		return asociatedGroups;
	}

	public void setAsociatedGroups(ArrayList asociatedGroups) {
		this.asociatedGroups = asociatedGroups;
	}

	public ArrayList getUnasociatedGroups() {
		return unasociatedGroups;
	}

	public void setUnasociatedGroups(ArrayList unasociatedGroups) {
		this.unasociatedGroups = unasociatedGroups;
	}

	public int[] getLinksByGroup() {
		return linksByGroup;
	}

	public void setLinksByGroup(int[] linksByGroup) {
		this.linksByGroup = linksByGroup;
	}
}
