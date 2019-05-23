package com.app.challenge.java.DTO;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="NOTIFY")
public class NotifyDTO {

		@Id
		@Column(name="NOTIFY_ID")
		@GeneratedValue(strategy=GenerationType.AUTO	)
		private int id;
		
		@Column(name="FIRST_NAME")
		private String firstName;
		
		@Column(name="LAST_NAME")
		private String lastName;
		
		@Column(name="EMAIL")
		private String email;
		
		@Column(name="PHONE")
		private String phone;
		
		@Column(name="CREATED_DATE")
		private Date createdDate;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}
}
