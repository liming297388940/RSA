package com.rsa.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsa.bean.ChannelInfo;
import com.rsa.job.RsaInfoJob;
import com.rsa.rsa.Base64;
import com.rsa.rsa.RSAEncrypt;
import com.rsa.service.ChannelInfoService;
import com.rsa.service.CheckService;

/**
 * 检验URL是否可用
 * @date 2017年5月11日
 *
 */
@Service("checkService")
public class CheckServiceImpl implements CheckService{
	private static final Logger log = Logger.getLogger(CheckServiceImpl.class);
	@Autowired
//	private RsaInfoService rsaInfoService;
	private ChannelInfoService channelInfoService;
	/**
	 * 检测IP地址 ---暂时不用
	 * @param url
	 * @return
	 */
	@Override
	public boolean checkIP(String url){
//		int firstNum = 0;
//		for(int i =0;i<url.length();i++){
//			char a = url.charAt(i);
//			if(a>'0'&&a<='9'){
//				firstNum = i;
//				break;
//			}
//		}
//		if(firstNum==0){//URL中没有数字
//			return false;
//		}
//		url = url.substring(firstNum);
		log.info(url);
		if(url.contains(":")){
			url = url.substring(0, url.indexOf(":"));
		}
		log.info(url);
		//去数据库查询 看是否存在这个IP地址或者域名
		List<String> ipList = RsaInfoJob.RSA_LIST_MAP.get("ipList");
		if(ipList==null||ipList.isEmpty()){
			ipList = channelInfoService.getAllIp();
			RsaInfoJob.RSA_LIST_MAP.put("ipList", ipList);
			//去redis取值，暂时不用
//			String ips = RedisUtil.getRedis().get("ipList");
		}
		if(ipList.contains(url)){
			return true;
		}
		return false;
	}
	/**
	 * 检测URL
	 * @param url URL地址
	 * @param sign 签名
	 * @param channelCode 渠道号
	 * @return
	 */
	@Override
	public boolean checkRSA(String ip,String sign,String channelCode){
		log.info("===checkRSA:"+channelCode+",ip:"+ip);
//		if(checkIP(url)){//暂时不用校验URL
			//需要用私钥进行解密
			ChannelInfo channelInfo = RsaInfoJob.RSA_INFO_MAP.get(channelCode);
			if(channelInfo==null){
				channelInfo = channelInfoService.queryByChannelCode(channelCode);
				//去redis取值，暂时不用
//				String rsa = RedisUtil.getRedis().get(channelCode);
//				log.info("rsa"+rsa);
				if(channelInfo==null){
					return false;
				}
			}
			RsaInfoJob.RSA_INFO_MAP.put(channelCode, channelInfo);
			String privateKey = channelInfo.getPrivateKey();
			log.info("===privateKey:"+privateKey);
			byte[] res = null;
			try {
				//解密操作
				res = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), Base64.decode(sign));
			} catch (Exception e) {
				e.printStackTrace();
			}
			String returnSign=new String(res);
			String [] signArray = returnSign.split("&");
			if(checkChannelCode(signArray)){
				log.info(channelCode+",渠道验证通过");
				return checkIp(signArray,ip);
			}
			
//		}
		return false;
	}
	/**
	 * 校验渠道号
	 * @param signArray
	 * @return
	 */
	public boolean checkChannelCode(String [] signArray){
		String cCode = "";//渠道号
		for(String str : signArray){
			if(str.contains("channelCode")){
				cCode = str;
				break;
			}
		}
		if(StringUtils.isNotEmpty(cCode)){
			cCode = cCode.substring(cCode.indexOf("=")+1);
		}
		List<String> channelCodeList = RsaInfoJob.RSA_LIST_MAP.get("channelCodeList");
		if(channelCodeList==null||channelCodeList.isEmpty()){
			//取数据库取值
			channelCodeList = channelInfoService.getAllChannelCode();
			RsaInfoJob.RSA_LIST_MAP.put("channelCodeList", channelCodeList);
		}
		if(channelCodeList.contains(cCode)){
			return true;
		}
		return false;
	}
	
	/**
	 * 校验IP地址
	 * @param signArray
	 * @return
	 */
	public boolean checkIp(String [] signArray,String incomeIp){
		String ip = "";//渠道号
		for(String str : signArray){
			if(str.contains("ip")){
				ip = str;
				break;
			}
		}
		log.info("====解密得到的IP:"+ip);
		if(StringUtils.isNotEmpty(ip)){
			ip = ip.substring(ip.indexOf("=")+1);
		}
		log.info("====解密得到的IP:"+ip);
		//暂时去掉解密的和传入的ip地址一致性的验证
//		if(!ip.equals(incomeIp)){
//			log.info("解密的IP："+ip+"和传入的IP："+incomeIp+",不一样");
//			return false;
//		}
		List<String> ipList = RsaInfoJob.RSA_LIST_MAP.get("ipList");
		if(ipList==null||ipList.isEmpty()){
			//取数据库取值
			ipList = channelInfoService.getAllIp();
			RsaInfoJob.RSA_LIST_MAP.put("ipList", ipList);
		}
		if(ipList.contains(ip)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String code = "channel=A123";
		System.out.println(code.substring(code.indexOf("=")+1));
	}
}
