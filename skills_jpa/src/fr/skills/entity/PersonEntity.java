package fr.skills.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.skills.dto.UserDTO;

/**
 * The persistent class for the person database table.
 * 
 */
@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_person")
	private Integer idPerson;

	private Boolean available;

	private String description;

	private String email;

	private String login;

	private String name;

	private String phone;

	private String pswd;

	// bi-directional many-to-many association to NotificationEntity
	@ManyToMany
	@JoinTable(name = "person_notif_assoc", joinColumns = { @JoinColumn(name = "id_person_person") }, inverseJoinColumns = { @JoinColumn(name = "id_notification_notification") })
	private List<NotificationEntity> notifications;

	// bi-directional many-to-one association to PromotionEntity
	@ManyToOne
	@JoinColumn(name = "id_promotion_promotion")
	private PromotionEntity promotion;

	// bi-directional many-to-one association to PersonNotifAssocEntity
	@OneToMany(mappedBy = "person")
	private List<PersonNotifAssocEntity> personNotifAssocs;

	// bi-directional many-to-many association to ProfileEntity
	@ManyToMany(mappedBy = "persons")
	private List<ProfileEntity> profiles;

	// bi-directional many-to-one association to ProjectEntity
	@OneToMany(mappedBy = "person")
	private List<ProjectEntity> projects1;

	// bi-directional many-to-many association to ProjectEntity
	@ManyToMany(mappedBy = "persons")
	private List<ProjectEntity> projects2;

	// bi-directional many-to-one association to SkillPersonAssocEntity
	@OneToMany(mappedBy = "person")
	private List<SkillPersonAssocEntity> skillPersonAssocs;

	public PersonEntity() {
	}

	public PersonEntity(UserDTO aUserDTO) {
		PersonEntity vRet = new PersonEntity();
		vRet.setAvailable(aUserDTO.isAvailable());
		vRet.setDescription(aUserDTO.getDescription());
		vRet.setEmail(aUserDTO.getEmail());
		vRet.setIdPerson(aUserDTO.getIdUser());
		vRet.setLogin(aUserDTO.getLogin());
		vRet.setName(aUserDTO.getName());
		vRet.setPswd(aUserDTO.getPassword());
	}

	public Integer getIdPerson() {
		return this.idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}

	public Boolean getAvailable() {
		return this.available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPswd() {
		return this.pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public List<NotificationEntity> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(List<NotificationEntity> notifications) {
		this.notifications = notifications;
	}

	public PromotionEntity getPromotion() {
		return this.promotion;
	}

	public void setPromotion(PromotionEntity promotion) {
		this.promotion = promotion;
	}

	public List<PersonNotifAssocEntity> getPersonNotifAssocs() {
		return this.personNotifAssocs;
	}

	public void setPersonNotifAssocs(List<PersonNotifAssocEntity> personNotifAssocs) {
		this.personNotifAssocs = personNotifAssocs;
	}

	public PersonNotifAssocEntity addPersonNotifAssoc(PersonNotifAssocEntity personNotifAssoc) {
		getPersonNotifAssocs().add(personNotifAssoc);
		personNotifAssoc.setPerson(this);

		return personNotifAssoc;
	}

	public PersonNotifAssocEntity removePersonNotifAssoc(PersonNotifAssocEntity personNotifAssoc) {
		getPersonNotifAssocs().remove(personNotifAssoc);
		personNotifAssoc.setPerson(null);

		return personNotifAssoc;
	}

	public List<ProfileEntity> getProfiles() {
		return this.profiles;
	}

	public void setProfiles(List<ProfileEntity> profiles) {
		this.profiles = profiles;
	}

	public List<ProjectEntity> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<ProjectEntity> projects1) {
		this.projects1 = projects1;
	}

	public ProjectEntity addProjects1(ProjectEntity projects1) {
		getProjects1().add(projects1);
		projects1.setPerson(this);

		return projects1;
	}

	public ProjectEntity removeProjects1(ProjectEntity projects1) {
		getProjects1().remove(projects1);
		projects1.setPerson(null);

		return projects1;
	}

	public List<ProjectEntity> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<ProjectEntity> projects2) {
		this.projects2 = projects2;
	}

	public List<SkillPersonAssocEntity> getSkillPersonAssocs() {
		return this.skillPersonAssocs;
	}

	public void setSkillPersonAssocs(List<SkillPersonAssocEntity> skillPersonAssocs) {
		this.skillPersonAssocs = skillPersonAssocs;
	}

	public SkillPersonAssocEntity addSkillPersonAssoc(SkillPersonAssocEntity skillPersonAssoc) {
		getSkillPersonAssocs().add(skillPersonAssoc);
		skillPersonAssoc.setPerson(this);

		return skillPersonAssoc;
	}

	public SkillPersonAssocEntity removeSkillPersonAssoc(SkillPersonAssocEntity skillPersonAssoc) {
		getSkillPersonAssocs().remove(skillPersonAssoc);
		skillPersonAssoc.setPerson(null);

		return skillPersonAssoc;
	}

	public static UserDTO buildUserDTO(PersonEntity aPersonEntity) {
		UserDTO vRet = null;
		if (aPersonEntity != null) {
			vRet = new UserDTO();
			vRet.setAvailable(aPersonEntity.getAvailable());
			vRet.setDescription(aPersonEntity.getDescription());
			vRet.setEmail(aPersonEntity.getEmail());
			vRet.setIdUser(aPersonEntity.getIdPerson());
			vRet.setLogin(aPersonEntity.getLogin());
			vRet.setName(aPersonEntity.getName());
			vRet.setPassword(aPersonEntity.getPswd());
			vRet.setPhone(aPersonEntity.getPhone());
		}
		return vRet;
	}

}