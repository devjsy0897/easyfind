package com.devjsy.easyfind.repository;

import com.devjsy.easyfind.entity.En_member;
import com.devjsy.easyfind.entity.En_save;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Re_save extends JpaRepository<En_save, Integer> {
    List<En_save> findByUserId(String id);
}
