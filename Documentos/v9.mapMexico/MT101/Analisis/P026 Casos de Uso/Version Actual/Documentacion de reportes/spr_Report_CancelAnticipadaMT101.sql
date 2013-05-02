

CREATE PROCEDURE spr_Report_CancelAnticipadaMT101 ( @fecha_proceso VARCHAR(10))
AS
	DECLARE @FECHAINI 	VARCHAR (8)
	DECLARE @FECHAFIN 	VARCHAR (8)

	---FORMATO DE FECHA RECIBIDO YYYY/MM/DD
	SET @FECHAFIN = convert(varchar(8),convert(datetime,@fecha_proceso,101),112) 
	SET @FECHAINI = left(@FECHAFIN,6)+ '01'



	--select que trae todas las cuentas que tuvieron operaciones antes de dar de baja la cuenta.
	SELECT C.cuenta_cheques as cuentaCheques, 
		--IMPORTE COMISION
			importeComUSD = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else COUNT(C.cuenta_cheques) * TIO.imp_comision_usd END, 
			importeComMXN = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else COUNT(C.cuenta_cheques) * TIO.imp_comision_mxp END,
			importeComEUR = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else COUNT(C.cuenta_cheques) * TIO.imp_comision_eur END,
		--IMPORTE IVA
			porcentajeIVA = case CONVERT(CHAR(1),C.porcentaje_iva) when '1' then 16 else 11 end, 
		--REFERENCIA
			rtrim(left(C.contrato_sicoco,12)) AS contratoSicoco, 
		--SUBSERVICIO Y NOMBRE DE SUBSERVICIO
			TIO.cod_sicoco as codigoSicoco,TIO.descripcion AS descripcion,
		--NUMERO DE OPERACIONES, 
			COUNT(C.cuenta_cheques) AS totalOperaciones, 
		--CLIENTE AAA
			C.indicador_AAA AS indicadorAAA,
		--OTROS CAMPOS 
	  		C.fecha_baja AS fecha,
			C.moneda,
		--MENSUALIDAD 
			mensualidad = CASE TIO.tipo_operacion when 12 then 1 else 0 END
		--TIO.tipo_operacion as tipoOper
	FROM CONTRATOS C, REPORTE_MT101 RMT, TIPO_OPERACION TIO 
	WHERE C.cuenta_cheques = CASE len(RMT.cuenta_cargo_50H_1_50A_1) when 10 then RMT.cuenta_cargo_50H_1_50A_1 else substring(RMT.cuenta_cargo_50H_1_50A_1,8,10)END 
		AND RMT.tipo_operacion = TIO.tipo_operacion  
		AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) >= @FECHAINI
		AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) <= @FECHAFIN
		AND (CONVERT(VARCHAR(8), C.fecha_baja, 112) >=  @FECHAINI
		AND CONVERT(VARCHAR(8), C.fecha_baja, 112) <=  @FECHAFIN)
		AND C.moneda = RMT.moneda_32B 
		AND RMT.status_envio = 11 
		AND TIO.tipo_operacion NOT IN (8, 9) 
	GROUP BY C.cuenta_cheques, TIO.tipo_operacion, C.moneda,  C.nombre_empresa, C.contrato_swift, fecha_baja,  TIO.cod_sicoco, C.indicador_AAA, 
		TIO.imp_comision_usd, TIO.imp_comision_mxp, TIO.imp_comision_eur,CONVERT(CHAR(1), C.porcentaje_iva),	
		C.anualidad , C.mensualidad, C.id_contratos, TIO.descripcion,C.fecha_alta, C.contrato_sicoco
	
	UNION


	
	--select que trae todas las cuentas que tienen indicada el cobro de mensualidad y/o anualidad
	SELECT C.cuenta_cheques as cuentaCheques, 
		--IMPORTE COMISION
			importeComUSD = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else TIO.imp_comision_usd END, 
			importeComMXN = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else TIO.imp_comision_mxp END,
			importeComEUR = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else TIO.imp_comision_eur END,
		--IMPORTE IVA
			porcentajeIVA = case CONVERT(CHAR(1),C.porcentaje_iva) when '1' then 16 else 11 end, 
		--REFERENCIA
			rtrim(left(C.contrato_sicoco,12)) AS contratoSicoco, 
		--SUBSERVICIO Y NOMBRE DE SUBSERVICIO
			TIO.cod_sicoco as codigoSicoco,TIO.descripcion AS descripcion,
		--NUMERO DE OPERACIONES, 
			totalOperaciones = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 1 else 0 END, 
		--CLIENTE AAA
			C.indicador_AAA AS indicadorAAA,
		--OTROS CAMPOS
	  		C.fecha_baja AS fecha,
			C.moneda,
		--MENSUALIDAD 
			mensualidad = CASE TIO.tipo_operacion when 12 then 1 else 0 END
		--TIO.tipo_operacion as tipoOper
	FROM CONTRATOS C, TIPO_OPERACION TIO--, REPORTE_MT101 RMT1 
	WHERE((C.anualidad = 1 and TIO.tipo_operacion = 13) or (C.mensualidad = 1 and TIO.tipo_operacion = 12))  
		AND CONVERT(VARCHAR(8), C.fecha_baja, 112) >=  @FECHAINI
		AND CONVERT(VARCHAR(8), C.fecha_baja, 112) <=  @FECHAFIN
	
	
	UNION 
	
	--select que trae el total de operaciones por cada cuenta dada de baja en el mes
	SELECT C.cuenta_cheques as cuentaCheques, 
		--IMPORTE COMISION
			importeComUSD = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else COUNT(C.cuenta_cheques) * TIO.imp_comision_usd END, 
			importeComMXN = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else COUNT(C.cuenta_cheques) * TIO.imp_comision_mxp END,
			importeComEUR = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0 else COUNT(C.cuenta_cheques) * TIO.imp_comision_eur END,
		--IMPORTE IVA
			porcentajeIVA = case CONVERT(CHAR(1),C.porcentaje_iva) when '1' then 16 else 11 end, 
		--REFERENCIA
			rtrim(left(C.contrato_sicoco,12)) AS contratoSicoco, 
		--SUBSERVICIO Y NOMBRE DE SUBSERVICIO
			TIO.cod_sicoco as codigoSicoco,TIO.descripcion AS descripcion,
		--NUMERO DE OPERACIONES, 
			COUNT(C.cuenta_cheques) AS totalOperaciones, 
		--CLIENTE AAA
			C.indicador_AAA AS indicadorAAA, 
		--OTROS CAMPOS
	  		C.fecha_baja AS fecha,
			C.moneda,
		--MENSUALIDAD 
			mensualidad = CASE TIO.tipo_operacion when 12 then 1 else 0 END
		--TIO.tipo_operacion as tipoOper
		--SUM(RMT.importe_32B)
	FROM CONTRATOS C, REPORTE_MT101 RMT, TIPO_OPERACION TIO 
	WHERE C.cuenta_cheques =CASE len(RMT.cuenta_cargo_50H_1_50A_1) when 10 then RMT.cuenta_cargo_50H_1_50A_1 else substring(RMT.cuenta_cargo_50H_1_50A_1,8,10)END 
		AND TIO.tipo_operacion = 10
		AND C.indicador_AAA = 1
		AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) >=  @FECHAINI
		AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) <=  @FECHAFIN
		AND C.moneda = RMT.moneda_32B 	
		AND status_envio IN (11,12) 
		AND (CONVERT(VARCHAR(8), C.fecha_baja, 112) >=  @FECHAINI
		AND CONVERT(VARCHAR(8), C.fecha_baja, 112) <=  @FECHAFIN)
	GROUP BY C.cuenta_cheques, TIO.tipo_operacion, C.moneda,  C.nombre_empresa, C.contrato_swift, fecha_baja,  TIO.cod_sicoco, C.indicador_AAA, 
		TIO.imp_comision_usd, TIO.imp_comision_mxp, TIO.imp_comision_eur,CONVERT(CHAR(1), C.porcentaje_iva),	
		C.anualidad , C.mensualidad, C.id_contratos, TIO.descripcion,C.fecha_alta, C.contrato_sicoco
	
	
	order by  C.cuenta_cheques
	


GO
