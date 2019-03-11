package com.csipl.hrms.model.employee;





import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.BaseModelWithoutCG;

import java.util.Date;


/**
 * The persistent class for the TicketDesc database table.
 * 
 */
@Entity
@NamedQuery(name="TicketDesc.findAll", query="SELECT t FROM TicketDesc t")
public class TicketDesc  extends BaseModelWithoutCG  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ticketDescId;

	

	private String description;

	private String fileExtension;

	private String fileLocation;

	private String status;



	//bi-directional many-to-one association to TicketRaisingHD
	@ManyToOne
	@JoinColumn(name="ticketRaisingHDId")
	private TicketRaisingHD ticketRaisingHd;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeId")
	private Employee employee;

	public TicketDesc() {
	}

	public Long getTicketDescId() {
		return this.ticketDescId;
	}

	public void setTicketDescId(Long ticketDescId) {
		this.ticketDescId = ticketDescId;
	}

	

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileExtension() {
		return this.fileExtension;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	public String getFileLocation() {
		return this.fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public TicketRaisingHD getTicketRaisingHd() {
		return this.ticketRaisingHd;
	}

	public void setTicketRaisingHd(TicketRaisingHD ticketRaisingHd) {
		this.ticketRaisingHd = ticketRaisingHd;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}