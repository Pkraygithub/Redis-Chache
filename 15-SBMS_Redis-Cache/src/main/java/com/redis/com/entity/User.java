package com.redis.com.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  implements Serializable{
	private Integer uid;
	private String name;
	private Integer age;
}
