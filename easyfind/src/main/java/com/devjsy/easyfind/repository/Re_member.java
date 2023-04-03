package com.devjsy.easyfind.repository;

import com.devjsy.easyfind.entity.En_member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Re_member extends JpaRepository<En_member, Integer> {

}
