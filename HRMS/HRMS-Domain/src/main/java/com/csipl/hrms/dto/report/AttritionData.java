package com.csipl.hrms.dto.report;

public class AttritionData {

   String  label,stepSkipped,appliedSmartLabel;

public AttritionData(String label, String stepSkipped, String appliedSmartLabel) {
	
	this.label = label;
	this.stepSkipped = stepSkipped;
	this.appliedSmartLabel = appliedSmartLabel;
}

public String getLabel() {
	return label;
}

public void setLabel(String label) {
	this.label = label;
}

public String getStepSkipped() {
	return stepSkipped;
}

public void setStepSkipped(String stepSkipped) {
	this.stepSkipped = stepSkipped;
}

public String getAppliedSmartLabel() {
	return appliedSmartLabel;
}

public void setAppliedSmartLabel(String appliedSmartLabel) {
	this.appliedSmartLabel = appliedSmartLabel;
}
   

}
