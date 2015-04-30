package org.hepx.proext.web.Controller;

import org.hepx.proext.exception.DoErrorException;
import org.hepx.proext.service.RoleService;
import org.hepx.proext.pojo.ModulePojo;
import org.hepx.proext.pojo.RolePojo;
import org.hepx.proext.pojo.UserInfoPojo;
import org.hepx.proext.util.LoginUserUtils;
import org.hepx.proext.web.ResponseResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    protected Logger log = Logger.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色
     * author:hepx 2011-3-9
     *
     * @return
     */
    @RequestMapping("/queryRole")
    @ResponseBody
    public Map queryRoleList() {
        ResponseResult result = new ResponseResult();
        try {
            List<RolePojo> rolePojos = roleService.queryRolePojo();
            result.setDefSucMsg();
            result.addData("rolePojos", rolePojos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
        }
        return result.toMap();
    }

    /**
     * 根据角色ID查询该角色所有的权限
     * author:hepx 2011-3-9
     *
     * @return
     */
    @RequestMapping("/queryRoleById")
    @ResponseBody
    public Map queryRoleById(Long roleId) {
        ResponseResult result = new ResponseResult();
        try {
            RolePojo rolePojo = roleService.queryRolePojoById(roleId);
            result.setDefSucMsg();
            result.addData("rolePojo", rolePojo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
        }
        return result.toMap();
    }

    /**
     * 保存和更新角色权限 author:hepx 2011-3-9
     *
     * @return
     */
    @RequestMapping("/saveOrUpdateRole")
    @ResponseBody
    public Map saveOrUpdateRole(@RequestBody RolePojo rolePojo) {
        try {
            roleService.saveRolePojo(rolePojo);
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    @RequestMapping("deleteRole")
    @ResponseBody
    public Map deleteRole(@RequestBody RolePojo rolePojo) {
        try {
            roleService.deleteRolePojo(rolePojo);
            return ResponseResult.buildSuccessResult().toMap();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseResult.buildFailResult(e).toMap();
        }
    }

    @RequestMapping("/queryModules")
    @ResponseBody
    public Map queryModules() {
        ResponseResult result = new ResponseResult();
        try {
            List<ModulePojo> modulePojos = roleService.queryModulePojos();
            result.setDefSucMsg();
            result.addData("modulePojos", modulePojos);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
        }
        return result.toMap();
    }

    @RequestMapping("/queryRoleModules")
    @ResponseBody
    public Map queryModulesByRole() {
        ResponseResult result = new ResponseResult();
        try {
            UserInfoPojo userInfo = LoginUserUtils.getLoginUserInfo();
            if (userInfo != null) {
                if (userInfo.getRoleId() != null) {
                    List<ModulePojo> modulePojos = roleService.queryModulePojos(userInfo.getRoleId());
                    result.setDefSucMsg();
                    result.addData("modulePojos", modulePojos);
                } else {
                    throw new DoErrorException("缺失必要参数！");
                }
            } else {
                throw new DoErrorException("会话超时，请重新登录！");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result.setExceptionMsg(e);
        }
        return result.toMap();
    }

}
