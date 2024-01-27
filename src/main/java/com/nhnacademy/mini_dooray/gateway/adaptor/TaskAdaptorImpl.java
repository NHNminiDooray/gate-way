package com.nhnacademy.mini_dooray.gateway.adaptor;

import com.nhnacademy.mini_dooray.gateway.config.TaskAdaptorProperties;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MilestoneRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.project.ProjectRegisterRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagRequestDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskDetailResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.task.TaskIndexListResponseDto;
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
        String url = taskAdaptorProperties.getTaskUrl() + "/projects";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProjectIndexListRequestDto> requestEntity = new HttpEntity<>(projectIndexListRequestDto, headers);

        ResponseEntity<List<ProjectIndexListResponseDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<ProjectIndexListResponseDto>>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public void registerProject(ProjectRegisterRequestDto projectRegisterRequestDto) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<ProjectRegisterRequestDto> requestEntity = new HttpEntity<>(projectRegisterRequestDto, headers);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }

    @Override
    public List<TaskIndexListResponseDto> getAllTasks(Long projectId) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{projectId}/tasks";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<List<TaskIndexListResponseDto>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<TaskIndexListResponseDto>>() {
                });

        return responseEntity.getBody();
    }

    @Override
    public TaskDetailResponseDto getTaskDetails(Long projectId, Long taskId) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{projectId}/tasks/{taskId}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<TaskDetailResponseDto> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                requestEntity,
                TaskDetailResponseDto.class);

        return responseEntity.getBody();
    }


    @Override
    public void registerTag(Long projectId,TagRequestDto tagRequestDto) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{projectId}/tags";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TagRequestDto> requestEntity = new HttpEntity<>(tagRequestDto, headers);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }


    @Override
    public void editTag(Long tagId, TagRequestDto tagRequestDto) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{tagId}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TagRequestDto> requestEntity = new HttpEntity<>(tagRequestDto, headers);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                Void.class);
    }

    @Override
    public void deleteTag(Long tagId) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{tagId}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                Void.class);
    }

    @Override
    public void registerMileStone(Long projectId, MilestoneRequestDto milestoneRequestDto) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{projectId}/milestones";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(
                url,
                HttpMethod.POST,
                requestEntity,
                Void.class);
    }

    @Override
    public void editMileStone(Long projectId, Long mileStoneId, MilestoneRequestDto milestoneRequestDto) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{projectId}/milestones/{mileStoneId}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<MilestoneRequestDto> requestEntity = new HttpEntity<>(milestoneRequestDto, headers);
        restTemplate.exchange(
                url,
                HttpMethod.PUT,
                requestEntity,
                Void.class);
    }

    @Override
    public void deleteMileStone(Long projectId, Long mileStoneId) {
        String url = taskAdaptorProperties.getTaskUrl() + "/projects/{projectId}/milestones/{milestoneId}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
        restTemplate.exchange(
                url,
                HttpMethod.DELETE,
                requestEntity,
                Void.class);
    }
}





