package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.BoardDTO;

@Repository
public interface BoardDAO extends JpaRepository<BoardDTO,Long> {
	
	@Query("SELECT b, u FROM BoardDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq WHERE b.type = :type ORDER BY b.boardSeq DESC")
	List<Object> selectTypeJoin(int type);

	@Query("SELECT b, u FROM BoardDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq WHERE b.boardSeq = :boardSeq")
	Object oneSeqJoin(@Param("boardSeq") long boardSeq);
}
