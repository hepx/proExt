package org.hepx.proext.dao;

import java.util.List;

import org.hepx.proext.entity.TbDicInfo;
import org.springframework.stereotype.Repository;

@Repository("dicInfoDao")
public class DicInfoDao extends AbstractDao<TbDicInfo> {

	public List<TbDicInfo> queryTbDicInfos(String dicGroup)throws Exception{
		String hql="from TbDicInfo T where T.dicGroup=?";
		return list(hql, new String[]{dicGroup});
	}
	
	public TbDicInfo queryTbDicInfo(String dicGroup,String dicValue)throws Exception{
		String hql="from TbDicInfo T where T.dicGroup=? and dicValue=?";
		List<TbDicInfo> tbDicInfos=list(hql, new String[]{dicGroup,dicValue});
		if(tbDicInfos!=null&&tbDicInfos.size()>0){
			return tbDicInfos.get(0);
		}else{
			return null;
		}
	}
}
