package com.ula.grootforum.services;

import com.ula.grootforum.model.Post;
import com.ula.grootforum.model.Topic;
import com.ula.grootforum.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urszula Kalinowska-Drozd on 07.08.17.
 */

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    //#################################################

    @PersistenceContext
    public EntityManager entityManager;


//    @Transactional
//    public List<Post> findByTopic(Topic thisTopic) {
//        return entityManager.createQuery("select post from Post post where topic = thisTopic").getResultList();
//    }

    //################################################

//    public ArrayList<Post> findByTopic(Topic topic){
//        return new ArrayList<>(postRepository.findByTopic(topic));
//    }
    @Transactional
    public Post findPostById(Long id){ return postRepository.findOne(id); }

//    public Long savePost(Post post, Topic topic){
//        topic.getPostsList().add(post);
//        post.setTopic(topic);
//        postRepository.save(post);
//        return post.getPostId();
//    }

}
