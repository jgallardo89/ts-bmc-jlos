CREATE PROCEDURE spu_MXMT101_Genera_Sicoco 
AS


	
	UPDATE REPORTE_MT101 SET status_envio = 11 
	FROM CONTRATOS C, TIPO_OPERACION TIO 
	WHERE C.cuenta_cheques = CASE len(REPORTE_MT101.cuenta_cargo_50H_1_50A_1) when 10 then REPORTE_MT101.cuenta_cargo_50H_1_50A_1 else substring(REPORTE_MT101.cuenta_cargo_50H_1_50A_1,8,10)END 
	AND REPORTE_MT101.tipo_operacion = TIO.tipo_operacion
	AND C.moneda = REPORTE_MT101.moneda_32B 
	AND REPORTE_MT101.status_envio = 9
	AND C.fecha_baja IS  NULL
	
	
	
	UPDATE REPORTE_MT101 SET status_envio = 12 
	FROM CONTRATOS C, TIPO_OPERACION TIO 
	WHERE C.cuenta_cheques = CASE len(REPORTE_MT101.cuenta_cargo_50H_1_50A_1) when 10 then REPORTE_MT101.cuenta_cargo_50H_1_50A_1 else substring(REPORTE_MT101.cuenta_cargo_50H_1_50A_1,8,10)END 
	AND REPORTE_MT101.tipo_operacion = TIO.tipo_operacion
	AND C.moneda = REPORTE_MT101.moneda_32B 
	AND REPORTE_MT101.status_envio = 10
	AND C.fecha_baja IS NULL




GO
