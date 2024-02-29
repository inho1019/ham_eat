package ham.service;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import ham.dao.StatusDAO;
import jakarta.transaction.Transactional;

@Component
public class AutoPing {

	@Autowired
	private StatusDAO statusDAO;
	
	@Scheduled(fixedRate = 300000) // 5분마다 실행
    public void autoPing() throws URISyntaxException {
        String url = "https://hameat.onrender.com/ping";//https://port-0-ham-eat-3wh3o2blr4s3qj5.sel5.cloudtype.app/
        ResponseEntity<Void> responseEntity = new RestTemplate().getForEntity(url, Void.class);
        System.out.println(responseEntity);
    }
	
	@Scheduled(cron = "0 0 0 * * *")
	@Transactional
	public void statusControll() {
		LocalDateTime thirtyDaysAgo = LocalDateTime.now().minus(30, ChronoUnit.DAYS);
	    statusDAO.deleteAllByTypeAndLogTimeBefore(0, thirtyDaysAgo);
	}
}
