--clave 123
Insert into TGM023_USUARIO (CD_USUARIO,CD_PAIS,CD_CLAVE_USUARIO,CD_CONTRASENIA,NB_NOMBRE_USR,NB_APELL_PAT,NB_APELL_MAT,NU_EXTENSION,TX_CORREO_ELECTR,CT_CONEX_LIMITE,CT_LOGEO_ERRONEO,CT_CONEX_ACTIVAS,TM_CAMBIO_CNTRASEN,TM_ULTIMO_ACCESO) values (1,6,'PBA123','202cb962ac59075b964b07152d234b70','Usuario','Tst','__',1234,'tst@bbva.com',3,0,0,to_timestamp('09/01/13 11:35:44.000000000','DD/MM/RR HH24:MI:SS.FF'),to_timestamp('09/01/13 11:35:52.000000000','DD/MM/RR HH24:MI:SS.FF'));

Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (14,'ZA','Zambia',null,'Zambia',null);
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (15,'PA','Panam�',null,'Panam�','BBVAPAP0');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (1,'CO','Colombia',null,'Colombia','GEROCOB0');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (2,'VE','Venezuela',null,'Venezuela','BPROVECA');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (3,'PE','Per�',null,'Per�','BCONPEP0');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (4,'CL','Chile','0117','Chile','BHIFCLR0');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (5,'AR','Argentina',null,'Argentina','BFRPARBA');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (6,'MX','M�xico',null,'Mexico','BCMRMXMM');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (7,'PY','Paraguay',null,'Paraguay','BBVAPYPA');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (8,'FR','Francia',null,'Francia','BBVAPAP0');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (9,'US','Estados Unidos',null,null,'BCMRUS66');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (10,'PR','Puerto Rico',null,'Puerto_Rico','BBVAPRSJ');
Insert into TGM006_PAIS (CD_PAIS,NB_PAIS,TX_PAIS,CD_BANCO_INTERNO,NB_PAIS_CCR,NB_BIC) values (11,'ES','Espa�a',null,'Espa�a',null);

Insert into TGM015_AVISO (CD_AVISO,TX_AVISO,TM_ALTA) values (1,'Ambiente de desarrollo (Version Ligera).',to_timestamp('13/12/12 18:10:45.000000000','DD/MM/RR HH24:MI:SS.FF'));

Insert into TGM017_SECCION (CD_SECCION,NB_SECCION,NU_ORDEN) values (1,'Consultas',2);
Insert into TGM018_SUBSECCION (CD_SUBSECCION,CD_SECCION,NB_SUBSECCION,NU_ORDEN) values (1,1,'Monitoreo MT101 CashMX',5);
Insert into TGM020_LIGA (CD_LIGA,CD_PAIS,CD_SECCION,CD_SUBSECCION,CD_TP_LIGA,NB_LIGA,NB_RUTA_LIGA,NU_ORDEN,TP_LIGA_PRIVADA,TX_LIGA) values (1,6,1,1,1,'MT101','jsp/consultas/MT101/contenido.jsp',1,'1','MT101');
Insert into TGM020_LIGA (CD_LIGA,CD_PAIS,CD_SECCION,CD_SUBSECCION,CD_TP_LIGA,NB_LIGA,NB_RUTA_LIGA,NU_ORDEN,TP_LIGA_PRIVADA,TX_LIGA) values (2,6,1,null,1,'MT101','jsp/consultas/MT101/contenido.jsp',1,'1','Bitacora');

Insert into TGM016_GRUPO_USR (CD_GRUPO,NB_GRUPO) values (1,'Administradores');

Insert into TGM022_LIGA_GRUPO (CD_LIGA,CD_GRUPO) values (1,1);

Insert into TGM025_USUARIO_GRU (CD_USUARIO,CD_GRUPO) values (1,1);

Insert into TGM024_LIGA_USUARI (CD_LIGA,CD_USUARIO) values (1,1);
Insert into TGM024_LIGA_USUARI (CD_LIGA,CD_USUARIO) values (2,1);
