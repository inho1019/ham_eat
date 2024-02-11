package ham.service;

import java.util.List;

import ham.bean.BoardDTO;

public interface BoardService {

	public void boardWrite(BoardDTO boardDTO);

	public List<Object> boardList(int type);

}
