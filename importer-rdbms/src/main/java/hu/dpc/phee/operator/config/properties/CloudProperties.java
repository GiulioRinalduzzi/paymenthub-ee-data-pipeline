package hu.dpc.phee.operator.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.boot.context.properties.bind.Name;

/**
 * The object storage batch files are read from.
 *
 * <p>
 * Nothing here is validated. The deployment feeds the credentials and the region from a kubernetes
 * secret, and an empty value there is the deployment's business - a required value would turn a pod
 * that runs today into one that refuses to start.
 * </p>
 *
 * <p>
 * Two names need care. "static" is a Java keyword, so the component is staticRegion and is mapped
 * back with {@link Name}. And the application.yml key s3BaseUrl had to become s3-base-url: a name
 * with a capital letter in the middle is not a valid configuration property name and the binder
 * rejects it outright. The deployment is unaffected, CLOUD_AWS_S3BASEURL matches both spellings.
 * </p>
 */
@ConfigurationProperties(prefix = "cloud")
public record CloudProperties(@DefaultValue Aws aws) {

    public record Aws(@DefaultValue("false") boolean enabled, @DefaultValue Credentials credentials, @DefaultValue Region region,
            @DefaultValue("") String s3BaseUrl) {}

    public record Credentials(@DefaultValue("") String accessKey, @DefaultValue("") String secretKey) {}

    public record Region(@Name("static") @DefaultValue("") String staticRegion) {}
}
