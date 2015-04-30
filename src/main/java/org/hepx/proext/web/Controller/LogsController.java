package org.hepx.proext.web.Controller;

import org.hepx.proext.service.LogsService;
import org.hepx.proext.pojo.Page;
import org.hepx.proext.pojo.LogsPojo;
import org.hepx.proext.web.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 系统日志
 */
@Controller
@RequestMapping("/logs")
public class LogsController {

	private static Logger log=Logger.getLogger(LogsController.class);

	@Autowired
	private LogsService logsService;
	
	@RequestMapping("queryLogs")
	@ResponseBody
    public Map queryLogs(int start,int limit){
        ResponseResult result = new ResponseResult();
		try{
            List<LogsPojo> logsPojos=logsService.queryLogsPojos(start,limit);
            long total = logsService.getLogsCounts();
            Page<LogsPojo> page =new Page<LogsPojo>(start,limit,total,logsPojos);
            result.setDefSucMsg();
            result.addPageResult(page);
		}catch(Exception e){
			log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
		}
        return result.toMap();

	}

	@RequestMapping("deleteLogs")
    @ResponseBody
	public Map deleteLogs(@RequestBody List<LogsPojo> logsPojos){
		try{
			logsService.deleteLogsPojos(logsPojos);
            return ResponseResult.buildSuccessResult().toMap();
		}catch(Exception e){
			log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
		}
	}

}
