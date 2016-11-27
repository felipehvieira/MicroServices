package br.unipe.pos.carros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class Boot
{

   public static void main(String[] args)
   {
      SpringApplication.run(Boot.class, args);
   }
}
