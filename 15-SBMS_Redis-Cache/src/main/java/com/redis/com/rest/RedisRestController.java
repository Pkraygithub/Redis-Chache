package com.redis.com.rest;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redis.com.entity.User;

@RestController
public class RedisRestController {

	
	private HashOperations<String, Integer, User> 	 hasOps;
	
	public RedisRestController(RedisTemplate<String, User>  redisTemplate) {
		
		hasOps=redisTemplate.opsForHash();
	}
	
	
	@PostMapping("/user")
	public String sotreData(@RequestBody User  usre) {
		hasOps.put("Person", usre.getUid(),  usre);
		System.out.println("Program Will Be Executed....🥰🥰🥰🥰");
		return "Success";
	}
	
	@GetMapping("/user/{uid}")
	public User sotreData(@PathVariable Integer uid) {
		User user =  hasOps.get("Person",uid);
		return user;
	}
	
	@GetMapping("/allusers")
	public List<User>  getAllUser() {
		return hasOps.values("Person");
	}
	
	
	@DeleteMapping("/userdelete/{uid}")
	public String  deleteUser(@PathVariable Integer uid) {
		hasOps.delete("Person", uid);
		return "Deleted Successfully";
	}
	
}
