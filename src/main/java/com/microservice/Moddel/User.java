package com.microservice.Moddel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="UserService")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userid;
	private String userName;
	private String password;
	private String Email;
	private Long mobileNo;
	private String roles;

}
