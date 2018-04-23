package com.rsa.service;

import java.util.List;

import com.rsa.bean.ChannelInfo;
import com.rsa.bean.RsaInfo;
/**
 * 渠道相关接口
 * @date 2017年6月21日
 *
 */
public interface ChannelInfoService {
	/**
	 * 删除渠道
	 * @param id
	 * @return
	 */
	int deleteByPrimaryKey(Integer id);
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	int insert(ChannelInfo record);
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	ChannelInfo selectByPrimaryKey(Integer id);
	/**
	 * 修改
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(ChannelInfo record);
	/**
	 * 根据渠道编号查询渠道信息
	 * @param channelCode
	 * @return
	 */
	ChannelInfo queryByChannelCode(String channelCode);
	
	/**
     * 查询所有
     * @return
     */
    List<ChannelInfo> selectAll();
    /**
     * 查询所有IP地址
     * @return
     */
    List<String> getAllIp();
    /**
     * 查询所有渠道
     * @return
     */
    List<String> getAllChannelCode();

}
