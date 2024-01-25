package ham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ham.bean.BurgerDTO;
import ham.bean.IngreDTO;
import ham.bean.RatingDTO;
import ham.bean.StoreDTO;
import ham.dao.BurgerDAO;
import ham.dao.IngreDAO;
import ham.dao.RatingDAO;
import ham.dao.StoreDAO;

@Service
public class BurgerServiceImpl implements BurgerService {
	
	@Autowired
	private BurgerDAO burgerDAO;
	@Autowired
	private StoreDAO storeDAO;
	@Autowired
	private IngreDAO ingreDAO;
	@Autowired
	private RatingDAO ratingDAO;

	@Override
	public void burgerWrite(BurgerDTO burgerDTO) {
		burgerDAO.save(burgerDTO);
	}

	@Override
	public void storeWrite(StoreDTO storeDTO) {
		storeDAO.save(storeDTO);
	}
	
	@Override
	public void ratingWrite(RatingDTO ratingDTO) {
		ratingDAO.save(ratingDTO);
	}

	@Override
	public List<StoreDTO> storeList(int type) {
		return storeDAO.findAllByTypeOrderByStoreSeqDesc(type);
	}

	@Override
	public void ingreWrite(IngreDTO ingreDTO) {
		ingreDAO.save(ingreDTO);
	}

	@Override
	public List<IngreDTO> ingreList() {
		return ingreDAO.findAll();
	}

	@Override
	public List<BurgerDTO> burgerList(int type) {
		return burgerDAO.findAllByTypeOrderByBurgerSeqDesc(type);
	}

	@Override
	public List<RatingDTO> ratingListType(int type) {
		return ratingDAO.findAllByTypeOrderByRatingSeqDesc(type);
	}

	@Override
	public List<RatingDTO> ratingListSeq(int burgerSeq) {
		return ratingDAO.findAllByBurgerSeqOrderByRatingSeqDesc(burgerSeq);
	}

	@Override
	public List<BurgerDTO> burgerListHome(int type) {
		return burgerDAO.findFirst3ByTypeOrderByBurgerSeqDesc(type);
	}

	@Override
	public BurgerDTO burgerView(int burgerSeq) {
		return burgerDAO.findById(burgerSeq).orElse(null);
	}
}
