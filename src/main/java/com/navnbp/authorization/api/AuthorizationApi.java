package com.navnbp.authorization.api;

import org.springframework.web.bind.annotation.PathVariable;

import com.navnbp.authorization.model.AuthorizationResp;
import com.navnbp.authorization.model.GroupFunctions;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Authorization")
public interface AuthorizationApi {
	/**
	 * 
	 * @param groupNum
	 * @param relationNum
	 * @return
	 */
	@ApiOperation(value = "login", notes = "", tags = { "Policy-Server", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Logged In") })
	GroupFunctions getAllowedFunctionsByGroupNo(
			@ApiParam(value = "groupNum", required = true) @PathVariable int groupNum,
			@ApiParam(value = "relationNum", required = true) @PathVariable int relationNum);
	/**
	 * 
	 * @param groupNum
	 * @param relationNum
	 * @param functionCode
	 * @return
	 */
	@ApiOperation(value = "Validate", notes = "", tags = { "Policy-Decision", })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 201, message = "Logged In") })
	public AuthorizationResp checkAllowedFunction(
			@ApiParam(value = "groupNum", required = true) @PathVariable("groupNum") int groupNum,
			@ApiParam(value = "relationNum", required = true) @PathVariable("relationNum") int relationNum,
			@ApiParam(value = "functionCode", required = true) @PathVariable("functionCode") String functionCode);

}
