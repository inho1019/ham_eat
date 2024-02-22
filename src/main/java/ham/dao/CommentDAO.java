package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.CommentDTO;

@Repository
public interface CommentDAO extends JpaRepository<CommentDTO,Long> {

	@Query("SELECT c, u FROM CommentDTO c LEFT JOIN UserDTO u ON c.userSeq = u.userSeq WHERE c.boardSeq = :boardSeq")
	List<Object> selectSeqJoin(@Param("boardSeq")long boardSeq);

}