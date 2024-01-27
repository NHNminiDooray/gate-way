package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.dto.milestone.MileStoneIndexListResponseDto;
import com.nhnacademy.mini_dooray.gateway.dto.tag.TagIndexRequestDto;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/{projectId}/manage")
public class TagMilestoneController {

    @GetMapping
    public String showTagList(Model model, @PathVariable Long projectId) {

        List<TagIndexRequestDto> tags = List.of(
                new TagIndexRequestDto(1L, "qwe"),
                new TagIndexRequestDto(2L, "rty"));
        List<MileStoneIndexListResponseDto> milestones = List.of(
                new MileStoneIndexListResponseDto(1L,"qwe", LocalDateTime.now(),LocalDateTime.now()),
                new MileStoneIndexListResponseDto(2L,"asd", LocalDateTime.now(),LocalDateTime.now())
        );
        model.addAttribute("tags", tags);
        model.addAttribute("milestones", milestones);
        model.addAttribute("projectId", projectId);
        return "management";
    }
    @GetMapping("/tag/edit/{tagId}")
    public String showTagEditForm(Model model, @PathVariable Long projectId, @PathVariable Long tagId) {
//        TagDto tag = tagService.getTag(tagId);
//        model.addAttribute("tag", tag);
//        model.addAttribute("projectId", projectId);
        return "tagEditForm";
    }
    @PutMapping("/tag/edit/{tagId}")
    public String editTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId, @RequestParam String newTagName) {
//        tagService.editTag(tagId, newTagName);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PostMapping("/tag/delete/{tagId}")
    public String deleteTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId) {
//        tagService.deleteTag(tagId);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PostMapping("/tag/create")
    public String createTag(Model model, @PathVariable Long projectId, @RequestParam String tagName) {
//        tagService.createTag(projectId, tagName);
        return "redirect:/projects/" + projectId + "/manage";
    }

    @GetMapping("/milestone/edit/{milestoneId}")
    public String showMilestoneEditForm(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId) {
//        MilestoneDto milestone = milestoneService.getMilestone(milestoneId);
//        model.addAttribute("milestone", milestone);
//        model.addAttribute("projectId", projectId);
        return "milestoneEditForm";
    }
    @PutMapping("/milestone/edit/{milestoneId}")
    public String editMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId, @RequestParam String newMilestoneName) {
//        milestoneService.editMilestone(milestoneId, newMilestoneName);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PostMapping("/milestone/delete/{milestoneId}")
    public String deleteMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId) {
//        milestoneService.deleteMilestone(milestoneId);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PostMapping("/milestone/create")
    public String createMilestone(Model model, @PathVariable Long projectId, @RequestParam String milestoneName, @RequestParam String startDate, @RequestParam String endDate) {
//        milestoneService.createMilestone(projectId, milestoneName, startDate, endDate);
        return "redirect:/projects/" + projectId + "/manage";
    }
}

