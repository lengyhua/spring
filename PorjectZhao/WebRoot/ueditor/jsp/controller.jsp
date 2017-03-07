<%@page import="java.io.InputStream"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
    request.setCharacterEncoding( "utf-8" );
	response.setHeader("Content-Type" , "text/html");
	try {
		//String p1 = (String) session.getAttribute("impath");//获取配置文件中设置的图片上传路径
		Properties properties=new Properties();
        InputStream inStream= this.getClass().getClassLoader().getResourceAsStream("security.properties");
        properties.load(inStream);
       
        String saverootPath=properties.getProperty("attachment.path");
		String rootPath = application.getRealPath( "/" );
		out.write( new ActionEnter( request,saverootPath, rootPath ).exec() );
	} catch (Exception e) {
		out.println(e.getMessage());
	}
%>