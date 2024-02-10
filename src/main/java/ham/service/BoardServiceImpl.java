package ham.service;

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

}
