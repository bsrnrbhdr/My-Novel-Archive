//package com.MNA.MNA.CONTROLLER;
//
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.session.jdbc.config.annotation.SpringSessionDataSource;
//
//import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
//
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//public class DatabaseConfig
//        extends AbstractHttpSessionApplicationInitializer {
//
//    @Bean
//    @Primary
//    @ConfigurationProperties("primary.datasource")
//    public DataSourceProperties primaryDataSourceProperties() {
//        return new DataSourceProperties();
//    }
//
//    @Bean
//    @Primary
//    public DataSource primaryDataSource() {
//        return primaryDataSourceProperties().initializeDataSourceBuilder()
//                .type(HikariDataSource.class).build();
//    }
//
//    @Bean
//    @SpringSessionDataSource
//    public EmbeddedDatabase springSessionDataSource() {
//        return new EmbeddedDatabaseBuilder()
//                .setType(EmbeddedDatabaseType.H2)
//                .addScript("org/springframework/session/jdbc/schema-h2.sql").build();
//    }
////    @Bean
////    @Primary
////    @ConfigurationProperties(prefix="spring.datasource")
////    public DataSource primaryDataSource() {
////        return DataSourceBuilder.create().build();
////    }
////
////    @Bean
////    @ConfigurationProperties(prefix="spring.second.datasource")
////    public DataSource secondaryDataSource() {
////        return DataSourceBuilder.create().build();
////    }
////    @Bean
////    public EmbeddedDatabase dataSource() {
////        return new EmbeddedDatabaseBuilder()
////                .setType(EmbeddedDatabaseType.H2)
////                .addScript("org/springframework/session/jdbc/schema-h2.sql").build();
////    }
////
////    @Bean
////    public PlatformTransactionManager transactionManager(DataSource dataSource) {
////        return new DataSourceTransactionManager(dataSource);
////    }
//
//}