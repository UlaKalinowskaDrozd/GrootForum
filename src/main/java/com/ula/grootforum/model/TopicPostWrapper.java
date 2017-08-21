package com.ula.grootforum.model;

import org.springframework.stereotype.Component;

/**
 * Created by Urszula Kalinowska-Drozd on 15.08.17.
 */

@Component
public class TopicPostWrapper {

    private Topic topic;
    private Post post;

    public TopicPostWrapper(){}

    public TopicPostWrapper(Topic topic, Post post){
        this.topic = topic;
        this.post = post;
    }

    public void setTopic(Topic topic) { this.topic = topic; }

    public void setPost(Post post) { this.post = post; }

    public Topic getTopic() { return topic; }

    public Post getPost() { return post; }

}
