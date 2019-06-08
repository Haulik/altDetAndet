package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.GoldenCow;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;



@Service
public class UserService {

    private List<GoldenCow> cows;

    public GoldenCow findCow(String username){
        for (GoldenCow cow: cows) {
            if(cow.getName().equals(username)){
                return cow;
            }
        }
        return null;
    }


    @PostConstruct // Java Spring vil kalde denne metode EFTER objektet er belvet indstantieret
    private void initDataForTest(){
        cows = new ArrayList<>();
        GoldenCow goldencow1 = new GoldenCow("Anna",1,2);
        GoldenCow goldencow2 = new GoldenCow("Benny",2,24);
        GoldenCow goldencow3 = new GoldenCow("Charlie",3,32);
        GoldenCow goldencow4 = new GoldenCow("David",4,25);
        cows.add(goldencow1);
        cows.add(goldencow2);
        cows.add(goldencow3);
        cows.add(goldencow4);
        System.out.println(cows);
    }
}
