package com.lottery.mylottery.dao.entity.db2;

import java.io.Serializable;
import java.util.Date;

public class TSdTbsobill implements Serializable {
    private String fid;

    private Integer ftradeprocessstatus;

    private Date fcreatetime;

    private String fsaleorderid;

    private String fsaleordernumber;

    private Date flastupdatetime;

    private String fadjustfee;

    private String falipayid;

    private String falipayno;

    private String falipayurl;

    private String falipaywarnmsg;

    private String fareaid;

    private String favailableconfirmfee;

    private String fbuyeralipayno;

    private String fbuyerarea;

    private String fbuyercodfee;

    private String fbuyeremail;

    private Long fbuyerflag;

    private String fbuyernick;

    private Long fbuyerobtainpointfee;

    private Boolean fbuyerrate;

    private Boolean fcanrate;

    private String fcodfee;

    private String fcodstatus;

    private String fcommissionfee;

    private Date fconsigntime;

    private Date fcreated;

    private String fcreditcardfee;

    private String fdiscountfee;

    private Date fendtime;

    private String feticketext;

    private String fexpressagencyfee;

    private Boolean fhasbuyermessage;

    private Boolean fhaspostfee;

    private Boolean fhasyfx;

    private String fiid;

    private String finvoicename;

    private Boolean fis3d;

    private Boolean fisbrandsale;

    private Boolean fisforcewlb;

    private Boolean fislgtype;

    private Boolean fispartconsign;

    private String flgaging;

    private String flgagingtype;

    private String fmarkdesc;

    private Date fmodified;

    private Long fnum;

    private Long fnumiid;

    private String fnutfeature;

    private Date fpaytime;

    private String fpayment;

    private Long fpointfee;

    private String fpostfee;

    private String fprice;

    private Long frealpointfee;

    private String freceivedpayment;

    private String freceiveraddress;

    private String freceivercity;

    private String freceiverdistrict;

    private String freceivermobile;

    private String freceivername;

    private String freceiverphone;

    private String freceiverstate;

    private String freceiverzip;

    private String fselleralipayno;

    private Boolean fsellercanrate;

    private String fsellercodfee;

    private String fselleremail;

    private Long fsellerflag;

    private String fsellermobile;

    private String fsellername;

    private String fsellernick;

    private String fsellerphone;

    private Boolean fsellerrate;

    private String fsendtime;

    private String fshippingtype;

    private String fstatus;

    private String fsteppaidfee;

    private String fsteptradestatus;

    private Long ftid;

    private Date ftimeoutactiontime;

    private String ftitle;

    private String ftotalfee;

    private String ftradefrom;

    private String ftradememo;

    private String ftradesource;

    private String ftype;

    private String fyfxfee;

    private String fyfxid;

    private Long fyfxtype;

    private String fplatformshopid;

    private Integer fconvertcount;

    private String fconvertmsg;

    private Integer fversion;

    private String fplatformid;

    /** 是否门店自提 */
    private Boolean fshoppick;

    /** 门店编码 */
    private String fstorecode;

    /** 租户ID */
    private Long ftenantid;

    /** 生成销售订单失败次数 */
    private Integer ftradegenerrcount;

    /** 生成销售订单失败原因 */
    private String ftradegenerrmsg;

    /** 发票内容 */
    private String finvoicetype;

    /** 发票类型 */
    private String finvoicekind;

    /** 买家税号 */
    private String fbuyertaxno;

    private String fbuyermemo;

    private String fbuyermessage;

    private String fpicpath;

    private String fsellermemo;

    private String fsnapshot;

    private String fsnapshoturl;

    private static final long serialVersionUID = 1L;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public Integer getFtradeprocessstatus() {
        return ftradeprocessstatus;
    }

