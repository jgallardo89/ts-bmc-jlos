package com.bancomer.gis.monitorwebswift.vo;

import java.util.ArrayList;
import java.util.Date;

public class ClientVo extends GeneralVo implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	private int nu_id_cliente;
	private int nu_pais;
	private int bic;
	private int branch;
	private int nu_cod_bic_euro;
	private int cd_activo;
	private int nu_tipo_srv;
	private int nu_tipo_srv_swift;
	private int tipo_cliente_aaa;
	private int nu_tipo_canal;
	private int coin;
	private int comision;
	private String cd_num_referencia;
	private String cd_bic_sw_cte;
	private String cd_ofi_sw_cte;
	private String cd_cte_latam;
	private String cd_bic_sw_cte_env;
	private String cd_ofi_sw_cte_env;
	private String nb_cliente;
	private String cd_acr_cliente;
	private Date fh_alta;
	private Date fh_modificacion;
	private Date fh_baja;
	private String nb_pais;
	private String nu_cuenta;
	private String relayAcount;
	private String relayBIC;
	@SuppressWarnings("unchecked")
	private ArrayList aviableProducts;
	@SuppressWarnings("unchecked")
	private ArrayList unaviableProducts;
	private int fileAct;
	private int fin;
	private String[] products;
	private String cd_contrato_swift;
	private String nb_empresa;
	private String pc_iva;
	private String cd_contrato_sicoco;
	private String tp_anualidad;
	private String tp_mensualidad;
	private String tp_sicoco_gen;
	
	private String nu_oficina;
	private String cd_bic_cta_env;
	private String cd_ofi_cta_env;
	
	private String decodeBic;
	
	private int cd_tp_archivo;
	private String nb_tp_archivo; 
	private String nb_masc_archivo;
	
	public ClientVo() {
	}



	public ClientVo(int nu_id_cliente, String cd_num_referencia, int nu_pais,
			String cd_bic_sw_cte, String cd_ofi_sw_cte, String cd_cte_latam,
			int nu_cod_bic_euro, String cd_bic_sw_cte_env,
			String cd_ofi_sw_cte_env, String nb_cliente, String cd_acr_cliente,
			Date fh_alta, Date fh_modificacion, Date fh_baja, int cd_activo) {
		this.nu_id_cliente = nu_id_cliente;
		this.cd_num_referencia = cd_num_referencia;
		this.nu_pais = nu_pais;
		this.cd_bic_sw_cte = cd_bic_sw_cte;
		this.cd_ofi_sw_cte = cd_ofi_sw_cte;
		this.cd_cte_latam = cd_cte_latam;
		this.nu_cod_bic_euro = nu_cod_bic_euro;
		this.cd_bic_sw_cte_env = cd_bic_sw_cte_env;
		this.cd_ofi_sw_cte_env = cd_ofi_sw_cte_env;
		this.nb_cliente = nb_cliente;
		this.cd_acr_cliente = cd_acr_cliente;
		this.fh_alta = fh_alta;
		this.fh_modificacion = fh_modificacion;
		this.fh_baja = fh_baja;
		this.cd_activo = cd_activo;
	}

	
	public ClientVo(int cd_cliente, String nb_cliente, String cd_referencia, int cd_tp_servicio, 
			String nb_tp_servicio, int cd_pais, String nb_pais, int cd_tp_archivo, String nb_tp_archivo, String mascara){
		this.nu_id_cliente = cd_cliente;
		this.nb_cliente = nb_cliente;
		this.cd_num_referencia = cd_referencia;
		this.nu_tipo_srv = cd_tp_servicio;
		this.nb_empresa = nb_tp_servicio;
		this.nu_pais = cd_pais;
		this.nb_pais = nb_pais;
		this.cd_tp_archivo = cd_tp_archivo;
		this.nb_tp_archivo = nb_tp_archivo;
		this.nb_masc_archivo = mascara;
	}
	
	public ClientVo(int cd_cliente, String nb_cliente, String cd_referencia, int cd_tp_servicio, 
			String nb_tp_servicio, int cd_pais, String nb_pais, int cd_tp_archivo, String nb_tp_archivo, String mascara, int idProduct, String nbProduct){
		this.nu_id_cliente = cd_cliente;
		this.nb_cliente = nb_cliente;
		this.cd_num_referencia = cd_referencia;
		this.nu_tipo_srv = cd_tp_servicio;
		this.nb_empresa = nb_tp_servicio;
		this.nu_pais = cd_pais;
		this.nb_pais = nb_pais;
		this.cd_tp_archivo = cd_tp_archivo;
		this.nb_tp_archivo = nb_tp_archivo;
		this.nb_masc_archivo = mascara;
		this.nu_tipo_canal = idProduct;
		this.relayBIC = nbProduct;
	}

	public int getNu_tipo_srv() {
		return nu_tipo_srv;
	}

	public void setNu_tipo_srv(int nu_tipo_srv) {
		this.nu_tipo_srv = nu_tipo_srv;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getNu_id_cliente() {
		return nu_id_cliente;
	}

	public void setNu_id_cliente(int nu_id_cliente) {
		this.nu_id_cliente = nu_id_cliente;
	}

	public String getCd_num_referencia() {
		return cd_num_referencia;
	}

	public void setCd_num_referencia(String cd_num_referencia) {
		this.cd_num_referencia = cd_num_referencia;
	}

	public int getNu_pais() {
		return nu_pais;
	}

	public void setNu_pais(int nu_pais) {
		this.nu_pais = nu_pais;
	}

	public String getCd_bic_sw_cte() {
		return cd_bic_sw_cte;
	}

	public void setCd_bic_sw_cte(String cd_bic_sw_cte) {
		this.cd_bic_sw_cte = cd_bic_sw_cte;
	}

	public String getCd_ofi_sw_cte() {
		return cd_ofi_sw_cte;
	}

	public void setCd_ofi_sw_cte(String cd_ofi_sw_cte) {
		this.cd_ofi_sw_cte = cd_ofi_sw_cte;
	}

	public String getCd_cte_latam() {
		return cd_cte_latam;
	}

	public void setCd_cte_latam(String cd_cte_latam) {
		this.cd_cte_latam = cd_cte_latam;
	}

	public int getNu_cod_bic_euro() {
		return nu_cod_bic_euro;
	}

	public void setNu_cod_bic_euro(int nu_cod_bic_euro) {
		this.nu_cod_bic_euro = nu_cod_bic_euro;
	}

	public String getCd_bic_sw_cte_env() {
		return cd_bic_sw_cte_env;
	}

	public void setCd_bic_sw_cte_env(String cd_bic_sw_cte_env) {
		this.cd_bic_sw_cte_env = cd_bic_sw_cte_env;
	}

	public String getCd_ofi_sw_cte_env() {
		return cd_ofi_sw_cte_env;
	}

	public void setCd_ofi_sw_cte_env(String cd_ofi_sw_cte_env) {
		this.cd_ofi_sw_cte_env = cd_ofi_sw_cte_env;
	}

	public String getNb_cliente() {
		return nb_cliente;
	}

	public void setNb_cliente(String nb_cliente) {
		this.nb_cliente = nb_cliente;
	}

	public String getCd_acr_cliente() {
		return cd_acr_cliente;
	}

	public void setCd_acr_cliente(String cd_acr_cliente) {
		this.cd_acr_cliente = cd_acr_cliente;
	}

	public Date getFh_alta() {
		return fh_alta;
	}

	public void setFh_alta(Date fh_alta) {
		this.fh_alta = fh_alta;
	}

	public Date getFh_modificacion() {
		return fh_modificacion;
	}

	public void setFh_modificacion(Date fh_modificacion) {
		this.fh_modificacion = fh_modificacion;
	}

	public Date getFh_baja() {
		return fh_baja;
	}

	public void setFh_baja(Date fh_baja) {
		this.fh_baja = fh_baja;
	}

	public int getCd_activo() {
		return cd_activo;
	}

	public void setCd_activo(int cd_activo) {
		this.cd_activo = cd_activo;
	}
	

	public int getTipo_cliente_aaa() {
		return tipo_cliente_aaa;
	}

	public void setTipo_cliente_aaa(int tipo_cliente_aaa) {
		this.tipo_cliente_aaa = tipo_cliente_aaa;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}

	public int getComision() {
		return comision;
	}

	public void setComision(int comision) {
		this.comision = comision;
	}

	public int getNu_tipo_srv_swift() {
		return nu_tipo_srv_swift;
	}

	public void setNu_tipo_srv_swift(int nu_tipo_srv_swift) {
		this.nu_tipo_srv_swift = nu_tipo_srv_swift;
	}

	public String getNb_pais() {
		return nb_pais;
	}

	public void setNb_pais(String nb_pais) {
		this.nb_pais = nb_pais;
	}

	public String getNu_cuenta() {
		return nu_cuenta;
	}

	public void setNu_cuenta(String nu_cuenta) {
		this.nu_cuenta = nu_cuenta;
	}

	public int getNu_tipo_canal() {
		return nu_tipo_canal;
	}

	public void setNu_tipo_canal(int nu_tipo_canal) {
		this.nu_tipo_canal = nu_tipo_canal;
	}

	public String getRelayAcount() {
		return relayAcount;
	}

	public void setRelayAcount(String relayAcount) {
		this.relayAcount = relayAcount;
	}

	public String getRelayBIC() {
		return relayBIC;
	}

	public void setRelayBIC(String relayBIC) {
		this.relayBIC = relayBIC;
	}

	public int getFileAct() {
		return fileAct;
	}

	public void setFileAct(int fileAct) {
		this.fileAct = fileAct;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getAviableProducts() {
		return aviableProducts;
	}

	@SuppressWarnings("unchecked")
	public void setAviableProducts(ArrayList aviableProducts) {
		this.aviableProducts = aviableProducts;
	}

	@SuppressWarnings("unchecked")
	public ArrayList getUnaviableProducts() {
		return unaviableProducts;
	}

	@SuppressWarnings("unchecked")
	public void setUnaviableProducts(ArrayList unaviableProducts) {
		this.unaviableProducts = unaviableProducts;
	}

	public String[] getProducts() {
		return products;
	}
	
	public void setProducts(String[] products) {
		this.products = products;
	}

	public int getBic() {
		return bic;
	}

	public void setBic(int bic) {
		this.bic = bic;
	}

	public int getBranch() {
		return branch;
	}

	public void setBranch(int branch) {
		this.branch = branch;
	}



	public String getCd_contrato_swift() {
		return cd_contrato_swift;
	}



	public void setCd_contrato_swift(String cd_contrato_swift) {
		this.cd_contrato_swift = cd_contrato_swift;
	}



	public String getNb_empresa() {
		return nb_empresa;
	}



	public void setNb_empresa(String nb_empresa) {
		this.nb_empresa = nb_empresa;
	}



	public String getPc_iva() {
		return pc_iva;
	}



	public void setPc_iva(String pc_iva) {
		this.pc_iva = pc_iva;
	}



	public String getCd_contrato_sicoco() {
		return cd_contrato_sicoco;
	}



	public void setCd_contrato_sicoco(String cd_contrato_sicoco) {
		this.cd_contrato_sicoco = cd_contrato_sicoco;
	}



	public String getTp_anualidad() {
		return tp_anualidad;
	}



	public void setTp_anualidad(String tp_anualidad) {
		this.tp_anualidad = tp_anualidad;
	}



	public String getTp_mensualidad() {
		return tp_mensualidad;
	}



	public void setTp_mensualidad(String tp_mensualidad) {
		this.tp_mensualidad = tp_mensualidad;
	}



	public String getTp_sicoco_gen() {
		return tp_sicoco_gen;
	}



	public void setTp_sicoco_gen(String tp_sicoco_gen) {
		this.tp_sicoco_gen = tp_sicoco_gen;
	}



	public String getNu_oficina() {
		return nu_oficina;
	}



	public void setNu_oficina(String nu_oficina) {
		this.nu_oficina = nu_oficina;
	}



	public String getCd_bic_cta_env() {
		return cd_bic_cta_env;
	}



	public void setCd_bic_cta_env(String cd_bic_cta_env) {
		this.cd_bic_cta_env = cd_bic_cta_env;
	}



	public String getCd_ofi_cta_env() {
		return cd_ofi_cta_env;
	}



	public void setCd_ofi_cta_env(String cd_ofi_cta_env) {
		this.cd_ofi_cta_env = cd_ofi_cta_env;
	}



	public String getDecodeBic() {
		return decodeBic;
	}



	public void setDecodeBic(String decodeBic) {
		this.decodeBic = decodeBic;
	}



	public int getCd_tp_archivo() {
		return cd_tp_archivo;
	}



	public void setCd_tp_archivo(int cd_tp_archivo) {
		this.cd_tp_archivo = cd_tp_archivo;
	}



	public String getNb_tp_archivo() {
		return nb_tp_archivo;
	}



	public void setNb_tp_archivo(String nb_tp_archivo) {
		this.nb_tp_archivo = nb_tp_archivo;
	}



	public String getNb_masc_archivo() {
		return nb_masc_archivo;
	}



	public void setNb_masc_archivo(String nb_masc_archivo) {
		this.nb_masc_archivo = nb_masc_archivo;
	}
	
	
}
