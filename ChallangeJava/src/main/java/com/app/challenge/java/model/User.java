package com.app.challenge.java.model;

import org.modelmapper.ModelMapper;

import com.app.challenge.java.DTO.NotifyDTO;
import com.app.challenge.java.DTO.UserDTO;


public class User {
 
    private int id;
 
    private String ssoId;
     
    private String password;
         
    private String firstName;
 
    private String lastName;
 
    private String email;
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getSsoId() {
        return ssoId;
    }
 
    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
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
    
    public static UserDTO convertToDTO(User user){
		ModelMapper mapper = new ModelMapper();
		return mapper.map(user, UserDTO.class);
	}
    
    public static User convertToModel(UserDTO user){
		ModelMapper mapper = new ModelMapper();
		return mapper.map(user, User.class);
	}
}
