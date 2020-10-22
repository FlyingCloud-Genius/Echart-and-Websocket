package org.example.demo.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TimeTask {

    private int addOn = 0;

    @Scheduled(fixedRate = 1000)
    public void printLog() {
        addOn++;
        log.info("love you {} times", addOn);
    }
}
