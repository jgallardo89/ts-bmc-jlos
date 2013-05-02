
/*********************************************************************************/
/***** Objetivo: obtiene los campos para el armado del archivo de  Reporte   *****/  
/*****		mensual de cancelación anticipada 					     		 *****/  
/***** Relizado: Enero-2010				 	             					 *****/
/***** Creado: ISC Susan Gabriela Gómez González 	  	  	     			 *****/
/*********************************************************************************/ 
CREATE   PROCEDURE dbo.spr_Reporte_Gestion_MT101( @fecha_proceso VARCHAR(10))
AS
BEGIN

	DECLARE @lsSQL		VARCHAR(3500)
	DECLARE @FECHAINI 	VARCHAR(8)
	DECLARE @FECHAFIN 	VARCHAR(8)

	SET @FECHAFIN = convert(varchar(8),convert(datetime,@fecha_proceso),112) 
	SET @FECHAINI = left(@FECHAFIN,6)+ '01'
	

	SET @lsSQL = 'SELECT C.cuenta_cheques, TIO.tipo_operacion, C.moneda, C.nombre_empresa, C.contrato_swift,  C.fecha_arch_cancel, ' 
	SET @lsSQL = @lsSQL  + 'REPLICATE(''0'',5-LEN(LTRIM(CAST( rtrim(TIO.cod_sicoco) AS VARCHAR(5)))))+LTRIM(CAST( rtrim(TIO.cod_sicoco) AS VARCHAR(5))) ,  '
	SET @lsSQL = @lsSQL  + 'COUNT(C.cuenta_cheques) AS TotalOps , C.indicador_AAA, '
	SET @lsSQL = @lsSQL  + 'TIO.imp_comision_usd, TIO.imp_comision_mxp, TIO.imp_comision_eur, '
	SET @lsSQL = @lsSQL  + 'SUM(RMT.importe_32B) AS Importe, CONVERT(CHAR(1),C.porcentaje_iva) as  porcentaje_iva, '
	SET @lsSQL = @lsSQL  + 'C.anualidad , C.mensualidad, C.id_contratos,TIO.descripcion, CONVERT(VARCHAR(8), C.fecha_alta,112) '

	SET @lsSQL = @lsSQL  + 'FROM CONTRATOS C, REPORTE_MT101 RMT, TIPO_OPERACION TIO '
	SET @lsSQL = @lsSQL  + 'WHERE C.cuenta_cheques = CASE len(RMT.cuenta_cargo_50H_1_50A_1) when 10 then RMT.cuenta_cargo_50H_1_50A_1 else substring(RMT.cuenta_cargo_50H_1_50A_1,8,10)END  '
	SET @lsSQL = @lsSQL  + 'AND RMT.tipo_operacion = TIO.tipo_operacion ' 
	SET @lsSQL = @lsSQL  + 'AND TIO.tipo_operacion NOT IN (8, 9) '
	SET @lsSQL = @lsSQL  + 'AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) >= ''' + @FECHAINI + ''' '
	SET @lsSQL = @lsSQL  + 'AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) <= ''' + @FECHAFIN + ''' '
	SET @lsSQL = @lsSQL  + 'AND C.moneda = RMT.moneda_32B '
	SET @lsSQL = @lsSQL  + 'AND RMT.status_envio = 11 '
	SET @lsSQL = @lsSQL  + 'AND ((C.fecha_baja IS NULL ) or (CONVERT(VARCHAR(8), C.fecha_baja, 112) >= ''' + @FECHAINI + ''' ))'
	SET @lsSQL = @lsSQL  + 	'GROUP BY C.cuenta_cheques, TIO.tipo_operacion, C.moneda,  C.nombre_empresa, C.contrato_swift, fecha_arch_cancel,  TIO.cod_sicoco, C.indicador_AAA, '
	SET @lsSQL = @lsSQL  + 	'TIO.imp_comision_usd, TIO.imp_comision_mxp, TIO.imp_comision_eur,CONVERT(CHAR(1), C.porcentaje_iva),	'
	SET @lsSQL = @lsSQL  + 	'C.anualidad , C.mensualidad, C.id_contratos, TIO.descripcion,C.fecha_alta '	

	SET @lsSQL = @lsSQL  + 	'UNION ALL '

	SET @lsSQL = @lsSQL  + 	'SELECT  C1.cuenta_cheques, TIO1.tipo_operacion, C1.moneda, C1.nombre_empresa, C1.contrato_swift,  C1.fecha_arch_cancel, '
	SET @lsSQL = @lsSQL  + 	'REPLICATE(''0'',5-LEN(LTRIM(CAST( rtrim( TIO1.cod_sicoco) AS VARCHAR(5)))))+LTRIM(CAST( rtrim( TIO1.cod_sicoco) AS VARCHAR(5))), TotalOps = 0, C1.indicador_AAA, '
	SET @lsSQL = @lsSQL  + 	'TIO1.imp_comision_usd, TIO1.imp_comision_mxp, TIO1.imp_comision_eur, '
	SET @lsSQL = @lsSQL  + 	'Importe = 0,CONVERT(CHAR(1),C1.porcentaje_iva) as  porcentaje_iva, '
	SET @lsSQL = @lsSQL  + 	'C1.anualidad , C1.mensualidad, C1.id_contratos,TIO1.descripcion, CONVERT(VARCHAR(8), C1.fecha_alta,112) '
	SET @lsSQL = @lsSQL  + 	'FROM CONTRATOS C1, TIPO_OPERACION TIO1, REPORTE_MT101 RMT1 '
	SET @lsSQL = @lsSQL  + 	'WHERE 	 TIO1.tipo_operacion in (12,13)	 '	
	SET @lsSQL = @lsSQL  + 	'AND C1.cuenta_cheques NOT IN '
		SET @lsSQL = @lsSQL  + 	'(SELECT DISTINCT C2.cuenta_cheques '
	     	SET @lsSQL = @lsSQL  + 	'FROM CONTRATOS C2, REPORTE_MT101 RMT2 '
		SET @lsSQL = @lsSQL  + 	'WHERE C2.cuenta_cheques =CASE len(RMT2.cuenta_cargo_50H_1_50A_1) when 10 then RMT2.cuenta_cargo_50H_1_50A_1 else substring(RMT2.cuenta_cargo_50H_1_50A_1,8,10)END  '
		SET @lsSQL = @lsSQL  + 	'AND RMT2.status_envio IN (11,12) '
		SET @lsSQL = @lsSQL  + 	'AND CONVERT(VARCHAR(8), RMT2.fecha_valor_30, 112) >= ''' + @FECHAINI + ''' '
		SET @lsSQL = @lsSQL  + 	'AND CONVERT(VARCHAR(8), RMT2.fecha_valor_30, 112) <=  ''' + @FECHAFIN + ''' '
	
	SET @lsSQL = @lsSQL  + 	') and ((C1.anualidad = 1 and TIO1.tipo_operacion = 13) or (C1.mensualidad = 1 and TIO1.tipo_operacion = 12))  '
	SET @lsSQL = @lsSQL  + 	'AND NOT CONVERT(VARCHAR(8), getdate(), 112) <=  ''' + @FECHAFIN + ''' '
	SET @lsSQL = @lsSQL  + 	'AND ((C1.fecha_baja IS NULL ) or (CONVERT(VARCHAR(8), C1.fecha_baja, 112) >= ''' + @FECHAINI + ''' ))'
	SET @lsSQL = @lsSQL  + 	'GROUP BY C1.cuenta_cheques, TIO1.tipo_operacion, C1.moneda,  C1.nombre_empresa, C1.contrato_swift, C1.fecha_arch_cancel,  TIO1.cod_sicoco, C1.indicador_AAA, '
	SET @lsSQL = @lsSQL  + 	'TIO1.imp_comision_usd, TIO1.imp_comision_mxp, TIO1.imp_comision_eur,CONVERT(CHAR(1), C1.porcentaje_iva), '	
	SET @lsSQL = @lsSQL  + 	'C1.anualidad , C1.mensualidad, C1.id_contratos, TIO1.descripcion,C1.fecha_alta '

	SET @lsSQL = @lsSQL  + 'ORDER BY 1,2 '

	-- EJECUTAR LA CONSULTA ARMADA
	EXEC(@lsSQL)
END




GO
