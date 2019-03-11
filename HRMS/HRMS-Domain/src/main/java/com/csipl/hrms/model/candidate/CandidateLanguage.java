package com.csipl.hrms.model.candidate;

import java.io.Serializable;
import javax.persistence.*;

import com.csipl.hrms.model.common.Language;


/**
 * The persistent class for the CandidateLanguage database table.
 * 
 */
@Entity
@NamedQuery(name="CandidateLanguage.findAll", query="SELECT c FROM CandidateLanguage c")
public class CandidateLanguage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidateLanguageId;

	private String langRead;

	private String langSpeak;

	private String langWrite;

	//bi-directional many-to-one association to Language
	@ManyToOne
	@JoinColumn(name="languageId")
	private Language language;

	//bi-directional many-to-one association to CandidatePersonal
	@ManyToOne
	@JoinColumn(name="candidatePersonalId")
	private CandidatePersonal candidatePersonal;

	public CandidateLanguage() {
	}

	public Long getCandidateLanguageId() {
		return this.candidateLanguageId;
	}

	public void setCandidateLanguageId(Long candidateLanguageId) {
		this.candidateLanguageId = candidateLanguageId;
	}

	public String getLangRead() {
		return this.langRead;
	}

	public void setLangRead(String langRead) {
		this.langRead = langRead;
	}

	public String getLangSpeak() {
		return this.langSpeak;
	}

	public void setLangSpeak(String langSpeak) {
		this.langSpeak = langSpeak;
	}

	public String getLangWrite() {
		return this.langWrite;
	}

	public void setLangWrite(String langWrite) {
		this.langWrite = langWrite;
	}

	public Language getLanguage() {
		return this.language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public CandidatePersonal getCandidatePersonal() {
		return this.candidatePersonal;
	}

	public void setCandidatePersonal(CandidatePersonal candidatePersonal) {
		this.candidatePersonal = candidatePersonal;
	}

}