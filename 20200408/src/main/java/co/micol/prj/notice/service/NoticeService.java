package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSearchList(String key, String val);
	List<NoticeVO> noticeSelectList(int page);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
}
