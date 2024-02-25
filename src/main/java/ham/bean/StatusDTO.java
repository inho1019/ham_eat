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
@Table(name="status")
@Getter
@Setter
public class StatusDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long statusSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="userSeq",nullable = true)
	private long userSeq;
	
	@Column(name="burgerSeq",nullable = true)
	private long burgerSeq;	

	@Column(name="req",nullable = false)
	private long req;	
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
