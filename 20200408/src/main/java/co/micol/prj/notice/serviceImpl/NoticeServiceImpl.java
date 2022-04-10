package co.micol.prj.notice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.prj.notice.service.NoticeMapper;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Repository("noticeDao")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper map;
	
	

	@Override
	public List<NoticeVO> noticeSearchList(String key, String val) {
		return map.noticeSearchList(key, val);
	}

	@Override
	public List<NoticeVO> noticeSelectList(int page) {
		// TODO Auto-generated method stub
		return map.noticeSelectList(page);
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeDelete(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return map.noticeInsert(vo);
	}

}
