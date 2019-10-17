package com.lottery.mylottery.dao.entity.db1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class TPrize implements Serializable {
    private Integer id;

    /** 买家昵称 */
    private String nick;

    /** 订单编号 */
    private String billNum;
    private String platformType;
    /** 下单时间 */
    private Date orderDt;

    /** 奖品类型（口碑券、天猫超市卡等） */
    private String prizeType;

    /** 购买商品 */
    private String goodsName;

    /** 设备信息 */
    private String deviceInfo;

    /** 是否已经领取奖品（1:已领取；0:未领取） */
    private Integer prizeStatus;

    /** 领取时间 */
    private Date receiveDt;

    private Date createDt;

    /** 活动表主键 */
    private Integer actId;

    private List<Integer> idList;
    private String actName;
    private String billNumStatus;


    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getBillNumStatus() {
        return billNumStatus;
    }

    public void setBillNumStatus(String billNumStatus) {
        this.billNumStatus = billNumStatus;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public List<Integer> getIdList() {
        return idList;
    }

    public void setIdList(List<Integer> idList) {
        this.idList = idList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getBillNum() {
        return billNum;
    }

    public void setBillNum(String billNum) {
        this.billNum = billNum == null ? null : billNum.trim();
    }

    public Date getOrderDt() {
        return orderDt;
    }

    public void setOrderDt(Date orderDt) {
        this.orderDt = orderDt;
    }

    public String getPrizeType() {
        return prizeType;
    }

    public void setPrizeType(String prizeType) {
        this.prizeType = prizeType == null ? null : prizeType.trim();
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public String getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(String deviceInfo) {
        this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim();
    }

    public Integer getPrizeStatus() {
        return prizeStatus;
    }

    public void setPrizeStatus(Integer prizeStatus) {
        this.prizeStatus = prizeStatus;
    }

    public Date getReceiveDt() {
        return receiveDt;
    }

    public void setReceiveDt(Date receiveDt) {
        this.receiveDt = receiveDt;
    }

    public Date getCreateDt() {
        return createDt;
    }

    public void setCreateDt(Date createDt) {
        this.createDt = createDt;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nick=").append(nick);
        sb.append(", billNum=").append(billNum);
        sb.append(", orderDt=").append(orderDt);
        sb.append(", prizeType=").append(prizeType);
        sb.append(", goodsName=").append(goodsName);
        sb.append(", deviceInfo=").append(deviceInfo);
        sb.append(", prizeStatus=").append(prizeStatus);
        sb.append(", receiveDt=").append(receiveDt);
        sb.append(", createDt=").append(createDt);
        sb.append(", actId=").append(actId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}