package br.com.pix.query_dict_api.infra;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Minha API de Exemplo")
                        .version("1.0.0")
                        .description("Documentação da API de Exemplo para um projeto Spring Boot.")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("André Ricardo da Silva Melo")
                                .url("https://github.com/andrericardofmelo")
                                .email("andrericardofmelo@gmail.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html")));
    }
}
