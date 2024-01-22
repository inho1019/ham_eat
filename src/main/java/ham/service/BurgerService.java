package ham.service;

import java.util.List;

import ham.bean.BurgerDTO;
import ham.bean.IngreDTO;
import ham.bean.RatingDTO;
import ham.bean.StoreDTO;

public interface BurgerService {

	public void burgerWrite(BurgerDTO burgerDTO);

	public void storeWrite(StoreDTO storeDTO);

	public List<StoreDTO> storeList(int type);

	public void ingreWrite(IngreDTO ingreDTO);

	public List<IngreDTO> ingreList();

	public void ratingWrite(RatingDTO ratingDTO);

}
