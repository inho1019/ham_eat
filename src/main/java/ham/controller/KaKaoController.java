package ham.controller;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ham.service.KakaoService;

@RestController
public class KaKaoController {
	
	@Autowired
	private KakaoService kakaoService;
	
	@GetMapping("map/search")
	public Object search(@RequestParam("search") String search ) throws URISyntaxException {
		return kakaoService.searchPlaces(search);
	}
}
