package ham.service;

import java.util.List;

import ham.bean.CommentDTO;

public interface CommentService {

	void commentWrite(CommentDTO commentDTO);

	List<Object> commentList(long boardSeq);

	void commentDelete(long commentSeq);

}
