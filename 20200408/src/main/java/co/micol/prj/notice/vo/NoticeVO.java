package co.micol.prj.notice.vo;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	private int id;
	private String title;
	private String content;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul")	
	private Date wdate;
	private int hit;
	private String fileName;
	private String uuidFile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUuidFile() {
		return uuidFile;
	}
	public void setUuidFile(String uuidFile) {
		this.uuidFile = uuidFile;
	}
}
