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
@Table(name="carousel")
@Getter
@Setter
public class CarouselDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long carouselSeq;
	
	@Column(name="type",nullable = false)
	private int type;

	@Column(name="image",nullable = false,columnDefinition = "TEXT")
	private String image;
	
	@Column(name="url",nullable = false,columnDefinition = "TEXT")
	private String url;
	
	@Column(name="seq",nullable = false)
	private long seq;

	@Column(nullable = false)
	@CreationTimestamp
	private Timestamp logTime;
}
