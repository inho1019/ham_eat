package ham.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AutoPing {

    @Scheduled(fixedRate = 300000) // 5분마다 실행
    public void ping() {
        System.out.println("Ping");
    }
}
