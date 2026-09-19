package hu.dpc.phee.operator.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * The bucket batch files are read from. The deployment sets it as APPLICATION_BUCKET-NAME, an
 * environment variable with a dash in the name.
 */
@ConfigurationProperties(prefix = "application")
public record ApplicationProperties(@DefaultValue("paymenthub-ee") String bucketName) {}
