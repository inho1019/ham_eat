package ham.service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

public interface KakaoService {
	
	public Object searchPlaces(String query) throws URISyntaxException, UnsupportedEncodingException;
	
}
