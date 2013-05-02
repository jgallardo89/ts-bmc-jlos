/*
Created: 21/01/2013
Modified: 05/03/2013
Model: MapMexGMM
Database: Oracle 10g
*/

-- Create tables section -------------------------------------------------

-- Table TGM501_PANTALLA

CREATE TABLE TGM501_PANTALLA(
  CD_PANTALLA Number(3,0) NOT NULL,
  CD_FK_PANTALLA Number(3,0),
  NB_PANTALLA Varchar2(30 CHAR) NOT NULL,
  TX_URL_PANTALLA Varchar2(300 CHAR),
  TX_URL_ICON Varchar2(300 CHAR),
  NU_ORD_PANTALLA Number(5,0) NOT NULL,
  ST_PANTALLA Number(5,0) NOT NULL
)
/

-- Add keys for table TGM501_PANTALLA

ALTER TABLE TGM501_PANTALLA ADD CONSTRAINT IGM501P1_PANTALLA PRIMARY KEY (CD_PANTALLA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM501_PANTALLA IS 'Tabla pantallas web, esta tabla es la encargada de almacenar el total de pantallas web que utiliza el sistema Mapeador México, también es la que determina la jerarquía entre  ellas, esta jerarquía es útil para generar el menú dinámico del sistema.'
/
COMMENT ON COLUMN TGM501_PANTALLA.CD_PANTALLA IS 'Consecutivo, representa a la llave primaria del la tabla TGM501_PANTALLA'
/
COMMENT ON COLUMN TGM501_PANTALLA.CD_FK_PANTALLA IS 'Llave foránea del la tabla TGM501_PANTALLA, indica la jerarquía que existe entres las pantallas '
/
COMMENT ON COLUMN TGM501_PANTALLA.NB_PANTALLA IS 'Nombre de la pantalla, hace referencia a una pantalla web la cual sirve como interfaz para que el usuario interactúe con el sistema mapeador México'
/
COMMENT ON COLUMN TGM501_PANTALLA.TX_URL_PANTALLA IS 'Es la dirección del lugar físico dentro del servidor, donde se encuentra la plantilla.
Puede ser dirección absoluta o relativa.
Ejemplo:
../bbva/mapeador/modulos/usuarios.xhtml'
/
COMMENT ON COLUMN TGM501_PANTALLA.TX_URL_ICON IS 'Es la dirección del lugar físico dentro ó fuera del servidor, donde se encuentra el icono a usar para el menu del sistema mapéador.
Puede ser dirección absoluta o relativa, url.
Ejemplo:
../bbva/mapeador/images/icnUsuario.ico
https://www.google.com.mx/images/srpr/addDate.icn'
/
COMMENT ON COLUMN TGM501_PANTALLA.NU_ORD_PANTALLA IS 'Es un número que representa el orden en el cual se deben mostrar las pantallas en la web.'
/
COMMENT ON COLUMN TGM501_PANTALLA.ST_PANTALLA IS 'Estatus de la pantalla.
Ejemplo:
Activo
Desarrollo 
'
/

-- Table TGM502_COMPONENTE

CREATE TABLE TGM502_COMPONENTE(
  CD_PANTALLA Number(3,0) NOT NULL,
  CD_COMPONENTE Number(3,0) NOT NULL,
  NB_COMPONENTE Varchar2(50 CHAR) NOT NULL,
  TP_COMPONENTE Varchar2(30 CHAR) NOT NULL,
  CD_DEFAULT Char(1 ) NOT NULL,
  ST_COMPONENTE Number(5,0) NOT NULL
)
/

-- Add keys for table TGM502_COMPONENTE

ALTER TABLE TGM502_COMPONENTE ADD CONSTRAINT IGM502P1_COMPONENT PRIMARY KEY (CD_PANTALLA,CD_COMPONENTE)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM502_COMPONENTE IS 'Tabla componentes por pantalla web, esta tabla es la encargada de almacenar el total de componentes que tiene cada pantalla web que utiliza el sistema Mapeador México y permite tener un control de todos los componentes web del sistema mapeador.'
/
COMMENT ON COLUMN TGM502_COMPONENTE.CD_PANTALLA IS 'Representa a la llave primaria del la tabla TGM501_PANTALLA, y forma parte de la llave compuesta de la tabla TGM502_COMPONENTE'
/
COMMENT ON COLUMN TGM502_COMPONENTE.CD_COMPONENTE IS 'Número consecutivo, forma parte de la llave compuesta de esta tabla. Se reinicia por pantalla.'
/
COMMENT ON COLUMN TGM502_COMPONENTE.NB_COMPONENTE IS 'Nombre del componente que utiliza una pantalla web .
Ejemplo.
btnGuardar
btnExcel
gridPrincipal'
/
COMMENT ON COLUMN TGM502_COMPONENTE.TP_COMPONENTE IS 'Campo que almacena el tipo del componente.
Ejemplo
btnGuardar es de tipo button
En este campo se guada.
button'
/
COMMENT ON COLUMN TGM502_COMPONENTE.CD_DEFAULT IS 'Este campo nos indica si el componente descrito es obligatorio mostrar siempre y cuando la pantalla a mostrar tenga un componente NO DEFAUL, 
Ejemplo:
T - Definir que es default
F - NO DEFAUL
'
/
COMMENT ON COLUMN TGM502_COMPONENTE.ST_COMPONENTE IS 'Estatus del componente
Ejemplo:
Activo
Desarrollo 
'
/

-- Table TGM503_USUARIO

CREATE TABLE TGM503_USUARIO(
  CD_USUARIO Number(5,0) NOT NULL,
  CD_CVE_USUARIO Varchar2(20 CHAR) NOT NULL,
  NB_USUARIO Varchar2(50 CHAR) NOT NULL,
  TX_PASSWORD_USR Varchar2(35 CHAR) NOT NULL,
  TM_ALTA Date NOT NULL,
  TM_MODIFICACION Date,
  FH_USUARIO Date NOT NULL,
  TM_CAMBIO_PWS Date NOT NULL,
  NU_INTENTOS Number(5,0),
  ST_USUARIO Number(5,0) NOT NULL,
  CD_PERFIL Number(3,0)
)
/

-- Create indexes for table TGM503_USUARIO

CREATE INDEX IGM503S1_USUARIO ON TGM503_USUARIO (FH_USUARIO)
/

-- Add keys for table TGM503_USUARIO

ALTER TABLE TGM503_USUARIO ADD CONSTRAINT IGM503P1_USUARIO PRIMARY KEY (CD_USUARIO)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM503_USUARIO IS 'Tabla catálogo usuario mapeador, almacena todos los usuarios y sus respectivas contraseñas de acceso al  sistema Mapeador México.'
/
COMMENT ON COLUMN TGM503_USUARIO.CD_USUARIO IS 'Consecutivo, representa a la llave primaria del la tabla TGM503_USUARIO'
/
COMMENT ON COLUMN TGM503_USUARIO.CD_CVE_USUARIO IS 'Campo que almacena el usuario de red asignado por bbva
Ejemplo 
XM05635'
/
COMMENT ON COLUMN TGM503_USUARIO.NB_USUARIO IS 'Campo que almacena el nombre de un usuario.
Ejemplo 
Juan Leon
Antonio Rios
'
/
COMMENT ON COLUMN TGM503_USUARIO.TX_PASSWORD_USR IS 'Campo que almacena la contraseña de acceso de un usuario.
Ejemplo 
sdw4654ghr762245faqewwr'
/
COMMENT ON COLUMN TGM503_USUARIO.TM_ALTA IS 'Campo que almacena la fecha y hora en que se dio de alta un usuario.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM503_USUARIO.TM_MODIFICACION IS 'Campo que almacena la fecha y hora en que se modificao la información de un usuario.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM503_USUARIO.FH_USUARIO IS 'Sirve como índice, y es un campo que almacena la fecha de la última modificación al registro de un usuario.
Ejemplo 
21/01/2013'
/
COMMENT ON COLUMN TGM503_USUARIO.TM_CAMBIO_PWS IS 'Campo que almacena la fecha y hora en que un usuario debe cambiar su contrasenia
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM503_USUARIO.NU_INTENTOS IS 'El campo que almacena el número de intentos fallidos que el usuario ha tenido al querer entrar al sistema Mapeador México.'
/
COMMENT ON COLUMN TGM503_USUARIO.ST_USUARIO IS 'Estatus del usuario
Ejemplo:
Activo
Vacaciones
'
/

-- Table TGM504_PERFIL

CREATE TABLE TGM504_PERFIL(
  CD_PERFIL Number(3,0) NOT NULL,
  NB_PERFIL Varchar2(30 CHAR) NOT NULL,
  TX_PERFIL Varchar2(300 CHAR) NOT NULL,
  ST_PERFIL Number(5,0) NOT NULL
)
/

-- Add keys for table TGM504_PERFIL

ALTER TABLE TGM504_PERFIL ADD CONSTRAINT IGM504P1_PERFIL PRIMARY KEY (CD_PERFIL)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM504_PERFIL IS 'Tabla catálogo perfil mapeador, almacena todos los perfiles existentes dentro del  sistema Mapeador México.'
/
COMMENT ON COLUMN TGM504_PERFIL.CD_PERFIL IS 'Número consecutivo, es la llave primaria de TGM504_PERFIL.'
/
COMMENT ON COLUMN TGM504_PERFIL.NB_PERFIL IS 'Nombre del perfil, sirve para otorgar permisos aun usuario, sobre el sistema mapeador México 
Ejemplo.
Administrador'
/
COMMENT ON COLUMN TGM504_PERFIL.TX_PERFIL IS 'Descripción del perfil, sirve para escribir a detalle los alcances sobre el sistema mapeador México del perfil.'
/
COMMENT ON COLUMN TGM504_PERFIL.ST_PERFIL IS 'Estatus del perfil
Ejemplo:
Activo
Desarrollo 
'
/

-- Table TGM505_CTRLPERMISO

CREATE TABLE TGM505_CTRLPERMISO(
  CD_PERFIL Number(3,0) NOT NULL,
  CD_PANTALLA Number(3,0) NOT NULL,
  CD_COMPONENTE Number(3,0) NOT NULL
)
/

-- Add keys for table TGM505_CTRLPERMISO

ALTER TABLE TGM505_CTRLPERMISO ADD CONSTRAINT IGM505P1_CTRLPERMI PRIMARY KEY (CD_PERFIL,CD_PANTALLA,CD_COMPONENTE)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM505_CTRLPERMISO IS 'Tabla de control de permisos, almacena la relación que existe de un perfil con determinadas pantallas web y componentes por pantalla, es decir, es la tabla que proporciona los privilegios a un perfil dentro del sistema mapeador México.'
/
COMMENT ON COLUMN TGM505_CTRLPERMISO.CD_PERFIL IS 'Representa a la llave primaria tabla TGM504_PERFIL, y forma parte de la llave compuesta de esta tabla.'
/
COMMENT ON COLUMN TGM505_CTRLPERMISO.CD_PANTALLA IS 'Representa a la llave primaria del la tabla TGM501_PANTALLA, y forma parte de la llave compuesta de la tabla TGM505_CTRLPERMISO'
/
COMMENT ON COLUMN TGM505_CTRLPERMISO.CD_COMPONENTE IS 'Representa a la llave primaria compuesta de la tabla TGM502_COMPONENTE, y forma parte de la llave compuesta de esta tabla.'
/

-- Table TGM507_BITACORA

CREATE TABLE TGM507_BITACORA(
  CD_BITACORA Number(15,0) NOT NULL,
  CD_USUARIO Number(5,0) NOT NULL,
  NB_BITACORA Varchar2(50 CHAR) NOT NULL,
  TX_BITACORA Clob NOT NULL,
  TM_BITACORA Date NOT NULL,
  FH_BITACORA Date NOT NULL,
  CD_EVENTO_MAPEADOR Number(5,0)
)
/

-- Create indexes for table TGM507_BITACORA

CREATE INDEX IGM507S1_BITACORA ON TGM507_BITACORA (FH_BITACORA)
/

-- Add keys for table TGM507_BITACORA

ALTER TABLE TGM507_BITACORA ADD CONSTRAINT IGM507P1_BITACORA PRIMARY KEY (CD_BITACORA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM507_BITACORA IS 'Tabla de bitácora de eventos, es la encargada de almacenar todo evento que intente ó genere cambios en la información del sistema Mapeador México.'
/
COMMENT ON COLUMN TGM507_BITACORA.CD_BITACORA IS 'Consecutivo, es la llave primaria del la tabla TGM507_BITACORA'
/
COMMENT ON COLUMN TGM507_BITACORA.CD_USUARIO IS 'Representa a la llave primaria del la tabla TGM503_USUARIO, sirve para identificar al usuario que realizo algun evento dentro del sistema mapeador'
/
COMMENT ON COLUMN TGM507_BITACORA.NB_BITACORA IS 'Es un comentario breve, sobre el evento que se ejecutó dentro del sistema mapeador
Ejemplo.
Alta de <elemento>
Modificación de <elemento>
Eliminación  de <elemento>'
/
COMMENT ON COLUMN TGM507_BITACORA.TX_BITACORA IS 'Campo que almacena a detalle el evento realizado y las infomrmacion afectada dentro del sistema mapeador México.'
/
COMMENT ON COLUMN TGM507_BITACORA.TM_BITACORA IS 'Campo que almacena la fecha y hora en que se generó algun eventro dentro del sistma mapeador
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM507_BITACORA.FH_BITACORA IS 'Sirve como indice y almacena la fecha en la que se generó algun evento dentro del sistema mapeador
Ejemplo 
21/01/2013'
/
COMMENT ON COLUMN TGM507_BITACORA.CD_EVENTO_MAPEADOR IS 'Llave foránea, sirve para relacionar el evento que se generó en el sistema mapeador '
/

-- Table TGM508_EVENTO_MAPA

CREATE TABLE TGM508_EVENTO_MAPA(
  CD_EVENTO_MAPEADOR Number(5,0) NOT NULL,
  NB_EVENTO_MAPEADOR Varchar2(30 CHAR) NOT NULL,
  TX_EVENTO_MAPEADOR Varchar2(200 CHAR)
)
/

-- Add keys for table TGM508_EVENTO_MAPA

ALTER TABLE TGM508_EVENTO_MAPA ADD CONSTRAINT IGM508P1_EVENTO_MA PRIMARY KEY (CD_EVENTO_MAPEADOR)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM508_EVENTO_MAPA IS 'Tabla catálogo de eventos mapeador, almacena todos los eventos permitidos en el dentro del  sistema Mapeador México.'
/
COMMENT ON COLUMN TGM508_EVENTO_MAPA.CD_EVENTO_MAPEADOR IS 'Consecutivo, es la llave primaria del la tabla TGM508_EVENTO_MAPA'
/
COMMENT ON COLUMN TGM508_EVENTO_MAPA.NB_EVENTO_MAPEADOR IS 'Campo que almacena un evento del sistema mapeador, el cual indica una accion del usuario dentro del sistema o un evento generado por el propio sistema.
Ejemplo 
agregar usuario
eliminar contratacion
registro de archivo entrada

'
/
COMMENT ON COLUMN TGM508_EVENTO_MAPA.TX_EVENTO_MAPEADOR IS 'Descripción del evento mapeador, sirve para escribir a detalle las caracteristicas del evento indicado .'
/

-- Table TGM534_ST_OBJETO

CREATE TABLE TGM534_ST_OBJETO(
  CD_ST_OBJETO Number(5,0) NOT NULL,
  CD_ST_CLAVE Char(10 CHAR) NOT NULL,
  NB_ST_OBJETO Varchar2(30 CHAR) NOT NULL,
  TX_ST_OBJETO Varchar2(200 CHAR)
)
/

-- Add keys for table TGM534_ST_OBJETO

ALTER TABLE TGM534_ST_OBJETO ADD CONSTRAINT IGM534P1_ST_OBJETO PRIMARY KEY (CD_ST_OBJETO)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM534_ST_OBJETO IS 'Tabla catálogo status objeto del sistema mapeador,  almacena todas las etiquetas que al usuario convenga para un mejor entendimiento de los status en determinada información del sistema mapeador México, estos status heredan el status clave.'
/
COMMENT ON COLUMN TGM534_ST_OBJETO.CD_ST_OBJETO IS 'Número consecutivo, es la llave primaria del la tabla TGM534_ST_OBJETO.'
/
COMMENT ON COLUMN TGM534_ST_OBJETO.CD_ST_CLAVE IS 'Llave foránea, sirve para asignar un status que identifique el sistema a la etiqueta estatus objeto la cual es el nombre propuesto por un usuario el sistema mapeador.'
/
COMMENT ON COLUMN TGM534_ST_OBJETO.NB_ST_OBJETO IS 'Nombre del status objeto, almacena etiqueta que al usuario convenga para un mejor entendimiento de los status en determinada información del sistema mapeador México, 
Ejemplo.
Vacaciones 
Cancelado
Suspendido'
/
COMMENT ON COLUMN TGM534_ST_OBJETO.TX_ST_OBJETO IS 'Descripción del status objeto, sirve para escribir a detalle el uso de la etiqueta status objeto dentro del mapeador México del perfil.'
/

-- Table TGM509_ST_CLAVE

CREATE TABLE TGM509_ST_CLAVE(
  CD_ST_CLAVE Char(10 CHAR) NOT NULL,
  NB_ST_CLAVE Varchar2(50 CHAR) NOT NULL
)
/

-- Add keys for table TGM509_ST_CLAVE

ALTER TABLE TGM509_ST_CLAVE ADD CONSTRAINT IGM509P1_ST_CLAVE PRIMARY KEY (CD_ST_CLAVE)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM509_ST_CLAVE IS 'Tabla catálogo status clave, almacena todos los status existentes en el sistema Mapeador México, la información contenida en esta tabla sirve para toma de decisiones dentro del sistema Mapeador México'
/
COMMENT ON COLUMN TGM509_ST_CLAVE.CD_ST_CLAVE IS 'Consecutivo, es la llave primaria del la tabla TGM509_ST_CLAVE'
/
COMMENT ON COLUMN TGM509_ST_CLAVE.NB_ST_CLAVE IS 'Nombre de la clave que representa un estatus estándar dentro del sistema mapeador.
Ejemplo.
Activo 
Inactivo
Este nombre clave, se comportará como palabra reservada la cual reconocerá el sistema para toma de decisiones


'
/

-- Table TGM540_CONTRASENIA

CREATE TABLE TGM540_CONTRASENIA(
  CD_USUARIO Number(5,0) NOT NULL,
  CD_CONTRASENIA Number(5,0) NOT NULL,
  TX_CONTRASENIA_USR Varchar2(35 CHAR) NOT NULL
)
/

-- Add keys for table TGM540_CONTRASENIA

ALTER TABLE TGM540_CONTRASENIA ADD CONSTRAINT IGM540P1_CONTRASEN PRIMARY KEY (CD_USUARIO,CD_CONTRASENIA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM540_CONTRASENIA IS 'Tabla historial de contraseñas por usuario, almacena las últimas 10 contraseñas que ha usado determinado usuario y con esto permite al sistema prohibir el uso recurrente en periodos cortos de la misma.'
/
COMMENT ON COLUMN TGM540_CONTRASENIA.CD_USUARIO IS 'Representa a la llave primaria del la tabla TGM503_USUARIO, y forma parte de la llave compuesta de esta tabla'
/
COMMENT ON COLUMN TGM540_CONTRASENIA.CD_CONTRASENIA IS 'Consecutivo, forma parte de la llave compuesta de esta tabla. 
Se reinicia por usuario.'
/
COMMENT ON COLUMN TGM540_CONTRASENIA.TX_CONTRASENIA_USR IS 'Campo que almacena una de las ultimas 10 contraseñas de acceso, usadas por el usuario.
Ejemplo 
sdw4654ghr762245faqewwr'
/

-- Table TGM517_ETAPA

CREATE TABLE TGM517_ETAPA(
  CD_ETAPA Number(5,0) NOT NULL,
  NB_ETAPA Varchar2(30 CHAR) NOT NULL,
  TX_ETAPA Varchar2(200 CHAR),
  TP_ETAPA Char(1 CHAR) NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM517_ETAPA

ALTER TABLE TGM517_ETAPA ADD CONSTRAINT IGM517P1_ETAPA PRIMARY KEY (CD_ETAPA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM517_ETAPA IS 'Tabla catálogo reporte del sistema mapeador,  almacena todos los reportes -archivos del sistema- existentes en todos los flujos del sistema mapeador México, estos reportes representan son los archivos de entrada y/o salida que tiene determinado flujo del sistema.'
/
COMMENT ON COLUMN TGM517_ETAPA.CD_ETAPA IS 'Consecutivo, es la llave primaria del la tabla TGM517_ETAPA'
/
COMMENT ON COLUMN TGM517_ETAPA.NB_ETAPA IS 'Nombre corto y representativo del reporte existente en los flujos.
Ejemplo:
Archivo Entrada
Acuse
Remisión total'
/
COMMENT ON COLUMN TGM517_ETAPA.TX_ETAPA IS 'Descripción del nombre corto y representativo del reporte existente en un flujo.
Ejemplo para:
Acuse
El valor a guardar es:
Reporte para archivo de Acuse de respuesta para el cliente IMSS'
/
COMMENT ON COLUMN TGM517_ETAPA.TP_ETAPA IS 'Es el tipo de reporte.
Ejemplo:
Entrada
Respuesta'
/
COMMENT ON COLUMN TGM517_ETAPA.CD_ST_OBJETO IS 'Estatus del reporte
Ejemplo:
Activo
Inactivo'
/

-- Table TGM518_FLUJOETAPA

CREATE TABLE TGM518_FLUJOETAPA(
  CD_FLUJO Number(5,0) NOT NULL,
  CD_ETAPA Number(5,0) NOT NULL,
  NU_ORDEN_ETAPA Number(5,0) NOT NULL
)
/

-- Add keys for table TGM518_FLUJOETAPA

ALTER TABLE TGM518_FLUJOETAPA ADD CONSTRAINT IGM518P1_FLUJOREP PRIMARY KEY (CD_FLUJO,CD_ETAPA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM518_FLUJOETAPA IS 'Tabla flujo reporte del sistema mapeador México, es una tabla de control, almacena la relación que existe entre un flujo con determinado número de reportes, es decir, es la tabla que proporciona al sistema Mapeador México la configuración que tiene determinado flujo ya que cada flujo puede tener n numero de reportes -archivo entrada, acuse, validación- y cada reporte está obligado a tener un orden que determina la secuencia de ejecución del los BPs y generación del archivo mapeado.'
/
COMMENT ON COLUMN TGM518_FLUJOETAPA.CD_FLUJO IS 'Representa a la llave primaria del la tabla TGM513_FLUJO, y forma parte de la llave compuesta de esta tabla TGM518_FLUJOETAPA'
/
COMMENT ON COLUMN TGM518_FLUJOETAPA.CD_ETAPA IS 'Representa a la llave primaria del la tabla TGM517_ETAPA, y forma parte de la llave compuesta de esta tabla TGM518_FLUJOETAPA'
/
COMMENT ON COLUMN TGM518_FLUJOETAPA.NU_ORDEN_ETAPA IS 'Numero consecutivo, represente al orden qued debe tener cada reporte en dentro de un flujo.'
/

-- Table TGM520_CONTRAT_MAP

CREATE TABLE TGM520_CONTRAT_MAP(
  CD_CONTRATACION Number(10,0) NOT NULL,
  CD_FLUJO Number(5,0) NOT NULL,
  CD_ETAPA Number(5,0) NOT NULL,
  CD_MAPA_GMM Number(5,0) NOT NULL,
  ST_NOTIFICACION Char(1 CHAR) NOT NULL,
  CD_MENSAJE_SALIDA Number(4,0),
  TX_ID_USUARIOS Varchar2(200 ) NOT NULL
)
/

-- Add keys for table TGM520_CONTRAT_MAP

ALTER TABLE TGM520_CONTRAT_MAP ADD CONSTRAINT IGM520P1_PROREPOR PRIMARY KEY (CD_FLUJO,CD_ETAPA,CD_CONTRATACION)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM520_CONTRAT_MAP IS 'Tabla contrato mapa del sistema mapeador México, es una tabla de control, almacena la configuración a detalle de cada contrato así como el tipo de mapeo a aplicar en cada uno de sus reportes y las notificaciones que recibirán determinados usuarios en caso de error también indica el canal de salida donde se tendrán que depositar los reportes mapeados según el contrato, esta tabla es indispensable para la ejecución de procesos dentro del sistema mapeador.'
/
COMMENT ON COLUMN TGM520_CONTRAT_MAP.CD_FLUJO IS 'Representa a la llave primaria del la tabla TGM513_FLUJO, y forma parte de la llave compuesta de esta tabla TGM520_CONTRAT_MAP'
/
COMMENT ON COLUMN TGM520_CONTRAT_MAP.CD_ETAPA IS 'Representa a la llave primaria del la tabla TGM517_REPORTE, y forma parte de la llave compuesta de esta tabla TGM520_CONTRAT_MAP'
/
COMMENT ON COLUMN TGM520_CONTRAT_MAP.CD_MAPA_GMM IS 'Llave foránea de esta tabla TGM520_CONTRAT_MAP, representa a la llave primaria del la tabla TGM514_MAPA_GMM, sirve para relacionar el mapa GMM que utiliza el reporte durante su mapeo.'
/
COMMENT ON COLUMN TGM520_CONTRAT_MAP.ST_NOTIFICACION IS 'Actua como bandera para determinar si se mandara notificación o no, a usuarios en caso de algun error.
Ejemplo.
''T'' para el caso de requerir notificación
''F'' para el caso de requerir notificación'
/
COMMENT ON COLUMN TGM520_CONTRAT_MAP.CD_MENSAJE_SALIDA IS 'Llave foránea de esta tabla TGM520_CONTRAT_MAP, representa a la llave primaria del la tabla TGM516_MENSAJE_SAL, hace referencia al mensaje que será enviado en caso de algún error durante el proceso de mapeo'
/
COMMENT ON COLUMN TGM520_CONTRAT_MAP.TX_ID_USUARIOS IS 'Campo ID_USUARIOS, es el campo que almacena una cadena que contiene todas las llaves primarias correspondientes a los usuarios que deberán recibir notificación en caso de error. Estas llaves primarias deben existir en la tabla TGM503_USUARIO.
Ejemplo de cadena a guardar:
23~1~3~9~2
'
/

-- Table TGM515_PRODUCTO

CREATE TABLE TGM515_PRODUCTO(
  CD_PRODUCTO Number(5,0) NOT NULL,
  CD_FLUJO Number(5,0) NOT NULL,
  NB_PRODUCTO Varchar2(30 CHAR) NOT NULL,
  TX_PRODUCTO Varchar2(200 CHAR) NOT NULL,
  TM_ALTA Date NOT NULL,
  TM_MODIFICACION Date,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM515_PRODUCTO

ALTER TABLE TGM515_PRODUCTO ADD CONSTRAINT IGM515P1_PRODUCTO PRIMARY KEY (CD_PRODUCTO)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM515_PRODUCTO IS 'Tabla catálogo producto del sistema mapeador,  almacena los productos -servicios que ofrece el banco a sus clientes- que contempla el sistema mapeador para ser generados. 
Por ejemplo, el producto Pago de Nomina IMSS'
/
COMMENT ON COLUMN TGM515_PRODUCTO.CD_PRODUCTO IS 'Consecutivo, es la llave primaria del la tabla TGM513_FLUJO.'
/
COMMENT ON COLUMN TGM515_PRODUCTO.CD_FLUJO IS 'Llave foránea, sirve para relacionar el flujo que utiliza un producto dentro del sistema mapeador.'
/
COMMENT ON COLUMN TGM515_PRODUCTO.NB_PRODUCTO IS 'Nombre representativo del un producto.
Ejemplo.
Nomina IMSS
'
/
COMMENT ON COLUMN TGM515_PRODUCTO.TX_PRODUCTO IS 'Descripción del producto, sirve para escribir a detalle las caracteristicas de determinado producto del sistema mapeador México.
Ejemplo para:
Nomina IMSS
El valor a guardar en este campo:
Producto de nómina para archivos de entrada del cliente'
/
COMMENT ON COLUMN TGM515_PRODUCTO.TM_ALTA IS 'Campo que almacena la fecha y hora en que se dio de alta un producto.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM515_PRODUCTO.TM_MODIFICACION IS 'Campo que almacena la fecha y hora en que se modificó la información de un producto.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM515_PRODUCTO.CD_ST_OBJETO IS 'Estatus del producto.
Ejemplo:
Activo
Inactivo
'
/

-- Table TGM513_FLUJO

CREATE TABLE TGM513_FLUJO(
  CD_FLUJO Number(5,0) NOT NULL,
  NB_FLUJO Varchar2(30 CHAR) NOT NULL,
  TX_FLUJO Varchar2(200 CHAR) NOT NULL,
  TX_URL_IMAGEN Varchar2(500 CHAR),
  TM_ALTA Date NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM513_FLUJO

ALTER TABLE TGM513_FLUJO ADD CONSTRAINT IGM513P1_FLUJO PRIMARY KEY (CD_FLUJO)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM513_FLUJO IS 'Tabla catálogo flujo del sistema mapeador,  almacena todos los flujos existentes dentro el sistema mapeador México.'
/
COMMENT ON COLUMN TGM513_FLUJO.CD_FLUJO IS 'Consecutivo, es la llave primaria del la tabla TGM513_FLUJO'
/
COMMENT ON COLUMN TGM513_FLUJO.NB_FLUJO IS 'Nombre representativo del flujo que se encuentra disponible en el sistema mapeador.
Ejemplo
F-H002
F-H010'
/
COMMENT ON COLUMN TGM513_FLUJO.TX_FLUJO IS 'Descripción del nombre representativo del flujol, sirve para escribir a detalle las caracteristicas de determinado flujo del sistema mapeador México.
Ejemplo para:
F-H010
El valor que se almacena en este campo es:
Protección a cheques
'
/
COMMENT ON COLUMN TGM513_FLUJO.TX_URL_IMAGEN IS 'Es la dirección del lugar físico dentro del servidor, donde se encuentra la imagen del esquema que representa al flujo.
Puede ser dirección absoluta o relativa.
Ejemplo:
../bbva/mapeador/image/flujos/fh10.png'
/
COMMENT ON COLUMN TGM513_FLUJO.TM_ALTA IS 'Campo que almacena la fecha y hora en que se dio de alta un flujo.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM513_FLUJO.CD_ST_OBJETO IS 'Estatus del flujo.
Ejemplo:
Activo
Inactivo'
/

-- Table TGM512_CLIENTE

CREATE TABLE TGM512_CLIENTE(
  CD_CLIENTE Number(5,0) NOT NULL,
  CD_IDENTIFICADOR Varchar2(30 CHAR) NOT NULL,
  NB_CORTO_CLIENTE Varchar2(30 CHAR) NOT NULL,
  NB_CLIENTE Varchar2(200 CHAR) NOT NULL,
  TM_ALTA Date NOT NULL,
  TM_MODIFICACION Date,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM512_CLIENTE

ALTER TABLE TGM512_CLIENTE ADD CONSTRAINT IGM512P1_CLIENTE PRIMARY KEY (CD_CLIENTE)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM512_CLIENTE IS 'Tabla catálogo cliente del sistema mapeador,  almacena las características de todos los clientes que usan los servicios del sistema mapeador México.La PK forma parte de un contrato.'
/
COMMENT ON COLUMN TGM512_CLIENTE.CD_CLIENTE IS 'Consecutivo, es la llave primaria del la tabla TGM512_CLIENTE'
/
COMMENT ON COLUMN TGM512_CLIENTE.CD_IDENTIFICADOR IS 'Identificador con el cual el canal de entrada reconoce al cliente.'
/
COMMENT ON COLUMN TGM512_CLIENTE.NB_CORTO_CLIENTE IS 'Nombre del cliente, hace referencia a un cliente sistema mapeador México.
Nombre representativo o Siglas del cliente
Ejemplo 
PEMEX 
IMSS'
/
COMMENT ON COLUMN TGM512_CLIENTE.NB_CLIENTE IS 'Nombre del cliente, hace referencia a un cliente del sistema mapeador México, este nombre es mas descriptivo que NB_CORTO_CLIENTE
Ejemplo para
IMSS
El valor que se guarda es 
Instituto Mexicano del Seguro Social'
/
COMMENT ON COLUMN TGM512_CLIENTE.TM_ALTA IS 'Campo que almacena la fecha y hora en que se dio de alta un cliente
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM512_CLIENTE.TM_MODIFICACION IS 'Campo que almacena la fecha y hora en que se modifico la información de un cliente
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM512_CLIENTE.CD_ST_OBJETO IS 'Estatus de un cliente
Ejemplo:
Activo
Inactivo'
/

-- Table TGM519_CONTRATACION

CREATE TABLE TGM519_CONTRATACION(
  CD_CONTRATACION Number(10,0) NOT NULL,
  CD_CANAL Number(5,0) NOT NULL,
  CD_CLIENTE Number(5,0) NOT NULL,
  CD_PRODUCTO Number(5,0) NOT NULL,
  CD_CANAL_SALIDA Number(5,0),
  TM_ALTA Date NOT NULL,
  TM_MODIFICACION Date,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM519_CONTRATACION

ALTER TABLE TGM519_CONTRATACION ADD CONSTRAINT IGM519P1_PROCESO PRIMARY KEY (CD_CONTRATACION)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM519_CONTRATACION IS 'Tabla contratación del sistema mapeador México , es una tabla de control, almacena la relación que existe entre un canal, cliente y producto , es decir, es la tabla que proporciona al sistema Mapeador México la contratación que tiene determinado cliente, esta contratación es única y un cliente puede tener varias contrataciones dentro del sistema mapeador México.'
/

-- Table TGM514_MAPA_GMM

CREATE TABLE TGM514_MAPA_GMM(
  CD_MAPA_GMM Number(5,0) NOT NULL,
  NB_MAPA_GMM Varchar2(30 CHAR) NOT NULL,
  TX_MAPA_GMM Varchar2(200 CHAR) NOT NULL,
  TM_ALTA Date NOT NULL,
  TM_MODIFICACION Date,
  NB_PROCESO_SI Varchar2(50 CHAR) NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM514_MAPA_GMM

ALTER TABLE TGM514_MAPA_GMM ADD CONSTRAINT IGM514P1_MAPA_GMM PRIMARY KEY (CD_MAPA_GMM)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM514_MAPA_GMM IS 'Tabla catálogo mapas GMM del sistema mapeador,  almacena todos los mapas y nombres de Business Process dispones para uso del sistema mapeador México.'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.CD_MAPA_GMM IS 'Consecutivo, es la llave primaria del la tabla TGM514_MAPA_GMM'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.NB_MAPA_GMM IS 'Nombre corto de un mapa GMM, sirve para identificar a un mapa de forma rapida
Ejemplo.
MP_DIE_SIT
MP_IMSS_CHEQUE'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.TX_MAPA_GMM IS 'Descripción a detalle del nombre representativo del mapa GMM.
Ejemplo para
MP_IMSS_CHEQUE
El valor a guardar en este campo es:
Mapa a aplicar para mapear archivos de formato de Imss a BBVA Protección a Cheques'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.TM_ALTA IS 'Campo que almacena la fecha y hora en que se dio de alta un mapa GMM.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.TM_MODIFICACION IS 'Campo que almacena la fecha y hora en que se modifico un mapa GMM.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.NB_PROCESO_SI IS 'Es el nombre del Business Process , que será ejecutado en Sterling Integrator.
Ejemplo:
BBVAbpGMtstXM05635P1.bp'
/
COMMENT ON COLUMN TGM514_MAPA_GMM.CD_ST_OBJETO IS 'Estatus del Mapa GMM
Ejemplo:
Activo
Inactivo'
/

-- Table TGM516_MENSAJE_SAL

CREATE TABLE TGM516_MENSAJE_SAL(
  CD_MENSAJE_SALIDA Number(4,0) NOT NULL,
  NB_MENSAJE_SALIDA Varchar2(50 CHAR) NOT NULL,
  TX_MENSAJE_SALIDA Varchar2(300 CHAR) NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM516_MENSAJE_SAL

ALTER TABLE TGM516_MENSAJE_SAL ADD CONSTRAINT IGM516P1_MSN_SAL PRIMARY KEY (CD_MENSAJE_SALIDA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM516_MENSAJE_SAL IS 'Tabla catálogo mensajes del sistema mapeador,  almacena los mensajes que serán usados por el sistema mapeador México, estos mensajes pueden ser las notificaciones a enviar en caso de error en algún proceso, cada mensaje es pre configurado  con palabras comodín con el objetivo de sustituir estas palabras y el mensaje sea personalizado por el sistema según el proceso en ejecución. '
/
COMMENT ON COLUMN TGM516_MENSAJE_SAL.CD_MENSAJE_SALIDA IS 'Numero consecutivo, es la llave primaria del la tabla TGM516_MENSAJE_SAL'
/
COMMENT ON COLUMN TGM516_MENSAJE_SAL.NB_MENSAJE_SALIDA IS 'Nombre corto y representativo del mensaje de salida.
Ejemplo.
MSG_ERR_IMSS
MSG_ERR_PEMEX_PC'
/
COMMENT ON COLUMN TGM516_MENSAJE_SAL.TX_MENSAJE_SALIDA IS 'Es el campo donde se guarda el mensaje de salida completo.
Ejemplo:
Error al mapear archivo de Pemex de Protección a Cheques correspondiente a %FH_ERROR%, lote %NU_LOTE%.
'
/
COMMENT ON COLUMN TGM516_MENSAJE_SAL.CD_ST_OBJETO IS 'Estatus del mensaje de salida.
Ejemplo:
Activo
Inactivo'
/

-- Table TGM511_CANAL

CREATE TABLE TGM511_CANAL(
  CD_CANAL Number(5,0) NOT NULL,
  NB_CANAL Varchar2(5 CHAR) NOT NULL,
  TX_CANAL Varchar2(300 CHAR) NOT NULL,
  TM_ALTA Date NOT NULL,
  TX_RUTA_CANAL_ENT Varchar2(300 CHAR) NOT NULL,
  TX_RUTA_CANAL_SAL Varchar2(300 CHAR) NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM511_CANAL

ALTER TABLE TGM511_CANAL ADD CONSTRAINT IGM511P1_CANAL PRIMARY KEY (CD_CANAL)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM511_CANAL IS 'Tabla catálogo canal del sistema mapeador,  almacena las características de todos los aplicativos -canales- que interactúan con el sistema mapeador México.'
/
COMMENT ON COLUMN TGM511_CANAL.CD_CANAL IS 'Consecutivo, es la llave primaria del la tabla TGM511_CANAL'
/
COMMENT ON COLUMN TGM511_CANAL.NB_CANAL IS 'Nombre del canal, es el nombre que indica el aplicativo de donde viene y a dónde van los diferentes tipos de archivos mapeados 
Ejemplo
H2H TRAD
SWIFT
BNC'
/
COMMENT ON COLUMN TGM511_CANAL.TX_CANAL IS 'Descripción del canal, sirve para escribir a detalle las características relevantes del canal.
Ejemplo, para
H2H TRAD 
El valor que se almacena es:
Host to Host tradicional'
/
COMMENT ON COLUMN TGM511_CANAL.TM_ALTA IS 'Campo que almacena la fecha y hora en que se dio de alta un canal.
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM511_CANAL.TX_RUTA_CANAL_ENT IS 'Campo que almacena la ruta de transmision de entrada del canal
Ejemplo
/gmm/pp/aplicación/to[aplicación ó aplicativo]'
/
COMMENT ON COLUMN TGM511_CANAL.TX_RUTA_CANAL_SAL IS 'Campo que almacena la ruta de transmision de salida, del canal.
Ejemplo
/gmm/pp/aplicación/from[aplicación ó aplicativo]'
/
COMMENT ON COLUMN TGM511_CANAL.CD_ST_OBJETO IS 'Estatus del canal
Ejemplo:
Activo
Desarrollo '
/

-- Table TGM521_PBA_COMODIN

CREATE TABLE TGM521_PBA_COMODIN(
  CD_PALABRA_COMODIN Number(5,0) NOT NULL,
  NB_PALABRA_COMODIN Varchar2(30 CHAR) NOT NULL,
  TX_PALABRA_COMODIN Varchar2(300 CHAR)
)
/

-- Add keys for table TGM521_PBA_COMODIN

ALTER TABLE TGM521_PBA_COMODIN ADD CONSTRAINT IGM521P1_PBA_COMOD PRIMARY KEY (CD_PALABRA_COMODIN)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM521_PBA_COMODIN IS 'Tabla catálogo palabra comodín del sistema mapeador,  almacena las palabras que serán usados por los mensajes de salida pre configurados, estas palabras comodín se comportaran como palabras clave para ser sustituidas por el sistema y el mensaje de salida sea personalizado según el proceso en ejecución.'
/
COMMENT ON COLUMN TGM521_PBA_COMODIN.CD_PALABRA_COMODIN IS 'Consecutivo, es la llave primaria de la tabla TGM521_PBA_COMODIN'
/
COMMENT ON COLUMN TGM521_PBA_COMODIN.NB_PALABRA_COMODIN IS 'Este nombre , se comportará como palabra reservada la cual reconocerá el sistema mapeador para sustituirlar por datos de procesos.
Ejemplo 
nom_usua
nom_arch_ent'
/
COMMENT ON COLUMN TGM521_PBA_COMODIN.TX_PALABRA_COMODIN IS 'Es el campo donde se guarda la descripción y uso de la palabra comodin dentro del sistema mapeador México.'
/

-- Table TGM522_ST_PROCESO

CREATE TABLE TGM522_ST_PROCESO(
  CD_CONTRATACION Number(10,0) NOT NULL,
  CD_FLUJO Number(5,0) NOT NULL,
  CD_ETAPA Number(5,0) NOT NULL,
  CD_REG_ARCH_ENTRA Number(15,0),
  NU_LOTE Number(5,0),
  TM_ST_PROCESO_INI Date NOT NULL,
  TM_ST_PROCESO_FIN Date,
  FH_ST_PROCESO Date NOT NULL,
  CD_ST_MAPEADOR Number(5,0) NOT NULL,
  TX_CONTRATACION Varchar2(300 CHAR)
)
/

-- Create indexes for table TGM522_ST_PROCESO

CREATE INDEX IGM522S1_ST_PROCES ON TGM522_ST_PROCESO (FH_ST_PROCESO)
/

-- Add keys for table TGM522_ST_PROCESO

ALTER TABLE TGM522_ST_PROCESO ADD CONSTRAINT IGM522P1_ST_PROCES PRIMARY KEY (CD_FLUJO,CD_ETAPA,CD_CONTRATACION)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM522_ST_PROCESO IS 'Tabla status por proceso del sistema mapeador México, es una tabla de seguimiento, almacena la información a detalle de cada proceso según la configuración de un contrato determinado, esta tabla es indispensable para el seguimiento del comportamiento y estatus de los procesos ejecutados y en ejecución dentro del sistema mapeador.'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.CD_FLUJO IS 'Representa a la llave primaria del la tabla TGM513_FLUJO, y forma parte de la llave compuesta de esta tabla TGM522_ST_PROCESO'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.CD_ETAPA IS 'Representa a la llave primaria del la tabla TGM517_REPORTE, y forma parte de la llave compuesta de esta tabla TGM522_ST_PROCESO'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.CD_REG_ARCH_ENTRA IS 'Representa a la llave primaria del la tabla TGM536_REG_ARCH_EN.'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.NU_LOTE IS 'Campo para identificar el numero del lote del cliente.'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.TM_ST_PROCESO_INI IS 'Campo que almacena la fecha y hora en que inicia el proceso de mapeo
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.TM_ST_PROCESO_FIN IS 'Campo que almacena la fecha y hora en que termina el proceso de mapeo
Ejemplo 
21/01/2013 03:58:41 p.m.'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.FH_ST_PROCESO IS 'Sirve como indice y almacena la fecha en la que se ejecutó algun proceso dentro del sistema mapeador
Ejemplo 
21/01/2013'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.CD_ST_MAPEADOR IS 'Estatus del proceso
Ejemplo:
Activo
En proceso 
Termino
'
/
COMMENT ON COLUMN TGM522_ST_PROCESO.TX_CONTRATACION IS 'Sirve par aagreagar una descripción en caso de error.'
/

-- Table TGM532_GPO_HOJA

CREATE TABLE TGM532_GPO_HOJA(
  CD_GPO_HOJA Number(15,0) NOT NULL,
  CD_NUMERO_HOJA Number(2,0) NOT NULL,
  CD_DEFINE_MAPA Number(5,0) NOT NULL,
  CD_REG_ARCH_ENTRA Number(15,0),
  TM_REGISTRO Date NOT NULL,
  FH_REGISTRO Date NOT NULL,
  TX_CAMPO_1 Varchar2(250 CHAR),
  TX_CAMPO_50 Varchar2(250 CHAR)
)
/

-- Create indexes for table TGM532_GPO_HOJA

CREATE INDEX IGM532S1_GPO_HOJA ON TGM532_GPO_HOJA (FH_REGISTRO)
/

-- Add keys for table TGM532_GPO_HOJA

ALTER TABLE TGM532_GPO_HOJA ADD CONSTRAINT IGM532P1_GPO_HOJA PRIMARY KEY (CD_GPO_HOJA,CD_NUMERO_HOJA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM532_GPO_HOJA IS 'Tabla grupo de hoja del sistema mapeador,  almacena las información que se extrae de un archivo cliente, es indispensable para proveer a un BP de información a mapear.'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.CD_GPO_HOJA IS 'Número consecutivo, forma parte de la llave compuesta de esta tabla TGM532_GPO_HOJA. 
Cada grupo compone a una serie de hojas.
El número hoja, representa a un conjunto de valores predefinidos.'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.CD_NUMERO_HOJA IS 'Número consecutivo, forma parte de la llave compuesta de esta tabla TGM532_GPO_HOJA. El valor se reinicia cada vez que cambia CD_GPO_HOJA.
El número hoja, representa a un conjunto de valores predefinidos, este es único dentro de un grupo de hoja'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.CD_DEFINE_MAPA IS 'Llave foránea de esta tabla TGM532_GPO_HOJA, representa a la llave primaria de la tabla TGM531_DEFINE_MAPA, sirve para identificar la definición que rige a esta hoja.'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.CD_REG_ARCH_ENTRA IS 'Llave foránea de esta tabla TGM532_GPO_HOJA, representa a la llave primaria de la tabla TGM536_REG_ARCH_EN, sirve para identificar el archivo de donde se extrae la información.'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.TM_REGISTRO IS 'Campo que almacena la fecha y hora en que se extrae la información del archivo, según la definición.
Ejemplo 
21/01/2013 03:58:41 p.m.
'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.FH_REGISTRO IS 'Sirve como índice y almacena la fecha en la que se extrae la información del archivo, según la definición.
Ejemplo 
21/01/2013'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.TX_CAMPO_1 IS 'Campo que almacena el valor correspondiente a un campo cliente, según la definición establecida.
El valor puede ser:
Alfabético
Alfanumérico
Numérico'
/
COMMENT ON COLUMN TGM532_GPO_HOJA.TX_CAMPO_50 IS 'Campo que almacena el valor correspondiente a un campo cliente, según la definición establecida.
El valor puede ser:
Alfabético
Alfanumérico
Numérico'
/

-- Table TGM531_DEFINE_MAPA

CREATE TABLE TGM531_DEFINE_MAPA(
  CD_DEFINE_MAPA Number(5,0) NOT NULL,
  CD_SECCION_MAPA Number(5,0) NOT NULL,
  NB_CAMPO_CLIENTE Varchar2(100 CHAR) NOT NULL,
  CD_NUMERO_HOJA Number(2,0) NOT NULL,
  NB_CAMPO_BD Varchar2(30 CHAR) NOT NULL,
  NU_POS_INICIAL Number(5,0),
  NU_POS_FINAL Number(5,0),
  TP_CAMPO_CLIENTE Varchar2(30 CHAR) NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM531_DEFINE_MAPA

ALTER TABLE TGM531_DEFINE_MAPA ADD CONSTRAINT IGM531P1_DEFINE_MA PRIMARY KEY (CD_DEFINE_MAPA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM531_DEFINE_MAPA IS 'Tabla definición de mapa del sistema mapeador,  almacena la información necesaria para identificar la extracción ordenada de datos que está en un archivo cliente.'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.CD_DEFINE_MAPA IS 'Número consecutivo, es la llave primaria del la tabla TGM531_DEFINE_MAPA'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.CD_SECCION_MAPA IS 'Llave foránea de esta tabla TGM531_DEFINE_MAPA, representa a la llave primaria del la tabla TGM533_SECC_MAPA, sirve para identificar a que seccion corresponde el campo de está definicion.'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.NB_CAMPO_CLIENTE IS 'Nombre del campo del cliente, sirve para identificar el nombre del dato a extraer.
Ejemplo.
Identificador
Numero de Cheque
Tipo de Operación'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.CD_NUMERO_HOJA IS 'Índice que hace referencia al número de fila donde se encuentra el valor del campo, este número de hoja representa a la llave compuesta de la tabla TGM532_GPO_HOJA.'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.NB_CAMPO_BD IS 'Nombre del campo a nivel Base de Datos, sirve para identificar el nombre de la columna que almacena el valor del Campo Cliente.
Ejemplo para.
Identificador
Numero de Cheque
El valor a guardar es:
TX_CAMPO_1
TX_CAMPO_2'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.NU_POS_INICIAL IS 'Número que indica la posición inicial de un dato alfanumérico a extraer del archivo cliente.'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.NU_POS_FINAL IS 'Número que indica la posición inicial de un dato alfanumérico a extraer del archivo cliente.'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.TP_CAMPO_CLIENTE IS 'Es el tipo de dato a extraer del archivo cliente, este campo solo es de uso informativo, no es parámetro para ningún proceso dentro del sistema mapeador
Ejemplo
Integer
String 
Numérico 
Alfanumérico'
/
COMMENT ON COLUMN TGM531_DEFINE_MAPA.CD_ST_OBJETO IS 'Estatus del campo del cliente
Ejemplo:
Activo
Inactivo
'
/

-- Table TGM537_EDO_ARCHIVO

CREATE TABLE TGM537_EDO_ARCHIVO(
  CD_ESTADO_ARCHIVO Number(15,0) NOT NULL,
  CD_REG_ARCH_ENTRA Number(15,0) NOT NULL,
  CD_ESTADO_ARCHIVO Number(5,0) NOT NULL,
  TM_ESTADO_ARCHIVO Date NOT NULL,
  FH_ESTADO_ARCHIVO Date NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Create indexes for table TGM537_EDO_ARCHIVO

CREATE INDEX IGM537S1_EDO_ARCHI ON TGM537_EDO_ARCHIVO (FH_ESTADO_ARCHIVO)
/

-- Add keys for table TGM537_EDO_ARCHIVO

ALTER TABLE TGM537_EDO_ARCHIVO ADD CONSTRAINT IGM537P1_EDO_ARCHI PRIMARY KEY (CD_ESTADO_ARCHIVO)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM537_EDO_ARCHIVO IS 'Tabla estado de archivo del sistema mapeador,  almacena los estados que han o están aplicándose a determinado archivo dentro sistema mapeador México.'
/
COMMENT ON COLUMN TGM537_EDO_ARCHIVO.CD_ESTADO_ARCHIVO IS 'Consecutivo, es la llave primaria del la tabla TGM537_EDO_ARCHIVO'
/
COMMENT ON COLUMN TGM537_EDO_ARCHIVO.CD_REG_ARCH_ENTRA IS 'Llave foránea de esta tabla TGM537_EDO_ARCHIVO, representa a la llave primaria de la tabla TGM536_REG_ARCH_EN, sirve para identificar el archivo del cual se reporta estado de mapeo.'
/
COMMENT ON COLUMN TGM537_EDO_ARCHIVO.CD_ESTADO_ARCHIVO IS 'Llave foránea de esta tabla TGM537_EDO_ARCHIVO, representa a la llave primaria de la tabla TGM538_ESTADO_MAPA, sirve para identificar el estado de mapeo por el cual está pasando o se aplicó al archivo en cuestión. '
/
COMMENT ON COLUMN TGM537_EDO_ARCHIVO.TM_ESTADO_ARCHIVO IS 'Campo que almacena la fecha y hora en que se aplica determinado estado de mapeo al archivo en cuestión.
Ejemplo 
21/01/2013 03:58:41 p.m.
'
/
COMMENT ON COLUMN TGM537_EDO_ARCHIVO.FH_ESTADO_ARCHIVO IS 'Sirve como índice y almacena la fecha en la que se aplica determinado estado de mapeo al archivo en cuestión.
Ejemplo 
21/01/2013'
/
COMMENT ON COLUMN TGM537_EDO_ARCHIVO.CD_ST_OBJETO IS 'Estatus del estado de archivo
Ejemplo:
Correcto
Incorrecto
Terminado
'
/

-- Table TGM536_REG_ARCH_EN

CREATE TABLE TGM536_REG_ARCH_EN(
  CD_REG_ARCH_ENTRA Number(15,0) NOT NULL,
  NB_REG_ARCH_ENTRA Varchar2(200 CHAR) NOT NULL,
  NU_LOTE Number(3,0) NOT NULL,
  FH_REG_ARCH_ENTRA Date
)
/

-- Create indexes for table TGM536_REG_ARCH_EN

CREATE INDEX IGM536S1_REG_ARCH ON TGM536_REG_ARCH_EN (FH_REG_ARCH_ENTRA)
/

-- Add keys for table TGM536_REG_ARCH_EN

ALTER TABLE TGM536_REG_ARCH_EN ADD CONSTRAINT IGM536P1_REG_ARCH PRIMARY KEY (CD_REG_ARCH_ENTRA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM536_REG_ARCH_EN IS 'Tabla registro de archivo entrada del sistema mapeador,  almacena el registro de nombre tipo y hora en que se recibe un archivo para ser procesado por el sistema mapeador México.'
/
COMMENT ON COLUMN TGM536_REG_ARCH_EN.CD_REG_ARCH_ENTRA IS 'Número consecutivo, es la llave primaria del la tabla TGM536_REG_ARCH_EN'
/
COMMENT ON COLUMN TGM536_REG_ARCH_EN.NB_REG_ARCH_ENTRA IS 'Campo que almacena el nombre del archivo recibido, no se cuenta con una nomenclatura establecida, por lo tanto, debe almacenar cualquier nombre.'
/
COMMENT ON COLUMN TGM536_REG_ARCH_EN.NU_LOTE IS 'Campo que almacena el folio ó lote del archivo recibido, es decir, se pueden tener mas de un archivo recibido con el mismo nombre pero con diferente lote.
Ejeplo para
NominaIMSS.cliente
Valor Lote:
6548
6549
6550'
/
COMMENT ON COLUMN TGM536_REG_ARCH_EN.FH_REG_ARCH_ENTRA IS 'Sirve como índice y almacena la fecha en la que se recibió algún archivo para el sistema mapeador
Ejemplo 
21/01/2013'
/

-- Table TGM533_SECC_MAPA

CREATE TABLE TGM533_SECC_MAPA(
  CD_SECCION_MAPA Number(5,0) NOT NULL,
  CD_FK_SECCION_MAPA Number(5,0),
  CD_MAPA_GMM Number(5,0),
  NB_SECCION_MAPA Varchar2(30 CHAR) NOT NULL,
  NB_EXPR_IDENTIFICA Varchar2(200 CHAR) NOT NULL,
  TX_SECCION_MAPA Varchar2(200 CHAR),
  NU_ORDEN_SECCION Number(5,0)
)
/

-- Add keys for table TGM533_SECC_MAPA

ALTER TABLE TGM533_SECC_MAPA ADD CONSTRAINT IGM533P1_SECC_MAPA PRIMARY KEY (CD_SECCION_MAPA)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM533_SECC_MAPA IS 'Tabla sección de mapa del sistema mapeador,  almacena la información necesaria para identificar los niveles y jerarquía entre niveles que agrupan una serie de definiciones de un determinado tipo de archivo.'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.CD_SECCION_MAPA IS 'Número consecutivo, es la llave primaria del la tabla TGM533_SECC_MAPA.'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.CD_FK_SECCION_MAPA IS 'Llave foránea del la tabla TGM533_SECC_MAPA, indica la jerarquía que existe entres las secciones definidas.'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.CD_MAPA_GMM IS 'Llave foránea de esta tabla TGM533_SECC_MAPA, representa a la llave primaria del la tabla TGM14_MAPA_GMM, sirve para identificar el tipo de mapa que aplica para esta definicion.'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.NB_SECCION_MAPA IS 'Nombre corto de una seccion, sirve para identificar a una seccion de forma rapida
Ejemplo.
TG-0008 - HEADER
TG-0008 - DETALLE'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.NB_EXPR_IDENTIFICA IS 'Etiqueta con la que se identifica una sección dentro del archivo cliente.
Ejemplo
TG-0008 - DETALLE
la etiqueta a guardar:
25180981D'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.TX_SECCION_MAPA IS 'Descripción a detalle del nombre y/o de la etiqueta de la seccion del mapa.
'
/
COMMENT ON COLUMN TGM533_SECC_MAPA.NU_ORDEN_SECCION IS 'Numero consecutivo, representa el orden que debe tener cada sección del mismo nivel jerárquico y que tengan la misma sección padre, es decir, que tengan la misma llave FK CD_FK_SECCION_MAPA'
/

-- Table TGM538_ESTADO_ARCH

CREATE TABLE TGM538_ESTADO_ARCH(
  CD_ESTADO_ARCHIVO Number(5,0) NOT NULL,
  NB_ESTADO_ARCHIVO Varchar2(30 CHAR) NOT NULL,
  TX_ESTADO_ARCHIVO Varchar2(200 CHAR)
)
/

-- Add keys for table TGM538_ESTADO_ARCH

ALTER TABLE TGM538_ESTADO_ARCH ADD CONSTRAINT IGM538P1_ESTADO_AR PRIMARY KEY (CD_ESTADO_ARCHIVO)
/

-- Table and Columns comments section
  
COMMENT ON TABLE TGM538_ESTADO_ARCH IS 'Tabla catálogo estado mapa GMM del sistema mapeador,  almacena todos los posibles estados o etapas posibles en el sistema, estas estapas son aquellas  que aplican a un archivo desde  su  entrada  hasta la transferencia del archivo mapeado dentro sistema mapeador México.'
/
COMMENT ON COLUMN TGM538_ESTADO_ARCH.CD_ESTADO_ARCHIVO IS 'Consecutivo, es la llave primaria del la tabla TGM538_ESTADO_ARCH'
/
COMMENT ON COLUMN TGM538_ESTADO_ARCH.NB_ESTADO_ARCHIVO IS 'Nombre representativo del estado archivo hace referencia a las diferentes etapas de procesos que aplican a un archivo desde  su  entrada  hasta la transferencia del archivo mapeado.
Ejemplo.
Registro de archivo entrada
Validación de archivo header
Validación de integridad'
/
COMMENT ON COLUMN TGM538_ESTADO_ARCH.TX_ESTADO_ARCHIVO IS 'Guarda la descripción y uso del nombre del estado archivo.
Ejemplo para:
Registro de archivo entrada
El valor a guardar es:
Estado mapeador que hace referencia al registro en BD del  nombre, tipo y hora en que se recibió un  archivo.'
/

-- Table TGM539_ESTADISTICA

CREATE TABLE TGM539_ESTADISTICA(
  CD_CONTRATACION Number(10,0) NOT NULL,
  CD_FLUJO Number(5,0) NOT NULL,
  CD_ETAPA Number(5,0) NOT NULL,
  NU_OPERACIONES Number(5,0) NOT NULL,
  FH_ESTADISTICA Date NOT NULL
)
/

-- Add keys for table TGM539_ESTADISTICA

ALTER TABLE TGM539_ESTADISTICA ADD CONSTRAINT Key1 PRIMARY KEY (CD_FLUJO,CD_ETAPA,CD_CONTRATACION)
/

-- Table TGM510_USUA_NOTIFI

CREATE TABLE TGM510_USUA_NOTIFI(
  CD_USUA_NOTIFICADO Number(5,0) NOT NULL,
  NB_USUA_NOTIFICADO Varchar2(100 CHAR) NOT NULL,
  TX_EMAIL Varchar2(100 CHAR) NOT NULL,
  CD_ST_OBJETO Number(5,0)
)
/

-- Add keys for table TGM510_USUA_NOTIFI

ALTER TABLE TGM510_USUA_NOTIFI ADD CONSTRAINT Key2 PRIMARY KEY (CD_USUA_NOTIFICADO)
/

-- Table and Columns comments section
  
COMMENT ON COLUMN TGM510_USUA_NOTIFI.CD_USUA_NOTIFICADO IS 'Llave primaria de la tabla TGM510_USUA_NOTIFI'
/
COMMENT ON COLUMN TGM510_USUA_NOTIFI.NB_USUA_NOTIFICADO IS 'Representa al usuario que recibirá notificación en caso de un error en el mapero de caulquier etapa.'
/
COMMENT ON COLUMN TGM510_USUA_NOTIFI.TX_EMAIL IS 'email del usuario donde recibira la notificación'
/
COMMENT ON COLUMN TGM510_USUA_NOTIFI.CD_ST_OBJETO IS 'Estatus del usuario notificador'
/

-- Create relationships section ------------------------------------------------- 

ALTER TABLE TGM501_PANTALLA ADD CONSTRAINT R5015011 FOREIGN KEY (CD_FK_PANTALLA) REFERENCES TGM501_PANTALLA (CD_PANTALLA)
/

ALTER TABLE TGM502_COMPONENTE ADD CONSTRAINT R5015022 FOREIGN KEY (CD_PANTALLA) REFERENCES TGM501_PANTALLA (CD_PANTALLA)
/

ALTER TABLE TGM505_CTRLPERMISO ADD CONSTRAINT R5025053 FOREIGN KEY (CD_PANTALLA, CD_COMPONENTE) REFERENCES TGM502_COMPONENTE (CD_PANTALLA, CD_COMPONENTE)
/

ALTER TABLE TGM505_CTRLPERMISO ADD CONSTRAINT R5045054 FOREIGN KEY (CD_PERFIL) REFERENCES TGM504_PERFIL (CD_PERFIL)
/

ALTER TABLE TGM507_BITACORA ADD CONSTRAINT R5035076 FOREIGN KEY (CD_USUARIO) REFERENCES TGM503_USUARIO (CD_USUARIO)
/

ALTER TABLE TGM507_BITACORA ADD CONSTRAINT R5085077 FOREIGN KEY (CD_EVENTO_MAPEADOR) REFERENCES TGM508_EVENTO_MAPA (CD_EVENTO_MAPEADOR)
/

ALTER TABLE TGM502_COMPONENTE ADD CONSTRAINT R5345028 FOREIGN KEY (ST_COMPONENTE) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM501_PANTALLA ADD CONSTRAINT R5345019 FOREIGN KEY (ST_PANTALLA) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM504_PERFIL ADD CONSTRAINT R53450411 FOREIGN KEY (ST_PERFIL) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM503_USUARIO ADD CONSTRAINT R53450310 FOREIGN KEY (ST_USUARIO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM534_ST_OBJETO ADD CONSTRAINT R50953412 FOREIGN KEY (CD_ST_CLAVE) REFERENCES TGM509_ST_CLAVE (CD_ST_CLAVE)
/

ALTER TABLE TGM540_CONTRASENIA ADD CONSTRAINT R50354014 FOREIGN KEY (CD_USUARIO) REFERENCES TGM503_USUARIO (CD_USUARIO)
/

ALTER TABLE TGM518_FLUJOETAPA ADD CONSTRAINT R5175182 FOREIGN KEY (CD_ETAPA) REFERENCES TGM517_ETAPA (CD_ETAPA)
/

ALTER TABLE TGM520_CONTRAT_MAP ADD CONSTRAINT R5185208 FOREIGN KEY (CD_FLUJO, CD_ETAPA) REFERENCES TGM518_FLUJOETAPA (CD_FLUJO, CD_ETAPA)
/

ALTER TABLE TGM515_PRODUCTO ADD CONSTRAINT R5135151 FOREIGN KEY (CD_FLUJO) REFERENCES TGM513_FLUJO (CD_FLUJO)
/

ALTER TABLE TGM518_FLUJOETAPA ADD CONSTRAINT R5135183 FOREIGN KEY (CD_FLUJO) REFERENCES TGM513_FLUJO (CD_FLUJO)
/

ALTER TABLE TGM520_CONTRAT_MAP ADD CONSTRAINT R5195207 FOREIGN KEY (CD_CONTRATACION) REFERENCES TGM519_CONTRATACION (CD_CONTRATACION)
/

ALTER TABLE TGM520_CONTRAT_MAP ADD CONSTRAINT R51452010 FOREIGN KEY (CD_MAPA_GMM) REFERENCES TGM514_MAPA_GMM (CD_MAPA_GMM)
/

ALTER TABLE TGM520_CONTRAT_MAP ADD CONSTRAINT R51652011 FOREIGN KEY (CD_MENSAJE_SALIDA) REFERENCES TGM516_MENSAJE_SAL (CD_MENSAJE_SALIDA)
/

ALTER TABLE TGM522_ST_PROCESO ADD CONSTRAINT R52052221 FOREIGN KEY (CD_FLUJO, CD_ETAPA, CD_CONTRATACION) REFERENCES TGM520_CONTRAT_MAP (CD_FLUJO, CD_ETAPA, CD_CONTRATACION)
/

ALTER TABLE TGM532_GPO_HOJA ADD CONSTRAINT R5315322 FOREIGN KEY (CD_DEFINE_MAPA) REFERENCES TGM531_DEFINE_MAPA (CD_DEFINE_MAPA)
/

ALTER TABLE TGM532_GPO_HOJA ADD CONSTRAINT R5365324 FOREIGN KEY (CD_REG_ARCH_ENTRA) REFERENCES TGM536_REG_ARCH_EN (CD_REG_ARCH_ENTRA)
/

ALTER TABLE TGM537_EDO_ARCHIVO ADD CONSTRAINT R5365375 FOREIGN KEY (CD_REG_ARCH_ENTRA) REFERENCES TGM536_REG_ARCH_EN (CD_REG_ARCH_ENTRA)
/

ALTER TABLE TGM533_SECC_MAPA ADD CONSTRAINT R5335331 FOREIGN KEY (CD_FK_SECCION_MAPA) REFERENCES TGM533_SECC_MAPA (CD_SECCION_MAPA)
/

ALTER TABLE TGM531_DEFINE_MAPA ADD CONSTRAINT R5335313 FOREIGN KEY (CD_SECCION_MAPA) REFERENCES TGM533_SECC_MAPA (CD_SECCION_MAPA)
/

ALTER TABLE TGM537_EDO_ARCHIVO ADD CONSTRAINT R53853712 FOREIGN KEY (CD_ESTADO_ARCHIVO) REFERENCES TGM538_ESTADO_ARCH (CD_ESTADO_ARCHIVO)
/

ALTER TABLE TGM511_CANAL ADD CONSTRAINT R53451113 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM515_PRODUCTO ADD CONSTRAINT R53451514 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM512_CLIENTE ADD CONSTRAINT R53451217 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM514_MAPA_GMM ADD CONSTRAINT R53451418 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM516_MENSAJE_SAL ADD CONSTRAINT R53451619 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM513_FLUJO ADD CONSTRAINT R53451315 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM517_ETAPA ADD CONSTRAINT R53451716 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM531_DEFINE_MAPA ADD CONSTRAINT R53453110 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM537_EDO_ARCHIVO ADD CONSTRAINT R53453711 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM522_ST_PROCESO ADD CONSTRAINT R53452214 FOREIGN KEY (CD_ST_MAPEADOR) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM533_SECC_MAPA ADD CONSTRAINT R5145336 FOREIGN KEY (CD_MAPA_GMM) REFERENCES TGM514_MAPA_GMM (CD_MAPA_GMM)
/

ALTER TABLE TGM522_ST_PROCESO ADD CONSTRAINT R53652213 FOREIGN KEY (CD_REG_ARCH_ENTRA) REFERENCES TGM536_REG_ARCH_EN (CD_REG_ARCH_ENTRA)
/

ALTER TABLE TGM503_USUARIO ADD CONSTRAINT R5045035 FOREIGN KEY (CD_PERFIL) REFERENCES TGM504_PERFIL (CD_PERFIL)
/

ALTER TABLE TGM539_ESTADISTICA ADD CONSTRAINT R5225398 FOREIGN KEY (CD_FLUJO, CD_ETAPA, CD_CONTRATACION) REFERENCES TGM522_ST_PROCESO (CD_FLUJO, CD_ETAPA, CD_CONTRATACION)
/

ALTER TABLE TGM510_USUA_NOTIFI ADD CONSTRAINT R53451015 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/

ALTER TABLE TGM519_CONTRATACION ADD CONSTRAINT R51151920 FOREIGN KEY (CD_CANAL_SALIDA) REFERENCES TGM511_CANAL (CD_CANAL)
/

ALTER TABLE TGM519_CONTRATACION ADD CONSTRAINT R5115194 FOREIGN KEY (CD_CANAL) REFERENCES TGM511_CANAL (CD_CANAL)
/

ALTER TABLE TGM519_CONTRATACION ADD CONSTRAINT R5125195 FOREIGN KEY (CD_CLIENTE) REFERENCES TGM512_CLIENTE (CD_CLIENTE)
/

ALTER TABLE TGM519_CONTRATACION ADD CONSTRAINT R5155196 FOREIGN KEY (CD_PRODUCTO) REFERENCES TGM515_PRODUCTO (CD_PRODUCTO)
/

ALTER TABLE TGM519_CONTRATACION ADD CONSTRAINT R53451922 FOREIGN KEY (CD_ST_OBJETO) REFERENCES TGM534_ST_OBJETO (CD_ST_OBJETO)
/




