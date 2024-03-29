package com.itheima.d2_simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
    秒杀活动
 */
public class SimpleDateFormatTest3 {
    public static void main(String[] args) throws ParseException {

        // 1.开始和结束时间
        String startTime = "2022-6-1 00:00:00";
        String endTime = "2022-6-1 00:10:00";
        // 2. 小贾和小皮
        String xiaoJia = "2022-6-1 00:03:35";
        String xiaoPi = "2022-6-1 00:10:08";

        // 3. 解析他们的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = sdf.parse(startTime);
        Date d2 = sdf.parse(endTime);
        Date d3 = sdf.parse(xiaoJia);
        Date d4 = sdf.parse(xiaoPi);

        // 4. 判断是否秒杀成功
        if (d3.after(d1) && d3.before(d2)){
            System.out.println("小贾秒杀成功，可以发货了。");
        }else {
            System.out.println("小贾秒杀失败。");
        }

        if (d4.after(d1) && d4.before(d2)){
            System.out.println("小皮秒杀成功，可以发货了。");
        }else {
            System.out.println("小皮秒杀失败。");
        }

    }
}
