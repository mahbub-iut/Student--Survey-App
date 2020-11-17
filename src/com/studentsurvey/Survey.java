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
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/* Mahbubul Alam Palash & Taseef Rahman
 * 
 * entity class that represents Survey
 */
@Entity
@Table
@XmlRootElement
public class Survey {


	public Survey(Long id, String first_name, String last_name, String address, String zip, String city, String state,
			String tel_num, String email, String dos, List<String> likings, String interested, String likelihood) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.state = state;
		this.tel_num = tel_num;
		this.email = email;
		this.dos = dos;
		this.likings = likings;
		this.interested = interested;
		this.likelihood = likelihood;
	}
 public Survey() {
		// TODO Auto-generated constructor stub
	}
	   @Id @GeneratedValue
		  private Long id;

    private String first_name;
	private String last_name;
    private String address;
    private String zip;
    private String city;
    private String state;
    private String tel_num;
    private String email;
    private String dos;
    private List<String> likings;
    private String interested;   
    private String likelihood;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
	public String getTel_num() {
		return tel_num;
	}
	public void setTel_num(String tel_num) {
		this.tel_num = tel_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDos() {
		return dos;
	}
	public void setDos(String dos) {
		this.dos = dos;
	}
	public List<String> getLikings() {
		return likings;
	}
	public void setLikings(List<String> likings) {
		this.likings = likings;
	}
	public String getInterested() {
		return interested;
	}
	public void setInterested(String interested) {
		this.interested = interested;
	}
	public String getLikelihood() {
		return likelihood;
	}
	public void setLikelihood(String likelihood) {
		this.likelihood = likelihood;
	}
	@Override
	public String toString() {
		return "Survey [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", address=" + address
				+ ", zip=" + zip + ", city=" + city + ", state=" + state + ", tel_num=" + tel_num + ", email=" + email
				+ ", dos=" + dos + ", likings=" + likings + ", interested=" + interested + ", likelihood=" + likelihood
				+ "]";
	}
}
