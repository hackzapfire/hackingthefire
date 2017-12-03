package com.jstenio.zap_fire.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jstenio.zap_fire.ws.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}


