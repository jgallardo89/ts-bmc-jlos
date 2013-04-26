package mx.com.bbva.mapeador.entity.tgm534StObjeto;

import java.io.Serializable;
import javax.persistence.*;

import mx.com.bbva.mapeador.entity.tgm501pantalla.Tgm501Pantalla;
import mx.com.bbva.mapeador.entity.tgm502componente.Tgm502Componente;
import mx.com.bbva.mapeador.entity.tgm503usuario.Tgm503Usuario;
import mx.com.bbva.mapeador.entity.tgm504perfil.Tgm504Perfil;

import java.util.List;


/**
 * The persistent class for the TGM534_ST_OBJETO database table.
 * 
 */
public class Tgm534StObjeto implements Serializable {
	private static final long serialVersionUID = 1L;

	private long cdStObjeto;
	private String nbStObjeto;
	private String nbTabla;
	private String txStObjeto;
	private List<Tgm501Pantalla> tgm501Pantallas;
	private List<Tgm502Componente> tgm502Componentes;
	private List<Tgm503Usuario> tgm503Usuarios;
	private List<Tgm504Perfil> tgm504Perfils;
//	private List<Tgm510UsuaNotifi> tgm510UsuaNotifis;
//	private List<Tgm511Canal> tgm511Canals;
//	private List<Tgm512Cliente> tgm512Clientes;
//	private List<Tgm513Flujo> tgm513Flujos;
//	private List<Tgm514MapaGmm> tgm514MapaGmms;
//	private List<Tgm515Producto> tgm515Productos;
//	private List<Tgm516MensajeSal> tgm516MensajeSals;
//	private List<Tgm517Etapa> tgm517Etapas;
//	private List<Tgm519Contratacion> tgm519Contratacions;
//	private List<Tgm522StProceso> tgm522StProcesos;
//	private List<Tgm531DefineMapa> tgm531DefineMapas;
//	private Tgm509StClave tgm509StClave;
//	private List<Tgm537EdoArchivo> tgm537EdoArchivos;

	public Tgm534StObjeto() {
	}

	public long getCdStObjeto() {
		return this.cdStObjeto;
	}

	public void setCdStObjeto(long cdStObjeto) {
		this.cdStObjeto = cdStObjeto;
	}

	public String getNbStObjeto() {
		return this.nbStObjeto;
	}

	public void setNbStObjeto(String nbStObjeto) {
		this.nbStObjeto = nbStObjeto;
	}

	public String getNbTabla() {
		return this.nbTabla;
	}

	public void setNbTabla(String nbTabla) {
		this.nbTabla = nbTabla;
	}

	public String getTxStObjeto() {
		return this.txStObjeto;
	}

	public void setTxStObjeto(String txStObjeto) {
		this.txStObjeto = txStObjeto;
	}

	public List<Tgm501Pantalla> getTgm501Pantallas() {
		return this.tgm501Pantallas;
	}

	public void setTgm501Pantallas(List<Tgm501Pantalla> tgm501Pantallas) {
		this.tgm501Pantallas = tgm501Pantallas;
	}

	public Tgm501Pantalla addTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		getTgm501Pantallas().add(tgm501Pantalla);
		tgm501Pantalla.setTgm534StObjeto(this);

