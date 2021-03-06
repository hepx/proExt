package org.hepx.proext.web;


import org.hepx.proext.pojo.Page;
import org.apache.poi.hssf.record.formula.functions.T;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * web层使用的Json结果集
 *
 * @author: hepx
 * @Date: 14-8-21 下午6:23
 * @Version: 1.0
 */
public class ResponseResult implements Serializable {

    public final static int RESULT_SUCCESS = 1; //成功
    public final static int RESULT_FAil = 0; //失败
    public final static String UN_KNOW_EXCEPTION = "服务器出现未知异常";
    public final static String NOT_FIND_RESOURCE = "访问的资源不存在";
    public final static String MISS_PARAM_RESOURCE = "请求参数异常";
    public final static String SUCCESS_MSG = "系统处理成功";

    //日志输出模板
    public final static String LOGGER_TEMPLATE ="error:{},params:{}。";

    private final String KEY_RESULT = "code";
    private final String KEY_MSG = "msg";

    /**
     * 数据
     */
    private Map<String, Object> dataMap;

    public ResponseResult() {
        dataMap = new HashMap<String, Object>();
    }

    /**
     * 构造成功的响应信息
     *
     * @param msg
     */
    private ResponseResult(String msg) {
        dataMap = new HashMap<String, Object>();
        setResult(RESULT_SUCCESS);
        setMsg(msg);
    }

    /**
     * 构造指定结果状态响应信息
     *
     * @param result
     */
    private ResponseResult(int result) {
        dataMap = new HashMap<String, Object>();
        setResult(result);
    }

    /**
     * 以消息和响应码来构造信息
     *
     * @param msg
     */
    private ResponseResult(int result, String msg) {
        dataMap = new HashMap<String, Object>();
        setResult(result);
        setMsg(msg);
    }

    /**
     * 返回json对象
     *
     * @return
     */
    public String toJson() {
        //return .objectToJson(this.dataMap);
         return null;
    }

    /**
     * 直接写入客户端
     *
     * @param response
     * @throws java.io.IOException
     */
    public void toJson(HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(toJson());
    }

    /**
     * 返回MAP数据对象
     *
     * @return
     */
    public Map<String, Object> toMap() {
        return this.dataMap;
    }

    /**
     * 加入数据项到MAP
     *
     * @param name
     * @param value
     */
    public void addData(String name, Object value) {
        dataMap.put(name, value);
    }

    /**
     * 添加分页数据
     * @param page
     */
    public void addPageResult(Page page){
        if(page!=null){
            addPageData(page.getStart(),page.getLimit(),page.getTotal(),page.getDataList());
        }
    }

    public void addPageData(int start,int limit,long total, List<T> dataList){
        dataMap.put("start",start);
        dataMap.put("limit",limit);
        dataMap.put("total",total);
        dataMap.put("dataList",dataList);
    }

    /**
     * 合并MAP中的数据
     * @param map
     */
    public void mergerMap(Map<String,Object> map){
        dataMap.putAll(map);
    }

    /**
     * 设置默认的失败标志
     */
    public void setDefFailMsg(){
        setResult(RESULT_FAil);
        setMsg(UN_KNOW_EXCEPTION);
    }

    /**
     * 设置异常信息
     * @param e
     */
    public void setExceptionMsg(Exception e){
        setResult(RESULT_FAil);
        setMsg(buildErrorMessage(e));
    }

    /**
     * 设置默认的成功标志
     */
    public void setDefSucMsg(){
        setResult(RESULT_SUCCESS);
        setMsg(SUCCESS_MSG);
    }

    public void setResult(int result) {
        if(result==RESULT_FAil){//如果是失败的结果，清除之前加入MAP中的数据
            dataMap.clear();
        }
        dataMap.put(KEY_RESULT, result);
    }

    public void setMsg(String msg) {
        dataMap.put(KEY_MSG, msg);
    }

    public static ResponseResult buildSuccessResult(){
        ResponseResult result = new ResponseResult();
        result.setDefSucMsg();
        return  result;
    }

    public static ResponseResult buildSuccessResult(String msg){
        ResponseResult result = new ResponseResult();
        result.setMsg(msg);
        return  result;
    }

    public static ResponseResult buildFailResult(){
        ResponseResult result = new ResponseResult();
        result.setDefFailMsg();
        return result;
    }

    public static ResponseResult buildFailResult(Exception e){
        ResponseResult result = new ResponseResult();
        result.setExceptionMsg(e);
        return result;
    }

    public String buildErrorMessage(String errorMessage) {
        return "系统异常:"+(errorMessage==null?"null":errorMessage);
    }

    public String buildErrorMessage(Exception e){
        String errorMessage =null;
        String exceptionName = e.getClass().getSimpleName();
        if("DoErrorException".equals(exceptionName)){
            errorMessage=e.getMessage();
        }else if("DataAccessException".equals(exceptionName)) {
            errorMessage="数据库操作失败！";
        }else if("NullPointerException".equals(exceptionName)){
            errorMessage="调用了未经初始化的对象或者是不存在的对象！";
        }else if("IOException".equals(exceptionName)) {
            errorMessage="IO异常！";
        }else if("ClassNotFoundException".equals(exceptionName)) {
            errorMessage="指定的类不存在！";
        }else if("ArithmeticException".equals(exceptionName)) {
            errorMessage=("数学运算异常！");
        }else if("ArrayIndexOutOfBoundsException".equals(exceptionName)) {
            errorMessage="数组下标越界!";
        }else if("IllegalArgumentException".equals(exceptionName)) {
            errorMessage="方法的参数错误！";
        }else if("ClassCastException".equals(exceptionName)) {
            errorMessage="类型强制转换错误！";
        }else if("SecurityException".equals(exceptionName)) {
            errorMessage="违背安全原则异常！";
        }else if("SQLException".equals(exceptionName)) {
            errorMessage="操作数据库异常！";
        }else if("NoSuchMethodError".equals(exceptionName)) {
            errorMessage="方法末找到异常！";
        }else if("InternalError".equals(exceptionName)) {
            errorMessage="Java虚拟机发生了内部错误！";
        }else if("SchedulerException".equals(exceptionName)){
            errorMessage="JOB任务调度出现异常！";
        }else if("DataIntegrityViolationException".equals(exceptionName)){
            errorMessage="数据完整性冲突异常！";
        }else{
            errorMessage="程序内部错误，操作失败！";
        }
        return errorMessage;
    }
}
