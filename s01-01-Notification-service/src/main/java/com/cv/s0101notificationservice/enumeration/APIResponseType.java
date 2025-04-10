package com.cv.s0101notificationservice.enumeration;

import lombok.Getter;

@Getter
public enum APIResponseType {

	MESSAGE_ACTUAL(0), MESSAGE_CODE(1), MESSAGE_CODE_LIST(2), OBJECT_ONE(3), OBJECT_LIST(4);

	private int value;

	APIResponseType(int value) {
		this.value = value;
	}

}
