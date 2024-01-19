package ham.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ham.bean.HamDTO;
import ham.bean.IngreDTO;

@Repository
public interface IngreDAO extends JpaRepository<IngreDTO,Integer> {

}
