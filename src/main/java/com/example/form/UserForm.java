package com.example.form;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Range;

public class UserForm {
	@NotBlank(message="名前を記入してください")
	private String name;
	@Range(min=0,max=120,message="年齢は0〜120の間で入力してください")
	private String age;
	@NotBlank(message="コメントを入力してください")
	private String comment;
	
	public int getIntAge() {
		return Integer.parseInt(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", age=" + age + ", comment=" + comment + "]";
	}

}
