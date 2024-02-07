package ham.service;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import ham.controller.KaKaoController.SearchDTO;

public interface KakaoService {
	
	public Object searchPlaces(String query) throws URISyntaxException, UnsupportedEncodingException;

	public Object currentPlaces(SearchDTO searchDTO) throws URISyntaxException, UnsupportedEncodingException;
	
}
