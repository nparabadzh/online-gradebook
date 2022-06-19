package com.example.onlinegradebook.controller;

import com.example.onlinegradebook.model.Topic;
import com.example.onlinegradebook.services.TopicServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicServices topicServices;

    @GetMapping(path = "/topics")
    public String showTopicsPage(Model model) {
        List<Topic> topics = topicServices.findAll();
        model.addAttribute("topics", topics);
        return "topics";
    }

    @GetMapping(path = "/topics/add")
    public String showAddTopicPage(Model model) {
        model.addAttribute("topic", new Topic());
        return "topics-add";
    }

    @PostMapping(path = "/topics/add")
    public String addTopic(@ModelAttribute Topic topic) {
        topicServices.addTopic(topic);
        return "redirect:/topics";
    }

    @GetMapping("/topics/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Topic topic = topicServices.findTopicById(id);
        model.addAttribute("topic", topic);
        return "topics-edit";
    }

    @PostMapping("/topics/edit/{id}")
    public String updateTopic(@ModelAttribute Topic topic) throws Exception {
        topicServices.updateTopic(topic);
        return "redirect:/topics";
    }

    @GetMapping("/topics/delete/{id}")
    public String deleteTopic(@PathVariable("id") int id) {
        topicServices.deleteTopic(id);
        return "redirect:/topics";
    }
}
