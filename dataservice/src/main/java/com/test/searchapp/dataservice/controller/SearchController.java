package com.test.searchapp.dataservice.controller;

import java.util.List;

import com.test.searchapp.dataservice.dbmodel.orm.Topic;
import com.test.searchapp.dataservice.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    TopicRepository topicRepository;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/topics")
    public List<Topic> searchTopics(@RequestParam("searchString") String searchString) {
        return topicRepository.findByDescriptionLikeIgnoreCase("%"+searchString+"%");
        //return topicRepository.findByAttributeContainsText("description", searchString);
    }
}
