package com.ula.grootforum.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

//    @ManyToOne
//    private User author;


    private LocalDateTime date = LocalDateTime.now();

    @NotEmpty
    private String text;

    public Post(){}

    public Long getPostId() {
        return postId;
    }

    public void setTopic(Topic topic) { this.topic = topic; }

    public Topic getTopic() { return topic; }

//    public void setAuthor(User author) { this.author = author; }
//
//    public User getAuthor() { return author; }

    public void setDate(LocalDateTime date){ this.date = date; }

    public LocalDateTime getDate() { return date; }

    public void setText(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
