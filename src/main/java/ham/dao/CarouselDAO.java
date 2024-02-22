package ham.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ham.bean.CarouselDTO;

@Repository
public interface CarouselDAO extends JpaRepository<CarouselDTO,Long> {

}
