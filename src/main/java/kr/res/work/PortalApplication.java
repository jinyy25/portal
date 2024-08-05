package kr.res.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@ComponentScan("egovframework.*")
@EnableFeignClients
@EnableEurekaClient
public class PortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public WebClient.Builder webClient() {
//        return WebClient.builder();
//    }

}
