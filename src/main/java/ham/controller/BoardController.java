package ham.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.BoardDTO;
import ham.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping(value="board/write")
	public BoardDTO boardWrite(@RequestBody BoardDTO boardDTO) {
		boardService.boardWrite(boardDTO);
		return boardDTO;
	}
	
	@GetMapping(value="board/list/{type}")
	public List<Object> boardList(@PathVariable int type) {
		return boardService.boardList(type);
	}
	
	@GetMapping(value="board/view/{boardSeq}")
	public Object boardView(@PathVariable long boardSeq) {
		return boardService.boardView(boardSeq);
	}
	
	@PutMapping(value="board/update")
	public void boardUpdate(@RequestBody BoardDTO boardDTO) {
		boardService.boardUpdate(boardDTO);
	}
	@DeleteMapping(value="board/delete/{boardSeq}")
	public void boardDelete(@PathVariable long boardSeq) {
		boardService.boardDelete(boardSeq);
	}
}
