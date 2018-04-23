package com.rsa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.rsa.bean.RsaInfo;
import com.rsa.dao.RsaInfoMapper;
import com.rsa.service.RsaInfoService;

@Service("rsaInfoService")
public class RsaInfoServiceImpl implements RsaInfoService{
	
	@Resource
	private RsaInfoMapper rsaInfoMapper;
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return rsaInfoMapper.deleteByPrimaryKey(id);
	}
	/**
     * 新增
     * @param record
     * @return
     */
	@Override
	public int insert(RsaInfo record) {
		return rsaInfoMapper.insert(record);
	}
	/**
     * 根据条件查询
     * @param id
     * @return
     */
	@Override
	public RsaInfo selectByParam(RsaInfo rsaInfo) {
		return rsaInfoMapper.selectByParam(rsaInfo);
	}
	/**
     * 修改
     * @param record
     * @return
     */
	@Override
	public int updateByPrimaryKeySelective(RsaInfo record) {
		return rsaInfoMapper.updateByPrimaryKeySelective(record);
	}
	/**
     * 查询所有
     * @return
     */
	@Override
	public List<RsaInfo> selectAll() {
		return rsaInfoMapper.selectAll();
	}
	/**
     * 查询所有IP地址
     * @return
     */
	@Override
	public List<String> getAllIp() {
		List<RsaInfo> list = selectAll();
		List<String> returnList = new ArrayList<String>();
		for(RsaInfo rsaInfo : list){
			if(rsaInfo.getIp().contains(";")){
				String [] rsaArray = rsaInfo.getIp().split(";");
				for(String rasString : rsaArray){
					returnList.add(rasString);
				}
			}else{
				returnList.add(rsaInfo.getIp());
			}
		}
		return returnList;
	}
	/**
     * 查询所有渠道
     * @return
     */
	@Override
	public List<String> getAllChannelCode() {
		List<RsaInfo> list = selectAll();
		List<String> returnList = new ArrayList<String>();
		for(RsaInfo rsaInfo : list){
			returnList.add(rsaInfo.getChannelCode());
		}
		return returnList;
	}
}
