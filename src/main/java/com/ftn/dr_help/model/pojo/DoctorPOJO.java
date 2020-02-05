package com.ftn.dr_help.model.pojo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ftn.dr_help.model.enums.RoleEnum;
import com.ftn.dr_help.model.enums.Shift;

@Entity
@Table(name = "doctors")
public class DoctorPOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "status", nullable = false)
	private RoleEnum role = RoleEnum.DOCTOR;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "phoneNumber", nullable = false)
	private String phoneNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday")
	private Calendar birthday;
	
	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ClinicPOJO clinic;
	
	@OneToMany (mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AppointmentPOJO> appointmentList;
	
	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DoctorRequestedAppointmentPOJO> request;
	
	@JsonManagedReference
	//@ManyToMany 
	//@JoinTable (name = "operating", joinColumns = @JoinColumn (name = "doctor_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn (name = "operations_id", referencedColumnName = "id"))
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OperationPOJO> operationList;

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ProceduresTypePOJO procedureType;
	
	@Column (nullable = false)
	private boolean deleted;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "monday", nullable = false)
	public Shift monday;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "tuesday", nullable = false)
	public Shift tuesday;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "wednesday", nullable = false)
	public Shift wednesday;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "thursday", nullable = false)
	public Shift thursday;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "friday", nullable = false)
	public Shift friday;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "saturday", nullable = false)
	public Shift saturday;
	
	@Enumerated(EnumType.STRING)
	@Column (name = "sunday", nullable = false)
	public Shift sunday;
	
	@Column(name = "mustChangePassword", nullable = true)
	private Boolean mustChangePassword = false;
	
	@OneToMany(mappedBy="doctor",  fetch = FetchType.LAZY)
	private List<LeaveRequestPOJO> leaveRequest;
	
	public DoctorPOJO() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Calendar getBirthday() {
		return birthday;
	}
	public void setBirthday(Calendar birthday) {
		this.birthday = birthday;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public ClinicPOJO getClinic() {
		return clinic;
	}

	public void setClinic(ClinicPOJO clinic) {
		this.clinic = clinic;
	}

	public List<AppointmentPOJO> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<AppointmentPOJO> appointmentList) {
		this.appointmentList = appointmentList;
	}

	public List<OperationPOJO> getOperationList() {
		return operationList;
	}

	public void setOperationList(List<OperationPOJO> operationList) {
		this.operationList = operationList;

	}

	public ProceduresTypePOJO getProcedureType() {
		return procedureType;
	}

	public void setProcedureType(ProceduresTypePOJO procedureType) {
		this.procedureType = procedureType;
	}

	public Shift getMonday() {
		return monday;
	}

	public void setMonday(Shift monday) {
		this.monday = monday;
	}

	public Shift getTuesday() {
		return tuesday;
	}

	public void setTuesday(Shift tuesday) {
		this.tuesday = tuesday;
	}

	public Shift getWednesday() {
		return wednesday;
	}

	public void setWednesday(Shift wednesday) {
		this.wednesday = wednesday;
	}

	public Shift getThursday() {
		return thursday;
	}

	public void setThursday(Shift thursday) {
		this.thursday = thursday;
	}

	public Shift getFriday() {
		return friday;
	}

	public void setFriday(Shift friday) {
		this.friday = friday;
	}

	public Shift getSaturday() {
		return saturday;
	}

	public void setSaturday(Shift saturday) {
		this.saturday = saturday;
	}

	public Shift getSunday() {
		return sunday;
	}

	public void setSunday(Shift sunday) {
		this.sunday = sunday;
	}

	public Boolean getMustChangePassword() {
		return mustChangePassword;
	}

	public void setMustChangePassword(Boolean mustChangePassword) {
		this.mustChangePassword = mustChangePassword;
	}

	public List<DoctorRequestedAppointmentPOJO> getRequest() {
		return request;
	}

	public void setRequest(List<DoctorRequestedAppointmentPOJO> request) {
		this.request = request;
	}

	
}
