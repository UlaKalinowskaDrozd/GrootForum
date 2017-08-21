package com.ula.grootforum.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topic_id")
    private Long topicId;

    @Size(min = 3)
    private String topicName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="topic", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("date")
    private List<Post> postsList = new ArrayList<>();

    public Topic(){}

    public Long getTopicId() { return topicId; }

    public void setTopicName(String topicName){
        this.topicName = topicName;
    }

    public String getTopicName() { return topicName; }

    public void setPostsList(List<Post> postsList) { this.postsList = postsList; }

    public List<Post> getPostsList() { return postsList; }
}
