<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />
<script src="<%=path %>/js/jquery-2.0.3.min.js"></script>
		<script src="<%=path %>/js/jquery.cookie.min.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />

<script type="text/javascript">

	function teaAll1() {
		var strUrl = "<%=path%>/tea?type=teaAll";
		var ret = window.open(strUrl, "", "dialogWidth:700px; dialogHeight:500px; dialogLeft: status:no; directories:yes;scrollbars:yes;Resizable=no;");

		if (ret == undefined) {
			ret = "";
		}
 		document.getElementById("tea_id").value = $.cookie('bianhao') ;
	}
	function check() {
		if (document.getElementById("tea_id").value == "") {
			alert("请选择老师");
			return false;
		}

		document.formAdd.submit();
	}
</script>


<script language="JavaScript" type="text/javascript">
var t,n,count = 0;


$(function(){

	t = setInterval("showAuto()", 1000);

	})

	function showAuto(){

	  document.getElementById("tea_id").value = $.cookie('bianhao') ;

	}
	function StringBuffer() {
		this._strs = new Array;
	}
	StringBuffer.prototype.append = function(str) {
		this._strs.push(str); //添加
	}
	StringBuffer.prototype.pop = function(str) {
		this._strs.pop(str); //删除最后一个
	}
	StringBuffer.prototype.toString = function() {
		return this._strs.join(",");
	}
	window.onload = function() {
		var sb = new StringBuffer();

		<c:forEach items="${requestScope.zhibiaoList}"  varStatus="sta" var="zhibiao">
			        sb.append("${zhibiao.id}"); 
			    </c:forEach>

		document.formAdd.zhibiao_id.value = sb.toString();
	}
</script>
</head>

<body leftmargin="2" topmargin="2" background='<%=path%>/img/allbg.gif'>
	<form action="<%=path%>/jiaoxuepj_sys?type=pingjiaAdd" name="formAdd"
		method="post">
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top:8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="3" background="<%=path%>/img/tbg.gif">&nbsp;评价老师&nbsp;</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="20%" bgcolor="#FFFFFF" align="right">老师：</td>
				<td width="80%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="tea_id" id="tea_id" readonly="readonly" /> <input
					type="button" value="选择" onclick="teaAll1()" /></td>
			</tr>
			<c:forEach items="${requestScope.zhibiaoList}" var="zhibiao">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td width="20%" bgcolor="#FFFFFF" align="right">
						${zhibiao.mingcheng}：</td>
					<td width="80%" bgcolor="#FFFFFF" align="left"><select
						name="${zhibiao.id}">
							<option value="2">2</option>
							<option value="4">4</option>
							<option value="6">6</option>
							<option value="8">8</option>
							<option value="10">10</option>
							<option value="12">12</option>
							<option value="14">14</option>
							<option value="16">16</option>
							<option value="18">18</option>
							<option value="20" selected="selected">20</option>
					</select></td>

				</tr>
			</c:forEach>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="20%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td width="80%" bgcolor="#FFFFFF" align="left"><input
					type="hidden" name="zhibiao_id" id="zhibiao_id" value="" /> <input
					type="button" value="提交" onclick="check()" />&nbsp; <input
					type="reset" value="重置" />&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
