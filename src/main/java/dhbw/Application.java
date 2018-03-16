package dhbw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
//@EnableSwagger2
public class Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

//   @Bean
//    public Docket swaggerSettings() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(apiInfo())
//                .pathMapping("/");
//    }

//   private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("SpotifySuche")
//                .description("Swagger for FrontEnd Team")
//                .contact("Florian")
//                .version("0.1")
//                .build();
//    }


}
