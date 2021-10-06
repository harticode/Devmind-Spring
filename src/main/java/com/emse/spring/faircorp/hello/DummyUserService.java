package com.emse.spring.faircorp.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyUserService implements UserService{
    @Autowired
    private GreetingService g;

    public void setGreetingService(GreetingService g){
        this.g=g;
    }

    public GreetingService GetGreetingService() {
        return this.g;
    }

    @Override
    public void greetAll(){
        List<String> list =new ArrayList<String>();
        list.add("Elodie");
        list.add("Charles");
        for(int i=0; i<list.size(); i++){
            this.g.greet(list.get(i));
        }
    }
}
