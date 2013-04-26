package mx.com.bbva.mt101.audit.negocio;

import javax.ejb.Local;

import mx.com.bbva.mt101.entities.Tgm048ProcesoLog;

@Local
public abstract interface IProcesoLog {
	public abstract int setProcesoLog(Tgm048ProcesoLog tgm048ProcesoLog);
}
