package co.micol.prj.notice.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeMapper {
	List<NoticeVO> noticeSearchList(@Param("key") String key, @Param("val") String val);
	List<NoticeVO> noticeSelectList(int page);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
}
