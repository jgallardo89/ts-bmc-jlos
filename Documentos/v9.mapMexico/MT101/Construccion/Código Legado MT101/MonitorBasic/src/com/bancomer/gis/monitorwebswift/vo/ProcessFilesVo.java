package com.bancomer.gis.monitorwebswift.vo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("unchecked")
public class ProcessFilesVo extends GeneralVo implements java.io.Serializable,Comparable {
	
	private static final long serialVersionUID = 1L;
	private int nu_consecutivo;
	private int nu_id_tipo_arch;
	private String nb_arch_procesado;
	private Date fh_proceso;
	private String nb_arch_sag;
	private int nu_estatus_archivo;
	private String nb_estatus_archivo;
	private String cd_ent_sal_gmm;
	private String nb_masc_archivo;
	private int nu_tipo_srvswift;
	private int nu_pais;
	private int nu_tipo_servicio;
	private String nb_tipo_servicio;
	private String nu_tipo_canal;
	private String nb_pais;
	private String nb_srvswift;
	private String nb_tipo_srv;
	private long size;
	private String fullName;
	private String nu_flujo_cte_swift;
	private String cd_bic_origen;
	private String cd_pais;
	private String aux1;
	private String aux2;
	private String aux3;
	private String bic_origen;
	private String nbCliente = "";
	private String containsFINMT199="0";/*Esta variable indica si tiene el texto Archivo Fin MT199 en aux1*/
	
	/*Se agrega el numero de bloque*/
	private int num_bloque;
	
	
	
	public int getNum_bloque() {
		return num_bloque;
	}

	public void setNum_bloque(int num_bloque) {
		this.num_bloque = num_bloque;
	}

	public ProcessFilesVo(){}

	public ProcessFilesVo(int nu_consecutivo, int nu_id_tipo_arch,
			String nb_arch_procesado, Date fh_proceso, String nb_arch_sag,
			int nu_estatus_archivo, String nb_estatus_archivo,
			String cd_ent_sal_gmm, String nb_masc_archivo, int nu_tipo_srvswift,
			int nu_pais, int nu_tipo_servicio, String nb_tipo_servicio,
			String nu_tipo_canal, String nb_pais, String nb_srvswift,
			String nb_tipo_srv, int size, String fullName) {
		super();
		this.nu_consecutivo = nu_consecutivo;
		this.nu_id_tipo_arch = nu_id_tipo_arch;
		this.nb_arch_procesado = nb_arch_procesado;
		this.fh_proceso = fh_proceso;
		this.nb_arch_sag = nb_arch_sag;
		this.nu_estatus_archivo = nu_estatus_archivo;
		this.nb_estatus_archivo = nb_estatus_archivo;
		this.cd_ent_sal_gmm = cd_ent_sal_gmm;
		this.nb_masc_archivo = nb_masc_archivo;
		this.nu_tipo_srvswift = nu_tipo_srvswift;
		this.nu_pais = nu_pais;
		this.nu_tipo_servicio = nu_tipo_servicio;
		this.nb_tipo_servicio = nb_tipo_servicio;
		this.nu_tipo_canal = nu_tipo_canal;
		this.nb_pais = nb_pais;
		this.nb_srvswift = nb_srvswift;
		this.nb_tipo_srv = nb_tipo_srv;
		this.size=size;
		this.fullName=fullName;
	}

	public int getNu_consecutivo() {
		return nu_consecutivo;
	}

	public void setNu_consecutivo(int nu_consecutivo) {
		this.nu_consecutivo = nu_consecutivo;
	}

	public int getNu_id_tipo_arch() {
		return nu_id_tipo_arch;
	}

	public void setNu_id_tipo_arch(int nu_id_tipo_arch) {
		this.nu_id_tipo_arch = nu_id_tipo_arch;
	}

	public String getNb_arch_procesado() {
		return nb_arch_procesado;
	}

	public void setNb_arch_procesado(String nb_arch_procesado) {
		this.nb_arch_procesado = nb_arch_procesado;
	}

	public Date getFh_proceso() {
		return fh_proceso;
	}

	public void setFh_proceso(Date fh_proceso) {
		this.fh_proceso = fh_proceso;
	}

	public String getNb_arch_sag() {
		return nb_arch_sag;
	}

	public void setNb_arch_sag(String nb_arch_sag) {
		this.nb_arch_sag = nb_arch_sag;
	}

	public int getNu_estatus_archivo() {
		return nu_estatus_archivo;
	}

	public void setNu_estatus_archivo(int nu_estatus_archivo) {
		this.nu_estatus_archivo = nu_estatus_archivo;
	}

	public String getNb_estatus_archivo() {
		return nb_estatus_archivo;
	}

	public void setNb_estatus_archivo(String nb_estatus_archivo) {
		this.nb_estatus_archivo = nb_estatus_archivo;
	}

