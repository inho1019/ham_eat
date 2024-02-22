package ham.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.CarouselDTO;
import ham.bean.IngreDTO;
import ham.bean.UserDTO;
import ham.service.CarouselService;
import ham.service.EmailService;
import ham.service.UserService;
import jakarta.mail.MessagingException;
import lombok.Getter;
import lombok.Setter;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@Autowired
	private CarouselService carouselService;
		
	@Autowired
    private EmailService emailService;
	
	@Getter
	@Setter
	public static class UpdateDTO {
		private int field;
		private String value;
		private long userSeq;
    }
	
	@PostMapping("user/email")
    public String mailConfirm(@RequestBody UserDTO userDTO) throws UnsupportedEncodingException, MessagingException {

    	String email = userDTO.getEmail();
    	
        String authCode = emailService.sendEmail(email);
        return authCode;
    }
	
	@PostMapping("user/emailCheck")
	public boolean checkEmail(@RequestBody UserDTO userDTO) {
		String email = userDTO.getEmail();
		
		return userService.checkEmail(email);
	}
	@PostMapping("user/nameCheck")
	public boolean checkName(@RequestBody UserDTO userDTO) {
		String name = userDTO.getName();
		
		return userService.checkName(name);
	}
	
	@PostMapping("user/register")
	public boolean register(@RequestBody UserDTO userDTO) {
		return userService.register(userDTO);
	}
	
	
	@PostMapping("user/login")
	public Map<String,Object> login(@RequestBody UserDTO userDTO) {
		return userService.login(userDTO);
	}
	
	@PutMapping("user/update")
	public boolean update(@RequestBody UpdateDTO updateDTO) {
		int field = updateDTO.getField();
		String value = updateDTO.getValue();
		long userSeq = updateDTO.getUserSeq();
 		return userService.update(field,value,userSeq);
	}
	
	@PostMapping("user/checkPwd")
	public boolean checkPwd(@RequestBody UserDTO userDTO) {
		return userService.checkPwd(userDTO);
	}
	
	@DeleteMapping("user/delete/{userSeq}")
	public boolean delete(@PathVariable Long userSeq) {
		return userService.delete(userSeq);
	}
	
	@PostMapping("carousel/write")
	public CarouselDTO carouselWrite(@RequestBody CarouselDTO carouselDTO) {
		carouselService.carouselWrite(carouselDTO);
		return carouselDTO;
	}
	
	@GetMapping("carousel/list")
	public List<CarouselDTO> carouselList() {
		return carouselService.carouselList();
	}
	
	@DeleteMapping("carousel/delete/{carouselSeq}")
	public void carouselDelete(@PathVariable("carouselSeq") Long carouselSeq) {
		carouselService.carouselDelete(carouselSeq);
	}
	
	@GetMapping(value="ping")
	public void ingreList() {
		System.out.println("ping");
	}
	
	@GetMapping("policy")
    public String policy() {
        return ". 개인정보의 처리 목적<br>"
        		+ "<br>"
        		+ "HAMEAT 은 다음의 목적을 위하여 개인정보를 처리하고 있으며, 다음의 목적 이외의 용도로는 이용하지 않습니다.<br>"
        		+ "– 고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인 식별.인증, 회원자격 유지.관리 등<br>"
        		+ "<br>"
        		+ "2. 개인정보의 처리 및 보유 기간<br>"
        		+ "<br>"
        		+ "① ‘HAMEAT’은 정보주체로부터 개인정보를 수집할 때 동의 받은 개인정보 보유․이용기간 또는 법령에 따른 개인정보 보유․이용기간 내에서 개인정보를 처리․보유합니다.<br>"
        		+ "<br>"
        		+ "② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다.<br>"
        		+ "– 고객 가입 및 관리 : 이메일 인증을 통한 회원가입 및 데이터 베이스를 통한 관리<br>"
        		+ "– 보유 기간 : 회원 탈퇴 시, 즉시 삭제<br>"
        		+ "<br>"
        		+ "3. 정보주체와 법정대리인의 권리·의무 및 그 행사방법 이용자는 개인정보주체로써 다음과 같은 권리를 행사할 수 있습니다.<br>"
        		+ "<br>"
        		+ "① 정보주체는 ‘HAMEAT’ 에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를 행사할 수 있습니다.<br>"
        		+ "1. 개인정보 열람요구<br>"
        		+ "2. 오류 등이 있을 경우 정정 요구<br>"
        		+ "3. 삭제요구<br>"
        		+ "4. 처리정지 요구<br>"
        		+ "<br>"
        		+ "4. 처리하는 개인정보의 항목 작성<br>"
        		+ "<br>"
        		+ "① ‘HAMEAT’은 다음의 개인정보 항목을 처리하고 있습니다.<br>"
        		+ "<br>"
        		+ "<‘HAMEAT’에서 수집하는 개인정보 항목><br>"
        		+ "‘HAMEAT’ 회원 가입 및 고객 문의 시, 제공 동의를 해주시는 개인정보 수집 항목입니다.<br>"
        		+ "<br>"
        		+ "■ 회원 가입 시(회원)<br>"
        		+ "– 필수항목 : 이메일, 성별"
        		+ "– 선택항목 : 생년월일<br>"
        		+ "– 수집목적 : HAMEAT 회원관리 및 마케팅 이용<br>"
        		+ "– 보유기간 : 회원 탈퇴 또는 동의철회 시 지체없이 파기<br>"
        		+ "<br>"
        		+ "5. 개인정보의 파기<br>"
        		+ "<br>"
        		+ "‘HAMEAT’은 원칙적으로 개인정보 처리목적이 달성된 경우에는 지체없이 해당 개인정보를 파기합니다. 파기의 절차, 기한 및 방법은 다음과 같습니다.’<br>"
        		+ "<br>"
        		+ "-파기절차<br>"
        		+ "이용자가 입력한 정보는 목적 달성 후 별도의 DB에 옮겨져(종이의 경우 별도의 서류) 내부 방침 및 기타 관련 법령에 따라 일정기간 저장된 후 혹은 즉시 파기됩니다. 이 때, DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 다른 목적으로 이용되지 않습니다.<br>"
        		+ "<br>"
        		+ "-파기기한<br>"
        		+ "이용자의 개인정보는 개인정보의 보유기간이 경과된 경우에는 보유기간의 종료일로부터 5일 이내에, 개인정보의 처리 목적 달성, 해당 서비스의 폐지, 사업의 종료 등 그 개인정보가 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 5일 이내에 그 개인정보를 파기합니다.<br>"
        		+ "<br>"
        		+ "6. 개인정보 자동 수집 장치의 설치•운영 및 거부에 관한 사항<br>"
        		+ "<br>"
        		+ "① ‘HAMEAT’은 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.<br>"
        		+ "<br>"
        		+ "▶ 개인정보 보호 책임자<br>"
        		+ "성명 : 명인호<br>"
        		+ "직책 : 개발자<br>"
        		+ "연락처 : ino1019@gmail.com<br>"
        		+ "※ 개인정보 보호 담당부서로 연결됩니다.<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "② ‘HAMEAT’의 서비스(또는 사업)을 이용하시면서 발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및 담당부서로 문의하실 수 있습니다.<br>"
        		+ "<br>"
        		+ "‘HAMEAT’은 정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.<br>"
        		+ "<br>"
        		+ "8. 개인정보 처리방침 변경<br>"
        		+ "<br>"
        		+ "① 이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른 변경내용의 추가, 삭제 및 정정이 있는 경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.<br>"
        		+ "<br>"
        		+ "9. 개인정보의 안전성 확보 조치 <br>"
        		+ "‘HAMEAT’은 개인정보보호법 제29조에 따라 다음과 같이 안전성 확보에 필요한 기술적/관리적 및 물리적 조치를 하고 있습니다.<br>"
        		+ "<br>"
        		+ "① 개인정보 취급 직원의 최소화 및 교육<br>"
        		+ "개인정보를 취급하는 직원을 지정하고 담당자에 한정시켜 최소화 하여 개인정보를 관리하는 대책을 시행하고 있습니다.<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "② 해킹 등에 대비한 기술적 대책<br>"
        		+ "‘HAMEAT’은 해킹이나 컴퓨터 바이러스 등에 의한 개인정보 유출 및 훼손을 막기 위하여 보안프로그램을 설치하고 주기적인 갱신·점검을 하며 외부로부터 접근이 통제된 구역에 시스템을 설치하고 기술적/물리적으로 감시 및 차단하고 있습니다.<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "③ 개인정보의 암호화<br>"
        		+ "이용자의 개인정보는 비밀번호는 암호화 되어 저장 및 관리되고 있어, 본인만이 알 수 있으며 중요한 데이터는 파일 및 전송 데이터를 암호화 하거나 파일 잠금 기능을 사용하는 등의 별도 보안기능을 사용하고 있습니다.<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "④ 접속기록의 보관 및 위변조 방지<br>"
        		+ "개인정보처리시스템에 접속한 기록을 최소 6개월 이상 보관, 관리하고 있으며, 접속 기록이 위변조 및 도난, 분실되지 않도록 보안기능 사용하고 있습니다.<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "⑤ 개인정보에 대한 접근 제한<br>"
        		+ "개인정보를 처리하는 데이터베이스시스템에 대한 접근권한의 부여,변경,말소를 통하여 개인정보에 대한 접근통제를 위하여 필요한 조치를 하고 있으며 침입차단시스템을 이용하여 외부로부터의 무단 접근을 통제하고 있습니다.<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "10. 정보주체의 권익침해에 대한 구제방법<br>"
        		+ "<br>"
        		+ "▶ 개인정보 침해신고센터 (한국인터넷진흥원 운영)<br>"
        		+ "– 소관업무 : 개인정보 침해사실 신고, 상담 신청<br>"
        		+ "– 홈페이지 : privacy.kisa.or.kr<br>"
        		+ "– 전화 : (국번없이) 118<br>"
        		+ "– 주소 : (58324) 전남 나주시 진흥길 9(빛가람동 301-2) 3층 개인정보침해신고센터<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "▶ 개인정보 분쟁조정위원회<br>"
        		+ "– 소관업무 : 개인정보 분쟁조정신청, 집단분쟁조정 (민사적 해결)<br>"
        		+ "– 홈페이지 : www.kopico.go.kr<br>"
        		+ "– 전화 : (국번없이) 1833-6972<br>"
        		+ "– 주소 : (03171)서울특별시 종로구 세종대로 209 정부서울청사 4층<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "▶ 대검찰청 사이버범죄수사단 : 02-3480-3573 (www.spo.go.kr)<br>"
        		+ "<br>"
        		+ "<br>"
        		+ "▶ 경찰청 사이버안전국 : 182 (http://cyberbureau.police.go.kr)";
    }
}
