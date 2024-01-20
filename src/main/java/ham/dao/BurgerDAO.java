package ham.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ham.bean.BurgerDTO;

@Repository
public interface BurgerDAO extends JpaRepository<BurgerDTO,Integer> {

}
