package com.devjsy.easyfind.repository;

import com.devjsy.easyfind.entity.En_save;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Re_save extends JpaRepository<En_save, Integer> {

}
