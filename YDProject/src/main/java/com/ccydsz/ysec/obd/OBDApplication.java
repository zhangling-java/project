package com.ccydsz.ysec.obd;

import com.ccydsz.ysec.obd.util.RSAUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Map;

@SpringBootApplication
@ServletComponentScan //注意别忘了   过滤器和监听器需要
public class OBDApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
//        Map<String, String> keyMap = RSAUtils.createKeys(1024);
//        String  publicKey = keyMap.get(RSAUtils.publicKeyTag);
//        String  privateKey = keyMap.get(RSAUtils.privateKeyTag);
//
//        System.out.println("公钥: \n\r" + publicKey);
//        System.out.println("私钥： \n\r" + privateKey);
        SpringApplication.run(OBDApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(OBDApplication.class);
    }
}
