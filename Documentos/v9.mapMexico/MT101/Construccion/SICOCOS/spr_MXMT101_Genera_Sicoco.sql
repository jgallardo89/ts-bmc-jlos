

CREATE PROCEDURE spr_MXMT101_Genera_Sicoco 
AS
		--TODOS LOS TIPOS DE OPERACION
    		SELECT C.cuenta_cheques AS CuentaServicio, TIO.cod_sicoco AS SubServicio, 
		TIO.descripcion AS DescSubservicio, C.contrato_sicoco AS Referencia,
		COUNT(C.cuenta_cheques) AS TotalOps ,C.moneda AS Moneda, C.indicador_AAA AS IndicadorAAA,
		iva = case CONVERT(CHAR(1),C.porcentaje_iva) when '1' then 16 else 11 end,
		imp_comision_usd = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then SUM(RMT.importe_32B) else COUNT(C.cuenta_cheques) * TIO.imp_comision_usd END, 
		imp_comision_mxp = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then SUM(RMT.importe_32B) else COUNT(C.cuenta_cheques) * TIO.imp_comision_mxp END,
		imp_comision_eur = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then SUM(RMT.importe_32B) else COUNT(C.cuenta_cheques) * TIO.imp_comision_eur END,
		tarifa_usd = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_usd END, 
		tarifa_mxp = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_mxp END,
		tarifa_eur = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_eur END,
		SUM(RMT.importe_32B) AS Importe,
		C.anualidad , C.mensualidad,  C.id_contratos
		FROM  REPORTE_MT101 RMT, TIPO_OPERACION TIO,CONTRATOS C
		Where C.cuenta_cheques = CASE len(RMT.cuenta_cargo_50H_1_50A_1) when 10 then RMT.cuenta_cargo_50H_1_50A_1 else substring(RMT.cuenta_cargo_50H_1_50A_1,8,10)END 
		AND RMT.tipo_operacion = TIO.tipo_operacion
		AND C.moneda = RMT.moneda_32B
		AND RMT.status_envio IN (9)
		AND TIO.tipo_operacion NOT IN (8, 9)
		AND C.fecha_baja IS NULL
		GROUP BY C.cuenta_cheques,TIO.cod_sicoco, TIO.descripcion, TIO.clave, C.contrato_sicoco,
		TIO.imp_comision_usd, TIO.imp_comision_mxp, C.moneda, CONVERT(CHAR(1),C.porcentaje_iva),C.id_contratos , 
		C.anualidad, C.mensualidad, TIO.imp_comision_eur,  C.indicador_AAA	
	
	
	
	UNION 
		--ANUALIDAD Y MENSUALIDAD
		SELECT C.cuenta_cheques AS CuentaServicio, TIO.cod_sicoco AS SubServicio,
		TIO.descripcion AS DescSubservicio, C.contrato_sicoco AS Referencia,
		TotalOps = 1 , C.moneda AS Moneda, C.indicador_AAA AS IndicadorAAA,		
		iva = case CONVERT(CHAR(1),C.porcentaje_iva) when '1' then 16 else 11 end,
		imp_comision_usd = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 1 else TIO.imp_comision_usd END, 
		imp_comision_mxp = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 1 else TIO.imp_comision_mxp END,
		imp_comision_eur = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 1 else TIO.imp_comision_eur END,
		tarifa_usd = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_usd END, 
		tarifa_mxp = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_mxp END,
		tarifa_eur = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_eur END,
		Importe = 0 ,C.anualidad , C.mensualidad , C.id_contratos					
		FROM CONTRATOS C, TIPO_OPERACION TIO
		Where ((C.anualidad = 1 and TIO.tipo_operacion = 13) or (C.mensualidad = 1 and TIO.tipo_operacion = 12))  
			AND C.fecha_baja IS NULL
		GROUP BY C.cuenta_cheques, TIO.cod_sicoco, TIO.descripcion, C.contrato_sicoco, TIO.imp_comision_usd, TIO.imp_comision_mxp,
			TIO.imp_comision_eur,
			C.moneda ,  CONVERT(CHAR(1),C.porcentaje_iva),  C.id_contratos ,
		C.anualidad, C.mensualidad, TIO.imp_comision_eur,  C.indicador_AAA
	
	
	
	UNION 
	
		--MENSAJES SWIFT
		SELECT C.cuenta_cheques AS CuentaServicio, TIO.cod_sicoco AS SubServicio,
		TIO.descripcion AS DescSubservicio, C.contrato_sicoco AS Referencia,
		COUNT(C.cuenta_cheques) AS TotalOps ,C.moneda AS Moneda, C.indicador_AAA AS IndicadorAAA,
		iva = case CONVERT(CHAR(1),C.porcentaje_iva) when '1' then 16 else 11 end,
		imp_comision_usd = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else COUNT(C.cuenta_cheques) * TIO.imp_comision_usd END, 
		imp_comision_mxp = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else COUNT(C.cuenta_cheques) * TIO.imp_comision_mxp END,
		imp_comision_eur = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else COUNT(C.cuenta_cheques) * TIO.imp_comision_eur END,
		tarifa_usd = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_usd END, 
		tarifa_mxp = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_mxp END,
		tarifa_eur = CASE CONVERT(CHAR(1),C.indicador_AAA) when '1' then 0.00 else TIO.imp_comision_eur END,
		SUM(RMT.importe_32B) AS Importe,
		C.anualidad , C.mensualidad,  C.id_contratos
		FROM  REPORTE_MT101 RMT, TIPO_OPERACION TIO,CONTRATOS C
		Where  C.cuenta_cheques IN (SELECT CASE len(RMT1.cuenta_cargo_50H_1_50A_1) when 10 then RMT1.cuenta_cargo_50H_1_50A_1 else substring(RMT1.cuenta_cargo_50H_1_50A_1,8,10)END  FROM  REPORTE_MT101 RMT1, TIPO_OPERACION TIO,CONTRATOS C
						Where C.cuenta_cheques = CASE len(RMT1.cuenta_cargo_50H_1_50A_1) when 10 then RMT1.cuenta_cargo_50H_1_50A_1 else substring(RMT1.cuenta_cargo_50H_1_50A_1,8,10)END 
						AND RMT1.status_envio IN (9)
						AND TIO.tipo_operacion NOT IN (8, 9)
						AND C.fecha_baja IS NULL
						GROUP BY CASE len(RMT1.cuenta_cargo_50H_1_50A_1) when 10 then RMT1.cuenta_cargo_50H_1_50A_1 else substring(RMT1.cuenta_cargo_50H_1_50A_1,8,10)END)
		and C.cuenta_cheques = CASE len(RMT.cuenta_cargo_50H_1_50A_1) when 10 then RMT.cuenta_cargo_50H_1_50A_1 else substring(RMT.cuenta_cargo_50H_1_50A_1,8,10) END 
		AND TIO.tipo_operacion = 10
		AND RMT.status_envio IN (10,9)
		AND TIO.tipo_operacion NOT IN (8, 9)
		AND C.fecha_baja IS NULL
		GROUP BY C.cuenta_cheques, TIO.cod_sicoco, TIO.descripcion, TIO.clave, C.contrato_sicoco,
		TIO.imp_comision_usd, TIO.imp_comision_mxp, C.moneda, CONVERT(CHAR(1),C.porcentaje_iva),C.id_contratos ,
		C.anualidad, C.mensualidad, TIO.imp_comision_eur,  C.indicador_AAA	
	
	
	ORDER BY  C.cuenta_cheques





GO
