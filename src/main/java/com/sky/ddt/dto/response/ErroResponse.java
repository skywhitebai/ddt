package com.sky.ddt.dto.response;

import com.sky.ddt.common.enums.response.IResponseBaseEnum;

import java.io.Serializable;

public class ErroResponse implements Serializable {
	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static ErroResponse erroEnum(IResponseBaseEnum baseEnum) {
		ErroResponse erroResponse=new ErroResponse();
		erroResponse.setCode(baseEnum.getCode());
		erroResponse.setMessage(baseEnum.getMessage());
		return erroResponse;
	}
}
