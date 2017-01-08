package com.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class NotificationService {

    public void send(){
        // do something
    }

    public void sendAsync(){
        // do something
    }

    @Override
    public String toString() {
        return "Notification comes very soon...";
    }

}
