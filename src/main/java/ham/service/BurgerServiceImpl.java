package ham.service;

import java.util.List;
import java.util.Optional;

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
	public List<Object> burgerList(int type) {
		return burgerDAO.selectTypeJoin(type);
	}

	@Override
	public List<Object> ratingListType(int type) {
		return ratingDAO.selTypeJoin(type);
	}

	@Override
	public List<Object> ratingListSeq(long burgerSeq) {
		return ratingDAO.selSeqJoin(burgerSeq);
	}

	@Override
	public List<BurgerDTO> burgerListHome(int type) {
		return burgerDAO.findFirst3ByTypeOrderByBurgerSeqDesc(type);
	}

	@Override
	public Object burgerView(long burgerSeq) {
		return burgerDAO.oneSeqJoin(burgerSeq);
	}

	@Override
	public StoreDTO storeGetSeq(long storeSeq) {
		return storeDAO.findById(storeSeq).orElse(null);
	}

	@Override
	public void ratingDelete(long ratingSeq) {
		ratingDAO.deleteById(ratingSeq);
	}

	@Override
	public boolean storeCheck(String placeId) {
		Optional<StoreDTO> storeDTO = storeDAO.findByPlaceId(placeId);
		
		return storeDTO.isPresent();
	}

	@Override
	public List<Object> burgerListAll() {
		return burgerDAO.selectAllJoin();
	}
}
