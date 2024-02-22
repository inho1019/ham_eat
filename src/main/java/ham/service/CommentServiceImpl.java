package ham.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ham.bean.CommentDTO;
import ham.dao.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDAO commentDAO;

	@Override
	public void commentWrite(CommentDTO commentDTO) {
		commentDAO.save(commentDTO);
	}

	@Override
	public List<Object> commentList(long boardSeq) {
		return commentDAO.selectSeqJoin(boardSeq);
	}

	@Override
	public void commentDelete(long commentSeq) {
		commentDAO.deleteById(commentSeq);
	}
}
