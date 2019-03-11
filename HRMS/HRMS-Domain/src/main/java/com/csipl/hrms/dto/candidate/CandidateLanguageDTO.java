package com.csipl.hrms.dto.candidate;
public class CandidateLanguageDTO   {
    	
	 	private Long candidateLanguageId;

		private String langRead;

		private String langSpeak;

		private String langWrite;
		
		private Long candidatePersonalId;

		private Long languageId;
		
		private String languageName;

		public Long getCandidateLanguageId() {
			return candidateLanguageId;
		}

		public void setCandidateLanguageId(Long candidateLanguageId) {
			this.candidateLanguageId = candidateLanguageId;
		}

		public String getLangRead() {
			return langRead;
		}

		public void setLangRead(String langRead) {
			this.langRead = langRead;
		}

		public String getLangSpeak() {
			return langSpeak;
		}

		public void setLangSpeak(String langSpeak) {
			this.langSpeak = langSpeak;
		}

		public String getLangWrite() {
			return langWrite;
		}

		public void setLangWrite(String langWrite) {
			this.langWrite = langWrite;
		}

		

		public Long getCandidatePersonalId() {
			return candidatePersonalId;
		}

		public void setCandidatePersonalId(Long candidatePersonalId) {
			this.candidatePersonalId = candidatePersonalId;
		}

		public Long getLanguageId() {
			return languageId;
		}

		public void setLanguageId(Long languageId) {
			this.languageId = languageId;
		}

		public String getLanguageName() {
			return languageName;
		}

		public void setLanguageName(String languageName) {
			this.languageName = languageName;
		}

	}