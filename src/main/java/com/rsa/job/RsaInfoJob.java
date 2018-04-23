package com.rsa.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.rsa.bean.ChannelInfo;
import com.rsa.service.ChannelInfoService;
/**
 * 获取所有渠道的详细信息并保存
 * @date 2017年5月12日
 *
 */
public class RsaInfoJob {
	private static  Logger log=Logger.getLogger(RsaInfoJob.class);
	//遍历出来所有信息的集合
    public static Map<String,List<String>> RSA_LIST_MAP = new HashMap<String,List<String>>();
    //以渠道号为key 对应的对象为value
//    public static Map<String,RsaInfo> RSA_INFO_MAP = new HashMap<String,RsaInfo>();
    public static Map<String,ChannelInfo> RSA_INFO_MAP = new HashMap<String,ChannelInfo>();
	
    @Autowired
//	private RsaInfoService rsaInfoService;
    private ChannelInfoService channelInfoService;
    
    @Scheduled(cron = "0 51 10 * * ?") //每天凌晨6点执行
	public void start(){
    	log.info("获取所有渠道的详细信息 start："+new Date());
    	List<ChannelInfo> list = channelInfoService.selectAll();
    	if(list==null||list.isEmpty()){
    		log.info("获取所有渠道的数量为空");
    		return;
    	}
    	
    	
    	log.info("获取所有渠道的数量为:"+list.size());
    	List<String> channelCodeList = new ArrayList<String>();//渠道
    	List<String> ipList = new ArrayList<String>();//IP
    	List<String> privateKeyList = new ArrayList<String>();//私钥
    	List<String> publicKeyList = new ArrayList<String>();//公钥
    	List<String> domainNameList = new ArrayList<String>();//域名
    	for(ChannelInfo channelInfo : list){
    		RSA_INFO_MAP.put(channelInfo.getChannelCode(), channelInfo);
    		// redis内部会创建连接池，从连接池中获取连接使用，然后再把连接返回给连接池
//    		RedisUtil.getRedis().set(rsaInfo.getChannelCode(), ToStringBuilder.reflectionToString(rsaInfo));
    		
    		channelCodeList.add(channelInfo.getChannelCode());
    		privateKeyList.add(channelInfo.getPrivateKey());
    		publicKeyList.add(channelInfo.getPublicKey());
    		domainNameList.add(channelInfo.getDomainName());
    		if(StringUtils.isNotEmpty(channelInfo.getIp())&&channelInfo.getIp().contains(";")){
				String [] rsaArray = channelInfo.getIp().split(";");
				for(String rasString : rsaArray){
					ipList.add(rasString);
				}
			}else{
				ipList.add(channelInfo.getIp());
			}
    	}
    	RSA_LIST_MAP.put("channelCodeList", channelCodeList);
    	RSA_LIST_MAP.put("ipList", ipList);
    	RSA_LIST_MAP.put("privateKeyList", privateKeyList);
    	RSA_LIST_MAP.put("publicKeyList", publicKeyList);
    	RSA_LIST_MAP.put("domainNameList", domainNameList);
    	
//    	RedisUtil.getRedis().set("channelCodeList", channelCodeList.toString());
//    	RedisUtil.getRedis().set("ipList", ipList.toString());
//    	RedisUtil.getRedis().set("privateKeyList", privateKeyList.toString());
//    	RedisUtil.getRedis().set("publicKeyList", publicKeyList.toString());
//    	RedisUtil.getRedis().set("domainNameList", domainNameList.toString());
    	log.info("获取所有渠道的详细信息 end："+new Date());
	}
}
