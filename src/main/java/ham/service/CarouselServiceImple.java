package ham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ham.bean.CarouselDTO;
import ham.dao.CarouselDAO;

@Service
public class CarouselServiceImple implements CarouselService {
	
	@Autowired
	private CarouselDAO carouselDAO;
	
	@Override
	public void carouselWrite(CarouselDTO carouselDTO) {
		carouselDAO.save(carouselDTO);
	}

	@Override
	public List<CarouselDTO> carouselList() {
		return carouselDAO.findAll(Sort.by(Sort.Direction.DESC, "logTime"));
	}

	@Override
	public void carouselDelete(Long carouselSeq) {
		carouselDAO.deleteById(carouselSeq);
	}

}
