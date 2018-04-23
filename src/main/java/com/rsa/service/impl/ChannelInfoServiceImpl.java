package com.rsa.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.rsa.bean.ChannelInfo;
import com.rsa.bean.RsaInfo;
import com.rsa.dao.ChannelInfoMapper;
import com.rsa.service.ChannelInfoService;

/**
 * 渠道相关接口
 * @date 2017年6月21日
 *
 */
@Service("channelInfoService")
public class ChannelInfoServiceImpl implements ChannelInfoService {
	@Resource
	ChannelInfoMapper channelInfoMapper;
	/**
	 * 删除渠道
	 * @param id
	 * @return
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return channelInfoMapper.deleteByPrimaryKey(id);
	}
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	@Override
	public int insert(ChannelInfo record) {
		return channelInfoMapper.insert(record);
	}
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	@Override
	public ChannelInfo selectByPrimaryKey(Integer id) {
		return channelInfoMapper.selectByPrimaryKey(id);
	}
	/**
	 * 修改
	 * @param record
	 * @return
	 */
	@Override
	public int updateByPrimaryKeySelective(ChannelInfo record) {
		return channelInfoMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * 根据渠道编号查询渠道信息
	 * @param channelCode
	 * @return
	 */
	@Override
	public ChannelInfo queryByChannelCode(String channelCode) {
		return channelInfoMapper.queryByChannelCode(channelCode);
	}
	/**
     * 查询所有
     * @return
     */
	@Override
	public List<ChannelInfo> selectAll() {
		return channelInfoMapper.selectAll();
	}
	/**
     * 查询所有IP地址
     * @return
     */
	@Override
	public List<String> getAllIp() {
		List<ChannelInfo> list = selectAll();
		List<String> returnList = new ArrayList<String>();
		for(ChannelInfo channelInfo : list){
			if(StringUtils.isNotEmpty(channelInfo.getIp())&&channelInfo.getIp().contains(";")){
				String [] rsaArray = channelInfo.getIp().split(";");
				for(String rasString : rsaArray){
					returnList.add(rasString);
				}
			}else{
				returnList.add(channelInfo.getIp());
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
		List<ChannelInfo> list = selectAll();
		List<String> returnList = new ArrayList<String>();
		for(ChannelInfo channelInfo : list){
			returnList.add(channelInfo.getChannelCode());
		}
		return returnList;
	}
}
