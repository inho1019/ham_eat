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
@Table(name="ingre")//테이블 명을 자유자제로 바꿀수 있다
@Getter
@Setter
public class IngreDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ingreSeq;
	
	@Column(name="type",nullable = false)
	private int type;
	
	@Column(name="kcal",nullable = false)
	private int kcal;
	
	@Column(name="width",nullable = false)
	private int width;
	
	@Column(name="carbohydrates",nullable = false)
	private float carbohydrates;
	
	@Column(name="protein",nullable = false)
	private float protein;
	
	@Column(name="lipid",nullable = false)
	private float lipid;
	
	@Column(name="height",nullable = false)
	private int height;
	
	@Column(name="name",nullable = false,length = 100)//칼럼 조건 지정
	private String name;
	
	@Column(name="image",nullable = false,length = 1000)//칼럼 조건 지정
	private String image;
}
