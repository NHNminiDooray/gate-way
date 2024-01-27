package com.nhnacademy.mini_dooray.gateway.controller;

import com.nhnacademy.mini_dooray.gateway.service.MileStoneService;
import com.nhnacademy.mini_dooray.gateway.service.TagService;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects/{projectId}/manage")
public class TagMilestoneController {

    private final TagService tagService;
    private final MileStoneService mileStoneService;

    public TagMilestoneController(TagService tagService, MileStoneService mileStoneService) {
        this.tagService = tagService;
        this.mileStoneService = mileStoneService;
    }

//    @GetMapping
//    public String showManagementList(Model model, @PathVariable Long projectId) {
//
//
//
//
//        model.addAttribute("tags", tags);
//        model.addAttribute("milestones", milestones);
//        model.addAttribute("projectId", projectId);
//        return "management";
//    }
    @GetMapping("/tag/edit/{tagId}")
    public String showTagEditForm(Model model, @PathVariable Long projectId, @PathVariable Long tagId) {
        model.addAttribute("tagId", tagId);
        model.addAttribute("projectId", projectId);
        return "tagEditForm";
    }

    @PostMapping("/tag/create")
    public String createTag(Model model, @PathVariable Long projectId, @RequestParam String tagName) {
        tagService.createTag(projectId, tagName);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PutMapping("/tag/edit/{tagId}")
    public String editTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId, @RequestParam String newTagName) {
       tagService.editTag(tagId, newTagName);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @DeleteMapping("/tag/delete/{tagId}")
    public String deleteTag(Model model, @PathVariable Long projectId, @PathVariable Long tagId) {
        tagService.deleteTag(tagId);
        return "redirect:/projects/" + projectId + "/manage";
    }

    @GetMapping("/milestone/edit/{milestoneId}")
    public String showMilestoneEditForm(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId) {
        model.addAttribute("milestoneId", milestoneId);
        model.addAttribute("projectId", projectId);
        return "milestoneEditForm";
    }

    @PostMapping("/milestone/create")
    public String createMilestone(Model model, @PathVariable Long projectId, @RequestParam String milestoneName, @RequestParam
    LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        mileStoneService.createMilestone(projectId, milestoneName, startDate, endDate);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PutMapping("/milestone/edit/{milestoneId}")
    public String editMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId, @RequestParam String newMilestoneName,@RequestParam LocalDateTime startDate, @RequestParam LocalDateTime endDate) {
        mileStoneService.editMileStone(projectId,milestoneId, newMilestoneName,startDate,endDate);
        return "redirect:/projects/" + projectId + "/manage";
    }
    @PostMapping("/milestone/delete/{milestoneId}")
    public String deleteMilestone(Model model, @PathVariable Long projectId, @PathVariable Long milestoneId) {
        mileStoneService.deleteMileStine(projectId,milestoneId);
        return "redirect:/projects/" + projectId + "/manage";
    }
}

