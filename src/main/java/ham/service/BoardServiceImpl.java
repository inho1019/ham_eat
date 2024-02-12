package ham.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ham.bean.BoardDTO;
import ham.bean.BurgerDTO;
import ham.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardDTO getRandomElement(List<BoardDTO> list) {
	    if (list.isEmpty()) {
	        return null; // 빈 리스트인 경우 null 또는 예외 처리
	    }

	    Random random = new Random();
	    return list.get(random.nextInt(list.size()));
	}
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void boardWrite(BoardDTO boardDTO) {
		boardDAO.save(boardDTO);
	}

	@Override
	public List<Object> boardList(int type) {
		return boardDAO.selectTypeJoin(type);
	}

	@Override
	public Object boardView(long boardSeq) {
		Optional<BoardDTO> opDTO = boardDAO.findById(boardSeq);
		
		opDTO.ifPresent(dto -> {
			dto.setHit(dto.getHit() + 1);
			
	        boardDAO.save(dto);
	    });
		return boardDAO.oneSeqJoin(boardSeq);
	}

	@Override
	public void boardUpdate(BoardDTO boardDTO) {
		Optional<BoardDTO> opDTO = boardDAO.findById(boardDTO.getBoardSeq());
		
		opDTO.ifPresent(dto -> {
			dto.setTitle(boardDTO.getTitle());
			dto.setContent(boardDTO.getContent());
			
	        boardDAO.save(dto);
	    });
	}

	@Override
	public void boardDelete(long boardSeq) {
		boardDAO.deleteById(boardSeq);
	}

	@Override
	public void boardFav(BoardDTO boardDTO) {
		Optional<BoardDTO> opDTO = boardDAO.findById(boardDTO.getBoardSeq());
		
		opDTO.ifPresent(dto -> {
			dto.setFav(boardDTO.getFav());
			
	        boardDAO.save(dto);
	    });
	}

	@Override
	public List<BoardDTO> boardListHome(int type) {
		return boardDAO.findFirst3ByTypeOrderByBoardSeqDesc(type);
	}

	@Override
	public BoardDTO boardBest(int type) {
		LocalDateTime setMonth = LocalDateTime.now().minusDays(30);
		
		List<BoardDTO> boardList = boardDAO.getListTypeMonth(type,setMonth);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		boardList.sort((board1, board2) -> {
		    try {
		        int length1 = objectMapper.writeValueAsString(board1.getFav()).length();
		        int length2 = objectMapper.writeValueAsString(board2.getFav()).length();

		        return Integer.compare(length1, length2);
		    } catch (JsonProcessingException e) {
		        e.printStackTrace();
		        return 0;
		    }
		});
		
		boardList.sort(Comparator.comparing(board -> {
		    try {
		        return objectMapper.writeValueAsString(board.getFav()).length();
		    } catch (JsonProcessingException e) {
		        e.printStackTrace();
		        return 0;
		    }
		}, Comparator.reverseOrder()));
		
		return getRandomElement(boardList.subList(0, Math.min(5, boardList.size())));
	}

}
