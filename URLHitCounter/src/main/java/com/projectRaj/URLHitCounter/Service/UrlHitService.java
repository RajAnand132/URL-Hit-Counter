package com.projectRaj.URLHitCounter.Service;

import com.projectRaj.URLHitCounter.Entity.UrlHitCounter;
import com.projectRaj.URLHitCounter.Repository.UrlHitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlHitService {

    @Autowired
    UrlHitRepo urlHitRepo;

    public List<UrlHitCounter> getAllVisitors()
    {
        return  urlHitRepo.getUrlHitCounter();
    }


    public String addVisitor(UrlHitCounter user) {
        List<UrlHitCounter> visitorlist = getAllVisitors();
        for(UrlHitCounter currentUser : visitorlist)
        {
            if(currentUser.getUserName().equals(user.getUserName()))
            {
                currentUser.setCounter(currentUser.getCounter()+1);
                return "Cannot add the same visitor. Count updated";
            }
        }
        visitorlist.add(user);

        return "Hello🤝 "+user.getUserName()+", Welcome to our Application !!!";
    }


    public String getCountOfVisitors() {

        List<UrlHitCounter> VisitorsList = getAllVisitors();

        return "Visitors: "+VisitorsList.size();
    }


    public UrlHitCounter getAVisitor(String username) {
        List<UrlHitCounter> visitorlist = getAllVisitors();
        for(UrlHitCounter currentUser : visitorlist)
        {
            if(currentUser.getUserName().equals(username))
            {
                return currentUser;

            }
        }
        throw new IllegalStateException("UserName :"+ username +" not found🙁");
    }

    public String countUpdated(String username) {
        List<UrlHitCounter> visitorlist = getAllVisitors();
        for(UrlHitCounter currentUser : visitorlist)
        {
            if(currentUser.getUserName().equals(username))
            {
                currentUser.setCounter(currentUser.getCounter()+1);
                return "Welcome Back🤝 "+username;
            }
        }


        return "User not found new User";
    }
}