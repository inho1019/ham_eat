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

@Entity//boardDTO라는 테이블 생성
@Table(name="hamburger")//테이블 명을 자유자제로 바꿀수 있다
@Getter
@Setter
public class HamDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hamburgerSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="store",nullable = true)
	private int storeSeq;	
	
	@Column(name="size",nullable = true)
	private int size;	
	
	@Column(name="make",nullable = false,length = 1000)
	private String make;	
	
	@Column(name="name",nullable = false,length = 100)//칼럼 조건 지정
	private String name;
	
	@Column(name="content",nullable = false,length = 1000)//칼럼 조건 지정
	private String content;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
