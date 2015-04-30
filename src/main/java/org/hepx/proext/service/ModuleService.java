package org.hepx.proext.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hepx.proext.dao.ModuleDao;
import org.hepx.proext.entity.TbFunction;
import org.hepx.proext.entity.TbModule;
import org.hepx.proext.pojo.FunctionPojo;
import org.hepx.proext.pojo.ModulePojo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("moduleModel")
public class ModuleService {

	@Autowired
    ModuleDao moduleDao;
	
	/**
	 * 
	 * author:hepx 
	 * 2011-1-17
	 * @param modulePojo
	 * @throws Exception
	 * 保存或更新MODULE
	 */
	public void saveOrUpdateModule(ModulePojo modulePojo)throws Exception{
		TbModule tbModule=new TbModule();
		BeanUtils.copyProperties(modulePojo, tbModule);
		if(modulePojo.getParentId()!=null&&!"".equals(modulePojo.getParentId())){
			tbModule.setTbModule(new TbModule(modulePojo.getParentId()));
		}
		tbModule.setTbFunctions(paserTbFunctions(modulePojo.getFunctionPojos(),modulePojo.getId()));
		moduleDao.saveOrUpdateModule(tbModule);
	}
	
	/**
	 * 
	 * author:hepx 
	 * 2011-1-17
	 * @param modulePojo
	 * @throws Exception
	 * 删除MODULE
	 */
	public void deleteModule(ModulePojo modulePojo)throws Exception{
		if(modulePojo.getId()!=null){
			moduleDao.deleteModule(modulePojo.getId());
		}
	}
	
	/**
	 * 
	 * author:hepx 
	 * 2011-1-17
	 * @param node
	 * @return
	 * @throws Exception
	 * 查询树结构的MODULE  
	 */
	public List<ModulePojo> queryModuleTreePojos(Long node)throws Exception{
		List<TbModule> tbModuleList=moduleDao.queryTbModuleTreeList(node);
		List<ModulePojo> moduleTreePojos=new ArrayList<ModulePojo>();
		for(TbModule t:tbModuleList){
			ModulePojo pojo=new ModulePojo(t);
			moduleTreePojos.add(pojo);
		}
		return moduleTreePojos;
	}
	
	private Set<TbFunction> paserTbFunctions(List<FunctionPojo> functionPojos,Long moduleId){
		Set<TbFunction> tbFunctions=null;
		if(functionPojos!=null&&functionPojos.size()>0){
			tbFunctions=new HashSet<TbFunction>();
			for(FunctionPojo functionPojo:functionPojos){
				TbFunction tbFunction=new TbFunction(functionPojo.getId(),functionPojo.getFunctionName(),functionPojo.getType(),moduleId);
				tbFunctions.add(tbFunction);
			}
		}
		return tbFunctions;
	}
}