		return tgm501Pantalla;
	}

	public Tgm501Pantalla removeTgm501Pantalla(Tgm501Pantalla tgm501Pantalla) {
		getTgm501Pantallas().remove(tgm501Pantalla);
		tgm501Pantalla.setTgm534StObjeto(null);

		return tgm501Pantalla;
	}

	public List<Tgm502Componente> getTgm502Componentes() {
		return this.tgm502Componentes;
	}

	public void setTgm502Componentes(List<Tgm502Componente> tgm502Componentes) {
		this.tgm502Componentes = tgm502Componentes;
	}

	public Tgm502Componente addTgm502Componente(Tgm502Componente tgm502Componente) {
		getTgm502Componentes().add(tgm502Componente);
		tgm502Componente.setTgm534StObjeto(this);

		return tgm502Componente;
	}

	public Tgm502Componente removeTgm502Componente(Tgm502Componente tgm502Componente) {
		getTgm502Componentes().remove(tgm502Componente);
		tgm502Componente.setTgm534StObjeto(null);

		return tgm502Componente;
	}

	public List<Tgm503Usuario> getTgm503Usuarios() {
		return this.tgm503Usuarios;
	}

	public void setTgm503Usuarios(List<Tgm503Usuario> tgm503Usuarios) {
		this.tgm503Usuarios = tgm503Usuarios;
	}

	public Tgm503Usuario addTgm503Usuario(Tgm503Usuario tgm503Usuario) {
		getTgm503Usuarios().add(tgm503Usuario);
		tgm503Usuario.setTgm534StObjeto(this);

		return tgm503Usuario;
	}

	public Tgm503Usuario removeTgm503Usuario(Tgm503Usuario tgm503Usuario) {
		getTgm503Usuarios().remove(tgm503Usuario);
		tgm503Usuario.setTgm534StObjeto(null);

		return tgm503Usuario;
	}

	public List<Tgm504Perfil> getTgm504Perfils() {
		return this.tgm504Perfils;
	}

	public void setTgm504Perfils(List<Tgm504Perfil> tgm504Perfils) {
		this.tgm504Perfils = tgm504Perfils;
	}

	public Tgm504Perfil addTgm504Perfil(Tgm504Perfil tgm504Perfil) {
		getTgm504Perfils().add(tgm504Perfil);
		tgm504Perfil.setTgm534StObjeto(this);

		return tgm504Perfil;
	}

	public Tgm504Perfil removeTgm504Perfil(Tgm504Perfil tgm504Perfil) {
		getTgm504Perfils().remove(tgm504Perfil);
		tgm504Perfil.setTgm534StObjeto(null);

		return tgm504Perfil;
	}

