package com.ula.grootforum.repositories;

import com.ula.grootforum.model.Post;
import com.ula.grootforum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Urszula Kalinowska-Drozd on 08.08.17.
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long > {
//    @Query("SELECT post FROM Post post WHERE post.topic = ?1")
    List<Post> findByTopic(Topic topic);
}
