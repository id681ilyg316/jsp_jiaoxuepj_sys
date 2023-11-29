<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
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

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function stuDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/stu?type=stuDel&id="+id;
               }
           }
           
           function stuAdd()
           {
                 var url="<%=path %>/admin/stu/stuAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="32" background="<%=path %>/img/tbg.gif">&nbsp;评价管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="11%">老师</td>
					<td width="11%">分数</td>
					<td width="11%">评价时间</td>
					<td width="11%">评价学生</td>
		        </tr>	
				<c:forEach items="${requestScope.pingjiaList}" var="pingjia">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${pingjia.tea.name}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${pingjia.zongfenshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    ${pingjia.shijian}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${pingjia.stu.name1}
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
