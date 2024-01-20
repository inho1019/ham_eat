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
@Table(name="burger")
@Getter
@Setter
public class BurgerDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int burgerSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="storeSeq",nullable = true)
	private int storeSeq;	
	
	@Column(name="size",nullable = false)
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
