package com.navnbp.authorization.api;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navnbp.authorization.model.AuthorizationResp;
import com.navnbp.authorization.model.GroupFunctions;
import com.navnbp.authorization.service.AuthorService;

@RestController
@RequestMapping("/mckesson/")
public class AuthorizationController implements AuthorizationApi {

	@Autowired
	AuthorService grpServ;

	@Override
	@RequestMapping(value = "/radar/functions/{groupNum}/{relationNum}", method = RequestMethod.GET)
	public GroupFunctions getAllowedFunctionsByGroupNo(@PathVariable int groupNum, @PathVariable int relationNum) {
		System.out.println("In controller method");
		HashMap<String, String> allowedUserFunctions = new HashMap<String, String>();
		allowedUserFunctions = grpServ.getGroupAllowedFunctions(String.valueOf(groupNum),
				(String.valueOf(relationNum)));
		GroupFunctions grpFunctions = new GroupFunctions();
		grpFunctions.setGrpFunctions(allowedUserFunctions);
		return grpFunctions;
	}

	@Override
	@RequestMapping(value = "/authorize/{groupNum}/{relationNum}/{functionCode}", method = RequestMethod.GET, produces="application/json")
	public AuthorizationResp checkAllowedFunction(@PathVariable("groupNum") int groupNum,@PathVariable("relationNum") int relationNum,
			@PathVariable("functionCode") String functionCode) {
		System.out.println("In controller method");
		System.out.println("In controller method, function code :"+ functionCode);
		String allowed="false";
		HashMap<String, String> allowedUserFunctions = new HashMap<String, String>();
		AuthorizationResp resp= new AuthorizationResp();
		allowedUserFunctions = grpServ.getGroupAllowedFunctions(String.valueOf(groupNum),
				(String.valueOf(relationNum)));
		System.out.println("After Hash method");
		boolean iaAllowed=grpServ.isFunctionAllowed(functionCode, allowedUserFunctions);
		if(iaAllowed){
			allowed="true";
			resp.setIsAllowed(allowed);
			resp.setMsgDesc("Function Allowed");
		}else{
			resp.setIsAllowed("false");
			resp.setMsgDesc("Function Not Allowed");
		}
		return resp;
	}

}
