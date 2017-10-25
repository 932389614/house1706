<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>高大上租房网 - 用户注册</title>
		<link type="text/css" rel="stylesheet" href="css/style.css">
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="images/logo.png" />
			</div>
		</div>
		<div id="regLogin" class="wrap">
			<div class="dialog">
				<dl class="clearfix">
					<dt>新用户注册</dt>
					<dd class="past">填写个人信息</dd>
				</dl>
				<div class="box">
					<form action="register" method="post" id="userRegisterForm">
						<div class="infos">
							<table class="field">
								<tr>
									<td>&nbsp;</td>
									<td style="color: red">${hint}</td>
								</tr>
								<tr>
									<td class="field">用 户 名：</td>
									<td>
										<input id="username" type="text" class="text" name="username"> 
										<span id="isValid"></span>
										<span id="uerror" style="color:red; font-size:12px;"></span>
									</td>
									
								</tr>
								<tr>
									<td class="field">密 码：</td>
									<td>
										<input type="password" class="text" name="password" id="password">
										<span id="pwderror" style="color:red; font-size:12px;"></span>
									</td>
									
								</tr>
								<tr>
									<td class="field">确认密码：</td>
									<td>
										<input type="password" class="text" name="repassword" id="repassword">
										<span id="repwderror" style="color:red; font-size:12px;"></span>
									</td>
									
								</tr>
								<tr>
									<td class="field">电 话：</td>
									<td>
										<input type="text" class="text" name="tel" id="tel">
										<span id="telerror" style="color:red; font-size:12px;"></span>
									</td>
									
								</tr>
								<tr>
									<td class="field">用户姓名：</td>
									<td>
										<input type="text" class="text" name="relName" id="relName">
										<span id="rnerror" style="color:red; font-size:12px;"></span>
									</td>
									
								</tr>
								<tr>
									<td class="field">验 证 码：</td>
									<td>
										<input type="text" class="text" name="code"> 
										<img id="code" src="code" width="80" height="30">

									</td>
								</tr>
							</table>
							<div class="buttons">
								<input type="submit"   value="立即注册" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="footer" class="wrap">
			<dl>
				<dt>高大上租房网 &copy; 2013 攀峰科技 川ICP证1000001号</dt>
				<dd>关于我们 · 联系方式 · 意见反馈 · 帮助中心</dd>
			</dl>
		</div>
		<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
		<script>
		$('#code').on('click', function() {
			$(this).attr('src', 'code?' + Math.random());
		});
		$('#toRegBtn').on('click', function() {
			location.href="toRegister";
		});
		</script>
		<script>
		/* js验证表单数据 */
		$(function(){
			var isValid=false;
			$('#userRegisterForm').on('submit', function(evt) {
				evt.preventDefault();
				var username = $('#username').val();
				var password = $('#password').val();
				var repassword= $('#repassword').val();
				var tel= $('#tel').val();
				var relName= $('#relName').val();
				if (checkUsername(username) & checkPassword(password) 
						& checkRePassword(repassword) & checkRelName(relName) & checkTel(tel)) {
					this.submit();
				}
			});
			
			$('#username').on('blur', function() {
				var username = $(this).val();
				
				if(checkUsername(username))
					$.getJSON('check?username='+username,function(data){
							isValid=data.valid;
							$('#isValid').children().remove();
							$('#isValid').append($('<img>').attr("src","images/"+data.picture));
						
				});
			});
			
			$('#username').on('blur', function() {
				checkUsername($(this).val());
			});
			
			$('#password').on('blur', function() {
				checkPassword($(this).val());
			});
			
			$('#repassword').on('blur', function() {
				checkRePassword($(this).val());
			});
			
			$('#tel').on('blur', function() {
				checkTel($(this).val());
			});
			
			$('#relName').on('blur', function() {
				checkRelName($(this).val());
			});
			function checkUsername(username) {
				var flag = /^\w{6,20}$/.test(username);
				flag ? $('#uerror').text('') : $('#uerror').text('无效的用户名');
				return flag;
			}
			
			function checkPassword(password) {
				var flag = (password.length >= 6);
				flag ? $('#pwderror').text('') : $('#pwderror').text('密码不能少于6个字符');
				return flag;
			}
			
			function checkRePassword(repassword) {
				var flag = (repassword==$('#password').val());
				flag ? $('#repwderror').text('') : $('#repwderror').text('请确认密码');
				return flag;
			}
			
			function checkTel(tel) {
				var flag = /^\d{11}$/.test(tel);
				flag ? $('#telerror').text('') : $('#telerror').text('请输入正确的电话号码');
				return flag;
			}
			
			function checkRelName(relName) {
				var flag = (relName.length>=2);
				flag ? $('#rnerror').text('') : $('#rnerror').text('请输入正确的姓名');
				return flag;
			}
		});
		</script>
	</body>
</html>

