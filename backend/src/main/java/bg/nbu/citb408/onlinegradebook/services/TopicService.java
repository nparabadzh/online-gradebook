package bg.nbu.citb408.onlinegradebook.services;

import bg.nbu.citb408.onlinegradebook.repositories.TopicRepository;
import bg.nbu.citb408.onlinegradebook.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TopicService {
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
        Topic topicInDB = topicRepository.findById(topic.getId()).orElse(null);
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