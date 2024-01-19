package ham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.HamDTO;
import ham.bean.IngreDTO;
import ham.bean.StoreDTO;
import ham.service.BurgerService;

@Controller
@RestController
public class BurgerController {
	
	@Autowired
	private BurgerService burgerService;
	
	@PostMapping(value="burger/write")
	public void hamWrite(@RequestBody HamDTO hamDTO) {
		burgerService.hamWrite(hamDTO);
	}
	
	@PostMapping(value="store/write")
	public StoreDTO storeWrite(@RequestBody StoreDTO storeDTO) {
		burgerService.storeWrite(storeDTO);
		return storeDTO;
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
}
