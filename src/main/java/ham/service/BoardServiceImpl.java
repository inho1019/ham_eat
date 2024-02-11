package ham.service;

import java.util.List;

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

}
