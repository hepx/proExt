package org.hepx.proext.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.hepx.proext.dao.ModuleDao;
import org.hepx.proext.dao.RoleDao;
import org.hepx.proext.entity.TbFunction;
import org.hepx.proext.entity.TbModule;
import org.hepx.proext.entity.TbRole;
import org.hepx.proext.pojo.DicInfo;
import org.hepx.proext.pojo.ModulePojo;
import org.hepx.proext.pojo.RolePojo;
import org.hepx.proext.util.SysConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;
	@Autowired
	private ModuleDao moduleDao;
	@Autowired
	private DicService dicService;

	/**
	 * author:hepx 2011-1-17
	 * 
	 * @return
	 * @throws Exception
	 *             查询ROLE
	 */
	public List<RolePojo> queryRolePojo() throws Exception {
		List<TbRole> list = roleDao.queryTbRoles();
		List<RolePojo> rolePojos = new ArrayList<RolePojo>();
		for (TbRole t : list) {
			RolePojo rolePojo = new RolePojo(t.getId(), t.getRoleName(), t
					.getRoleType(), t.getRoleCode(), t.getRoleDesc());
			rolePojos.add(rolePojo);
		}
		return rolePojos;
	}

	/**
	 * 
	 * author:hepx 2011-1-17
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 *             根据ROLE ID 查询对应的权限
	 */
	public RolePojo queryRolePojoById(Long id) throws Exception {
		TbRole tbRole = roleDao.queryTbRoleById(id);
		RolePojo rolePojo = null;
		if (tbRole != null) {
			rolePojo = new RolePojo(tbRole.getId(), tbRole.getRoleName(),
					tbRole.getRoleType(), tbRole.getRoleCode(), tbRole
							.getRoleDesc(), tbRole.getTbModules(), tbRole
							.getTbFunctions());
		}
		return rolePojo;
	}

	/**
	 * author:hepx 2011-1-17
	 * 
	 * @param rolePojos
	 * @throws Exception
	 *             保存 ROLE
	 */
	public void saveRolePojo(RolePojo rolePojo) throws Exception {
		if (rolePojo != null) {
			DicInfo dicInfo = dicService.querydicInfo(SysConfig.ROLE_TYPE,
					rolePojo.getRoleType());
			TbRole tbRole = new TbRole(rolePojo.getId(),
					rolePojo.getRoleName(), dicInfo.getDicValue(), dicInfo
							.getDicCode(), rolePojo.getRoleDesc());
			Set<TbModule> tbModules = buildTbModules(rolePojo.getModuleIds());
			Set<TbFunction> tbFunctions = buildTbFunctions(rolePojo
					.getFunctionIds());
			tbRole.setTbModules(tbModules);
			tbRole.setTbFunctions(tbFunctions);
			roleDao.saveOrUpdateTbRole(tbRole);
		}
	}

	/**
	 * author:hepx 2011-1-17
	 * 
	 * @param rolePojo
	 * @throws Exception
	 *             删除ROLE
	 */
	public void deleteRolePojo(RolePojo rolePojo) throws Exception {
		if (rolePojo.getId() != null && !"".equals(rolePojo.getId())) {
			roleDao.deleteTbRole(rolePojo.getId());
		}
	}

	/**
	 * 
	 * author:hepx 2011-1-17
	 * 
	 * @return
	 * @throws Exception
	 *             查询所有已级存在的模块
	 */
	public List<ModulePojo> queryModulePojos() throws Exception {
		List<TbModule> tbModules = moduleDao.queryTbModuleTreeList(null);// 查询出一级
		List<ModulePojo> modulePojos = new ArrayList<ModulePojo>();
		//递归调用得到
		buildModule(modulePojos, new TreeSet<TbModule>(tbModules),1,null);
		return modulePojos;
	}
	/**
	 * 找到指定角色对应的模块
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public List<ModulePojo> queryModulePojos(Long roleId) throws Exception {
		List<TbModule> tbModules = moduleDao.queryTbModuleTreeList(null,roleId);//查出一级
		List<ModulePojo> modulePojos = new ArrayList<ModulePojo>();
		//递归调用得到
		buildModule(modulePojos, new TreeSet<TbModule>(tbModules),2,roleId);
		return modulePojos;
	}
	
	public void buildModule(List<ModulePojo>modulePojos,Set<TbModule>tbModules,int type,Long roleId)throws Exception{
		ModulePojo modulePojo=null;
		for(TbModule tbModule :tbModules){
			Set<TbModule> tbList=null;
			if(type==1){
				modulePojo = getModulePojo(tbModule);
				tbList=tbModule.getTbModules();
			}else{
				modulePojo = new ModulePojo(tbModule);
				tbList=new TreeSet<TbModule>(moduleDao.queryTbModuleTreeList(tbModule.getId(),roleId));
			}
			if(tbList!=null&&tbList.size()>0){
				buildModule(modulePojo, tbList,type,roleId);
			}
			modulePojos.add(modulePojo);
		}
	}
	
	public void buildModule(ModulePojo modulePojo,Set<TbModule>tbModules,int type,Long roleId)throws Exception{
		List<ModulePojo>modulePojos=new ArrayList<ModulePojo>();
		for(TbModule tbModule :tbModules){
			ModulePojo pojo = null;
			Set<TbModule> tbList=null;
			if(type==1){
				pojo = getModulePojo(tbModule);
				tbList=tbModule.getTbModules();
			}else{
				pojo = new ModulePojo(tbModule);
				tbList = new TreeSet<TbModule>(moduleDao.queryTbModuleTreeList(tbModule.getId(), roleId));
			}
			modulePojos.add(pojo);
			if(tbList!=null&&tbList.size()>0){
				buildModule(pojo, tbList,type,roleId);
			}
		}
		modulePojo.setModulePojos(modulePojos);
	}

	private ModulePojo getModulePojo(TbModule tbModule) {
		return new ModulePojo(tbModule.getId(), tbModule.getText(),
				tbModule.getTbFunctions());
	}

	private Set<TbModule> buildTbModules(List<Long> moduleIds) {
		Set<TbModule> tbModules = null;
		if (moduleIds != null && moduleIds.size() > 0) {
			tbModules = new HashSet<TbModule>();
			for (Long id : moduleIds) {
				TbModule tbModule = new TbModule(id);
				tbModules.add(tbModule);
			}
		}
		return tbModules;
	}

	private Set<TbFunction> buildTbFunctions(List<Long> functionIds) {
		Set<TbFunction> tbFunctions = null;
		if (functionIds != null && functionIds.size() > 0) {
			tbFunctions = new HashSet<TbFunction>();
			for (Long id : functionIds) {
				TbFunction tbFunction = new TbFunction(id);
				tbFunctions.add(tbFunction);
			}
		}
		return tbFunctions;
	}
}
