package org.hepx.proext.util;

import java.util.Map;

public class SysConfig {

	public static final String LOGIN_USER="login_user";
	
	public static final String USER_STATE_OK="正常";
	
	public static final String LOGS_TYPE_USERLOGIN="登录系统";
	
	public static final String TIMEOUT_MESSAGE_PAGE="timeout.message.page";//请求超时
	
	//角色类型。
	public static final String ROLE_TYPE="roleType";
	//普通用户
	public static final String ROLE_TYPE_3="3";
	
	public static Map<String,String>vmap=null;
	//手机请求的默认开始
	public static final int PHONE_REQ_START=0;
	//手机请求的默认条数
	public static final int PHONE_REQ_LIMIT=5;
	
}
