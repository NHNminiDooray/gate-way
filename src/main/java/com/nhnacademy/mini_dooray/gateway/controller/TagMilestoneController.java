package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MileStoneIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import com.nhnacademy.mini_dooray.gateway.service.MileStoneService;
import com.nhnacademy.mini_dooray.gateway.service.TagService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.NestedServletException;

@Controller
@RequestMapping("/projects/{projectId}/manage")
@Slf4j
public class TagMilestoneController {

    private final TagService tagService;
    private final MileStoneService mileStoneService;

    public TagMilestoneController(TagService tagService, MileStoneService mileStoneService) {
        this.tagService = tagService;
        this.mileStoneService = mileStoneService;
    }

    @GetMapping
    public String showManagementList(Model model, @PathVariable Long projectId) {
        try {
            ManageListResponseDto manageListResponseDto = tagService.manageList(projectId);
            List<TagIndexRequestDto> tags = manageListResponseDto.getTagList();
            List<MileStoneIndexListResponseDto> milestones = manageListResponseDto.getMilestoneList();
            log.info("milestones: {}", milestones);
            model.addAttribute("tags", tags);
            model.addAttribute("milestones", milestones);
            model.addAttribute("projectId", projectId);
            return "management";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/tasks";
        }
    }

    @PostMapping("/tag/create")
    public String createTag(Model model, @PathVariable Long projectId, @RequestParam String tagName) {
        try {
            //TODO
            //오류
            tagService.createTag(projectId, tagName);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage";
        }
    }

    @GetMapping("/tag/edit/{tagId}")
    public String showTagEditForm(Model model, @PathVariable Long projectId, @PathVariable Long tagId) {
        model.addAttribute("tagId", tagId);
        model.addAttribute("projectId", projectId);
        return "tagEditForm";
    }

    @PostMapping("/tag/edit/{tagId}")
    public String editTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId, @RequestParam String newTagName) {
        try {
            tagService.editTag(projectId, tagId, newTagName);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage/tag/edit/" + tagId;
        }
    }

    @PostMapping("/tag/delete/{tagId}")
    public String deleteTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId) {
        try {
            tagService.deleteTag(projectId, tagId);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage";
        }
    }

    @PostMapping("/milestone/create")
    public String createMilestone(Model model,
                                  @PathVariable Long projectId,
                                  @RequestParam String milestoneName,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startPeriod,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endPeriod) {
        try {
            LocalDateTime startDate = startPeriod.atStartOfDay();
            LocalDateTime endDate = endPeriod.atStartOfDay().plusHours(23).plusMinutes(59).plusSeconds(59);

            mileStoneService.createMilestone(projectId, milestoneName, startDate, endDate);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage";
        }
    }


    @GetMapping("/milestone/edit/{milestoneId}")
    public String showMilestoneEditForm(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId) {
        model.addAttribute("milestoneId", milestoneId);
        model.addAttribute("projectId", projectId);
        return "milestoneEditForm";
    }

    @PostMapping("/milestone/edit/{milestoneId}")
    public String editMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId,
                                @RequestParam String newMilestoneName,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startPeriod,
                                @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endPeriod) {
        try {
            LocalDateTime startDate = startPeriod.atStartOfDay();
            LocalDateTime endDate = endPeriod.atStartOfDay().plusHours(23).plusMinutes(59).plusSeconds(59);

            mileStoneService.editMileStone(projectId, milestoneId, newMilestoneName, startDate, endDate);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage/milestone/edit/" + milestoneId;
        }
    }

    @PostMapping ("/milestone/delete/{milestoneId}")
    public String deleteMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId) {
        try {
            mileStoneService.deleteMileStone(projectId, milestoneId);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage";
        }
    }
}

