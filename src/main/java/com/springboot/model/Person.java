package com.springboot.model;
	
	import jakarta.persistence.*;

	import java.util.List;
	
	@Entity
	@Table(name = "person")
	public class Person {
	
		@Id
		@Column(name = "person_id", length = 13)
		private String personId;
	
		@Column(name = "fullname", length = 100, nullable = false)
		private String fullName;
	
		@Column(length = 45)	
		private String address;
	
		@Column(length = 45)
		private String mobile;
	
		@Column(length = 45)
		private String email;
		
		
	
		public Person(String personId, String fullName, String address, String mobile, String email, int gender) {
			super();
			this.personId = personId;
			this.fullName = fullName;
			this.address = address;
			this.mobile = mobile;
			this.email = email;
			this.gender = gender;
		}

		private int gender; 
	
		@OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
		private List<Dog> dogs;
	
		public Person() {
		}
	
		public String getPersonId() {
			return personId;
		}
	
		public void setPersonId(String personId) {
			this.personId = personId;
		}
	
		public String getFullName() {
			return fullName;
		}
	
		public void setFullName(String fullName) {
			this.fullName = fullName;
		}
	
		public String getAddress() {
			return address;
		}
	
		public void setAddress(String address) {
			this.address = address;
		}
	
		public String getMobile() {
			return mobile;
		}
	
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
	
		public String getEmail() {
			return email;
		}
	
		public void setEmail(String email) {
			this.email = email;
		}
	
		public int getGender() {
			return gender;
		}
	
		public void setGender(int gender) {
			this.gender = gender;
		}
	
		public List<Dog> getDogs() {
			return dogs;
		}
	
		public void setDogs(List<Dog> dogs) {
			this.dogs = dogs;
		}
	
		}
