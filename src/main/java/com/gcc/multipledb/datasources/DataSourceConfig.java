package com.gcc.multipledb.datasources;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.schema.TargetType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;

@Configuration
@EnableJpaRepositories(
		basePackages = "com.gcc.multipledb.repositories",
		transactionManagerRef = "transcationManager",
		entityManagerFactoryRef = "entityManager")
@EnableTransactionManagement
public class DataSourceConfig {
	
	private static Logger log = LoggerFactory.getLogger(DataSourceConfig.class);

	@Value("${gcc.databases}")
	private String[] gccDatabases;
	
	@Value("${gcc.hostdb}")
	private String hostdb;
	
	@Value("${gcc.userdb}")
	private String userdb;
	
	@Value("${gcc.passdb}")
	private String passdb;
	
	@Value("${gcc.entities}")
	private String[] entitiesPackages;
	
	@Value("${gcc.pool.initial-size}")
	private Integer poolInitialSize;
	
	@Value("${gcc.pool.max-active}")
	private Integer poolMaxActive;
	
	@Value("${gcc.pool.max-idle}")
	private Integer poolMaxIdle;
	
	private Map<Object, Object> dataSourceMap = new HashMap<>();
	
	private final Map<String, String> hibernatesettings = Map.of(
			AvailableSettings.DIALECT,"org.hibernate.dialect.PostgreSQL10Dialect", 
			AvailableSettings.DRIVER, "org.postgresql.Driver",
			AvailableSettings.HBM2DDL_AUTO, "update",
			AvailableSettings.PHYSICAL_NAMING_STRATEGY, "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl",
			AvailableSettings.SHOW_SQL, "false",
			AvailableSettings.HBM2DDL_HALT_ON_ERROR, "false"
	);
	
	@Bean
	@Primary
	@Autowired
	public DataSource dataSource() {
		for(String database : gccDatabases) {
			PoolProperties p = new PoolProperties();
			p.setUrl("jdbc:postgresql://" + hostdb + "/" + database);
			p.setUsername(userdb);
			p.setPassword(passdb);
			p.setDriverClassName("org.postgresql.Driver");
			p.setInitialSize(poolInitialSize);
			p.setMaxActive(poolMaxActive);
			p.setMaxIdle(poolMaxIdle);
			org.apache.tomcat.jdbc.pool.DataSource dataSource =  new org.apache.tomcat.jdbc.pool.DataSource();
			dataSource.setPoolProperties(p);
			dataSourceMap.put(database, dataSource);
		}
		DataSourceRouting routingDataSource = new DataSourceRouting();
		routingDataSource.initDatasource(dataSourceMap, gccDatabases[0]);
		updateSchemas();
		return routingDataSource;
	}
	
	@Bean(name = "entityManager")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
			EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource()).packages(entitiesPackages).build();
	}
	
	@Bean(name = "transcationManager")
	public JpaTransactionManager transactionManager(
			@Autowired @Qualifier("entityManager") LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
		return new JpaTransactionManager(entityManagerFactoryBean.getObject());
	}
	
	private void updateSchemas() {
		for(String database : gccDatabases) {
			
			log.info("### UpdateSchema " + database);
			
			boolean isNewDatabase = isEmptyDatabase((DataSource) dataSourceMap.get(database));
			
			//Schema update
			MetadataSources metadataSources = new MetadataSources(
	                new StandardServiceRegistryBuilder()
	                        .applySettings(hibernatesettings)
	                        .applySetting(Environment.DATASOURCE, dataSourceMap.get(database))
	                        .build());
	        List<Class<?>> classes = EntityScanner.scanPackages(entitiesPackages).result();
	        for (Class<?> annotatedClass : classes) {
	            metadataSources.addAnnotatedClass(annotatedClass);
	        }
	        final MetadataImplementor metadata = (MetadataImplementor) metadataSources.buildMetadata();
	        SchemaUpdate su = new SchemaUpdate();
	        su.setHaltOnError(false);
	        su.setDelimiter(";");
	        su.setFormat(true);
	        su.execute(EnumSet.of(TargetType.DATABASE), metadata);
	        System.out.println("....................OK");
	        
	        //Populate through the import.sql
	        if(isNewDatabase) {
        		log.info("### PopulateDatabase " + database);
        		ResourceDatabasePopulator rdp = new ResourceDatabasePopulator();
    	        rdp.addScript(new ClassPathResource("/import.sql"));
    	        rdp.execute((DataSource) dataSourceMap.get(database));
    	        System.out.println("....................OK");
        	}
	        
		}
	}
	
	private boolean isEmptyDatabase(DataSource dataSource) {
		//If there are tables, the database is not new
		//Tested with postgres
		ResultSet resultSet;
		try {
			DatabaseMetaData meta = dataSource.getConnection().getMetaData();
			resultSet = meta.getTables(null, null, null, new String[] {"TABLE"});
			return !resultSet.next();
		}
		catch(Exception e) {
			log.error("Check empty database failed!");
			e.printStackTrace();
			System.exit(0);
		}
		return false;
	}
	
	
}
