package com.lottery.mylottery.common;



public class DictConstant {

    public enum tradeNumStatus {

        /*交易状态*/
        trade_no_create_pay("没有创建支付宝交易", "TRADE_NO_CREATE_PAY"),
        wait_buyer_pay("等待买家付款", "WAIT_BUYER_PAY"),
        seller_consigned_part("卖家部分发货", "SELLER_CONSIGNED_PART"),
        wait_seller_send_goods("买家已付款", "WAIT_SELLER_SEND_GOODS"),
        wait_buyer_confirm_goods("卖家已发货", "WAIT_BUYER_CONFIRM_GOODS"),
        trade_buyer_signed("买家已签收", "TRADE_BUYER_SIGNED"),
        trade_finished("交易成功", "TRADE_FINISHED"),
        trade_closed("交易关闭", "TRADE_CLOSED"),
        trade_closed_by_taobao("交易关闭", "TRADE_CLOSED_BY_TAOBAO");

        private String name;
        private String code;

        tradeNumStatus(String name, String code) {
            this.name = name;
            this.code = code;
        }

        public static String getByValue(String value) {
            if (value == null) {
                return null;
            }
            for (tradeNumStatus type : tradeNumStatus.values()) {
                if (type.getCode().equalsIgnoreCase(value)) {
                    return type.getName();
                }
            }
            return null;
        }
        public static String getByName(String name) {
            if (name == null) {
                return null;
            }
            for (tradeNumStatus type : tradeNumStatus.values()) {
                if (type.getName().equalsIgnoreCase(name)) {
                    return type.getCode();
                }
            }
            return null;
        }
        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }
    }


}
