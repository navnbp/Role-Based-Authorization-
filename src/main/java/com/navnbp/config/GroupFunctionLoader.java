package com.navnbp.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import com.navnbp.authorization.api.AuthorizationController;

public class GroupFunctionLoader {

	public static String getGroupFromProps(String userGroupNum) {
		System.out.println("In getUsrGrpFunction method" + userGroupNum);
		Properties userGroupInfo = new Properties();
		InputStream input;
		String functionsStr = null;
		Set<String> propertyKeys = null;
		try {
			input = AuthorizationController.class.getResourceAsStream("/groupinfo.properties");
			userGroupInfo.load(input);
			System.out.println("Property File Loaded Succesfully");
			propertyKeys = userGroupInfo.stringPropertyNames();
			for (String userInfoKey : propertyKeys) {
				System.out.println(userInfoKey + ":" + userGroupInfo.getProperty(userInfoKey));
				System.out.println("Group Name: " + userInfoKey);
				if (userGroupNum.equalsIgnoreCase(userInfoKey)) {
					System.out.println("Group Name found.");
					functionsStr = userGroupInfo.getProperty(userInfoKey);
					break;
				}
			}
			if (functionsStr == null || functionsStr.isEmpty()) {
				System.out.println("No such Group Name found.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// return propertyNames;
		return functionsStr;
	}
}
