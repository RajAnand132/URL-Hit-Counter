package com.projectRaj.URLHitCounter.Controller;

import com.projectRaj.URLHitCounter.Entity.UrlHitCounter;
import com.projectRaj.URLHitCounter.Service.UrlHitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UrlHitController {

    @Autowired
    private UrlHitService urlHitService;

    @PostMapping("visitor")
    public String addAVisitor(@RequestBody UrlHitCounter user)
    {
        return urlHitService.addVisitor(user);
    }

    @GetMapping("visitors") //get all Visitors
    public List<UrlHitCounter> getAllVisitors()
    {
        return urlHitService.getAllVisitors();
    }

    @GetMapping("visitor/count") //Visitor Count
    public String getTheNumberOfVisitors()
    {
        return urlHitService.getCountOfVisitors();
    }

    @GetMapping("api/visitor/count/app/username/{username}") //get specific user
    public UrlHitCounter getAVisitor(@PathVariable String username)
    {
        return urlHitService.getAVisitor(username);
    }
    @PutMapping("api/count/update/username/{username}")
    public String countUpdated(@PathVariable  String username)
    {
        return urlHitService.countUpdated(username);
    }
}
