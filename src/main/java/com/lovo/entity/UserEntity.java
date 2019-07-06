package com.lovo.entity;

import java.sql.Date;

public class UserEntity {
	
	private Integer id;
	
	private String name;
	
	private String sex;
	
	private String tel;
	
	private Date birthday;
	
	private Integer age;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", sex=" + sex + ", tel=" + tel + ", birthday=" + birthday
				+ ", age=" + age + "]";
	}
	
	
}
