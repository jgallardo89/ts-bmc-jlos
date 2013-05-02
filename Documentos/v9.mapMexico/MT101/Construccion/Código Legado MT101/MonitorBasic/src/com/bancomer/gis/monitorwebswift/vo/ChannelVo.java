package com.bancomer.gis.monitorwebswift.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Marcos
 */
public class ChannelVo extends GeneralVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int channelType;
	private String channel;
	private String description;
	private Date createDate;
	
	//Campos utilizados para el form de operaciones por lote
	private String txtPswOpera; 
	
	public ChannelVo(){}
	
	
	

	/**
	 * @param channelType
	 * @param channel
	 * @param description
	 * @param createDate
	 */
	public ChannelVo(int channelType, String channel, String description,Date createDate) {
		this.channelType = channelType;
		this.channel = channel;
		this.description = description;
		this.createDate = createDate;
	}
	
	
	/**
	 * @return Devuelve channel.
	 */
	public String getChannel() {
		return channel;
	}
	/**
	 * @param channel El channel a establecer.
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}
	/**
	 * @return Devuelve channelType.
	 */
	public int getChannelType() {
		return channelType;
	}
	/**
	 * @param channelType El channelType a establecer.
	 */
	public void setChannelType(int channelType) {
		this.channelType = channelType;
	}
	/**
	 * @return Devuelve createDate.
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate El createDate a establecer.
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return Devuelve description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description El description a establecer.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getTxtPswOpera() {
		return txtPswOpera;
	}

	public void setTxtPswOpera(String passwordOperation) {
		this.txtPswOpera = passwordOperation;
	}
	
}
