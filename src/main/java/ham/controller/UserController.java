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
import ham.bean.VariDTO;
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
	
	@GetMapping("user/list")
	public List<UserDTO> userList() {
		return userService.userList();
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
	
	@PostMapping("vari/set")
	public void variSet(@RequestBody VariDTO variDTO) {
		userService.variSet(variDTO);
	}
	
	@GetMapping("vari/get/{name}")
	public String variGet(@PathVariable String name) {
		return userService.variGet(name);
	}
	
	@GetMapping("terms")
	public String terms() {
		return "본 서비스 약관(이하 \"약관\")은 귀하가 회사의 서비스뿐만 아니라 'HAMEAT'상에서 업로드 또는 다운로드되거나 보여지는 정보, 문구, 그래픽, 사진 또는 기타 자료(이하 통칭하여 '콘텐츠')에 엑세스하여 이를 이용하는 행위 일체에 적용됩니다. 귀하는 HAMEAT을 이용하시기 전 본 약관을 숙독하시어 이해하시고 동의하셔야 합니다. 귀하가 HAMEAT에 엑세스하고 이용하는 행위는 귀하가 본 약관에 동의하고 이에 준수하는 것을 의미합니다. 따라서 본 약관을 읽고 동의하신 후에 서비스를 이용하실 수 있습니다.<br>"
				+ "<br>"
				+ "정의<br>"
				+ "이 약관에서 사용하는 용어의 정의는 다음과 같습니다.<br>"
				+ "\"회사\"란, 서비스를 사용하는 주체를 말합니다.<br>"
				+ "\"서비스\"란, 커뮤니티를 비롯한 회사가 제공하는 모든 서비스 및 기능을 말합니다.<br>"
				+ "\"콘텐츠\"란, 서비스상에서 업로드 또는 다운로드되거나 보여지는 정보, 문구, 사진, 영상, 그래픽 또는 기타자료를 말합니다.<br>"
				+ "\"게시판\"이란, 게시물을 게시할 수 있는 공간을 말합니다.<br>"
				+ "1항에서 정의되지 않은 약관 내 용어의 의미는 일반적인 이용관행을 적용합니다.<br>"
				+ "귀하와 회사간의 동의 (재판권 및 준거법)<br>"
				+ "회사와 귀하 간 분쟁으로 인한 소송에는 한국법을 적용합니다.<br>"
				+ "귀하가 회사에 제공하는 정보 일체는 회사의 개인정보처리방침에 따르며, 당사가 귀하의 정보를 수집 및 이용하는 행위는 같은 정책이 적용됩니다. 귀하가 본 서비스를 이용함으로써 회사가 귀하의 정보를 수집 및 이용(개인정보취급방침에서 규정하는 바와 같음)하는 것에 동의하는 것으로 간주됩니다. <br>"
				+ "당사의 서비스를 이용함으로써 귀하는 법률에 의해 허용된 범위 내에서 아래와 같은 요소로 인해 발행하는 모든 제삼자의 청구 또는 요구로부터 회사 그리고 회사의 임직원, 주주, 소유자, 임원 및 대리인이 피해를 입지 않도록 하는데 동의합니다. 1) 귀하의 서비스 이용, 2) 콘텐츠 (게시글, 이미지, 비디오, 기타 자료 포함), 3) 귀하의 서비스 접속, 4) 본 약관에 대한 귀하의 위반, 그리고 5) 기타 적용가능한 법률의 위반<br>"
				+ "기본 약관<br>"
				+ "서비스의 사용과 서비스에 게시하는 콘텐츠, 그에 따른 결과에 대한 책임은 귀하에게 있습니다. 귀하가 게시판에 제출, 게시, 표시하는 콘텐츠는 동일한 게시판에 콘텐츠를 제출, 게시, 표시할 권리가 있는 다른 이용자가 열람할 수 있습니다. 귀하는 본 약관에 따라 다른 사람들과 공유하여도 불편하지 않은 콘텐츠만을 제공하여야 합니다. 또한, 군 보안위규사항에 해당하지 않는 콘텐츠만을 제공하여야 합니다.  귀하는 서비스를 이용하거나 콘텐츠를 게시함으로써 당사의 커뮤니티 가이드라인을 검토하고 준수할 것에 동의합니다.<br>"
				+ "회사가 제공하는 본 서비스는 언제든지 변경될 수 있으며, 회사가 제공하는 본 서비스의 형태 및 성격은 귀하에 대한 사전 통지 없이 수시로 변경될 수 있습니다. 또한, 회사는 귀하 또는 제반 이용자에 대한 본 서비스(또는 본 서비스에 포함된 특정 기능)의 제공을 (영구적 또는 일시적으로) 중단할 수 있으며, 귀하에게 사전 통지를 제공하지 못할 수도 있습니다. 당사는 또한 당사의 단독 재량에 따라 언제든지 귀하에 대한 사전 통지 없이 이용 및 저장에 대한 제한을 설정할 수 있는 권리를 보유합니다. <br>"
				+ "본 서비스는 본 서비스상의 콘텐츠, 본 서비스와 관련하여 제기되는 질의사항, 그리고 기타 정보 등을 기반으로 타게팅하는 광고를 포함할 수 있습니다. 회사가 본 서비스상에서 행하는 광고의 종류 및 범위는 변경될 수 있습니다. 회사가 귀하로 하여금 본 서비스에 액세스하고 본 서비스를 이용할 수 있도록 하는 데 대한 대가로서, 귀하는 회사, 회사의 제3자 제공자(서비스 퍼블리싱 업체 등)들 및 파트너사 등이 본 서비스상에 또는 본 서비스 내의 콘텐츠 등의 정보와 함께 (귀하가 제공한 것인지 또는 타이용자들이 제공한 것인지의 여부를 불문함) 본 서비스 내에 광고를 게재할 수 있음에 동의합니다.<br>"
				+ "콘텐츠<br>"
				+ "당사는 본 서비스를 통해 게시된 콘텐츠 및 의사소통 내용의 완전성, 진실성, 정확성, 신뢰성을 확인, 지지, 대표, 보증하지 않고 본 서비스를 통해 표출된 어떠한 의견도 지지하지 않습니다. 귀하는 본 서비스를 이용하는 과정에서 불쾌하거나, 유해하거나, 부정확하거나, 부적절하거나, 허위제목으로 등록되었거나, 기만적인 게시물에 노출될 수도 있음을 인지하고 있습니다. 회사는 어떠한 경우에도, 콘텐츠의 신뢰성에 대한(콘텐츠상의 오류나 누락을 포함하되 이에 한정되지 아니함) 책임을 부담하지 않으며, 본 서비스를 통해 게시되거나, 이메일 등의 방식으로 전송되거나, 서비스를 통해 제공되거나, 타 매체에 게시됨으로 인해서 발생하는 종류를 불문한 손실이나 손해 일체에 대한 책임을 부담하지 않습니다.<br>"
				+ "소유권: 콘텐츠에 대한 일체의 권리 및 소유권은 사용자에게 있습니다. 본 서비스를 통해 게시되었거나 본 서비스를 통해 귀하가 입수한 콘텐츠나 자료를 이용하거나 이에 의존하는 것은 귀하의 위험부담으로 합니다.<br>"
				+ "용도: 회사는 서비스의 운영, 확장, 홍보 등의 필요한 목적으로 회원의 저작물을 합리적이고 필요한 점위 내에서 별도의 허락 없이 수정하여 무상으로 사용하거나 제휴사에게 제공할 수 있습니다. 이 경우, 회원의 개인정보는 제공하지 않습니다. 회사는 위의 방법 이외의 방법으로 회원의 게시물을 이용할 경우, 서비스 내부 알림 수단과 회원의 연락처를 이용하여 회원의 동의를 받아야 합니다.<br>"
				+ "컨텐츠 및 서비스 이용 제한 사항: 서비스 운영 주체는 사용자가 작성한 컨텐츠를 숨김처리하거나, 서비스 이용을 제한 혹은 특정 닉네임 이용을 제한하기 위한 권리를 갖고 있습니다. 이 약관에 따라 아래에 해당 하는 행위를 한 사용자의 계정에 대해서는 서비스 이용이 제한될 수 있습니다.<br>"
				+ "불법적/차별적/악의적인 사항에 대한 논의 선동행위.<br>"
				+ "특정인의 명예훼손, 위협, 희롱하는 등의 행위나 개인정보보호 및 지적재산권 등의 법적인 권리를 위반하는 행위.<br>"
				+ "일반 게시판, 부대 게시판 등의 소통공간에 적합하지 않은 공격적인, 포르노성의, 위협적인, 공포스러운 류의 이미지 게재행위.<br>"
				+ "서비스의 제작 의도 등에 반하는 내용의 게재행위.<br>"
				+ "허가되지 않은 상업적 목적을 가진 광고, 홍보 등 내용의 게재행위.<br>"
				+ "당사는 콘텐츠를 모니터링하며 악의적이나 불법적인 콘텐츠를 없애기 위해 노력하지만 지적재산권 위반이나 기밀정보 남용과 같은 불법행위에 대한 책임을 부담하지 않습니다.<br>"
				+ "해지<br>"
				+ "귀하는 서비스 내의 '탈퇴하기' 버튼을 통해 언제든지 서비스 이용을 중단할 수 있습니다.<br>"
				+ "해지 처리가 완료 되었더라도, 회원이 게시한 게시물은 삭제되지 않습니다.<br>"
				+ "회사는 천재지변, 테러 등 불가피한 사유로 더 이상 서비스를 제공할 수 없을 경우, 회원의 동의 없이 회원자격을 박탈할 수 있습니다.<br>"
				+ "회사는 1항부터 전항까지로 인해 발생한 피해에 대한 어떠한 책임을 지지 않습니다.<br>"
				+ "통지<br>"
				+ "귀하에 대한 통지: 서비스 관련 메시지나 공지 등을 위해서 회사는 서비스 페이지 내에 배너 등 다른 적합한 방법을 이용하여 귀하에게 알립니다. 해당 방법은 당사가 취할 수 있는 최대한의 적극적인 고지 방식임에 동의하며, 귀하는 귀하가 서비스에 관련한 중요한 정보를 수신하지 않아서 발생한 혹은 그와 관련된 어떠한 책임도 당사는 지지 않음을 승인 및 동의합니다.<br>"
				+ "일반 약관<br>"
				+ "일부 무효의 원칙: 법원이 약관의 일부를 무효나 집행 불능으로 판단하는 경우 잔여 약관은 그대로 적용됩니다.<br>"
				+ "기권 금지: 당사가 귀하를 상대로 약관을 집행하지 않을 경우(또는 집행을 지연하는 경우) 이는 당사의 집행권을 유보한 것이 아닙니다.<br>"
				+ "양도 또는 이전: 귀하는 회사의 사전 허가 없이 본 계약에 따른 권리나 의무를 타인에게 양도 또는 이전할 수 없습니다. 당사는 귀하의 허가 없이 당사의 귀하에 대한 권리 및 의무를 이전할 수 있습니다(당사가 타사에 인수 또는 합병되거나 서비스 일부를 매각하는 경우).<br>"
				+ "완전한 합의: 본 약관은 서비스에 관한 회사와 귀하간의 완전하고 배타적인 합의를 구성하며, 본 약관은 본 서비스에 관한 회사와 귀하간의 모든 이전의 합의를 대체하고 대신합니다. 당사는 본 약관을 수시로 변경할 수 있습니다. 당사의 단독 재량에 따라 해당 변경사항이 중대하다고 판단하는 경우, 당사는 서비스 내 배너 등 적합한 방법을 통해 귀하에게 통지할 것입니다. 변경된 약관에 동의하지 않을 경우 이용계약을 해지함으로써 거부 의사를 표시할 수 있으며,  30일 이내에 거부 의사 표시를 하지 않을 경우 약관에 동의한 것으로 간주합니다.";
	}
	
	@GetMapping("policy")
    public String policy() {
        return "1. 개인정보의 처리 목적<br>"
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
        		+ "– 필수항목 : 이메일"
        		+ "– 선택항목 : 생년월일, 성별<br>"
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
        		+ "직책 : 개발자 및 총책임자<br>"
        		+ "연락처 : inho1019@gmail.com<br>"
        		+ "<br>"
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
