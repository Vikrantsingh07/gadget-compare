package web.com.gadgetbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"web.com.gadgetbackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {
/**
 * Hibernate Config details 
 * Here we are using static, It's not the right way
 * config details should be define in Property file. 
 */
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/onlineCompDB"; 
	private final static String DATABASE_DRIVER="org.h2.Driver";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME="sa";
	private final static String DATABASE_PASSWORD="";
	
	/*DataBase Connection Properties*/
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource(); //Note :- BasicDataSource is coming from dbcp2 , BasicDataSource class is predefine in BasicDataSource 
        
		//providing the Database connection information to dataSource
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);	
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
	}
	
	/*Hibernate Properties & Mapping Resource */
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource); //Note:-LocalSessionFactoryBuilder import according to Hibernate version ie : If you have choose hibernate version 4 then you have to import class LocalSessionFactoryBuilder for version 4 
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("web.com.gadgetbackend.dto");
		System.out.println("Session builder------>"+builder);
		return  builder.buildSessionFactory();
	}
    @Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		System.out.println("sessionFactory-------->"+sessionFactory.toString());
		HibernateTransactionManager transactionmanager=new HibernateTransactionManager(sessionFactory);
		System.out.println("transaction manager------->"+transactionmanager);
		return transactionmanager;
	}
	//All the hibernate properties will be 
	private Properties getHibernateProperties() {
		Properties properties= new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		//properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.format_sql", "true");
		//properties.put("use_sql_comments", "true");
		
		
		return properties;
	}
	
	
}
