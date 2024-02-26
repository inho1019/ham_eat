package ham.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ham.bean.BoardDTO;
import ham.bean.BurgerDTO;
import ham.bean.IngreDTO;
import ham.bean.RatingDTO;
import ham.bean.StatusDTO;
import ham.bean.StoreDTO;
import ham.dao.BurgerDAO;
import ham.dao.IngreDAO;
import ham.dao.RatingDAO;
import ham.dao.StatusDAO;
import ham.dao.StoreDAO;
import jakarta.transaction.Transactional;

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
	@Autowired
	private StatusDAO statusDAO;

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

	@Override
	public List<StoreDTO> storeListAll() {
		return storeDAO.findAll();
	}

	@Override
	public List<RatingDTO> ratingListAll() {
		return ratingDAO.findAll();
	}

	@Override
	public List<RatingDTO> ratingListNew() {
		return ratingDAO.findFirst8ByOrderByRatingSeqDesc();
	}

	@Override
	@Transactional
	public int statusWrite(StatusDTO statusDTO) {
		try {
			if(statusDAO.findByTypeAndBurgerSeqAndUserSeq(
					statusDTO.getType(),statusDTO.getBurgerSeq(),statusDTO.getUserSeq()).isPresent()) {
				return 0;
			} else {
				if(statusDTO.getType() == 0) {
					statusDAO.save(statusDTO);
					return 1;
				}else {
					if(statusDAO.findByTypeAndBurgerSeqAndReq(
							statusDTO.getType(),statusDTO.getBurgerSeq(),statusDTO.getReq()).isPresent()) {	
						
						statusDAO.deleteAllByTypeAndBurgerSeq(statusDTO.getType(),statusDTO.getBurgerSeq());
						
						Optional<BurgerDTO> opDTO = burgerDAO.findById(statusDTO.getBurgerSeq());
						
						opDTO.ifPresent(dto -> {
							dto.setPrice(statusDTO.getReq());	
							burgerDAO.save(dto);
					    });
						
						return 2;
					} else {
						statusDAO.save(statusDTO);
						return 1;
					}
				}
			}
		} catch (Exception e) {
	        System.out.println(e);
	        return -1;
	    }
	}

	@Override
	public void burgerStatus(long burgerSeq) {
		List<StatusDTO> statusList = statusDAO.findAllByTypeAndBurgerSeq(0,burgerSeq);
		int a = 0;
		int b = 0;
		
		for (StatusDTO item : statusList) {
		    if (item.getReq() == 0) {
		        a += 1;
		    } else if (item.getReq() == 1) {
		        b += 1;
		    }
		}
		
		Optional<BurgerDTO> opDTO = burgerDAO.findById(burgerSeq);
		
		if( a >= b ) {
			opDTO.ifPresent(dto -> {
				dto.setStatus(0);
				burgerDAO.save(dto);
		    });
		}else {
			opDTO.ifPresent(dto -> {
				dto.setStatus(1);
				burgerDAO.save(dto);
		    });
		}
	}

	@Override
	public List<StatusDTO> statusList(long burgerSeq) {
		return statusDAO.findAllByTypeAndBurgerSeq(1,burgerSeq);
	}

	@Override
	public void statusDelete(long statusSeq) {
		statusDAO.deleteById(statusSeq);
	}

	@Override
	public void burgerDelete(long burgerSeq) {
		burgerDAO.deleteById(burgerSeq);
	}

	@Override
	public void burgerUpdate(BurgerDTO burgerDTO) {
		burgerDAO.save(burgerDTO);
	}

	@Override
	@Transactional
	public void ratingUpdateType(BurgerDTO burgerDTO) {
		ratingDAO.updateRatingType(burgerDTO.getType(),burgerDTO.getBurgerSeq());
	}
}
