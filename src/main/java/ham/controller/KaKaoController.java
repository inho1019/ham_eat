package ham.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.service.KakaoService;
import lombok.Getter;
import lombok.Setter;

@RestController
public class KaKaoController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@Getter
	@Setter
	public static class SearchDTO {
		private String search;
    }
	
	@PostMapping("map/search")
	public Object search(@RequestBody SearchDTO searchDTO) throws URISyntaxException, UnsupportedEncodingException {
		String search = searchDTO.getSearch();
		return kakaoService.searchPlaces(search);
	}
}
