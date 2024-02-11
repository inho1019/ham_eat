package ham.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ham.bean.BoardDTO;
import ham.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

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

}
