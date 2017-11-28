package com.navnbp.authorization.service;

import java.util.HashMap;
/**
 * 
 * Services to perform various operations on policy server (mock up)
 *
 */
public interface AuthorService {
	/**
	 * method to get owner functions using group number read from property file
	 * @param grpNum
	 * @return
	 */
	public HashMap<String, String> getUsrGrpFunction(String grpNum);

	/**
	 * Method to fetch user relationship functions 
	 * @param relationNum
	 * @return
	 */
	public HashMap<String, String> getUserRelationshipFunctions(String relationNum);

	/**
	 * Method to consolidate all user related functions based on owner and relationship
	 * @param groupNum
	 * @param relationNum
	 * @return
	 */
	public HashMap<String, String> getGroupAllowedFunctions(String groupNum, String relationNum);

	/**
	 * Method to check whether user is allowed to perform requested function
	 * @param functionCode - requested function
	 * @param allowedFunctions
	 * @return
	 */
	public boolean isFunctionAllowed(String functionCode, HashMap<String, String> allowedFunctions);

}