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
@Table(name="board")
@Getter
@Setter
public class BoardDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long boardSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="userSeq",nullable = true)
	private long userSeq;	

	@Column(name="title",nullable = false,length = 100)//칼럼 조건 지정
	private String title;
	
	@Column(name="content",nullable = false,length = 1000)//칼럼 조건 지정
	private String content;
	
	@Column(name="hit",nullable = false)
	private int hit;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
