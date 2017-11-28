package com.navnbp.authorization.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * 
 * Class to format function details into <Key, Value> Pair
 *
 */
public class GroupFunctionBuilder {
	
	String[] grpDetails = null;
	List<String> funcList = null;
	HashMap<String, String> allowedFunctions=null;
	/**
	 * Method to return function details as Map
	 * @param groupString
	 * @return
	 */
	public HashMap<String, String> getFunctionMap(String groupString){
		System.out.println("In getFunctionMap method");
		funcList = new ArrayList<String>();
		allowedFunctions = new HashMap<String, String>();		
		if (!groupString.isEmpty() || groupString != null) {
			funcList = Arrays.asList(groupString.split("\\s*,\\s*"));
			for (String func : funcList) {
				grpDetails = new String[2];
				grpDetails = func.split("=");
				allowedFunctions.put(grpDetails[0], grpDetails[1]);
			}
		}		
		return allowedFunctions;		
	}
}
