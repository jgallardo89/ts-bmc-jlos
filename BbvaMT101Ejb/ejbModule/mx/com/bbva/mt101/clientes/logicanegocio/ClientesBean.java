package mx.com.bbva.mt101.clientes.logicanegocio;

import java.util.List;

import javax.ejb.Stateless;

import mx.com.bbva.mt101.clientes.negocio.IClientes;
import mx.com.bbva.mt101.configuration.Mt101SessionFactory;
import mx.com.bbva.mt101.entities.Tgm138Mt101ctrato;
import mx.com.bbva.mt101.mapper.MapTgm138Mt101ctrato;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

@Stateless
public class ClientesBean implements IClientes {

	private static final Logger logger = Logger.getLogger(ClientesBean.class);

	public long actualizarCliente(Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: actualizarCliente  -- **inicio**");
		long result = 0L;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			try {
				result = mapTgm138Mt101ctrato
						.actualizaCliente(tgm138Mt101ctrato);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("ClientesBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: actualizarCliente  -- **fin**");
		}
	}

	public long actualizarClienteInactivo(Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: actualizarClienteInactivo  -- **inicio**");
		long result = 0L;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			try {
				result = mapTgm138Mt101ctrato
						.actualizaClienteInactivo(tgm138Mt101ctrato);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("ClientesBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: actualizarClienteInactivo  -- **fin**");
		}
	}

	public Tgm138Mt101ctrato buscarTgm138Mt101ctrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		return null;
	}

	public long eliminaClienteActivo(Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: eliminaClienteActivo  -- **inicio**");
		long result = 0L;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			try {
				result = mapTgm138Mt101ctrato
						.eliminaClienteActivo(tgm138Mt101ctrato);
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("ClientesBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: eliminaClienteActivo  -- **fin**");
		}
	}

	public Tgm138Mt101ctrato existeCodigoBicEnvio(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: existeCodigoBicEnvio  -- **inicio**");
		Tgm138Mt101ctrato result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			result = mapTgm138Mt101ctrato.obtieneCdCodSwEnv(tgm138Mt101ctrato);
			logger.debug("ClientesBean: - result:" + result + "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: existeCodigoBicEnvio  -- **fin**");
		}
	}

	public Tgm138Mt101ctrato existeCodigoBicRecepcion(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: existeCodigoBicRecepcion  -- **inicio**");
		Tgm138Mt101ctrato result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			result = mapTgm138Mt101ctrato.obtieneCdCodSwRec(tgm138Mt101ctrato);
			logger.debug("ClientesBean: - result:" + result + "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: existeCodigoBicRecepcion  -- **fin**");
		}
	}

	public List<Tgm138Mt101ctrato> filtarTgm138Mt101ctrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: filtarTgm138Mt101ctrato  -- **inicio**");
		List<Tgm138Mt101ctrato> result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			result = mapTgm138Mt101ctrato.obtenerClientes(tgm138Mt101ctrato);
			logger.debug("ClientesBean: - result:" + result.size()
					+ "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: filtarTgm138Mt101ctrato  -- **fin**");
		}
	}

	public List<Tgm138Mt101ctrato> obtenerTodosTgm138Mt101ctrato() {
		return null;
	}

	public Tgm138Mt101ctrato obtieneCliente(Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: obtieneCliente  -- **inicio**");
		Tgm138Mt101ctrato result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			result = mapTgm138Mt101ctrato.obtieneContrato(tgm138Mt101ctrato);
			logger.debug("ClientesBean: - result:" + result + "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: obtieneCliente  -- **fin**");
		}
	}

	public Tgm138Mt101ctrato obtieneClienteContrato(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: obtieneClienteContrato  -- **inicio**");
		Tgm138Mt101ctrato result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			result = mapTgm138Mt101ctrato
					.obtieneContratoCliente(tgm138Mt101ctrato);
			logger.debug("ClientesBean: - result:" + result + "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: obtieneClienteContrato  -- **fin**");
		}
	}

	public Tgm138Mt101ctrato obtieneCuentaCheques(
			Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: obtieneCuentaCheques  -- **inicio**");
		Tgm138Mt101ctrato result = null;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			result = mapTgm138Mt101ctrato
					.obtieneCuentaCheques(tgm138Mt101ctrato);
			logger.debug("ClientesBean: - result:" + result + "  -- **inicio**");
			session.close();
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: obtieneCuentaCheques  -- **fin**");
		}
	}

	public long salvarCliente(Tgm138Mt101ctrato tgm138Mt101ctrato) {
		logger.debug("ClientesBean: - Metodo: salvarCliente  -- **inicio**");
		long result = 0L;
		try {
			SqlSession session = Mt101SessionFactory.getSqlSessionFactory()
					.openSession();
			MapTgm138Mt101ctrato mapTgm138Mt101ctrato = session
					.getMapper(MapTgm138Mt101ctrato.class);
			try {
				result = mapTgm138Mt101ctrato.salvarContrato(tgm138Mt101ctrato);
				result = tgm138Mt101ctrato.getCdContrato();
				session.commit();
			} catch (Exception ex) {
				session.rollback();
				ex.printStackTrace();
			} finally {
				session.close();
			}
			logger.debug("ClientesBean: - result: " + result + " -- **fin**");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
			return result;
		} finally {
			logger.debug("ClientesBean: - Metodo: salvarCliente  -- **fin**");
		}
	}
}
