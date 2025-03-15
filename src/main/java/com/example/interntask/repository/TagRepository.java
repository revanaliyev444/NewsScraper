package com.example.interntask.repository;

import com.example.interntask.model.entity.Tags;
import org.aspectj.apache.bcel.generic.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tags, Long> {
    Tag findByName(String name);

}
