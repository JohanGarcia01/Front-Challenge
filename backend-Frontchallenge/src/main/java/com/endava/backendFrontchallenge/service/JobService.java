package com.endava.backendFrontchallenge.service;

import com.endava.backendFrontchallenge.model.Job;
import com.endava.backendFrontchallenge.repository.JobRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> findJobGivenUserId(String id){
        return jobRepository.findAll().stream()
                .filter(j -> j.get_idUser().equalsIgnoreCase(id))
                .collect(Collectors.toList());
    }

    public void deleteJobsGivenId( String id ){
        List<Job> jobsToBeDeleted = jobRepository.findByUserId(id);
        jobsToBeDeleted.forEach(job -> jobRepository.delete(job));
    }

    public Job saveJob(Job job){
        job.set_id(String.valueOf(Math.random()));
        return jobRepository.save(job);
    }

}
