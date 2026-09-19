package hu.dpc.phee.operator.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * The JDBC pieces every tenant datasource is built from. The per-tenant host, schema and credentials
 * do not live here: they come from tenants.connections, which the deployment mounts as a properties
 * file.
 *
 * <p>
 * driverclass_name keeps its underscore because that is the name in application.yml; relaxed binding
 * matches it to driverclassName, and DeploymentEnvironmentBindingTest pins that down.
 * </p>
 */
@ConfigurationProperties(prefix = "datasource.common")
public record DatasourceCommonProperties(@DefaultValue("jdbc") String protocol,
        @DefaultValue("mysql") String subprotocol,
        @DefaultValue("com.mysql.cj.jdbc.Driver") String driverclassName) {}
