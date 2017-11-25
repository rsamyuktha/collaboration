package com.niit.Backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Backend.dao.Blogdao;
import com.niit.Backend.dao.Userdao;
import com.niit.Backend.daoimpl.Userdaoimpl;
import com.niit.Backend.daoimpl.Blogdaoimpl;
import com.niit.Backend.model.Blog;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit.Backend")

public class DBConfig 
{
	   //1.Creating a DataSource Object which is used for LocalSessionFactory
		public DataSource getOracleDataSource()
		{
			DriverManagerDataSource driverManagerDataSource=new DriverManagerDataSource();
			driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			driverManagerDataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
			driverManagerDataSource.setUsername("mycoll");
			driverManagerDataSource.setPassword("mycoll");
			return driverManagerDataSource;
		}
		
		//2.Creating Hibernate Properties which is used by LocalSessionFactory
		public Properties getHibernateProperties()
		{
			Properties properties=new Properties();
			properties.setProperty("hibernate.hbm2ddl.auto", "update");
			properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
			return properties;
		}
		
		@Bean
		public SessionFactory getSessionFactory()
		{
			LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getOracleDataSource());
			localSessionFactoryBuilder.addProperties(getHibernateProperties());
			localSessionFactoryBuilder.addAnnotatedClass(Blog.class);
			System.out.println("SessionFactory Bean Created");
			return localSessionFactoryBuilder.buildSessionFactory();
		}
		
		@Bean
		public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
		{
			return new HibernateTransactionManager(sessionFactory);
		}
		
		@Bean
		public Blogdao getBlogdao(SessionFactory sessionFactory)
		{
			System.out.println("Blog DAO object Created");
			return new Blogdaoimpl(sessionFactory);
		}
		
		
		public Userdao getUserdao(SessionFactory sessionFactory)
		{
			System.out.println("User DAO object Created");
			return new Userdaoimpl (sessionFactory);
		}
		
}
