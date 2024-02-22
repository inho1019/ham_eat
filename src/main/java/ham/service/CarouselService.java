package ham.service;

import java.util.List;

import ham.bean.CarouselDTO;

public interface CarouselService {

	void carouselWrite(CarouselDTO carouselDTO);

	List<CarouselDTO> carouselList();

	void carouselDelete(Long carouselSeq);

}
