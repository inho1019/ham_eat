package ham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.BurgerDTO;
import ham.bean.IngreDTO;
import ham.bean.RatingDTO;
import ham.bean.StoreDTO;
import ham.service.BurgerService;

@RestController
public class BurgerController {
	
	@Autowired
	private BurgerService burgerService;
	
	@PostMapping(value="burger/write")
	public BurgerDTO burgerWrite(@RequestBody BurgerDTO burgerDTO) {
		burgerService.burgerWrite(burgerDTO);
		return burgerDTO;
	}
	
	@PostMapping(value="store/write")
	public StoreDTO storeWrite(@RequestBody StoreDTO storeDTO) {
		burgerService.storeWrite(storeDTO);
		return storeDTO;
	}
	
	@PostMapping(value="rating/write")
	public void ratingWrite(@RequestBody RatingDTO ratingDTO) {
		System.out.println(ratingDTO.getUser());
		burgerService.ratingWrite(ratingDTO);
	}
	
	@PostMapping(value="ingre/write")
	public IngreDTO ingreWrite(@RequestBody IngreDTO ingreDTO) {
		burgerService.ingreWrite(ingreDTO);
		return ingreDTO;
	}
	
	@GetMapping(value="store/list/{type}")
	public List<StoreDTO> storeList(@PathVariable int type) {
		return burgerService.storeList(type);
	}
	
	@GetMapping(value="ingre/list")
	public List<IngreDTO> ingreList() {
		return burgerService.ingreList();
	}
	
	@GetMapping(value="burger/list/{type}")
	public List<BurgerDTO> burgerList(@PathVariable int type) {
		return burgerService.burgerList(type);
	}
	
	@GetMapping(value="burger/listHome/{type}")
	public List<BurgerDTO> burgerListHome(@PathVariable int type) {
		return burgerService.burgerListHome(type);
	}
	
	@GetMapping(value="rating/listType/{type}")
	public List<RatingDTO> ratingListType(@PathVariable int type) {
		return burgerService.ratingListType(type);
	}
	
	@GetMapping(value="rating/listSeq/{burgerSeq}")
	public List<RatingDTO> ratingListSeq(@PathVariable int burgerSeq) {
		return burgerService.ratingListSeq(burgerSeq);
	}
	
	@GetMapping(value="burger/view/{burgerSeq}")
	public BurgerDTO burgerView(@PathVariable int burgerSeq) {
		return burgerService.burgerView(burgerSeq);
	}
	
	@GetMapping(value="store/getSeq/{storeSeq}")
	public StoreDTO storeGetSeq(@PathVariable int storeSeq) {
		return burgerService.storeGetSeq(storeSeq);
	}
	
	@DeleteMapping(value="rating/delete/{ratingSeq}")
	public void ratingDelete(@PathVariable int ratingSeq) {
		burgerService.ratingDelete(ratingSeq);
	}
}
