package com.bilibilimao.utils;

import java.util.Base64;
import com.bilibilimao.po.User;
import redis.clients.jedis.Jedis;

public class SessionUtils {
	private static Jedis jedis = new Jedis("127.0.0.1", 6379);
	public static String putUserSession(User user) {
		String uuid = UUIDProductionUtils.getUUIDRemoveBar();
		byte[] bs = SerializeUtils.serialize(user);
		jedis.set(uuid, Base64.getEncoder().encodeToString(bs));
		jedis.expire(uuid, 1800);
		return(uuid);
	}
	public static User getUserSession(String uuid) {
		if(!jedis.exists(uuid)) {
			return null;
		}
		String stringUser = jedis.get(uuid);
		User user;
		user = (User)SerializeUtils.unserialize(Base64.getDecoder().decode(stringUser));
		return(user);
	}
	public static void resetTime(String uuid) {
		if(jedis.exists(uuid)) {
			jedis.expire(uuid, 1800);
		}
	}
	public static void rmUserSession(String uuid) {
		if(jedis.exists(uuid)) {
			jedis.del(uuid);
		}
	}
}