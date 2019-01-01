**[How To Configure Tomcat Connection Pool Via DataSourceBuilder](https://github.com/AnghelLeonard/Hibernate-SpringBoot/tree/master/HibernateSpringBootDataSourceBuilderTomcatKickoff)**

**Description:** This is a kickoff application that set up Tomcat Connection Pool via `DataSourceBuilder`. The `jdbcUrl` is set up for a MySQL database. For testing purpose the application uses an `ExecutorService` for simulating concurrent users. 

**Key points:**\
     - in pom.xml, add the `spring-boot-configuration-processor` dependency\
     - in pom.xml add the Tomcat Connection Pool dependency\
     - in application.properties, configure Tomcat Connection Pool via a custom prefix, e.g., `app.datasource.*`\
     - write a `@Bean` that returns the `DataSource`    