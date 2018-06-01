package com.zhangling.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
@ComponentScan
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    //nginx
    /*brew install nginx
    *cd /usr/local/etc/nginx
    *vim nginx.config
    *upstream  key1
{
    server   10.0.1.50:8080;
    server   10.0.1.51:8080;
}

upstream  key2
{
    server   10.0.1.50:8080;
    server   10.0.1.51:8080;
}

    *location / {
        proxy_pass        key1;
        }
    *
    *pkill -9 nginx  杀进程
    *brew services start nginx 启动nginx
    *
    * */

}
