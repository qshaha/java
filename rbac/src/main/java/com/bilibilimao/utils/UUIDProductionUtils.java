package com.bilibilimao.utils;

import java.util.UUID;

public class UUIDProductionUtils {
	public static String getUUID() {
		return(UUID.randomUUID().toString());
	}
	public static String getUUIDRemoveBar() {
		return(UUIDProductionUtils.getUUID().replaceAll("-", "").toLowerCase());
	}
}