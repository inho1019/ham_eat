package ham.bean;

import java.sql.Timestamp;
import java.time.LocalDate;

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
	private long userSeq;
	
	@Column(name="name",nullable = false,length = 100)//칼럼 조건 지정
	private String name;

	@Column(name="pwd",nullable = false,length = 200)//칼럼 조건 지정
	private String pwd;
	
	@Column(name="email",nullable = false,length = 200)//칼럼 조건 지정
	private String email;
	
	@Column(name="secretKey",nullable = false,length = 200)//칼럼 조건 지정
	private String secretKey;
	
	@Column(name="gender",nullable = false)//칼럼 조건 지정
	private int gender;	
	
	@Column(name="birth",nullable = false)//칼럼 조건 지정
	private LocalDate birth;
	
	@Column(name="own",nullable = false)
	private int own;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
