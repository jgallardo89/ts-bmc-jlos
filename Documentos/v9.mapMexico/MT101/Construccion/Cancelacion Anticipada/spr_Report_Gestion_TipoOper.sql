

/*********************************************************************************/
/***** Objetivo: obtiene los campos de mensualidad, Anualidad t mensajes Swift ***/
/*****           para el armado del archivo de Reporte cancelación anticipada  ***/  
/***** Relizado: Enero-2010		 			             					 *****/
/***** Creado: ISC Susan Gabriela Gómez González 	  	  	     			 *****/
/***** Modificado: Susan Gabriela Gomez Gonzalez (Diciembre-2011)            *****/
/*********************************************************************************/ 
CREATE   PROCEDURE dbo.spr_Report_Gestion_TipoOper(@fecha_proceso VARCHAR(10),@ID_CONT NUMERIC(10),@ID_TIPOOPER NUMERIC(2))
AS

BEGIN
	DECLARE @lsSQL VARCHAR(2000)
	DECLARE @FECHAINI 	VARCHAR(8)
	DECLARE @FECHAFIN 	VARCHAR(8)	

	SET @FECHAFIN = convert(varchar(8),convert(datetime,@fecha_proceso),112) 
	SET @FECHAINI = left(@FECHAFIN,6)+ '01'

	SET @lsSQL = 'SELECT C.cuenta_cheques, REPLICATE(''0'',5-LEN(LTRIM(CAST( rtrim(TIO.cod_sicoco) AS VARCHAR(5)))))+LTRIM(CAST( rtrim(TIO.cod_sicoco) AS VARCHAR(5))) , C.moneda, C.nombre_empresa, C.contrato_swift,fecha_arch_cancel, ' 
	SET @lsSQL = @lsSQL  + 'REPLICATE(''0'',5-LEN(LTRIM(CAST( rtrim(TIO.cod_sicoco) AS VARCHAR(5)))))+LTRIM(CAST( rtrim(TIO.cod_sicoco) AS VARCHAR(5))) , ' 
	SET @lsSQL = @lsSQL  + 'COUNT(C.cuenta_cheques) AS TotalOps , C.indicador_AAA, '
	SET @lsSQL = @lsSQL  + 'TIO.imp_comision_usd, TIO.imp_comision_mxp, TIO.imp_comision_eur, '
	SET @lsSQL = @lsSQL  + 'SUM(RMT.importe_32B) AS Importe, CONVERT(CHAR(1),C.porcentaje_iva) as  porcentaje_iva,'
	SET @lsSQL = @lsSQL  + 'C.anualidad , C.mensualidad,TIO.tipo_operacion, TIO.descripcion, C.fecha_alta '
	SET @lsSQL = @lsSQL  + 'FROM CONTRATOS C, REPORTE_MT101 RMT, TIPO_OPERACION TIO '
	SET @lsSQL = @lsSQL  + 'WHERE C.cuenta_cheques = CASE len(RMT.cuenta_cargo_50H_1_50A_1) when 10 then RMT.cuenta_cargo_50H_1_50A_1 else substring(RMT.cuenta_cargo_50H_1_50A_1,8,10)END  ' 
	SET @lsSQL = @lsSQL  + 'AND C.id_contratos = ' + convert(varchar(10),@ID_CONT )
	SET @lsSQL = @lsSQL  + 'AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) >= ''' + @FECHAINI + ''' '
	SET @lsSQL = @lsSQL  + 'AND CONVERT(VARCHAR(8), RMT.fecha_valor_30, 112) <= ''' + @FECHAFIN + ''' '	
	SET @lsSQL = @lsSQL  + 'AND TIO.tipo_operacion = ' + convert(varchar(10), @ID_TIPOOPER )	
	SET @lsSQL = @lsSQL  + 'AND C.moneda = RMT.moneda_32B '	
	SET @lsSQL = @lsSQL  + 'AND status_envio IN (11,12) '
	SET @lsSQL = @lsSQL  + 'AND ((C.fecha_baja IS NULL ) or (CONVERT(VARCHAR(8), C.fecha_baja, 112) >= ''' + @FECHAINI + ''' ))'	
	SET @lsSQL = @lsSQL  + 'GROUP BY C.cuenta_cheques, TIO.cod_sicoco, C.moneda,  C.nombre_empresa, C.contrato_swift, fecha_arch_cancel,  TIO.cod_sicoco, C.indicador_AAA, '
	SET @lsSQL = @lsSQL  + ' TIO.imp_comision_usd , TIO.imp_comision_mxp , TIO.imp_comision_eur , CONVERT(CHAR(1), C.porcentaje_iva), '
	SET @lsSQL = @lsSQL  + 'C.anualidad , C.mensualidad, TIO.tipo_operacion ,TIO.descripcion, C.fecha_alta '
	SET @lsSQL = @lsSQL  + 'ORDER BY C.cuenta_cheques, TIO.cod_sicoco '
	
	-- EJECUTAR LA CONSULTA ARMADA
 
	EXEC(@lsSQL)

END 	





GO
