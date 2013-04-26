package mx.com.bbva.mt101.clientes.negocio;

import java.util.List;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;

@Local
public abstract interface IClientes {
	public abstract long actualizarCliente(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract long actualizarClienteInactivo(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato buscarTgm138Mt101ctrato(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract long eliminaClienteActivo(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato existeCodigoBicEnvio(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato existeCodigoBicRecepcion(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract List<Tgm138Mt101ctrato> filtarTgm138Mt101ctrato(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract List<Tgm138Mt101ctrato> obtenerTodosTgm138Mt101ctrato();

	public abstract Tgm138Mt101ctrato obtieneCliente(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneClienteContrato(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract Tgm138Mt101ctrato obtieneCuentaCheques(
			Tgm138Mt101ctrato paramTgm138Mt101ctrato);

	public abstract long salvarCliente(Tgm138Mt101ctrato paramTgm138Mt101ctrato);
}

/*
 * Location: D:\Bancomer\EARS\BbvaMT101Ejb\ Qualified Name:
 * mx.com.bbva.mt101.clientes.negocio.IClientes JD-Core Version: 0.6.2
 */