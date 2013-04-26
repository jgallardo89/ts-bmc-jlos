package mx.com.bbva.mt101.mapper;

import java.util.List;

import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;

public abstract interface MapTgm138Mt101ctrato {
	public abstract int actualizaCliente(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract int actualizaClienteInactivo(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract int eliminaClienteActivo(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract List<Tgm138Mt101ctrato> obtenerClientes(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneCdCodSwEnv(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneCdCodSwRec(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneContrato(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneContratoCliente(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneCuentaCheques(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract int salvarContrato(Tgm138Mt101ctrato paramTgm138Mt101ctrato);
}