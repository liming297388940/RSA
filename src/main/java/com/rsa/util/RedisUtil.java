package com.rsa.util;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

	private RedisUtil() {
	};
	private static volatile JedisCluster jedisCluster;

	public static JedisCluster getRedis() {
		// 对象实例化时与否判断（不使用同步代码块，instance不等于null时，直接返回对象，提高运行效率）
		if (jedisCluster == null) {
			// 同步代码块（对象未初始化时，使用同步代码块，保证多线程访问时对象在第一次创建后，不再重复被创建）
			synchronized (RedisUtil.class) {
				// 未初始化，则初始instance变量
				if (jedisCluster == null) {
					jedisCluster = new RedisUtil().init();
				}
			}
		}
		return jedisCluster;
	}

	private static JedisCluster init() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		Set<HostAndPort> nodes1 = new HashSet<HostAndPort>();
		// HostAndPort hostAndPort = new HostAndPort("223.203.132.138", 7000);
		// HostAndPort hostAndPort1 = new HostAndPort("223.203.132.138", 7001);
		// HostAndPort hostAndPort2 = new HostAndPort("223.203.132.138", 7002);
		// HostAndPort hostAndPort3 = new HostAndPort("223.203.132.139", 7003);
		// HostAndPort hostAndPort4 = new HostAndPort("223.203.132.139", 7004);
		// HostAndPort hostAndPort5 = new HostAndPort("223.203.132.139", 7005);
//		HostAndPort hostAndPort = new HostAndPort("192.168.0.93", 7000);
//		HostAndPort hostAndPort1 = new HostAndPort("192.168.0.93", 7001);
//		HostAndPort hostAndPort2 = new HostAndPort("192.168.0.93", 7002);
//		HostAndPort hostAndPort3 = new HostAndPort("192.168.0.95", 7003);
//		HostAndPort hostAndPort4 = new HostAndPort("192.168.0.95", 7004);
//		HostAndPort hostAndPort5 = new HostAndPort("192.168.0.95", 7005);
		HostAndPort hostAndPort = new HostAndPort("192.168.1.7", 7000);
		HostAndPort hostAndPort1 = new HostAndPort("192.168.1.7", 7001);
		HostAndPort hostAndPort2 = new HostAndPort("192.168.1.8", 7000);
		HostAndPort hostAndPort3 = new HostAndPort("192.168.1.8", 7001);
		HostAndPort hostAndPort4 = new HostAndPort("192.168.1.9", 7000);
		HostAndPort hostAndPort5 = new HostAndPort("192.168.1.9", 7001);
		nodes1.add(hostAndPort);
		nodes1.add(hostAndPort1);
		nodes1.add(hostAndPort2);
		nodes1.add(hostAndPort3);
		nodes1.add(hostAndPort4);
		nodes1.add(hostAndPort5);
		JedisCluster jedisCluster = new JedisCluster(nodes1, poolConfig);
		return jedisCluster;
	}

	// public static void main(String[] args) {
	// JedisPoolConfig poolConfig = new JedisPoolConfig();
	// Set<HostAndPort> nodes1 = new HashSet<HostAndPort>();
	// HostAndPort hostAndPort = new HostAndPort("223.203.132.138", 7000);
	// HostAndPort hostAndPort1 = new HostAndPort("223.203.132.138", 7001);
	// HostAndPort hostAndPort2 = new HostAndPort("223.203.132.138", 7002);
	// HostAndPort hostAndPort3 = new HostAndPort("223.203.132.139", 7003);
	// HostAndPort hostAndPort4 = new HostAndPort("223.203.132.139", 7004);
	// HostAndPort hostAndPort5 = new HostAndPort("223.203.132.139", 7005);
	// HostAndPort hostAndPort = new HostAndPort("192.168.0.93", 7000);
	// HostAndPort hostAndPort1 = new HostAndPort("192.168.0.93", 7001);
	// HostAndPort hostAndPort2 = new HostAndPort("192.168.0.93", 7002);
	// HostAndPort hostAndPort3 = new HostAndPort("192.168.0.95", 7003);
	// HostAndPort hostAndPort4 = new HostAndPort("192.168.0.95", 7004);
	// HostAndPort hostAndPort5 = new HostAndPort("192.168.0.95", 7005);
	// nodes1.add(hostAndPort);
	// nodes1.add(hostAndPort1);
	// nodes1.add(hostAndPort2);
	// nodes1.add(hostAndPort3);
	// nodes1.add(hostAndPort4);
	// nodes1.add(hostAndPort5);
	// jedisCluster = new JedisCluster(nodes1, poolConfig);
	// // redis内部会创建连接池，从连接池中获取连接使用，然后再把连接返回给连接池
	// jedisCluster.set("a", "kkk");
	// String string = jedisCluster.get("a");
	// System.out.println(string);
	// }
}