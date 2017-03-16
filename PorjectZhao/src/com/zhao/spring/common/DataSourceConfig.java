package com.zhao.spring.common;

import javax.activation.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
@Configuration
public class DataSourceConfig {

	@Bean(destroyMethod="shutdown")
	@Profile("dev")
	public DataSource embeddeDataSource(){
		return (DataSource) new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).addScript("").addScript("").build();
	}
	
	@Bean
	@Profile("prod")
	public DataSource jndiDataSource(){
		JndiObjectFactoryBean jndiObjectFactoryBean=new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiName("");
		jndiObjectFactoryBean.setResourceRef(true);
		jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
		return (DataSource) jndiObjectFactoryBean.getObject();
	}
	
	public static void main(String [] args){
		System.out.println(-0.0==0.0);
		}
}
