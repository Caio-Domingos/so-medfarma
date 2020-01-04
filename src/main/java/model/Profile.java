package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profile {
	@Id
	private Integer idProfile;
	private String descriptionProfile;
	private Integer statusProfile;

	// Getters and Setters
	public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getDescriptionProfile() {
		return descriptionProfile;
	}

	public void setDescriptionProfile(String descriptionProfile) {
		this.descriptionProfile = descriptionProfile;
	}

	public Integer getStatusProfile() {
		return statusProfile;
	}

	public void setStatusProfile(Integer statusProfile) {
		this.statusProfile = statusProfile;
	}

}
