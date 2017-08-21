package com.ula.grootforum.repositories;

import com.ula.grootforum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Urszula Kalinowska-Drozd on 06.08.17.
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
}
