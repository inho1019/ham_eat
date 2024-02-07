package ham.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity//boardDTO라는 테이블 생성
@Table(name="store")//테이블 명을 자유자제로 바꿀수 있다
@Getter
@Setter
public class StoreDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storeSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="name",nullable = true,length = 100)
	private String name;
	
	@Column(name="image",nullable = true,length = 1000)
	private String image;
	
	@Column(name="address",nullable = true,length = 1000)
	private String address;	
	
	@Column(name="longitude",nullable = true,length = 100)
	private String longitude;
	
	@Column(name="latitude",nullable = true,length = 100)
	private String latitude;

	@Column(name="placeUrl",nullable = true,length = 200)
	private String placeUrl;
}