//	public List<Tgm510UsuaNotifi> getTgm510UsuaNotifis() {
//		return this.tgm510UsuaNotifis;
//	}
//
//	public void setTgm510UsuaNotifis(List<Tgm510UsuaNotifi> tgm510UsuaNotifis) {
//		this.tgm510UsuaNotifis = tgm510UsuaNotifis;
//	}
//
//	public Tgm510UsuaNotifi addTgm510UsuaNotifi(Tgm510UsuaNotifi tgm510UsuaNotifi) {
//		getTgm510UsuaNotifis().add(tgm510UsuaNotifi);
//		tgm510UsuaNotifi.setTgm534StObjeto(this);
//
//		return tgm510UsuaNotifi;
//	}
//
//	public Tgm510UsuaNotifi removeTgm510UsuaNotifi(Tgm510UsuaNotifi tgm510UsuaNotifi) {
//		getTgm510UsuaNotifis().remove(tgm510UsuaNotifi);
//		tgm510UsuaNotifi.setTgm534StObjeto(null);
//
//		return tgm510UsuaNotifi;
//	}
//
//	public List<Tgm511Canal> getTgm511Canals() {
//		return this.tgm511Canals;
//	}
//
//	public void setTgm511Canals(List<Tgm511Canal> tgm511Canals) {
//		this.tgm511Canals = tgm511Canals;
//	}
//
//	public Tgm511Canal addTgm511Canal(Tgm511Canal tgm511Canal) {
//		getTgm511Canals().add(tgm511Canal);
//		tgm511Canal.setTgm534StObjeto(this);
//
//		return tgm511Canal;
//	}
//
//	public Tgm511Canal removeTgm511Canal(Tgm511Canal tgm511Canal) {
//		getTgm511Canals().remove(tgm511Canal);
//		tgm511Canal.setTgm534StObjeto(null);
//
//		return tgm511Canal;
//	}
//
//	public List<Tgm512Cliente> getTgm512Clientes() {
//		return this.tgm512Clientes;
//	}
//
//	public void setTgm512Clientes(List<Tgm512Cliente> tgm512Clientes) {
//		this.tgm512Clientes = tgm512Clientes;
//	}
//
//	public Tgm512Cliente addTgm512Cliente(Tgm512Cliente tgm512Cliente) {
//		getTgm512Clientes().add(tgm512Cliente);
//		tgm512Cliente.setTgm534StObjeto(this);
//
//		return tgm512Cliente;
//	}
//
//	public Tgm512Cliente removeTgm512Cliente(Tgm512Cliente tgm512Cliente) {
//		getTgm512Clientes().remove(tgm512Cliente);
//		tgm512Cliente.setTgm534StObjeto(null);
//
//		return tgm512Cliente;
//	}
//
//	public List<Tgm513Flujo> getTgm513Flujos() {
//		return this.tgm513Flujos;
//	}
//
//	public void setTgm513Flujos(List<Tgm513Flujo> tgm513Flujos) {
//		this.tgm513Flujos = tgm513Flujos;
//	}
//
//	public Tgm513Flujo addTgm513Flujo(Tgm513Flujo tgm513Flujo) {
//		getTgm513Flujos().add(tgm513Flujo);
//		tgm513Flujo.setTgm534StObjeto(this);
//
//		return tgm513Flujo;
//	}
//
//	public Tgm513Flujo removeTgm513Flujo(Tgm513Flujo tgm513Flujo) {
//		getTgm513Flujos().remove(tgm513Flujo);
//		tgm513Flujo.setTgm534StObjeto(null);
//
//		return tgm513Flujo;
//	}
//
//	public List<Tgm514MapaGmm> getTgm514MapaGmms() {
//		return this.tgm514MapaGmms;
//	}
//
//	public void setTgm514MapaGmms(List<Tgm514MapaGmm> tgm514MapaGmms) {
//		this.tgm514MapaGmms = tgm514MapaGmms;
//	}
//
//	public Tgm514MapaGmm addTgm514MapaGmm(Tgm514MapaGmm tgm514MapaGmm) {
//		getTgm514MapaGmms().add(tgm514MapaGmm);
//		tgm514MapaGmm.setTgm534StObjeto(this);
//
//		return tgm514MapaGmm;
//	}
//
//	public Tgm514MapaGmm removeTgm514MapaGmm(Tgm514MapaGmm tgm514MapaGmm) {
//		getTgm514MapaGmms().remove(tgm514MapaGmm);
//		tgm514MapaGmm.setTgm534StObjeto(null);
//
//		return tgm514MapaGmm;
//	}
//
//	public List<Tgm515Producto> getTgm515Productos() {
//		return this.tgm515Productos;
//	}
//
//	public void setTgm515Productos(List<Tgm515Producto> tgm515Productos) {
//		this.tgm515Productos = tgm515Productos;
//	}
//
//	public Tgm515Producto addTgm515Producto(Tgm515Producto tgm515Producto) {
//		getTgm515Productos().add(tgm515Producto);
//		tgm515Producto.setTgm534StObjeto(this);
//
//		return tgm515Producto;
//	}
//
//	public Tgm515Producto removeTgm515Producto(Tgm515Producto tgm515Producto) {
//		getTgm515Productos().remove(tgm515Producto);
//		tgm515Producto.setTgm534StObjeto(null);
//
//		return tgm515Producto;
//	}
//
//	public List<Tgm516MensajeSal> getTgm516MensajeSals() {
//		return this.tgm516MensajeSals;
//	}
//
//	public void setTgm516MensajeSals(List<Tgm516MensajeSal> tgm516MensajeSals) {
//		this.tgm516MensajeSals = tgm516MensajeSals;
//	}
//
//	public Tgm516MensajeSal addTgm516MensajeSal(Tgm516MensajeSal tgm516MensajeSal) {
//		getTgm516MensajeSals().add(tgm516MensajeSal);
//		tgm516MensajeSal.setTgm534StObjeto(this);
//
//		return tgm516MensajeSal;
//	}
//
//	public Tgm516MensajeSal removeTgm516MensajeSal(Tgm516MensajeSal tgm516MensajeSal) {
//		getTgm516MensajeSals().remove(tgm516MensajeSal);
//		tgm516MensajeSal.setTgm534StObjeto(null);
//
//		return tgm516MensajeSal;
//	}
//
//	public List<Tgm517Etapa> getTgm517Etapas() {
//		return this.tgm517Etapas;
//	}
//
//	public void setTgm517Etapas(List<Tgm517Etapa> tgm517Etapas) {
//		this.tgm517Etapas = tgm517Etapas;
//	}
//
//	public Tgm517Etapa addTgm517Etapa(Tgm517Etapa tgm517Etapa) {
//		getTgm517Etapas().add(tgm517Etapa);
//		tgm517Etapa.setTgm534StObjeto(this);
//
//		return tgm517Etapa;
//	}
//
//	public Tgm517Etapa removeTgm517Etapa(Tgm517Etapa tgm517Etapa) {
//		getTgm517Etapas().remove(tgm517Etapa);
//		tgm517Etapa.setTgm534StObjeto(null);
//
//		return tgm517Etapa;
//	}
//
//	public List<Tgm519Contratacion> getTgm519Contratacions() {
//		return this.tgm519Contratacions;
//	}
//
//	public void setTgm519Contratacions(List<Tgm519Contratacion> tgm519Contratacions) {
//		this.tgm519Contratacions = tgm519Contratacions;
//	}
//
//	public Tgm519Contratacion addTgm519Contratacion(Tgm519Contratacion tgm519Contratacion) {
//		getTgm519Contratacions().add(tgm519Contratacion);
//		tgm519Contratacion.setTgm534StObjeto(this);
//
//		return tgm519Contratacion;
//	}
//
//	public Tgm519Contratacion removeTgm519Contratacion(Tgm519Contratacion tgm519Contratacion) {
//		getTgm519Contratacions().remove(tgm519Contratacion);
//		tgm519Contratacion.setTgm534StObjeto(null);
//
//		return tgm519Contratacion;
//	}
//
//	public List<Tgm522StProceso> getTgm522StProcesos() {
//		return this.tgm522StProcesos;
//	}
//
//	public void setTgm522StProcesos(List<Tgm522StProceso> tgm522StProcesos) {
//		this.tgm522StProcesos = tgm522StProcesos;
//	}
//
//	public Tgm522StProceso addTgm522StProceso(Tgm522StProceso tgm522StProceso) {
//		getTgm522StProcesos().add(tgm522StProceso);
//		tgm522StProceso.setTgm534StObjeto(this);
//
//		return tgm522StProceso;
//	}
//
//	public Tgm522StProceso removeTgm522StProceso(Tgm522StProceso tgm522StProceso) {
//		getTgm522StProcesos().remove(tgm522StProceso);
//		tgm522StProceso.setTgm534StObjeto(null);
//
//		return tgm522StProceso;
//	}
//
//	public List<Tgm531DefineMapa> getTgm531DefineMapas() {
//		return this.tgm531DefineMapas;
//	}
//
//	public void setTgm531DefineMapas(List<Tgm531DefineMapa> tgm531DefineMapas) {
//		this.tgm531DefineMapas = tgm531DefineMapas;
//	}
//
//	public Tgm531DefineMapa addTgm531DefineMapa(Tgm531DefineMapa tgm531DefineMapa) {
//		getTgm531DefineMapas().add(tgm531DefineMapa);
//		tgm531DefineMapa.setTgm534StObjeto(this);
//
//		return tgm531DefineMapa;
//	}
//
//	public Tgm531DefineMapa removeTgm531DefineMapa(Tgm531DefineMapa tgm531DefineMapa) {
//		getTgm531DefineMapas().remove(tgm531DefineMapa);
//		tgm531DefineMapa.setTgm534StObjeto(null);
//
//		return tgm531DefineMapa;
//	}
//
//	public Tgm509StClave getTgm509StClave() {
//		return this.tgm509StClave;
//	}
//
//	public void setTgm509StClave(Tgm509StClave tgm509StClave) {
//		this.tgm509StClave = tgm509StClave;
//	}
//
//	public List<Tgm537EdoArchivo> getTgm537EdoArchivos() {
//		return this.tgm537EdoArchivos;
//	}
//
//	public void setTgm537EdoArchivos(List<Tgm537EdoArchivo> tgm537EdoArchivos) {
//		this.tgm537EdoArchivos = tgm537EdoArchivos;
//	}
//
//	public Tgm537EdoArchivo addTgm537EdoArchivo(Tgm537EdoArchivo tgm537EdoArchivo) {
//		getTgm537EdoArchivos().add(tgm537EdoArchivo);
//		tgm537EdoArchivo.setTgm534StObjeto(this);
//
//		return tgm537EdoArchivo;
//	}
//
//	public Tgm537EdoArchivo removeTgm537EdoArchivo(Tgm537EdoArchivo tgm537EdoArchivo) {
//		getTgm537EdoArchivos().remove(tgm537EdoArchivo);
//		tgm537EdoArchivo.setTgm534StObjeto(null);
//
//		return tgm537EdoArchivo;
//	}

}