package ham.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.VariDTO;

@Repository
public interface VariDAO extends JpaRepository<VariDTO,Long>  {

	Optional<VariDTO> findByName(@Param("name") String name);

}