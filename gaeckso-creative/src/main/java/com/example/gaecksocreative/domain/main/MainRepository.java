package com.example.gaecksocreative.domain.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainRepository extends JpaRepository<MainEntity, Integer> {

    Optional<MainEntity> findById(Integer integer);
}
