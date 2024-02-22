package ham.bean;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="comment")
@Getter
@Setter
public class CommentDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentSeq;

	@Column(name="userSeq",nullable = true)
	private long userSeq;
	
	@Column(name="boardSeq",nullable = true)
	private long boardSeq;	

	@Column(name="content",nullable = false,columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
