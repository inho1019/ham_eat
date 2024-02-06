package ham.service;

import java.net.URISyntaxException;

public interface KakaoService {
	
	public Object searchPlaces(String query) throws URISyntaxException;
	
}
