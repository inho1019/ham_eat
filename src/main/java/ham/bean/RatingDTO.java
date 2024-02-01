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
@Table(name="rating")
@Getter
@Setter
public class RatingDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ratingSeq;
	
	@Column(name="burgerSeq",nullable = false)
	private int burgerSeq;
	
	@ManyToOne
    @JoinColumn(name="userSeq", nullable = true)
	private UserDTO user;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="rate",nullable = false)
	private float rate;
	
	@Column(name="content",nullable = true,length = 500)
	private String content;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
