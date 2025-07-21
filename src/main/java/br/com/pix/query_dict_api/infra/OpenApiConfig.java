package br.com.pix.query_dict_api.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class OpenApiConfig {

    private final String apiTitle;
    private final String apiVersion;
    private final String apiDescription;
    private final String apiTermsOfService;
    private final String apiContactName;
    private final String apiContactUrl;
    private final String apiContactEmail;
    private final String apiLicenseName;
    private final String apiLicenseUrl;

    public OpenApiConfig(
            @Value("${open.api.info.title}") String apiTitle,
            @Value("${open.api.info.version}") String apiVersion,
            @Value("${open.api.info.description}") String apiDescription,
            @Value("${open.api.info.termsOfService}") String apiTermsOfService,
            @Value("${open.api.info.contact.name}") String apiContactName,
            @Value("${open.api.info.contact.url}") String apiContactUrl,
            @Value("${open.api.info.contact.email}") String apiContactEmail,
            @Value("${open.api.info.license.name}") String apiLicenseName,
            @Value("${open.api.info.license.url}") String apiLicenseUrl) {
        this.apiTitle = apiTitle;
        this.apiVersion = apiVersion;
        this.apiDescription = apiDescription;
        this.apiTermsOfService = apiTermsOfService;
        this.apiContactName = apiContactName;
        this.apiContactUrl = apiContactUrl;
        this.apiContactEmail = apiContactEmail;
        this.apiLicenseName = apiLicenseName;
        this.apiLicenseUrl = apiLicenseUrl;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(apiTitle)
                        .version(apiVersion)
                        .description(apiDescription)
                        .termsOfService(apiTermsOfService)
                        .contact(new Contact()
                                .name(apiContactName)
                                .url(apiContactUrl)
                                .email(apiContactEmail))
                        .license(new License()
                                .name(apiLicenseName)
                                .url(apiLicenseUrl)));
    }
}
