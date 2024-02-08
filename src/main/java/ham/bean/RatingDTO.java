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
@Table(name="rating")
@Getter
@Setter
public class RatingDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ratingSeq;
	
	@Column(name="burgerSeq",nullable = false)
	private long burgerSeq;
	
	@Column(name="userSeq",nullable = false)
	private long userSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="rate",nullable = false)
	private float rate;
	
	@Column(name="content",nullable = true,length = 500)
	private String content;
	
	@Column(name="placeName",nullable = true,length = 100)
	private String placeName;
	
	@Column(name="longitude",nullable = true,length = 100)
	private String longitude;
	
	@Column(name="latitude",nullable = true,length = 100)
	private String latitude;

	@Column(name="placeUrl",nullable = true,length = 200)
	private String placeUrl;
	
	@Column(name="placeId",nullable = true,length = 100)
	private String placeId;
	
	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
