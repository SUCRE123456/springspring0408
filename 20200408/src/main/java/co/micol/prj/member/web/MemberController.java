package co.micol.prj.member.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;
import co.micol.prj.util.PasswordEncrypt;


@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;
	@Autowired
	private PasswordEncrypt penEncrypt;
	
	
	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) {
		model.addAttribute("members", memberDao.memberSelectList());
		
		return "member/memberSelectList";
	}
	
	@RequestMapping("/memberJoinForm.do")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@PostMapping("/memberJoin.do")
	public String memberJoin(MemberVO vo) {
		vo.setPassword(penEncrypt.pe(vo.getPassword()));
		memberDao.memberInsert(vo);
		//*************** redirect **************
		return "redirect:memberSelectList.do"; //직접 실행 구문을 호출할 때
	}
	
	@RequestMapping("/memberLoginForm.do")
	public String memberLoginForm() {
		return "member/memberLoginForm";
	}
	
	@PostMapping("/memberLogin.do")
	public String memberLogin(MemberVO vo, Model model, HttpSession session) {
		//vo 로그인정보 받아온걸로 셀렉트해서 셀렉하고 다시 vo로 선언
		//model은 데이터 넘겨줄때 선언.
		vo.setPassword(penEncrypt.pe(vo.getPassword()));
		vo = memberDao.memberSelect(vo);
		if(vo != null) {
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("name", vo.getName());
			model.addAttribute("message", vo.getName() + "님 환영합니다.");
		}else {
			model.addAttribute("message", "아이디 또는 패스워드가 틀렸습니다.");
		}
		return "member/memberLoginMessage";
	}
	
	
	
	/*private String passwordEncrypt(String password) {
		MessageDigest md; //다이제스트 함수
		String enc = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			enc = String.format("%064x", new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return enc;
	}*/
	

	@RequestMapping("/memberLogout.do")
	public String memberLogout(HttpSession session, Model model) {
		
		model.addAttribute("message", session.getAttribute("name") + "님 정상 로그아웃 되었습니다.");
		session.invalidate();
		
		return "member/memberMessage";
	}
	
	@RequestMapping(value="/ajaxIdCheck.do", produces="application/text;charset=UTF-8") //produce~ 한글깨짐방지.
	@ResponseBody //ajax 사용시 호출된 페이지로 결과를 돌려주는 어노테이션
	public String ajaxIdCheck(MemberVO vo) {
		String str = null;
		System.out.println(vo.getId()+"====================");
	//	vo.setId(id);
		vo = memberDao.memberSelect(vo);
		
		if(vo != null) {
			str = "Yes";
		}else {
			str = "No";
		}
		return str;
	}
	
	/*@RequestMapping("/passwordEncrypt.do")
	public String passwordEncrypt(Model model) {
		MessageDigest md; //다이제스트 함수
		String password="1234";
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			System.out.println(String.format("%064x", new BigInteger(1, md.digest())));
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		return "member/passwordEncrypt";
		
	}
	*/
}