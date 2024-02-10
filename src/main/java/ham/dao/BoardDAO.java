package ham.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ham.bean.BoardDTO;

@Repository
public interface BoardDAO extends JpaRepository<BoardDTO,Long> {

}
