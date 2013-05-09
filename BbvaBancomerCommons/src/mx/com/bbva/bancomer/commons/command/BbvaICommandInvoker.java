package mx.com.bbva.bancomer.commons.command;

import mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject;

public interface BbvaICommandInvoker 
	{
	/**
	 * <b>invoke</b>
	 * Invocacion generica de un Objeto de Negocio -POJO, EJB, WS, RMI- identificado mediante la relacion de la firma de sus metodos.
	 * 
	 * @param <T> - bbvaAbstractDataTransferObject - Bean contenedor especifico para cada caso de uso.
	 * @return mx.com.bbva.bancomer.commons.model.dto.BbvaAbstractDataTransferObject
	 * @throws mx.com.bbva.bancomer.commons.exception.BbvaBusinessException
	 */
	public <T extends BbvaAbstractDataTransferObject> T invoke( final T bbvaAbstractDataTransferObject )
	throws mx.com.bbva.bancomer.commons.exception.BbvaBusinessException;
	}