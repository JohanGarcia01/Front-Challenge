package com.endava.backendFrontchallenge.repository;

import com.endava.backendFrontchallenge.model.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends MongoRepository<Job, String> {
    @Query(value = "{ _idUser: ?0} ")
    List<Job> findByUserId(String id);
}