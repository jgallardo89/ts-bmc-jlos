package mx.com.bbva.mt101.configuration;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Mt101SessionFactory {
	protected static final SqlSessionFactory FACTORY;
	static {
		try {
			Reader reader = Resources
					.getResourceAsReader("MyBatis-JPA-Configuration.xml");
			FACTORY = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Fatal Error.  Cause: " + e, e);
		}
	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return FACTORY;
	}

}