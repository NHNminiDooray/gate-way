package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.manage.ManageListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.milestone.MileStoneIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import com.nhnacademy.mini_dooray.gateway.service.MileStoneService;
import com.nhnacademy.mini_dooray.gateway.service.TagService;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            //TODO
            //오류
            ManageListResponseDto manageListResponseDto = tagService.manageList(projectId);
            List<TagIndexRequestDto> tags = manageListResponseDto.getTagList();
            List<MileStoneIndexListResponseDto> milestones = manageListResponseDto.getMilestoneList();

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

    @PutMapping("/tag/edit/{tagId}")
    public String editTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId, @RequestParam String newTagName) {
        try {
            tagService.editTag(projectId, tagId, newTagName);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage/tag/edit" + tagId;
        }
    }

    @DeleteMapping("/tag/delete/{tagId}")
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
    public String createMilestone(Model model, @PathVariable Long projectId, @RequestParam String milestoneName, @RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        try {
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
    public String editMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId, @RequestParam String newMilestoneName, @RequestParam
    LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        try {
            mileStoneService.editMileStone(projectId, milestoneId, newMilestoneName, startDate, endDate);
            return "redirect:/projects/" + projectId + "/manage";
        } catch (Exception e) {
            log.error("error :{}", e.getMessage());
            return "redirect:/projects/" + projectId + "/manage/milestone/edit" + milestoneId;
        }
    }

    @PostMapping("/milestone/delete/{milestoneId}")
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

