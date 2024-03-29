package ham.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.BoardDTO;

@Repository
public interface BoardDAO extends JpaRepository<BoardDTO,Long> {
	
	@Query("SELECT b, u, COUNT(c) FROM BoardDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq LEFT JOIN CommentDTO c ON b.boardSeq = c.boardSeq WHERE b.type = :type GROUP BY b, u ORDER BY b.boardSeq DESC")
	List<Object> selectTypeJoin(int type);

	@Query("SELECT b, u FROM BoardDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq WHERE b.boardSeq = :boardSeq")
	Object oneSeqJoin(@Param("boardSeq") long boardSeq);

	List<BoardDTO> findFirst3ByTypeOrderByBoardSeqDesc(@Param("type") int type);

	@Query("SELECT b FROM BoardDTO b WHERE b.type = :type AND b.logTime >= :setMonth")
	List<BoardDTO> getListTypeMonth(@Param("type") int type, @Param("setMonth") LocalDateTime setMonth);

	@Query("SELECT b, u, COUNT(c) FROM BoardDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq LEFT JOIN CommentDTO c ON b.boardSeq = c.boardSeq GROUP BY b, u ORDER BY b.boardSeq DESC")
	List<Object> selectAllJoin();
}