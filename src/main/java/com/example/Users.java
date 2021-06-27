package com.example;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "info_table")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name="age")
	private Integer age;
	@Column(name = "city")
	private String city;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contact_id ", referencedColumnName="id")
	private UsersContact usersContact;
	
	@JsonIgnore
	@ManyToMany(mappedBy="users")
	Set <Courses> courses = new HashSet <Courses>();
	
	public Set<Courses> getCourses() {
		return courses;
	}
	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}
	public UsersContact getUsersContact() {
		return usersContact;
	}
	public Users setUsersContact(UsersContact usersContact) {
		this.usersContact = usersContact;
		return this;
	}
	

	public Users() {
	}

	public Integer getId() {
		return id;
	}

	public Users setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Users setName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Users setAge(Integer age) {
		this.age = age;
		return this;
	}
	
	public String getCity() {
		return city;
	}

	public Users setCity(String city) {
		this.city = city;
		return this;
	}
	
}
