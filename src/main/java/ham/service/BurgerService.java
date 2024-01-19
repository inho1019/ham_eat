package ham.service;

import java.util.List;

import ham.bean.HamDTO;
import ham.bean.IngreDTO;
import ham.bean.StoreDTO;

public interface BurgerService {

	public void hamWrite(HamDTO hamDTO);

	public void storeWrite(StoreDTO storeDTO);

	public List<StoreDTO> storeList(int type);

	public void ingreWrite(IngreDTO ingreDTO);

	public List<IngreDTO> ingreList();

}
