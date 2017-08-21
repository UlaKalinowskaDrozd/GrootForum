package com.ula.grootforum.controllers;

import com.ula.grootforum.model.Post;
import com.ula.grootforum.model.Topic;
import com.ula.grootforum.model.TopicPostWrapper;
import com.ula.grootforum.services.PostService;
import com.ula.grootforum.services.TopicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Urszula Kalinowska-Drozd on 07.08.17.
 */

@Controller
public class ContentController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private PostService postService;

    @RequestMapping(value="/createTopic", method= RequestMethod.GET)
    public String createTopic(Model model){
        model.addAttribute("topicPostWrapper", new TopicPostWrapper());
        return "createTopic";
    }

    @RequestMapping(value="/topicsList", method= RequestMethod.GET)
    public String viewTopics(Model model){
        model.addAttribute("topicsList", topicService.findAllTopics());
        return "topicsList";
    }

    @RequestMapping(value="/topic/{topicId}", method= RequestMethod.GET)
    public String viewTopic(@PathVariable Long topicId, Model model){
        TopicPostWrapper topicPostWrapper = new TopicPostWrapper(topicService.findTopicById(topicId), new Post());
        model.addAttribute("topicPostWrapper", topicPostWrapper);
        return "topic";
    }

    @RequestMapping(value= "/createTopic", method = RequestMethod.POST)
    public String createTopic(@Valid @ModelAttribute("topicPostWrapper") TopicPostWrapper topicPostWrapper, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "/createTopic";
        }
        else{
            Topic topic = topicService.saveTopic(topicPostWrapper.getTopic(), topicPostWrapper.getPost());
            //model.addAttribute("topic", topic);
            return "redirect:/topic/" + topic.getTopicId();
        }
    }

    @RequestMapping(value="/topic/{topicId}", method = RequestMethod.POST)
    public String createPost(@PathVariable Long topicId, @Valid @ModelAttribute("topicPostWrapper") TopicPostWrapper topicPostWrapper, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "redirect:/topic/" + topicId;
        }
        else{
            topicService.savePost(topicPostWrapper.getPost(), topicId);
            return "redirect:/topic/" + topicId;
        }
    }
}
