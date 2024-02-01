package ham.bean;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	private long burgerSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="storeSeq",nullable = true)
	private int storeSeq;	
	
	@ManyToOne
    @JoinColumn(name="userSeq", nullable = false)
	private UserDTO user;	
	
	@Column(name="size",nullable = false)
	private int size;
	
	@Column(name="singlePrice",nullable = false)
	private long singlePrice;	
	
	@Column(name="setPrice",nullable = false)
	private long setPrice;	
	
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
