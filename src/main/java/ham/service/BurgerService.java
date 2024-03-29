package ham.service;

import java.util.List;

import ham.bean.BurgerDTO;
import ham.bean.IngreDTO;
import ham.bean.RatingDTO;
import ham.bean.StatusDTO;
import ham.bean.StoreDTO;

public interface BurgerService {

	public void burgerWrite(BurgerDTO burgerDTO);

	public void storeWrite(StoreDTO storeDTO);

	public List<StoreDTO> storeList(int type);

	public void ingreWrite(IngreDTO ingreDTO);

	public List<IngreDTO> ingreList();

	public void ratingWrite(RatingDTO ratingDTO);

	public List<Object> burgerList(int type);

	public List<Object> ratingListType(int type);

	public List<Object> ratingListSeq(long burgerSeq);

	public List<BurgerDTO> burgerListHome(int type);

	public Object burgerView(long burgerSeq);

	public StoreDTO storeGetSeq(long storeSeq);

	public void ratingDelete(long ratingSeq);

	public boolean storeCheck(String placeId);

	public List<Object> burgerListAll();

	public List<StoreDTO> storeListAll();

	public List<RatingDTO> ratingListAll();

	public List<RatingDTO> ratingListNew();

	public int statusWrite(StatusDTO statusDTO);

	public void burgerStatus(long burgerSeq);

	public List<StatusDTO> statusList(long burgerSeq);

	public void statusDelete(long statusSeq);

	public void burgerDelete(long burgerSeq);

	public void burgerUpdate(BurgerDTO burgerDTO);

	public void ratingUpdateType(BurgerDTO burgerDTO);

	public BurgerDTO burgerRandom();

}
