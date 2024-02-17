package ham.service;
import java.net.URISyntaxException;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AutoPing {

	@Scheduled(fixedRate = 300000) // 5분마다 실행
    public void autoPing() throws URISyntaxException {
        String url = "https://hameat.onrender.com/ping";
        ResponseEntity<Void> responseEntity = new RestTemplate().getForEntity(url, Void.class);
        System.out.println(responseEntity);
    }
}
