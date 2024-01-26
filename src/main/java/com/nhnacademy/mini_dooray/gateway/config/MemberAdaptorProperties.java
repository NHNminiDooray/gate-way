package com.nhnacademy.mini_dooray.gateway.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhnacdemy.minidooray.member")
@Data
public class MemberAdaptorProperties {
    String memberUrl;
}
