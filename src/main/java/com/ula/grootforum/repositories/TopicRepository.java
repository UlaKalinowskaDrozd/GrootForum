package com.ula.grootforum.repositories;

import com.ula.grootforum.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Urszula Kalinowska-Drozd on 07.08.17.
 */

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long > {
}
