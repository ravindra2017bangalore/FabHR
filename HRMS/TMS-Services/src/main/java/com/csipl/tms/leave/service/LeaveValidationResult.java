package com.csipl.tms.leave.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LeaveValidationResult {
        private List<Date> applyHolidays;

        private BigDecimal weekllyOffCount;
        private BigDecimal holidaysOffCount;
        private BigDecimal weekholidaysOffCount;
        private BigDecimal totalLeaveApplyDays;
        
        
        public List<Date> getApplyHolidays() {
                return applyHolidays;
        }
        public void setApplyHolidays(List<Date> applyHolidays) {
                this.applyHolidays = applyHolidays;
        }
        public BigDecimal getWeekllyOffCount() {
                return weekllyOffCount;
        }
        public void setWeekllyOffCount(BigDecimal weekllyOffCount) {
                this.weekllyOffCount = weekllyOffCount;
        }
        public BigDecimal getHolidaysOffCount() {
                return holidaysOffCount;
        }
        public void setHolidaysOffCount(BigDecimal holidaysOffCount) {
                this.holidaysOffCount = holidaysOffCount;
        }
        public BigDecimal getWeekholidaysOffCount() {
                return weekholidaysOffCount;
        }
        public void setWeekholidaysOffCount(BigDecimal weekholidaysOffCount) {
                this.weekholidaysOffCount = weekholidaysOffCount;
        }
        public BigDecimal getTotalLeaveApplyDays() {
                return totalLeaveApplyDays;
        }
        public void setTotalLeaveApplyDays(BigDecimal totalLeaveApplyDays) {
                this.totalLeaveApplyDays = totalLeaveApplyDays;
        }
        
        
}
