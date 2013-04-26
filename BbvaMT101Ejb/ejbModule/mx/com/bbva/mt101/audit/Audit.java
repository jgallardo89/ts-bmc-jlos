package mx.com.bbva.mt101.audit;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.apache.log4j.Logger;

public class Audit implements Serializable {
	private static final long serialVersionUID = 4267181799103606230L;
	private static final Logger logger = Logger.getLogger(Audit.class);

	@AroundInvoke
	public Object methodChecker(InvocationContext ic) throws Exception {
		logger.info("Audit:methodChecker - About to execute method: "
				+ ic.getMethod());
		Object result = ic.proceed();
		return result;
	}
}