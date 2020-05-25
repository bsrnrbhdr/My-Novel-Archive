//package com.MNA.MNA.CONTROLLER;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.session.jdbc.config.annotation.web.http.JdbcHttpSessionConfiguration;
//
//import javax.sql.DataSource;
//
//@Configuration
//class SessionConfig extends JdbcHttpSessionConfiguration {
//
//    @Bean
//    public DataSource dataSource() {
//        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
//    }
//
//}