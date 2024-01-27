package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.config.MemberAdaptorProperties;
import com.nhnacademy.mini_dooray.gateway.dto.member.CreateMemberDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.LoginRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.member.MemberIdsDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import org.springframework.http.*;
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
    public void createMember(CreateMemberDto createMemberDto) {
        String url = memberAdaptorProperties.getMemberUrl() + "/members/create";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CreateMemberDto> requestEntity = new HttpEntity<>(createMemberDto, headers);

        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }

    @Override
    public void loginMember(LoginRequestDto loginRequestDto) {
        String url = memberAdaptorProperties.getMemberUrl() + "/members/login";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginRequestDto> requestEntity = new HttpEntity<>(loginRequestDto, headers);

        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }

    @Override
    public MemberIdsDto getAllMembers() {
        String url = memberAdaptorProperties.getMemberUrl() + "/members";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<MemberIdsDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                MemberIdsDto.class);
        return responseEntity.getBody();
    }
}

