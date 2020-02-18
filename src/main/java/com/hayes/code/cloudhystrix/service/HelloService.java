package com.hayes.code.cloudhystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate ;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        String url = "http://HELLO-SERVICE/hello" ;
        return restTemplate.getForObject(url , String.class) ;
    }

    public String helloFallback(){

        return "error" ;
    }


}
