package com.csipl.hrms.model.organisation;


import java.io.Serializable;
import javax.persistence.*;
import com.csipl.hrms.model.BaseModel;
import com.csipl.hrms.model.employee.PayStructureHd;
import com.csipl.hrms.model.payroll.Bonus;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the Grades database table.
 * 
 */
@Entity
@Table(name="Grades")
@NamedQuery(name="Grade.findAll", query="SELECT g FROM Grade g")
public class Grade extends BaseModel implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long gradesId;

	private String allowModi;

	private String gradesName;

	private BigDecimal incrementPer;

	private BigDecimal salaryFrom;

	private BigDecimal salaryTo;

	//bi-directional many-to-one association to Bonus
	@OneToMany(mappedBy="grade")
	private List<Bonus> bonuses;

	//bi-directional many-to-one association to GradesPayDefinition
	@OneToMany(mappedBy="grade", cascade = CascadeType.ALL)
	private List<GradesPayDefinition> gradesPayDefinitions;

	//bi-directional many-to-one association to PayStructureHd
	@OneToMany(mappedBy="grade")
	private List<PayStructureHd> payStructureHds;

	public Grade() {
	}

	public Long getGradesId() {
		return this.gradesId;
	}

	public void setGradesId(Long gradesId) {
		this.gradesId = gradesId;
	}

	public String getAllowModi() {
		return this.allowModi;
	}

	public void setAllowModi(String allowModi) {
		this.allowModi = allowModi;
	}

	public String getGradesName() {
		return this.gradesName;
	}

	public void setGradesName(String gradesName) {
		this.gradesName = gradesName;
	}

	public BigDecimal getIncrementPer() {
		return this.incrementPer;
	}

	public void setIncrementPer(BigDecimal incrementPer) {
		this.incrementPer = incrementPer;
	}

	public BigDecimal getSalaryFrom() {
		return this.salaryFrom;
	}

	public void setSalaryFrom(BigDecimal salaryFrom) {
		this.salaryFrom = salaryFrom;
	}

	public BigDecimal getSalaryTo() {
		return this.salaryTo;
	}

	public void setSalaryTo(BigDecimal salaryTo) {
		this.salaryTo = salaryTo;
	}

	public List<Bonus> getBonuses() {
		return this.bonuses;
	}

	public void setBonuses(List<Bonus> bonuses) {
		this.bonuses = bonuses;
	}

	public Bonus addBonus(Bonus bonus) {
		getBonuses().add(bonus);
		bonus.setGrade(this);

		return bonus;
	}

	public Bonus removeBonus(Bonus bonus) {
		getBonuses().remove(bonus);
		bonus.setGrade(null);

		return bonus;
	}

	public List<GradesPayDefinition> getGradesPayDefinitions() {
		return this.gradesPayDefinitions;
	}

	public void setGradesPayDefinitions(List<GradesPayDefinition> gradesPayDefinitions) {
		this.gradesPayDefinitions = gradesPayDefinitions;
	}

	public GradesPayDefinition addGradesPayDefinition(GradesPayDefinition gradesPayDefinition) {
		getGradesPayDefinitions().add(gradesPayDefinition);
		gradesPayDefinition.setGrade(this);

		return gradesPayDefinition;
	}

	public GradesPayDefinition removeGradesPayDefinition(GradesPayDefinition gradesPayDefinition) {
		getGradesPayDefinitions().remove(gradesPayDefinition);
		gradesPayDefinition.setGrade(null);

		return gradesPayDefinition;
	}

	public List<PayStructureHd> getPayStructureHds() {
		return this.payStructureHds;
	}

	public void setPayStructureHds(List<PayStructureHd> payStructureHds) {
		this.payStructureHds = payStructureHds;
	}

	public PayStructureHd addPayStructureHd(PayStructureHd payStructureHd) {
		getPayStructureHds().add(payStructureHd);
		payStructureHd.setGrade(this);

		return payStructureHd;
	}

	public PayStructureHd removePayStructureHd(PayStructureHd payStructureHd) {
		getPayStructureHds().remove(payStructureHd);
		payStructureHd.setGrade(null);

		return payStructureHd;
	}

}