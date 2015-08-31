package by.belisa.entity;

import java.sql.Types;

import org.hibernate.Hibernate;
import org.hibernate.dialect.Dialect;


public class SQLServerDialect extends Dialect {
	public SQLServerDialect() {
		super();
		registerHibernateType( Types.NVARCHAR, Hibernate.STRING.getName() );
	}
}
