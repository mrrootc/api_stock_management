package com.abdoulaye.gestionstock.config;

import java.util.Collections;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Abdoulaye Camara",
                        email = "camaraabdoulayeroo@gmail.com",
                        url = "https://mywebsite.com"
                ),
                description = "Une application de gestion de stock," +
                        "La gestion de stock est un processus essentiel pour les entreprises " +
                        "qui ont des produits physiques à gérer, que ce soit des biens" +
                        "matériels, des pièces détachées, des produits finis ou tout autre " +
                        "type d'inventaire. Cela consiste à suivre et à contrôler les niveaux" +
                        "de stock disponibles, à enregistrer les mouvements d'entrée et de sortie," +
                        "à gérer les réapprovisionnements, et à optimiser l'utilisation des" +
                        "ressources et des espaces de stockage",
                title = "OpenAPI documentation GESTION DE STOCK API REST",
                version = "1.0",
                license = @License(
                        name = "MIT licence",
                        url = "https//url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfiguration {
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(
//                        new ApiInfoBuilder()
//                                .description("La gestion de stock est un processus essentiel pour les entreprises " +
//                                        "qui ont des produits physiques à gérer, que ce soit des biens" +
//                                        " matériels, des pièces détachées, des produits finis ou tout autre " +
//                                        "type d'inventaire. Cela consiste à suivre et à contrôler les niveaux" +
//                                        " de stock disponibles, à enregistrer les mouvements d'entrée et de sortie," +
//                                        " à gérer les réapprovisionnements, et à optimiser l'utilisation des " +
//                                        "ressources et des espaces de stockage.")
//                                .title("Gestion de stock API REST")
//                                .build()
//                )
//                .groupName("GESTION DE STOCK API REST V1")
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.abdoulaye.gestionstock"))
//                .paths(PathSelectors.any())
//                .build();
//    }
}
