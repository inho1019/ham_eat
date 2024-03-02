package ham.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.BurgerDTO;
import ham.bean.IngreDTO;
import ham.bean.RatingDTO;
import ham.bean.StatusDTO;
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
		burgerService.ratingWrite(ratingDTO);
	}
	
	@PostMapping(value="ingre/write")
	public IngreDTO ingreWrite(@RequestBody IngreDTO ingreDTO) {
		burgerService.ingreWrite(ingreDTO);
		return ingreDTO;
	}
	
	@GetMapping(value="store/list/{type}")
	public List<StoreDTO> storeList(@PathVariable int type) {
		List<StoreDTO> list = burgerService.storeList(type);
		if(type == 0) Collections.reverse(list);
		return list;
	}
	
	@GetMapping(value="store/listAll")
	public List<StoreDTO> storeListAll() {
		return burgerService.storeListAll();
	}
	
	@GetMapping(value="ingre/list")
	public List<IngreDTO> ingreList() {
		return burgerService.ingreList();
	}
	
	@GetMapping(value="burger/list/{type}")
	public List<Object> burgerList(@PathVariable int type) {
		return burgerService.burgerList(type);
	}
	
	@GetMapping(value="burger/listAll")
	public List<Object> burgerListAll() {
		return burgerService.burgerListAll();
	}
	
	@GetMapping(value="burger/listHome/{type}")
	public List<BurgerDTO> burgerListHome(@PathVariable int type) {
		return burgerService.burgerListHome(type);
	}
	
	@DeleteMapping(value="burger/delete/{burgerSeq}")
	public void burgerDelete(@PathVariable long burgerSeq) {
		burgerService.burgerDelete(burgerSeq);
	}
	
	@GetMapping(value="rating/listAll")
	public List<RatingDTO> ratingListAll() {
		return burgerService.ratingListAll();
	}
	
	@GetMapping(value="rating/listNew")
	public List<RatingDTO> ratingListNew() {
		return burgerService.ratingListNew();
	}
	
	@GetMapping(value="rating/listType/{type}")
	public List<Object> ratingListType(@PathVariable int type) {
		return burgerService.ratingListType(type);
	}
	
	@GetMapping(value="rating/listSeq/{burgerSeq}")
	public List<Object> ratingListSeq(@PathVariable long burgerSeq) {
		return burgerService.ratingListSeq(burgerSeq);
	}
	
	@GetMapping(value="burger/view/{burgerSeq}")
	public Object burgerView(@PathVariable long burgerSeq) {
		return burgerService.burgerView(burgerSeq);
	}
	
	@GetMapping(value="store/getSeq/{storeSeq}")
	public StoreDTO storeGetSeq(@PathVariable long storeSeq) {
		return burgerService.storeGetSeq(storeSeq);
	}
	
	@GetMapping(value="store/check/{placeId}")
	public boolean storeCheck(@PathVariable String placeId) {
		return burgerService.storeCheck(placeId);
	}
	
	@DeleteMapping(value="rating/delete/{ratingSeq}")
	public void ratingDelete(@PathVariable long ratingSeq) {
		burgerService.ratingDelete(ratingSeq);
	}
	
	@PostMapping(value="status/write")
	public int statusWrite(@RequestBody StatusDTO statusDTO) {
		return burgerService.statusWrite(statusDTO);
	}
	
	@DeleteMapping(value="status/delete/{statusSeq}")
	public void statusDelete(@PathVariable long statusSeq) {
		burgerService.statusDelete(statusSeq);
	}
	
	@GetMapping(value="burger/status/{burgerSeq}")
	public void burgerStatus(@PathVariable long burgerSeq) {
		burgerService.burgerStatus(burgerSeq);
	}
	
	@GetMapping(value="status/list/{burgerSeq}")
	public List<StatusDTO> statusList(@PathVariable long burgerSeq) {
		return burgerService.statusList(burgerSeq);
	}
	
	@PutMapping(value="burger/update")
	public void burgerUpdate(@RequestBody BurgerDTO burgerDTO) {
		burgerService.burgerUpdate(burgerDTO);
	}
	
	@PutMapping(value="rating/updateType")
	public void ratingUpdateType(@RequestBody BurgerDTO burgerDTO) {
		burgerService.ratingUpdateType(burgerDTO);
	}
	
	@GetMapping(value="burger/random")
	public BurgerDTO burgerRandom() {
		return burgerService.burgerRandom();
	}
}
