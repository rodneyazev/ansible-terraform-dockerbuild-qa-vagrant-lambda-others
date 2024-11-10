package br.com.caelum.clines.shared.configurations;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpMethod;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Getter
@Setter
@ConfigurationProperties(prefix = "cors.allowed")
public class CorsConfigurationProperties {
    private static final List<String> PERMIT_ALL = List.of("*");

    private List<String> origins = List.of();
    private List<String> headers = List.of();
    private List<HttpMethod> methods = List.of(HttpMethod.HEAD, HttpMethod.GET);
    private boolean sendCredentials;
    private boolean allMethods;
    private boolean allHeaders;

    public String[] getOrigins() {
        return origins.toArray(String[]::new);
    }

    public String[] getHeaders() {
        return buildHeaderStream().toArray(String[]::new);
    }

    private Stream<String> buildHeaderStream() {
        if (allHeaders) {
            return PERMIT_ALL.stream();
        }

        return headers.stream();
    }

    public String[] getMethods() {
        return buildMethodStream().map(HttpMethod::name).toArray(String[]::new);
    }

    private Stream<HttpMethod> buildMethodStream() {
        if (allMethods) {
            return Arrays.stream(HttpMethod.values());
        }
        return methods.stream();
    }
}