    public void setFtradeprocessstatus(Integer ftradeprocessstatus) {
        this.ftradeprocessstatus = ftradeprocessstatus;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public String getFsaleorderid() {
        return fsaleorderid;
    }

    public void setFsaleorderid(String fsaleorderid) {
        this.fsaleorderid = fsaleorderid == null ? null : fsaleorderid.trim();
    }

    public String getFsaleordernumber() {
        return fsaleordernumber;
    }

    public void setFsaleordernumber(String fsaleordernumber) {
        this.fsaleordernumber = fsaleordernumber == null ? null : fsaleordernumber.trim();
    }

    public Date getFlastupdatetime() {
        return flastupdatetime;
    }

    public void setFlastupdatetime(Date flastupdatetime) {
        this.flastupdatetime = flastupdatetime;
    }

    public String getFadjustfee() {
        return fadjustfee;
    }

    public void setFadjustfee(String fadjustfee) {
        this.fadjustfee = fadjustfee == null ? null : fadjustfee.trim();
    }

    public String getFalipayid() {
        return falipayid;
    }

    public void setFalipayid(String falipayid) {
        this.falipayid = falipayid == null ? null : falipayid.trim();
    }

    public String getFalipayno() {
        return falipayno;
    }

    public void setFalipayno(String falipayno) {
        this.falipayno = falipayno == null ? null : falipayno.trim();
    }

    public String getFalipayurl() {
        return falipayurl;
    }

    public void setFalipayurl(String falipayurl) {
        this.falipayurl = falipayurl == null ? null : falipayurl.trim();
    }

    public String getFalipaywarnmsg() {
        return falipaywarnmsg;
    }

    public void setFalipaywarnmsg(String falipaywarnmsg) {
        this.falipaywarnmsg = falipaywarnmsg == null ? null : falipaywarnmsg.trim();
    }

    public String getFareaid() {
        return fareaid;
    }

    public void setFareaid(String fareaid) {
        this.fareaid = fareaid == null ? null : fareaid.trim();
    }

    public String getFavailableconfirmfee() {
        return favailableconfirmfee;
    }

    public void setFavailableconfirmfee(String favailableconfirmfee) {
        this.favailableconfirmfee = favailableconfirmfee == null ? null : favailableconfirmfee.trim();
    }

    public String getFbuyeralipayno() {
        return fbuyeralipayno;
    }

    public void setFbuyeralipayno(String fbuyeralipayno) {
        this.fbuyeralipayno = fbuyeralipayno == null ? null : fbuyeralipayno.trim();
    }

    public String getFbuyerarea() {
        return fbuyerarea;
    }

    public void setFbuyerarea(String fbuyerarea) {
        this.fbuyerarea = fbuyerarea == null ? null : fbuyerarea.trim();
    }

    public String getFbuyercodfee() {
        return fbuyercodfee;
    }

    public void setFbuyercodfee(String fbuyercodfee) {
        this.fbuyercodfee = fbuyercodfee == null ? null : fbuyercodfee.trim();
    }

    public String getFbuyeremail() {
        return fbuyeremail;
    }

    public void setFbuyeremail(String fbuyeremail) {
        this.fbuyeremail = fbuyeremail == null ? null : fbuyeremail.trim();
    }

    public Long getFbuyerflag() {
        return fbuyerflag;
    }

    public void setFbuyerflag(Long fbuyerflag) {
        this.fbuyerflag = fbuyerflag;
    }

    public String getFbuyernick() {
        return fbuyernick;
    }

    public void setFbuyernick(String fbuyernick) {
        this.fbuyernick = fbuyernick == null ? null : fbuyernick.trim();
    }

    public Long getFbuyerobtainpointfee() {
        return fbuyerobtainpointfee;
    }

    public void setFbuyerobtainpointfee(Long fbuyerobtainpointfee) {
        this.fbuyerobtainpointfee = fbuyerobtainpointfee;
    }

    public Boolean getFbuyerrate() {
        return fbuyerrate;
    }

    public void setFbuyerrate(Boolean fbuyerrate) {
        this.fbuyerrate = fbuyerrate;
    }

    public Boolean getFcanrate() {
        return fcanrate;
    }

    public void setFcanrate(Boolean fcanrate) {
        this.fcanrate = fcanrate;
    }

    public String getFcodfee() {
        return fcodfee;
    }

    public void setFcodfee(String fcodfee) {
        this.fcodfee = fcodfee == null ? null : fcodfee.trim();
    }

    public String getFcodstatus() {
        return fcodstatus;
    }

    public void setFcodstatus(String fcodstatus) {
        this.fcodstatus = fcodstatus == null ? null : fcodstatus.trim();
    }

    public String getFcommissionfee() {
        return fcommissionfee;
    }

    public void setFcommissionfee(String fcommissionfee) {
        this.fcommissionfee = fcommissionfee == null ? null : fcommissionfee.trim();
    }

    public Date getFconsigntime() {
        return fconsigntime;
    }

    public void setFconsigntime(Date fconsigntime) {
        this.fconsigntime = fconsigntime;
    }

    public Date getFcreated() {
        return fcreated;
    }

    public void setFcreated(Date fcreated) {
        this.fcreated = fcreated;
    }

    public String getFcreditcardfee() {
        return fcreditcardfee;
    }

    public void setFcreditcardfee(String fcreditcardfee) {
        this.fcreditcardfee = fcreditcardfee == null ? null : fcreditcardfee.trim();
    }

    public String getFdiscountfee() {
        return fdiscountfee;
    }

    public void setFdiscountfee(String fdiscountfee) {
        this.fdiscountfee = fdiscountfee == null ? null : fdiscountfee.trim();
    }

    public Date getFendtime() {
        return fendtime;
    }

    public void setFendtime(Date fendtime) {
        this.fendtime = fendtime;
    }

    public String getFeticketext() {
        return feticketext;
    }

    public void setFeticketext(String feticketext) {
        this.feticketext = feticketext == null ? null : feticketext.trim();
    }

    public String getFexpressagencyfee() {
        return fexpressagencyfee;
    }

    public void setFexpressagencyfee(String fexpressagencyfee) {
        this.fexpressagencyfee = fexpressagencyfee == null ? null : fexpressagencyfee.trim();
    }

    public Boolean getFhasbuyermessage() {
        return fhasbuyermessage;
    }

    public void setFhasbuyermessage(Boolean fhasbuyermessage) {
        this.fhasbuyermessage = fhasbuyermessage;
    }

    public Boolean getFhaspostfee() {
        return fhaspostfee;
    }

    public void setFhaspostfee(Boolean fhaspostfee) {
        this.fhaspostfee = fhaspostfee;
    }

    public Boolean getFhasyfx() {
        return fhasyfx;
    }

    public void setFhasyfx(Boolean fhasyfx) {
        this.fhasyfx = fhasyfx;
    }

    public String getFiid() {
        return fiid;
    }

    public void setFiid(String fiid) {
        this.fiid = fiid == null ? null : fiid.trim();
    }

    public String getFinvoicename() {
        return finvoicename;
    }

    public void setFinvoicename(String finvoicename) {
        this.finvoicename = finvoicename == null ? null : finvoicename.trim();
    }

    public Boolean getFis3d() {
        return fis3d;
    }

    public void setFis3d(Boolean fis3d) {
        this.fis3d = fis3d;
    }

    public Boolean getFisbrandsale() {
        return fisbrandsale;
    }

    public void setFisbrandsale(Boolean fisbrandsale) {
        this.fisbrandsale = fisbrandsale;
    }

    public Boolean getFisforcewlb() {
        return fisforcewlb;
    }

    public void setFisforcewlb(Boolean fisforcewlb) {
        this.fisforcewlb = fisforcewlb;
    }

    public Boolean getFislgtype() {
        return fislgtype;
    }

    public void setFislgtype(Boolean fislgtype) {
        this.fislgtype = fislgtype;
    }

    public Boolean getFispartconsign() {
        return fispartconsign;
    }

    public void setFispartconsign(Boolean fispartconsign) {
        this.fispartconsign = fispartconsign;
    }

    public String getFlgaging() {
        return flgaging;
    }

    public void setFlgaging(String flgaging) {
        this.flgaging = flgaging == null ? null : flgaging.trim();
    }

    public String getFlgagingtype() {
        return flgagingtype;
    }

    public void setFlgagingtype(String flgagingtype) {
        this.flgagingtype = flgagingtype == null ? null : flgagingtype.trim();
    }

    public String getFmarkdesc() {
        return fmarkdesc;
    }

    public void setFmarkdesc(String fmarkdesc) {
        this.fmarkdesc = fmarkdesc == null ? null : fmarkdesc.trim();
    }

    public Date getFmodified() {
        return fmodified;
    }

    public void setFmodified(Date fmodified) {
        this.fmodified = fmodified;
    }

    public Long getFnum() {
        return fnum;
    }

    public void setFnum(Long fnum) {
        this.fnum = fnum;
    }

    public Long getFnumiid() {
        return fnumiid;
    }

    public void setFnumiid(Long fnumiid) {
        this.fnumiid = fnumiid;
    }

    public String getFnutfeature() {
        return fnutfeature;
    }

    public void setFnutfeature(String fnutfeature) {
        this.fnutfeature = fnutfeature == null ? null : fnutfeature.trim();
    }

    public Date getFpaytime() {
        return fpaytime;
    }

    public void setFpaytime(Date fpaytime) {
        this.fpaytime = fpaytime;
    }

    public String getFpayment() {
        return fpayment;
    }

    public void setFpayment(String fpayment) {
        this.fpayment = fpayment == null ? null : fpayment.trim();
    }

    public Long getFpointfee() {
        return fpointfee;
    }

    public void setFpointfee(Long fpointfee) {
        this.fpointfee = fpointfee;
    }

    public String getFpostfee() {
        return fpostfee;
    }

    public void setFpostfee(String fpostfee) {
        this.fpostfee = fpostfee == null ? null : fpostfee.trim();
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice == null ? null : fprice.trim();
    }

    public Long getFrealpointfee() {
        return frealpointfee;
    }

    public void setFrealpointfee(Long frealpointfee) {
        this.frealpointfee = frealpointfee;
    }

    public String getFreceivedpayment() {
        return freceivedpayment;
    }

    public void setFreceivedpayment(String freceivedpayment) {
        this.freceivedpayment = freceivedpayment == null ? null : freceivedpayment.trim();
    }

    public String getFreceiveraddress() {
        return freceiveraddress;
    }

    public void setFreceiveraddress(String freceiveraddress) {
        this.freceiveraddress = freceiveraddress == null ? null : freceiveraddress.trim();
    }

    public String getFreceivercity() {
        return freceivercity;
    }

    public void setFreceivercity(String freceivercity) {
        this.freceivercity = freceivercity == null ? null : freceivercity.trim();
    }

    public String getFreceiverdistrict() {
        return freceiverdistrict;
    }

    public void setFreceiverdistrict(String freceiverdistrict) {
        this.freceiverdistrict = freceiverdistrict == null ? null : freceiverdistrict.trim();
    }

    public String getFreceivermobile() {
        return freceivermobile;
    }

    public void setFreceivermobile(String freceivermobile) {
        this.freceivermobile = freceivermobile == null ? null : freceivermobile.trim();
    }

    public String getFreceivername() {
        return freceivername;
    }

    public void setFreceivername(String freceivername) {
        this.freceivername = freceivername == null ? null : freceivername.trim();
    }

    public String getFreceiverphone() {
        return freceiverphone;
    }

    public void setFreceiverphone(String freceiverphone) {
        this.freceiverphone = freceiverphone == null ? null : freceiverphone.trim();
    }

    public String getFreceiverstate() {
        return freceiverstate;
    }

    public void setFreceiverstate(String freceiverstate) {
        this.freceiverstate = freceiverstate == null ? null : freceiverstate.trim();
    }

    public String getFreceiverzip() {
        return freceiverzip;
    }

    public void setFreceiverzip(String freceiverzip) {
        this.freceiverzip = freceiverzip == null ? null : freceiverzip.trim();
    }

    public String getFselleralipayno() {
        return fselleralipayno;
    }

    public void setFselleralipayno(String fselleralipayno) {
        this.fselleralipayno = fselleralipayno == null ? null : fselleralipayno.trim();
    }

    public Boolean getFsellercanrate() {
        return fsellercanrate;
    }

    public void setFsellercanrate(Boolean fsellercanrate) {
        this.fsellercanrate = fsellercanrate;
    }

    public String getFsellercodfee() {
        return fsellercodfee;
    }

    public void setFsellercodfee(String fsellercodfee) {
        this.fsellercodfee = fsellercodfee == null ? null : fsellercodfee.trim();
    }

    public String getFselleremail() {
        return fselleremail;
    }

    public void setFselleremail(String fselleremail) {
        this.fselleremail = fselleremail == null ? null : fselleremail.trim();
    }

    public Long getFsellerflag() {
        return fsellerflag;
    }

    public void setFsellerflag(Long fsellerflag) {
        this.fsellerflag = fsellerflag;
    }

    public String getFsellermobile() {
        return fsellermobile;
    }

    public void setFsellermobile(String fsellermobile) {
        this.fsellermobile = fsellermobile == null ? null : fsellermobile.trim();
    }

    public String getFsellername() {
        return fsellername;
    }

    public void setFsellername(String fsellername) {
        this.fsellername = fsellername == null ? null : fsellername.trim();
    }

    public String getFsellernick() {
        return fsellernick;
    }

    public void setFsellernick(String fsellernick) {
        this.fsellernick = fsellernick == null ? null : fsellernick.trim();
    }

    public String getFsellerphone() {
        return fsellerphone;
    }

    public void setFsellerphone(String fsellerphone) {
        this.fsellerphone = fsellerphone == null ? null : fsellerphone.trim();
    }

    public Boolean getFsellerrate() {
        return fsellerrate;
    }

    public void setFsellerrate(Boolean fsellerrate) {
        this.fsellerrate = fsellerrate;
    }

    public String getFsendtime() {
        return fsendtime;
    }

    public void setFsendtime(String fsendtime) {
        this.fsendtime = fsendtime == null ? null : fsendtime.trim();
    }

    public String getFshippingtype() {
        return fshippingtype;
    }

    public void setFshippingtype(String fshippingtype) {
        this.fshippingtype = fshippingtype == null ? null : fshippingtype.trim();
    }

    public String getFstatus() {
        return fstatus;
    }

    public void setFstatus(String fstatus) {
        this.fstatus = fstatus == null ? null : fstatus.trim();
    }

    public String getFsteppaidfee() {
        return fsteppaidfee;
    }

    public void setFsteppaidfee(String fsteppaidfee) {
        this.fsteppaidfee = fsteppaidfee == null ? null : fsteppaidfee.trim();
    }

    public String getFsteptradestatus() {
        return fsteptradestatus;
    }

    public void setFsteptradestatus(String fsteptradestatus) {
        this.fsteptradestatus = fsteptradestatus == null ? null : fsteptradestatus.trim();
    }

    public Long getFtid() {
        return ftid;
    }

    public void setFtid(Long ftid) {
        this.ftid = ftid;
    }

    public Date getFtimeoutactiontime() {
        return ftimeoutactiontime;
    }

    public void setFtimeoutactiontime(Date ftimeoutactiontime) {
        this.ftimeoutactiontime = ftimeoutactiontime;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle == null ? null : ftitle.trim();
    }

    public String getFtotalfee() {
        return ftotalfee;
    }

    public void setFtotalfee(String ftotalfee) {
        this.ftotalfee = ftotalfee == null ? null : ftotalfee.trim();
    }

    public String getFtradefrom() {
        return ftradefrom;
    }

    public void setFtradefrom(String ftradefrom) {
        this.ftradefrom = ftradefrom == null ? null : ftradefrom.trim();
    }

    public String getFtradememo() {
        return ftradememo;
    }

    public void setFtradememo(String ftradememo) {
        this.ftradememo = ftradememo == null ? null : ftradememo.trim();
    }

    public String getFtradesource() {
        return ftradesource;
    }

    public void setFtradesource(String ftradesource) {
        this.ftradesource = ftradesource == null ? null : ftradesource.trim();
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    public String getFyfxfee() {
        return fyfxfee;
    }

    public void setFyfxfee(String fyfxfee) {
        this.fyfxfee = fyfxfee == null ? null : fyfxfee.trim();
    }

    public String getFyfxid() {
        return fyfxid;
    }

    public void setFyfxid(String fyfxid) {
        this.fyfxid = fyfxid == null ? null : fyfxid.trim();
    }

    public Long getFyfxtype() {
        return fyfxtype;
    }

    public void setFyfxtype(Long fyfxtype) {
        this.fyfxtype = fyfxtype;
    }

    public String getFplatformshopid() {
        return fplatformshopid;
    }

    public void setFplatformshopid(String fplatformshopid) {
        this.fplatformshopid = fplatformshopid == null ? null : fplatformshopid.trim();
    }

    public Integer getFconvertcount() {
        return fconvertcount;
    }

    public void setFconvertcount(Integer fconvertcount) {
        this.fconvertcount = fconvertcount;
    }

    public String getFconvertmsg() {
        return fconvertmsg;
    }

    public void setFconvertmsg(String fconvertmsg) {
        this.fconvertmsg = fconvertmsg == null ? null : fconvertmsg.trim();
    }

    public Integer getFversion() {
        return fversion;
    }

    public void setFversion(Integer fversion) {
        this.fversion = fversion;
    }

    public String getFplatformid() {
        return fplatformid;
    }

    public void setFplatformid(String fplatformid) {
        this.fplatformid = fplatformid == null ? null : fplatformid.trim();
    }

    public Boolean getFshoppick() {
        return fshoppick;
    }

    public void setFshoppick(Boolean fshoppick) {
        this.fshoppick = fshoppick;
    }

    public String getFstorecode() {
        return fstorecode;
    }

    public void setFstorecode(String fstorecode) {
        this.fstorecode = fstorecode == null ? null : fstorecode.trim();
    }

    public Long getFtenantid() {
        return ftenantid;
    }

    public void setFtenantid(Long ftenantid) {
        this.ftenantid = ftenantid;
    }

    public Integer getFtradegenerrcount() {
        return ftradegenerrcount;
    }

    public void setFtradegenerrcount(Integer ftradegenerrcount) {
        this.ftradegenerrcount = ftradegenerrcount;
    }

    public String getFtradegenerrmsg() {
        return ftradegenerrmsg;
    }

    public void setFtradegenerrmsg(String ftradegenerrmsg) {
        this.ftradegenerrmsg = ftradegenerrmsg == null ? null : ftradegenerrmsg.trim();
    }

    public String getFinvoicetype() {
        return finvoicetype;
    }

    public void setFinvoicetype(String finvoicetype) {
        this.finvoicetype = finvoicetype == null ? null : finvoicetype.trim();
    }

    public String getFinvoicekind() {
        return finvoicekind;
    }

    public void setFinvoicekind(String finvoicekind) {
        this.finvoicekind = finvoicekind == null ? null : finvoicekind.trim();
    }

    public String getFbuyertaxno() {
        return fbuyertaxno;
    }

    public void setFbuyertaxno(String fbuyertaxno) {
        this.fbuyertaxno = fbuyertaxno == null ? null : fbuyertaxno.trim();
    }

    public String getFbuyermemo() {
        return fbuyermemo;
    }

    public void setFbuyermemo(String fbuyermemo) {
        this.fbuyermemo = fbuyermemo == null ? null : fbuyermemo.trim();
    }

    public String getFbuyermessage() {
        return fbuyermessage;
    }

    public void setFbuyermessage(String fbuyermessage) {
        this.fbuyermessage = fbuyermessage == null ? null : fbuyermessage.trim();
    }

    public String getFpicpath() {
        return fpicpath;
    }

    public void setFpicpath(String fpicpath) {
        this.fpicpath = fpicpath == null ? null : fpicpath.trim();
    }

    public String getFsellermemo() {
        return fsellermemo;
    }

    public void setFsellermemo(String fsellermemo) {
        this.fsellermemo = fsellermemo == null ? null : fsellermemo.trim();
    }

    public String getFsnapshot() {
        return fsnapshot;
    }

    public void setFsnapshot(String fsnapshot) {
        this.fsnapshot = fsnapshot == null ? null : fsnapshot.trim();
    }

    public String getFsnapshoturl() {
        return fsnapshoturl;
    }

    public void setFsnapshoturl(String fsnapshoturl) {
        this.fsnapshoturl = fsnapshoturl == null ? null : fsnapshoturl.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fid=").append(fid);
        sb.append(", ftradeprocessstatus=").append(ftradeprocessstatus);
        sb.append(", fcreatetime=").append(fcreatetime);
        sb.append(", fsaleorderid=").append(fsaleorderid);
        sb.append(", fsaleordernumber=").append(fsaleordernumber);
        sb.append(", flastupdatetime=").append(flastupdatetime);
        sb.append(", fadjustfee=").append(fadjustfee);
        sb.append(", falipayid=").append(falipayid);
        sb.append(", falipayno=").append(falipayno);
        sb.append(", falipayurl=").append(falipayurl);
        sb.append(", falipaywarnmsg=").append(falipaywarnmsg);
        sb.append(", fareaid=").append(fareaid);
        sb.append(", favailableconfirmfee=").append(favailableconfirmfee);
        sb.append(", fbuyeralipayno=").append(fbuyeralipayno);
        sb.append(", fbuyerarea=").append(fbuyerarea);
        sb.append(", fbuyercodfee=").append(fbuyercodfee);
        sb.append(", fbuyeremail=").append(fbuyeremail);
        sb.append(", fbuyerflag=").append(fbuyerflag);
        sb.append(", fbuyernick=").append(fbuyernick);
        sb.append(", fbuyerobtainpointfee=").append(fbuyerobtainpointfee);
        sb.append(", fbuyerrate=").append(fbuyerrate);
        sb.append(", fcanrate=").append(fcanrate);
        sb.append(", fcodfee=").append(fcodfee);
        sb.append(", fcodstatus=").append(fcodstatus);
        sb.append(", fcommissionfee=").append(fcommissionfee);
        sb.append(", fconsigntime=").append(fconsigntime);
        sb.append(", fcreated=").append(fcreated);
        sb.append(", fcreditcardfee=").append(fcreditcardfee);
        sb.append(", fdiscountfee=").append(fdiscountfee);
        sb.append(", fendtime=").append(fendtime);
        sb.append(", feticketext=").append(feticketext);
        sb.append(", fexpressagencyfee=").append(fexpressagencyfee);
        sb.append(", fhasbuyermessage=").append(fhasbuyermessage);
        sb.append(", fhaspostfee=").append(fhaspostfee);
        sb.append(", fhasyfx=").append(fhasyfx);
        sb.append(", fiid=").append(fiid);
        sb.append(", finvoicename=").append(finvoicename);
        sb.append(", fis3d=").append(fis3d);
        sb.append(", fisbrandsale=").append(fisbrandsale);
        sb.append(", fisforcewlb=").append(fisforcewlb);
        sb.append(", fislgtype=").append(fislgtype);
        sb.append(", fispartconsign=").append(fispartconsign);
        sb.append(", flgaging=").append(flgaging);
        sb.append(", flgagingtype=").append(flgagingtype);
        sb.append(", fmarkdesc=").append(fmarkdesc);
        sb.append(", fmodified=").append(fmodified);
        sb.append(", fnum=").append(fnum);
        sb.append(", fnumiid=").append(fnumiid);
        sb.append(", fnutfeature=").append(fnutfeature);
        sb.append(", fpaytime=").append(fpaytime);
        sb.append(", fpayment=").append(fpayment);
        sb.append(", fpointfee=").append(fpointfee);
        sb.append(", fpostfee=").append(fpostfee);
        sb.append(", fprice=").append(fprice);
        sb.append(", frealpointfee=").append(frealpointfee);
        sb.append(", freceivedpayment=").append(freceivedpayment);
        sb.append(", freceiveraddress=").append(freceiveraddress);
        sb.append(", freceivercity=").append(freceivercity);
        sb.append(", freceiverdistrict=").append(freceiverdistrict);
        sb.append(", freceivermobile=").append(freceivermobile);
        sb.append(", freceivername=").append(freceivername);
        sb.append(", freceiverphone=").append(freceiverphone);
        sb.append(", freceiverstate=").append(freceiverstate);
        sb.append(", freceiverzip=").append(freceiverzip);
        sb.append(", fselleralipayno=").append(fselleralipayno);
        sb.append(", fsellercanrate=").append(fsellercanrate);
        sb.append(", fsellercodfee=").append(fsellercodfee);
        sb.append(", fselleremail=").append(fselleremail);
        sb.append(", fsellerflag=").append(fsellerflag);
        sb.append(", fsellermobile=").append(fsellermobile);
        sb.append(", fsellername=").append(fsellername);
        sb.append(", fsellernick=").append(fsellernick);
        sb.append(", fsellerphone=").append(fsellerphone);
        sb.append(", fsellerrate=").append(fsellerrate);
        sb.append(", fsendtime=").append(fsendtime);
        sb.append(", fshippingtype=").append(fshippingtype);
        sb.append(", fstatus=").append(fstatus);
        sb.append(", fsteppaidfee=").append(fsteppaidfee);
        sb.append(", fsteptradestatus=").append(fsteptradestatus);
        sb.append(", ftid=").append(ftid);
        sb.append(", ftimeoutactiontime=").append(ftimeoutactiontime);
        sb.append(", ftitle=").append(ftitle);
        sb.append(", ftotalfee=").append(ftotalfee);
        sb.append(", ftradefrom=").append(ftradefrom);
        sb.append(", ftradememo=").append(ftradememo);
        sb.append(", ftradesource=").append(ftradesource);
        sb.append(", ftype=").append(ftype);
        sb.append(", fyfxfee=").append(fyfxfee);
        sb.append(", fyfxid=").append(fyfxid);
        sb.append(", fyfxtype=").append(fyfxtype);
        sb.append(", fplatformshopid=").append(fplatformshopid);
        sb.append(", fconvertcount=").append(fconvertcount);
        sb.append(", fconvertmsg=").append(fconvertmsg);
        sb.append(", fversion=").append(fversion);
        sb.append(", fplatformid=").append(fplatformid);
        sb.append(", fshoppick=").append(fshoppick);
        sb.append(", fstorecode=").append(fstorecode);
        sb.append(", ftenantid=").append(ftenantid);
        sb.append(", ftradegenerrcount=").append(ftradegenerrcount);
        sb.append(", ftradegenerrmsg=").append(ftradegenerrmsg);
        sb.append(", finvoicetype=").append(finvoicetype);
        sb.append(", finvoicekind=").append(finvoicekind);
        sb.append(", fbuyertaxno=").append(fbuyertaxno);
        sb.append(", fbuyermemo=").append(fbuyermemo);
        sb.append(", fbuyermessage=").append(fbuyermessage);
        sb.append(", fpicpath=").append(fpicpath);
        sb.append(", fsellermemo=").append(fsellermemo);
        sb.append(", fsnapshot=").append(fsnapshot);
        sb.append(", fsnapshoturl=").append(fsnapshoturl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}