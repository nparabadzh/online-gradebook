package com.example.onlinegradebook.services;

import com.example.onlinegradebook.model.Topic;
import com.example.onlinegradebook.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class TopicServices {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> findAll() {
        List<Topic> topics = topicRepository.findAll();
        return topics;
    }

    public void addTopic(@ModelAttribute Topic topic) {
        topicRepository.save(topic);
    }

    public Topic findTopicById(@PathVariable("id") int id) {
        Topic topic = topicRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid topic Id:" + id));
        return topic;
    }

    public void updateTopic(@ModelAttribute Topic topic) throws Exception {
        Topic topicInDB = topicRepository.findById(topic.getID()).orElse(null);
        if (topicInDB != null) {
            topicInDB.setTopic(topic.getTopic());
            topicInDB.setTakingDate(topic.getTakingDate());
            topicInDB.setTaken(topic.isTaken());
            topicRepository.save(topicInDB);
        } else {
            throw new Exception("Topic not found");
        }
    }

    public void deleteTopic(@PathVariable("id") int id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid topic Id:" + id));
        topicRepository.delete(topic);
    }
}