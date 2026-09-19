package org.mifos.ops.zeebe.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * The Zeebe gateway this service talks to. The deployment sets ZEEBE_BROKER_CONTACTPOINT.
 *
 * <p>
 * zeebe.client.evenly-allocated-max-jobs is deliberately not a component here: its value in
 * application.yml is a SpEL expression over the other two, which only @Value evaluates, and nothing
 * in this module reads it.
 * </p>
 */
@ConfigurationProperties(prefix = "zeebe")
public record ZeebeProperties(@DefaultValue Broker broker, @DefaultValue Client client) {

    public record Broker(@DefaultValue("localhost:26500") String contactpoint) {}

    public record Client(@DefaultValue("100") int maxExecutionThreads) {}
}
