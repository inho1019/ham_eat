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
import ham.bean.BurgerDTO;
import ham.bean.CommentDTO;
import ham.service.BoardService;
import ham.service.CommentService;

@RestController
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping(value="board/write")
	public BoardDTO boardWrite(@RequestBody BoardDTO boardDTO) {
		boardService.boardWrite(boardDTO);
		return boardDTO;
	}
	
	@PostMapping(value="comment/write")
	public CommentDTO commentWrite(@RequestBody CommentDTO commentDTO) {
		commentService.commentWrite(commentDTO);
		return commentDTO;
	}
	
	@PutMapping(value="board/fav")
	public void boardFav(@RequestBody BoardDTO boardDTO) {
		boardService.boardFav(boardDTO);
	}
	
	@GetMapping(value="board/list/{type}")
	public List<Object> boardList(@PathVariable int type) {
		return boardService.boardList(type);
	}
	
	@GetMapping(value="comment/list/{boardSeq}")
	public List<Object> commentList(@PathVariable("boardSeq") long boardSeq) {
		return commentService.commentList(boardSeq);
	}
	
	@GetMapping(value="board/listAll")
	public List<Object> boardListAll() {
		return boardService.boardListAll();
	}
	
	@GetMapping(value="board/listHome/{type}")
	public List<BoardDTO> boardListHome(@PathVariable int type) {
		return boardService.boardListHome(type);
	}
	
	@GetMapping(value="board/best/{type}")
	public BoardDTO boardBest(@PathVariable int type) {
		return boardService.boardBest(type);
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
	
	@DeleteMapping(value="comment/delete/{commentSeq}")
	public void commentDelete(@PathVariable("commentSeq") long commentSeq) {
		commentService.commentDelete(commentSeq);
	}
	
	
}
