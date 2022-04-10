package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService noticeDao;
	
	@Autowired
	private String saveDir;
	
	@RequestMapping("/noticeList.do")
	public String noticeList(@RequestParam int page, Model model) {
		model.addAttribute("notices", noticeDao.noticeSelectList(page));
		return "notice/noticeList";
	}
	
	
	
	//요청들 처리하는 메소드 작성
/*	@RequestMapping("/noticeList.do")
	public String noticeList(Model model) {
		//리스트 가져오는거 처리
		model.addAttribute("notices", noticeDao.noticeSelectList());		
		
		return "notice/noticeList";
	}*/
	
	@RequestMapping("/noticeInputForm.do")
	public String noticeInputForm() {
		return "notice/noticeInputForm";
	}
	@RequestMapping("/noticeInsert.do") //file upload 하면서 게시글 등록하는 메소드
	public String noticeInsert(NoticeVO vo, MultipartFile file) {
		
		if(file.isEmpty()) { //파일이 비어 있으면 true
			noticeDao.noticeInsert(vo);
		}else { //파일이 존재하면
			String originalFilename = file.getOriginalFilename(); //원본파일명
			String saveFilename = 
					UUID.randomUUID().toString() + originalFilename.substring(originalFilename.lastIndexOf('.'));
		//System.out.println(originalFilename);
		//System.out.println(saveFilename);
			
		try {
			file.transferTo(new File(saveDir, saveFilename)); //물리적 위치에 저장
			//이곳에서 DB저장하면됨.
			saveFilename = saveDir + saveFilename; //저장된 물리경로를 포함한다.
			//System.out.println(saveFilename);
			vo.setFileName(originalFilename);
			vo.setUuidFile(saveFilename);
			noticeDao.noticeInsert(vo);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //물리적 위치에 저장
		}		
		return "redirect:noticeList.do?page=1";
	}
	
	@PostMapping("/noticeSearch.do")
	@ResponseBody
	public List<NoticeVO> noticeSearch(@RequestParam String key, @RequestParam String val) {
//		List<NoticeVO> list = new ArrayList<NoticeVO>();
//	list = noticeDao.noticeSearchList(key,val);
		return noticeDao.noticeSearchList(key,val);
	}
}