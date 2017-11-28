package com.navnbp.authorization.service.impl;

import java.util.HashMap;
import org.springframework.stereotype.Service;

import com.navnbp.authorization.service.AuthorService;
import com.navnbp.authorization.util.GroupFunctionBuilder;
import com.navnbp.config.GroupFunctionLoader;

@Service("grpServ")
public class AuthorServiceImpl implements AuthorService {

	GroupFunctionBuilder grpFucntionBuilder;

	@Override
	public HashMap<String, String> getUsrGrpFunction(String userGroupNum) {
		System.out.println("In getUsrGrpFunction Service method");
		String propString = GroupFunctionLoader.getGroupFromProps(userGroupNum);
		System.out.println("After getUsrGrpFunction Service method");
		HashMap<String, String> allowedOwnerFunctions = new HashMap<String, String>();
		grpFucntionBuilder = new GroupFunctionBuilder();
		allowedOwnerFunctions = grpFucntionBuilder.getFunctionMap(propString);
		return allowedOwnerFunctions;
	}

	@Override
	public HashMap<String, String> getUserRelationshipFunctions(String userRelationshipNum) {
		System.out.println("In getUserRelationshipFunctions Service method");
		String propString = GroupFunctionLoader.getGroupFromProps(userRelationshipNum);
		System.out.println("After getUserRelationshipFunctions Service method");
		HashMap<String, String> allowedRelationShipFunctions = new HashMap<String, String>();
		grpFucntionBuilder = new GroupFunctionBuilder();
		allowedRelationShipFunctions = grpFucntionBuilder.getFunctionMap(propString);
		return allowedRelationShipFunctions;

	}

	@Override
	public HashMap<String, String> getGroupAllowedFunctions(String groupNum, String relationNum) {
		HashMap<String, String> ownerGroupFunctions = new HashMap<String, String>();
		ownerGroupFunctions = getUsrGrpFunction(String.valueOf(groupNum));
		HashMap<String, String> relationshipFunctions = new HashMap<String, String>();
		relationshipFunctions = getUserRelationshipFunctions(String.valueOf(relationNum));
		HashMap<String, String> allowedUserFunctions = new HashMap<String, String>();
		allowedUserFunctions.putAll(ownerGroupFunctions);
		allowedUserFunctions.putAll(relationshipFunctions);
		return allowedUserFunctions;
	}

	@Override
	public boolean isFunctionAllowed(String functionCode, HashMap<String, String> allowedFunctions) {
		boolean isAllowed = false;
		if (allowedFunctions.containsKey(functionCode)) {
			isAllowed = true;
		}
		return isAllowed;
	}
}
