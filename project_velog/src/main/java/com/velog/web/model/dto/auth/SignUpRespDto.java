package com.velog.web.model.dto.auth;

import lombok.Data;

@Data
public class SignUpRespDto<T> {
	private int code;
	private T msg;
}
