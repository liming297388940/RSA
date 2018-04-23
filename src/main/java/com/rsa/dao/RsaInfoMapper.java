package com.rsa.dao;

import java.util.List;

import com.rsa.bean.RsaInfo;

public interface RsaInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RsaInfo record);

    RsaInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RsaInfo record);
    /**
     * 根据条件查询
     * @param rsaInfo
     * @return
     */
    RsaInfo selectByParam(RsaInfo rsaInfo);
    /**
     * 查询所有
     * @return
     */
    List<RsaInfo> selectAll();
}