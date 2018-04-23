package com.rsa.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ManagerResources extends PropertyPlaceholderConfigurer{


	private static final Logger logger  = Logger.getLogger(ManagerResources.class);
	private static Map<String, Object> resourcesMap = new HashMap<String, Object>();
	
	  
    protected void processProperties(
            ConfigurableListableBeanFactory beanFactoryToProcess,
            Properties props) throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        if (resourcesMap != null) {
            logger.warn("The property map will be override!");
        }
        resourcesMap = new HashMap<String, Object>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            resourcesMap.put(keyStr, value);
        }
    }
    public static Object get(String name) {
        if (resourcesMap == null) {
        	resourcesMap = new HashMap<String, Object>();
        }
        return resourcesMap.get(name);
    }
    public static void set(String key,Object value){
    	resourcesMap.put(key, value);
    }
    public static void set(Map<String,Object> keyandvalue){
    	if(keyandvalue !=null){
    		for(Map.Entry<String, Object> entry:keyandvalue.entrySet()){
    			resourcesMap.put(entry.getKey(), entry.getValue());
    		}
    	}
    }
}
