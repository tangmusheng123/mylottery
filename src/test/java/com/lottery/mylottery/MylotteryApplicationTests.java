package com.lottery.mylottery;

import com.lottery.mylottery.common.BaseResponse;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MylotteryApplicationTests {

    @Test
    public void contextLoads() {
        String fstatus="TRADE_FINISHED";
        if(fstatus==null || StringUtils.isBlank(fstatus) ){
            System.out.println("111");
        }else if("TRADE_FINISHED".equals(fstatus)){
            System.out.println("222"+fstatus);
        }
        System.out.println("333");
    }

    public static void main(String[] args) {

    }

}
