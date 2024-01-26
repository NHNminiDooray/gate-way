package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.config.MemberAdaptorProperties;
import com.nhnacademy.mini_dooray.gateway.domain.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.domain.LoginRequestDto;
import java.lang.reflect.Member;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public LoginRequestDto getMember(String id) {
        String url = memberAdaptorProperties.getMemberUrl() + "/members/{id}";

        ResponseEntity<LoginRequestDto> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                LoginRequestDto.class,
                id);

        if (response.getStatusCode() != HttpStatus.OK) {
            throw new RuntimeException("Fail" + id);
        }

        return response.getBody();
    }

    @Override
    public void createMember(CreateMemberDto createMemberDto) {
        String url = memberAdaptorProperties.getMemberUrl() + "/members/create";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateMemberDto> requestEntity = new HttpEntity<>(createMemberDto, headers);

        ResponseEntity<Void> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }
}
