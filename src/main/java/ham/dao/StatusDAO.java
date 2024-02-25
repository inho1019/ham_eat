package ham.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.StatusDTO;
import jakarta.transaction.Transactional;

@Repository
public interface StatusDAO extends JpaRepository<StatusDTO,Long> {

	Optional<StatusDTO> findByTypeAndBurgerSeqAndUserSeq(@Param("type") int type, 
														 @Param("burgerSeq") long burgerSeq, 
														 @Param("userSeq") long userSeq);

	Optional<StatusDTO> findByTypeAndBurgerSeqAndReq(@Param("type") int type, 
													@Param("burgerSeq") long burgerSeq, 
													@Param("req") long req);

	List<StatusDTO> findAllByTypeAndBurgerSeq(@Param("type") int type, 
											  @Param("burgerSeq") long burgerSeq);

	void deleteAllByTypeAndBurgerSeq(@Param("type") int type, 
									 @Param("burgerSeq") long burgerSeq);

	@Modifying
    @Transactional
	void deleteAllByTypeAndLogTimeBefore(@Param("type") int type, LocalDateTime thirtyDaysAgo);
}
