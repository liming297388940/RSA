package com.rsa.util;


import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
public class JsonUtil {
	
	public static String toJson(int state ,String msg,Object data){
		JSONObject json = new JSONObject();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("state", state);
		map.put("msg", msg);
		map.put("data", data);
		/*json.put("state", state);
		json.put("msg", msg);
		json.put("data", data);*/
		//System.out.println(json.toJSONString());
		return json.toJSONString(map,SerializerFeature.DisableCircularReferenceDetect);
	}	
}
