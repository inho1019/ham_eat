package ham.service;

import java.util.List;

import ham.bean.BoardDTO;

public interface BoardService {

	public void boardWrite(BoardDTO boardDTO);

	public List<Object> boardList(int type);

	public Object boardView(long boardSeq);

	public void boardUpdate(BoardDTO boardDTO);

	public void boardDelete(long boardSeq);

	public void boardFav(BoardDTO boardDTO);

	public List<BoardDTO> boardListHome(int type);

	public BoardDTO boardBest(int type);

	public List<Object> boardListAll();
}
