package com.studentsurvey;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TypedQuery;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Entity
@Table
@NamedQueries({
   @NamedQuery(name="Student.findAll", query="SELECT c FROM Student c"),
    @NamedQuery(name="...", query="..."),
}) 

@XmlRootElement
public class Student {
	@Id @GeneratedValue(strategy=GenerationType.AUTO) long id;
    private String first_name;
	private String last_name;
    private String address;
    private String zip;
    private String city;
    private String state;
    private String tel_num;
    private String email;
    private String dos;
    @Column
    @ElementCollection(targetClass=String.class)
    private List<String> likings;
    private String interested;   
    private String likelihood;
    
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipcode() {
		return zip;
	}
	public void setZipcode(String zipcode) {
		this.zip = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPhone() {
		return tel_num;
	}
	public void setPhone(String phone) {
		this.tel_num = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSurveyDate() {
		return dos;
	}
	public void setSurveyDate(String date) {
		this.dos = date;
	}
	public List<String> getLikes() {
		return likings;
	}
	public void setLikes(List<String> likes) {
		this.likings = likes;
	}
	public String getInterest() {
		return interested;
	}
	public void setInterest(String interest) {
		this.interested = interest;
	}

	public String getRecommend() {
		return likelihood;
	}
	public void setRecommend(String recommend) {
		this.likelihood = recommend;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", zip=" + zip + ", city=" + city + ", state=" + state + ", tel_num=" + tel_num + ", email=" + email
				+ ", dos=" + dos + ", likings=" + likings + ", interested=" + interested + ", likelihood=" + likelihood
				+ "]";
	}


	

}
