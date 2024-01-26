package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.config.MemberAdaptorProperties;
import java.lang.reflect.Member;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MemberAdaptorImpl implements MemberAdaptor {
    private final RestTemplate restTemplate;
    private final MemberAdaptorProperties memberAdaptorProperties;

    public MemberAdaptorImpl(RestTemplate restTemplate, MemberAdaptorProperties memberAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.memberAdaptorProperties = memberAdaptorProperties;
    }
    @Override
    public Member getMember(String id) {
        String url = memberAdaptorProperties.getMemberUrl() + "/members/{id}";

        ResponseEntity<Member> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                Member.class,
                id);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Fail" + id);
        }

        return response.getBody();
    }

}
