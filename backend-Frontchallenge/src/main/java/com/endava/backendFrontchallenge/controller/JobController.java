package com.endava.backendFrontchallenge.controller;

import com.endava.backendFrontchallenge.model.Job;
import com.endava.backendFrontchallenge.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs/{id}")
    public List<Job> findById(@PathVariable("id") String id) {
        return jobService.findJobGivenUserId(id);
    }

    @GetMapping("/jobs/delete/{id}")
    public void deleteById(@PathVariable("id") String id) {
        jobService.deleteJobsGivenId(id);
    }

    @PostMapping("/save/jobs")
    public Job saveJob(@RequestBody Job job) {
        return jobService.saveJob(job);
    }
}
