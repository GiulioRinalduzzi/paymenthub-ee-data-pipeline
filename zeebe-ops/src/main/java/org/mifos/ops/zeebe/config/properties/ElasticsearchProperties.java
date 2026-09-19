package org.mifos.ops.zeebe.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Where the Elasticsearch the /es routes query lives.
 */
@ConfigurationProperties(prefix = "elasticsearch")
public record ElasticsearchProperties(@DefaultValue("http://localhost:9200/") String url,
        @DefaultValue Security security, @DefaultValue("false") boolean sslVerification, @DefaultValue("") String username,
        @DefaultValue("") String password) {

    public record Security(@DefaultValue("false") boolean enabled) {}
}
