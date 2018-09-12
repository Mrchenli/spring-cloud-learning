package io.mrchenli.springcloud.trace01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Trace01Application {

    private final Logger logger  = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(Trace01Application.class, args);
    }


    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @GetMapping(value = "/trace-1")
    public String trace(){
        logger.info("===call trace-1===");
        return restTemplate().getForEntity("http://trace-02/trace-02",String.class).getBody();
    }




}
