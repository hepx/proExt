package org.hepx.proext.web.Controller;

import org.hepx.proext.service.ModuleService;
import org.hepx.proext.pojo.ModulePojo;
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
 * 模块ACTION
 *
 * @author hepx
 */
@Controller
@RequestMapping("/module")
public class ModuleController {

    protected Logger log = Logger.getLogger(ModuleController.class);

    @Autowired
    private ModuleService moduleService;

    /**
     * 保存模块
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("saveModule")
    @ResponseBody
    public Map saveModule(@RequestBody ModulePojo modulePojo) {
        try {
            moduleService.saveOrUpdateModule(modulePojo);
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    /**
     * 删除模块
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteModule")
    @ResponseBody
    public Map deleteModule(@RequestBody ModulePojo modulePojo) {
        try {
            moduleService.deleteModule(modulePojo);
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    /**
     * 查询模块
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("queryModuleTreePojos")
    @ResponseBody
    public Map queryModulePojos(String node) {
        ResponseResult result = new ResponseResult();
        try {
            List<ModulePojo> moduleTreePojos = moduleService.queryModuleTreePojos("root".equals(node) ? null : new Long(node));
            result.setDefSucMsg();
            result.addData("moduleTreePojos", moduleTreePojos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
        }
        return result.toMap();
    }

}
