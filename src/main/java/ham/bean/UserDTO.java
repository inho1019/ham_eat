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
@Table(name="user")
@Getter
@Setter
public class UserDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userSeq;
	
	@Column(name="name",nullable = false,length = 100)//칼럼 조건 지정
	private String name;
	
	@Column(name="email",nullable = false,length = 200)//칼럼 조건 지정
	private String email;
	
	@Column(name="pwd",nullable = false,length = 30)//칼럼 조건 지정
	private String pwd;
	
	@Column(name="own",nullable = false)
	private int own;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
