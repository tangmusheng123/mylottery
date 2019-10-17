package com.lottery.mylottery.dao.entity.db1;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.Date;

public class TAct implements Serializable {
    private Integer id;

    /** 活动类型 */
    private String actType;
    private String platformType;
    /** 活动名称 */
    private String actName;

    private String actInfo;

    /** 创建时间 */
    private Date createDt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActType() {
        return actType;
    }

    public void setActType(String actType) {
        this.actType = actType;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActInfo() {
        return actInfo;
    }

    public void setActInfo(String actInfo) {
        this.actInfo = actInfo;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("actType", actType)
                .append("platformType", platformType)
                .append("actName", actName)
                .append("actInfo", actInfo)
                .append("createDt", createDt)
                .toString();
    }
}