package com.rsa.service;

/**
 * 检验URL是否可用
 * 
 * @date 2017年5月11日
 *
 */
public interface CheckService {

	/**
	 * 检测IP地址
	 * 
	 * @param url
	 * @return
	 */
	public boolean checkIP(String url);

	/**
	 * 检测URL
	 * 
	 * @param url
	 *            URL地址
	 * @param sign
	 *            签名
	 * @param channelCode
	 *            渠道号
	 * @return
	 */
	public boolean checkRSA(String ip, String sign, String channelCode);

}
