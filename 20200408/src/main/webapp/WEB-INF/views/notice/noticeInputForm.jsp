<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center"><h1>게시글 등록</h1></div>
<div>
<form id="fmr" action="noticeInsert.do" method="post" enctype="multipart/form-data"> 
	<div align="center">
	<table border="1">
		<tbody>
			<tr>
				<th width="70">제목</th>
				<td width="300">
					<input type="text" id="title" name="title" size="70">
				</td>
			</tr>
			<tr>
				<th width="70">내용</th>
				<td width="300">
					<textarea rows="10" cols="70" name="content" ></textarea>
				</td>
			</tr>
			<tr>
				<th width="70">작성일자</th>
				<td width="300">
					<input type="date" id="wdate" name="wdate">
				</td>
			</tr>
			<tr>
				<th width="70">첨부파일</th>
				<td width="300">
					<input type="file" id="file" name="file">
				</td>
			</tr>
		</tbody>
	</table>
	</div><br>
	<div>
		<input type="submit" value="글 등록">&nbsp;&nbsp;&nbsp;
		<input type="reset" value="취소">&nbsp;&nbsp;
		<input type="button" value="홈가기" onclick="location.href='home.do'">
	</div>
	</form>
	</div>
</body>
</html>