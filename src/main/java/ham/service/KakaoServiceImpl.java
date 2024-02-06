package ham.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoServiceImpl implements KakaoService {

	@Override
	public Object searchPlaces(String query) throws URISyntaxException {
        URI uri = new URI("https://dapi.kakao.com/v2/local/search/keyword.json?query=" + query);
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK 56386d89f0ccd13a7cac988bfddf6879");
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        RequestEntity<Void> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);

        ResponseEntity<Object> responseEntity = new RestTemplate().exchange(
                requestEntity,
                Object.class
        );
        
        return responseEntity;
    }
	

}
