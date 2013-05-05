create or replace PROCEDURE SP_IGM009_ARCH_PRC(
	O_CD_ARCH_PROCESADO OUT NOCOPY NUMBER,
	I_TP_ENT_SAL_BBVA IN VARCHAR2,
	I_NB_MASC_ARCHIVO IN VARCHAR2,
	I_CD_ST_ARCHIVO IN NUMBER,
	I_NB_ARCH_PROCESADO IN VARCHAR2,
	I_CD_PAIS IN VARCHAR2 DEFAULT NULL,
	I_CD_BIC IN VARCHAR2 DEFAULT NULL) AS
	V_CD_TP_ARCHIVO NUMBER DEFAULT 0;
	V_STMT_STR VARCHAR2(1000);
	O_CURSOR PG_XX_UTILERIA.param_cursor;
BEGIN
	SELECT T011.CD_TP_ARCHIVO
	INTO V_CD_TP_ARCHIVO
	FROM TGM011_ARCH_PRC T011
	WHERE T011.NB_MASC_ARCHIVO = I_NB_MASC_ARCHIVO AND ROWNUM = 1;
	
	-- SI EXISTE EL ID DEL TIPO ARCHIVO PROCESADO
	IF V_CD_TP_ARCHIVO > 0 THEN
		INSERT INTO TGM009_ARCHPRC_LOG(TP_ENT_SAL_BBVA,CD_TP_ARCHIVO,CD_ST_ARCHIVO,NB_ARCH_PROCESADO,TM_PROCESO,CD_PAIS,CD_BIC)
		VALUES(I_TP_ENT_SAL_BBVA, V_CD_TP_ARCHIVO, I_CD_ST_ARCHIVO, I_NB_ARCH_PROCESADO, SYSTIMESTAMP, I_CD_PAIS, I_CD_BIC);

		COMMIT;

		V_STMT_STR := 'SELECT CD_ARCH_PROCESADO ' ||
		'FROM TGM009_ARCHPRC_LOG ' ||
		'WHERE TM_PROCESO > TO_DATE(TO_CHAR(SYSDATE, ''DD-MM-YYYY''), ''DD-MM-YYYY'') AND ' ||
		'NB_ARCH_PROCESADO = ''' || I_NB_ARCH_PROCESADO || ''' AND TP_ENT_SAL_BBVA = ''' || I_TP_ENT_SAL_BBVA || ''' ' ||
		'AND CD_TP_ARCHIVO = ' || V_CD_TP_ARCHIVO || ' AND CD_ST_ARCHIVO = ' || I_CD_ST_ARCHIVO || ' ';
		
		IF LENGTH(I_CD_PAIS) > 0 THEN
			V_STMT_STR := V_STMT_STR || 'AND CD_PAIS = ''' || I_CD_PAIS || ''' ';
		ELSE
			V_STMT_STR := V_STMT_STR || 'AND CD_PAIS IS NULL ';
		END IF;
		
		IF LENGTH(I_CD_BIC) > 0 THEN
			V_STMT_STR := V_STMT_STR || 'AND CD_BIC = ''' || I_CD_BIC || ''' ';
		ELSE
			V_STMT_STR := V_STMT_STR || 'AND CD_BIC IS NULL ';
		END IF;
		
		V_STMT_STR := V_STMT_STR || 'AND ROWNUM = 1 ORDER BY CD_ARCH_PROCESADO DESC';
		
		
    	OPEN O_CURSOR FOR V_STMT_STR;
    	LOOP 
			FETCH O_CURSOR INTO O_CD_ARCH_PROCESADO; -- fetch from cursor variable
			EXIT WHEN O_CURSOR%NOTFOUND; -- exit when last row is fetched
		END LOOP;
	ELSE
		O_CD_ARCH_PROCESADO := 0;
	END IF;
END;