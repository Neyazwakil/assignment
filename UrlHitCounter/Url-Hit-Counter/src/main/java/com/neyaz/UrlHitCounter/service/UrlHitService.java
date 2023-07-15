package com.neyaz.UrlHitCounter.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlHitService {
    public Integer hitCount=1;

    HashMap<String, Integer> userHitCounts = new HashMap<>();

    public int incrementHitCount() {
        return hitCount++;
    }

    public void incrementUserHitCount(String username) {
        int userHitCount = userHitCounts.getOrDefault(username, 0);
        userHitCount++;
        userHitCounts.put(username, userHitCount);
        hitCount++;
    }

    public Integer getUserHitCounter(String username) {
        incrementUserHitCount(username);
        return userHitCounts.get(username);

    }

}