	public String getNb_masc_archivo() {
		return nb_masc_archivo;
	}

	public void setNb_masc_archivo(String nb_masc_archivo) {
		this.nb_masc_archivo = nb_masc_archivo;
	}

	public int getNu_tipo_srvswift() {
		return nu_tipo_srvswift;
	}

	public void setNu_tipo_srvswift(int nu_tipo_srvswift) {
		this.nu_tipo_srvswift = nu_tipo_srvswift;
	}

	public int getNu_pais() {
		return nu_pais;
	}

	public void setNu_pais(int nu_pais) {
		this.nu_pais = nu_pais;
	}

	public int getNu_tipo_servicio() {
		return nu_tipo_servicio;
	}

	public void setNu_tipo_servicio(int nu_tipo_servicio) {
		this.nu_tipo_servicio = nu_tipo_servicio;
	}

	public String getNb_tipo_servicio() {
		return nb_tipo_servicio;
	}

	public void setNb_tipo_servicio(String nb_tipo_servicio) {
		this.nb_tipo_servicio = nb_tipo_servicio;
	}

	public String getNu_tipo_canal() {
		return nu_tipo_canal;
	}

	public void setNu_tipo_canal(String nu_tipo_canal) {
		this.nu_tipo_canal = nu_tipo_canal;
	}

	public String getNb_pais() {
		return nb_pais;
	}

	public void setNb_pais(String nb_pais) {
		this.nb_pais = nb_pais;
	}

	public String getNb_srvswift() {
		return nb_srvswift;
	}

	public void setNb_srvswift(String nb_srvswift) {
		this.nb_srvswift = nb_srvswift;
	}

	public String getNb_tipo_srv() {
		return nb_tipo_srv;
	}

	public void setNb_tipo_srv(String nb_tipo_srv) {
		this.nb_tipo_srv = nb_tipo_srv;
	}

	public String getCd_ent_sal_gmm() {
		return cd_ent_sal_gmm;
	}

	public void setCd_ent_sal_gmm(String cd_ent_sal_gmm) {
		this.cd_ent_sal_gmm = cd_ent_sal_gmm;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNu_flujo_cte_swift() {
		return nu_flujo_cte_swift;
	}

	public void setNu_flujo_cte_swift(String nu_flujo_cte_swift) {
		this.nu_flujo_cte_swift = nu_flujo_cte_swift;
	}
	
	public boolean equals(Object file){
		if(file instanceof ProcessFilesVo){
			ProcessFilesVo pf = (ProcessFilesVo)file;
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			String fecha1 = format.format(pf.fh_proceso);
			String fecha2 = format.format(this.fh_proceso);
			if(pf.getNb_arch_procesado().equals(this.nb_arch_procesado) && fecha1.equals(fecha2)) return true;
			else return false;
		}
		else{
			return false;
		}
	}
	public static void main(String args[]){
		ProcessFilesVo file1 = new ProcessFilesVo();
		ProcessFilesVo file2 = new ProcessFilesVo();
		
		file1.setFullName("Marcos");
		file2.setFullName("Marcos");
		
		file1.setFh_proceso(new Date());
		file2.setFh_proceso(new Date());
		
		HashMap map = new HashMap();
		map.put(file1.getFullName(), file1);
		map.put(file2.getFullName(), file2);
		
	}
	
	public int hashCode(ProcessFilesVo file){
		return file.getFullName().length();
	}

	public int compareTo(Object o1) {
		Date date1 = ((ProcessFilesVo)o1).getFh_proceso();
		Date date2 = this.fh_proceso;
		return date1.compareTo(date2);
	}

	public String getCd_bic_origen() {
		return cd_bic_origen;
	}

	public void setCd_bic_origen(String cd_bic_origen) {
		this.cd_bic_origen = cd_bic_origen;
	}

	public String getCd_pais() {
		return cd_pais;
	}

	public void setCd_pais(String cd_pais) {
		this.cd_pais = cd_pais;
	}

	public String getAux1() {
		return aux1.trim();
	}

	public void setAux1(String aux1) {
		this.aux1 = aux1.trim();
	}

	public String getAux2() {
		return aux2;
	}

	public void setAux2(String aux2) {
		this.aux2 = aux2;
	}

	public String getAux3() {
		return aux3;
	}

	public void setAux3(String aux3) {
		this.aux3 = aux3;
	}

	public String getBic_origen() {
		return bic_origen;
	}

	public void setBic_origen(String bic_origen) {
		this.bic_origen = bic_origen;
	}

	public String getNbCliente() {
		return nbCliente;
	}

	public void setNbCliente(String nbCliente) {
		this.nbCliente = nbCliente;
	}

	public String getContainsFINMT199() {
		return containsFINMT199;
	}

	public void setContainsFINMT199(String containsFINMT199) {
		this.containsFINMT199 = containsFINMT199;
	}
	
	
	
}
