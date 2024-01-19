package ham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ham.bean.HamDTO;
import ham.bean.IngreDTO;
import ham.bean.StoreDTO;
import ham.dao.HamDAO;
import ham.dao.IngreDAO;
import ham.dao.StoreDAO;

@Service
public class BurgerServiceImpl implements BurgerService {
	
	@Autowired
	private HamDAO hamDAO;
	@Autowired
	private StoreDAO storeDAO;
	@Autowired
	private IngreDAO ingreDAO;

	@Override
	public void hamWrite(HamDTO hamDTO) {
		hamDAO.save(hamDTO);
	}

	@Override
	public void storeWrite(StoreDTO storeDTO) {
		storeDAO.save(storeDTO);
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
}
