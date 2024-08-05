package com.example.demo;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @GetMapping("/welcome")
    public String welcome(){
        return "Xin Chao DTS";
    }

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        factory.setPort(9090);
    }
}
