package com.citi.trading.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Data;


@Configuration
@Data
public class DbConfiguration {
	@Value("${db_url}")
	private String url;
	@Value("${db_username}")
	private String userName;
	@Value("${db_password}")
	private String password;
	@Value("${db_driver}")
	private String driverClassName;
	
	@Profile("prod")
	@Bean
	public DataSource getProdnDataSource()
	{
		
		DataSourceBuilder builder= DataSourceBuilder.create();
		builder.url(url);
		builder.username(userName);
		builder.password(password);
		builder.driverClassName(driverClassName);
		System.out.println("Production.....");
		return builder.build();
	}
	@Profile("dev")
	@Bean
	public DataSource getDevDataSource()
	{
		
		DataSourceBuilder builder= DataSourceBuilder.create();
		builder.url(url);
		builder.username(userName);
		builder.password(password);
		builder.driverClassName(driverClassName);
		System.out.println("Development.....");
		return builder.build();
	}
	@Profile("qa")
	@Bean
	public DataSource getQADataSource()
	{
		DataSourceBuilder builder= DataSourceBuilder.create();
		builder.url(url);
		builder.username(userName);
		builder.password(password);
		builder.driverClassName(driverClassName);
		System.out.println("QA.....");
		return builder.build();
		
	}
	
}
