package com.daiict.model;

import java.io.Serializable;

public class CreateProfessional implements Serializable{
	
		private String firstname;
		private String lastname;
		private String password;
		private String email;
		private String areaOfExpertise;
		private long sid;
		
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAreaOfExpertise() {
			return areaOfExpertise;
		}
		public void setAreaOfExpertise(String areaOfExpertise) {
			this.areaOfExpertise = areaOfExpertise;
		}
		public long getSid() {
			return sid;
		}
		public void setSid(long sid) {
			this.sid = sid;
		}

}
