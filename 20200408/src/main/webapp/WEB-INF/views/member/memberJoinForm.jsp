<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h1>회원가입</h1></div>
	<div>
		<form id="frm" action="memberJoin.do" method="post">
			<div>
			<table border="1">
				<tr>
					<th width="100">아이디</th>
					<td width="300">
						<input type="email" id="id" name="id" >
						<span><button type="button" onClick="idCheck()"> 중복체크 </button></span>
					</td>
				</tr>
				<tr>
					<th width="100">패스워드</th>
					<td width="300">
						<input type="password" id="password" name="password" >
					</td>
				</tr>
				<tr>
					<th width="100">패스워드확인</th>
					<td width="300">
						<input type="password" id="pwd" name="pwd" >
					</td>
				</tr>
				<tr>
					<th width="100">이 름</th>
					<td width="300">
						<input type="text" id="name" name="name" >
					</td>
				</tr>
				<tr>
					<th width="100">주 소</th>
					<td width="300">
						<input type="text" id="address" name="address" >
					</td>
				</tr>
				<tr>
					<th width="100">전화번호</th>
					<td width="300">
						<input type="text" id="tel" name="tel" >
					</td>
				</tr>
			</table>
		</div><br>
		<div>
			<input type="submit" value="회원가입">&nbsp;&nbsp;&nbsp;
			<input type="reset" value="취 소">&nbsp;&nbsp;&nbsp;
			<input type="button" value="홈가기" onclick="location.href='home.do'">&nbsp;&nbsp;&nbsp;
		</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function idCheck(){
		
		/* var id = frm.id.value;
		const url = "ajaxIdCheck.do?id="+id;
		fetch(url)
		.then( response => response.text())
		.then( text=>alert(text))
		} */
	
		var id = frm.id.value;
		var url = "ajaxIdCheck.do?id="+id;
		/*fetch(url, {
			method : "POST",
			headers : {
				//'Content-Type':'application/json', json type data전송
				'Content-Type':'application/x-www-form-urlencoded',
			},
			body : 'id='+id
		})
		.then( response => response.text())
//		.then(successFunction(response)) 함수를 이용해서 처리하는 경우
		.then( text=>alert(text))
		}*/
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(this.readyState == 4 && this.status ==200){
				if(this.responseText == 'Yes'){
					idCheckSuccess(); //이미 존재한다면
				}else {
					idCheckFail(); //사용가능 한 아이디면
				}
			}
		};
		xhr.open('get',url);
		xhr.send();
		}
		
		function idCheckSuccess(){
			alert("이미 존재하는 아이디 입니다.");
			frm.id.value="";
			frm.id.focus();
		}
		function idCheckFail(){
			alert("사용가능한 아이디 입니다.");
			frm.password.focus();
		}
</script>
</body>
</html>