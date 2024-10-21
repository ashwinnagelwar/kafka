package com.kafkaDemo.kafkaDemo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserInfo {

	private Integer id;
	private String firstName;
	private String lastName;
	private String address;
	private Integer age;
}
