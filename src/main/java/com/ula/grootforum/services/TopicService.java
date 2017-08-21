package com.ula.grootforum.services;

import com.ula.grootforum.model.Post;
import com.ula.grootforum.model.Topic;
import com.ula.grootforum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Urszula Kalinowska-Drozd on 08.08.17.
 */
@Transactional
@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public Topic findTopicById(Long id){ return entityManager.find(Topic.class, id); }

    @Transactional
    public List<Topic> findAllTopics(){
        return topicRepository.findAll();
    }

    @Transactional
    public Topic saveTopic(Topic topic, Post post){

        topic.getPostsList().add(post);
        post.setTopic(topic);
        entityManager.persist(topic);
        return topic;
    }

    @Transactional
    public Topic savePost(Post post, Long topicId){
        Topic thisTopic = entityManager.find(Topic.class, topicId);
        thisTopic.getPostsList().add(post);
        post.setTopic(thisTopic);
        entityManager.merge(thisTopic);
        return thisTopic;
    }

    @Transactional
    public List<Post> findPostsByTopic(Long id) { return topicRepository.findOne(id).getPostsList(); }

    @Transactional
    public void deleteTopic(Long id){
        topicRepository.delete(topicRepository.findOne(id));
    }
}
