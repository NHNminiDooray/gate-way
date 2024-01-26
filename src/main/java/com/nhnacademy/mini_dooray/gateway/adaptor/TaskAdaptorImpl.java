package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.mini_dooray.gateway.dto.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.ProjectIndexListResponseDto;
import java.util.List;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TaskAdaptorImpl implements TaskAdaptor {

    private final RestTemplate restTemplate;
    private final TaskAdaptorProperties taskAdaptorProperties;

    public TaskAdaptorImpl(RestTemplate restTemplate, TaskAdaptorProperties taskAdaptorProperties) {
        this.restTemplate = restTemplate;
        this.taskAdaptorProperties = taskAdaptorProperties;
    }

    @Override
    public List<ProjectIndexListResponseDto> getAllProjects(ProjectIndexListRequestDto projectIndexListRequestDto) {
        String url = taskAdaptorProperties.getTaskUrl() + "";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProjectIndexListRequestDto> requestEntity = new HttpEntity<>(projectIndexListRequestDto, headers);

        ResponseEntity<List<ProjectIndexListResponseDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<ProjectIndexListResponseDto>>() {
                });

        return responseEntity.getBody();
    }
}
