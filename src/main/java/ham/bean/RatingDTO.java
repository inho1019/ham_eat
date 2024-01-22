package ham.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private int ratingSeq;
	
	@Column(name="userSeq",nullable = false)
	private int userSeq;
	
	@Column(name="rate",nullable = false)
	private float rate;
	
	@Column(name="context",nullable = true,length = 500)
	private String context;
}
