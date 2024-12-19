package com.spring.mvcproject.chap3_4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //이것은 설정파일이다
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry
                // 요청을 허용할 서버 URL
                .addMapping("/api/v1/*")
                // 요청을 허용할 클라이언트 URL
                .allowedOrigins("http://127.0.0.1:5500")
                // 요청을 허용할 요청방식
                .allowedMethods("GET", "POST")
                .allowedHeaders("*")
                ;
    }
}
