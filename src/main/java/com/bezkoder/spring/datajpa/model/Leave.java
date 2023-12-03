package com.bezkoder.spring.datajpa.model;
import com.bezkoder.spring.datajpa.enums.LeaveStatusEnum;
import com.bezkoder.spring.datajpa.enums.LeaveTypeEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Leave_requests")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;
    private LeaveTypeEnum leaveType;
    private LeaveStatusEnum status;

    public Leave() {}

    public Leave(Date startDate, Date endDate, LeaveTypeEnum leaveType, LeaveStatusEnum status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveType = leaveType;
        this.status = status;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LeaveTypeEnum getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveTypeEnum leaveType) {
        this.leaveType = leaveType;
    }

    public LeaveStatusEnum getStatus() {
        return status;
    }

    public void setStatus(LeaveStatusEnum status) {
        this.status = status;
    }
}
