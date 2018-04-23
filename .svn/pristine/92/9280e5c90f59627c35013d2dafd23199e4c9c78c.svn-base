package com.rsa.dao;

import java.util.List;

import com.rsa.bean.ChannelInfo;
public interface ChannelInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ChannelInfo record);

    ChannelInfo selectByPrimaryKey(Integer id);

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
     * 根据条件查询
     * @param rsaInfo
     * @return
     */
    ChannelInfo selectByParam(ChannelInfo channelCode);
}