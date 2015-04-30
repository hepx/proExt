package org.hepx.proext.web.Controller;

import org.hepx.proext.service.DicService;
import org.hepx.proext.pojo.DicInfo;
import org.hepx.proext.web.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dic")
public class DicInfoController {

	protected Logger log=Logger.getLogger(DicInfoController.class);
	
	@Autowired
	private DicService dicService;
	
	/**
	 * 
	 * @author : hepx 
	 * @date : 2011-3-11下午12:23:51
	 * @description : 查询字典消息
	 * @return : String
	 */
	@RequestMapping("/queryDicInfo")
    @ResponseBody
	public Map queryDicInfo(String dicGroup){
        ResponseResult result = new ResponseResult();
        try{
			List<DicInfo> dicInfos=dicService.queryDicInfos(dicGroup);
            result.setDefSucMsg();
            result.addData("dicInfos",dicInfos);
		}catch(Exception e){
			log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
		}
		return result.toMap();
	}

}
