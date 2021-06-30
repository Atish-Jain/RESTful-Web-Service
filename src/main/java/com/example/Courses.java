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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "courses")
public class Courses {

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "id")
		private Integer id;
		@Column(name = "name")
		private String name;
		
		//Many to Many mapping with Users class using Join Table method
		@ManyToMany(cascade = CascadeType.ALL)
		@JoinTable(name="users_enrolled",joinColumns=@JoinColumn(name="course_id"),inverseJoinColumns=@JoinColumn(name="user_id"))
		private Set<Users> users = new HashSet<Users>();

		public Courses() {
			
		}

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

		public Set<Users> getUsers() {
			return users;
		}

		public void setUsers(Set<Users> users) {
			this.users = users;
		}

		public void enrollUser(Users user) {
			
			users.add(user);
			
		}
	}
