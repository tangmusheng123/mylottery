// const baseUrl = 'http://tools.baho.cn:30002'
// 测试地址
const baseUrl = "http://localhost:8080";

//查询接口
const inquireUrl = baseUrl + "/lottery/queryByObject";




// 一键领取接口
const getAllUrl = baseUrl + "/lottery/receivePrize";
//获取活动信息
const getmsgList = baseUrl + "/lottery/getActInfo";


// ----------------固定--------------------
//关注跳转地址KUB or DIAI
const KUBjumpAddress =
    "https://keyoubi.m.tmall.com/?spm=a222m.7628550.1998338745.2";
const DiAijumpAddress =
    "https://diai.m.tmall.com/?spm=a320p.7692363.0.0.9aef50adOTLUYe";

// 图片地址
const kubLogo = baseUrl + "/platform/kub_logo.png";
const kubbgImg = baseUrl + "/platform/kub_background.png";
const diaiLogo = baseUrl + "/platform/diai_logo.png";
const diaibgImg = baseUrl + "/platform/diai_background.png";

// 页面地址
// https://ityp.baho.cn:8094/mylottery/index.html
// https://ityp.baho.cn:8094/mylottery/index.html#diai-