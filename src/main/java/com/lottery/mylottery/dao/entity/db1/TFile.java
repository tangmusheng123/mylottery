package com.lottery.mylottery.dao.entity.db1;

import java.io.Serializable;
import java.util.Date;

public class TFile implements Serializable {
    private Integer id;

    /** 活动表主键 */
    private Integer actId;

    /** 是否是主图，或存在的位置，logo或其他图片 */
    private String theType;

    /** 图片名称 */
    private String showName;

    /** 阿里云存储位置 */
    private String realUrl;

    /** 预览下载地址 */
    private String previewUrl;

    private Date createDt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public String getTheType() {
        return theType;
    }

    public void setTheType(String theType) {
        this.theType = theType == null ? null : theType.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getRealUrl() {
        return realUrl;
    }

    public void setRealUrl(String realUrl) {
        this.realUrl = realUrl == null ? null : realUrl.trim();
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl == null ? null : previewUrl.trim();
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", actId=").append(actId);
        sb.append(", theType=").append(theType);
        sb.append(", showName=").append(showName);
        sb.append(", realUrl=").append(realUrl);
        sb.append(", previewUrl=").append(previewUrl);
        sb.append(", createDt=").append(createDt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}