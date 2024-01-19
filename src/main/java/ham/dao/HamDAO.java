package ham.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ham.bean.HamDTO;

@Repository
public interface HamDAO extends JpaRepository<HamDTO,Integer> {

}
