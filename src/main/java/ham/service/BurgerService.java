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

	public List<BurgerDTO> burgerList(int type);

	public List<RatingDTO> ratingListType(int type);

	public List<RatingDTO> ratingListSeq(int burgerSeq);

	public List<BurgerDTO> burgerListHome(int type);

	public BurgerDTO burgerView(int burgerSeq);

	public StoreDTO storeGetSeq(int storeSeq);

	public void ratingDelete(int ratingSeq);

}
