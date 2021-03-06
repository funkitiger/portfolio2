package dhbw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"dhbw"})
public class Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

   @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .pathMapping("/");
    }

   private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpotifySuche")
                .description("Swagger for FrontEnd Team")
                .contact("Florian")
                .version("0.1")
                .build();
    }


}
