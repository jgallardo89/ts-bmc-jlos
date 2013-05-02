package com.bancomer.gis.monitorwebswift.forms;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ChannelForm extends ActionForm{

	private int id;
    private String name = null;
    private String description = null;
    private String date = null;
	private String dateFinal = null;
    private String method= null;
    private String chkAcuse = null;
    private String reference = null;
    private String[] aux;
    private int[] row;
    private int selection = 0;
    private String rowArray[];    
    private String nameArray[];
    private String auxAcuse[];
    private String newRow[];

    
	//Campos utilizados para el form de operaciones por lote
	private String txtPswOpera;
	private String acuse;
    private String acuseM;
	private String radRegs;
	private String radio1 = null;
	private String radio2 = null;
	private String radio3 = null;
	private String radio4 = null;
    
    public String getName() {
        return name;
    }
    public void setName(String n) {
        this.name = n;
    }

    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.name = null;
        this.description = null;
        this.method = null;
        this.id=0;
        this.date=null;
		this.dateFinal = null;
    }

    public String getDescription() {
		return description;
	}

	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        aux = request.getParameterValues("aux");
        return errors;
    }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String fecha) {
		this.date = fecha;
	}
	
	public String getDateFinal() {
		return dateFinal;
	}
	public void setDateFinal(String dateFinal) {
		this.dateFinal = dateFinal;
	}
	public String getTxtPswOpera() {
		return txtPswOpera;
	}
	public void setTxtPswOpera(String txtPswOpera) {
		this.txtPswOpera = txtPswOpera;
	}
	public String getAcuse() {
		return acuse;
	}
	public void setAcuse(String acuse) {
		this.acuse = acuse;
	}
	public String getAcuseM() {
		return acuseM;
	}
	public void setAcuseM(String acuseM) {
		this.acuseM = acuseM;
	}
	public String getRadRegs() {
		return radRegs;
	}
	public void setRadRegs(String radRegs) {
		this.radRegs = radRegs;
	}
	public String getChkAcuse() {
		return chkAcuse;
	}
	public void setChkAcuse(String chkAcuse) {
		this.chkAcuse = chkAcuse;
	}
	public String[] getAux() {
		return aux;
	}
	public void setAux(String[] aux) {
		this.aux = aux;
	}
	public int getSelection() {
		return selection;
	}
	public void setSelection(int selection) {
		this.selection = selection;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String[] getRowArray() {
		return rowArray;
	}
	public void setRowArray(String[] rowArray) {
		this.rowArray = rowArray;
	}
	public int[] getRow() {
		return row;
	}
	public void setRow(int[] row) {
		this.row = row;
	}
	public String[] getNameArray() {
		return nameArray;
	}
	public void setNameArray(String[] nameArray) {
		this.nameArray = nameArray;
	}
	public String[] getAuxAcuse() {
		return auxAcuse;
	}
	public void setAuxAcuse(String[] auxAcuse) {
		this.auxAcuse = auxAcuse;
	}
	public String getRadio1() {
		return radio1;
	}
	public void setRadio1(String radio1) {
		this.radio1 = radio1;
	}
	public String getRadio2() {
		return radio2;
	}
	public void setRadio2(String radio2) {
		this.radio2 = radio2;
	}
	public String getRadio3() {
		return radio3;
	}
	public void setRadio3(String radio3) {
		this.radio3 = radio3;
	}
	public String getRadio4() {
		return radio4;
	}
	public void setRadio4(String radio4) {
		this.radio4 = radio4;
	}
	public String[] getNewRow() {
		return newRow;
	}
	public void setNewRow(String[] newRow) {
		this.newRow = newRow;
	}
}
