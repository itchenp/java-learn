package com.ithub.source.learn.base;

import org.json.JSONObject;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author CP.
 * @date 2022-02-15 16:14
 */
public class TestFive {

    @Test
    public void test01(){
        for (int i = 1; i < 11; i++) {
            Random random = new Random(10);
            int ii = random.nextInt(i*10+i);
            System.out.println(ii);
        }

    }

    @Test
    public void test02(){
        String a = "abc";
        String b = new String("abc");
        String c = b.intern();

        System.out.println(a==b);
        System.out.println(b==c);
        System.out.println(a==c);
    }

    @Test
    public void test03(){
        int i = new BigDecimal("0.1").multiply(new BigDecimal(String.valueOf(1))).intValue();
        System.out.println(i);
    }

    @Test
    public void test04(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY,-24);
        SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd");

        System.out.println(sf.format(cal.getTime()));

        int h = 5;
        System.out.println("0"+h);
    }

    @Test
    public void test05() throws IOException {
        String url = "https://nim-nosdn.netease.im/NDMyMjg0MA==/bmltYV80OTUyNDM0NDA5OV8xNjQzOTg0ODE3NDU0X2I5MTZlMzkxLWI0ZTAtNDA1Yy05ODc2LTFhN2Q1NTQ5ZWI4YQ==?createTime=1646204586144";
        System.out.println(getFileName(url));

        System.out.println(UUID.randomUUID());

        String mp = "-0.93%";
        mp = mp.substring(0,mp.length()-1);
        System.out.println(mp);

    }


    @Test
    public void test06(){
        String voucherAmount= "1=500000,2=200000,3=100000,4-10=50000,11-15=20000,16-20=10000";
        Map<Integer,MtCouponIdEnum> map = new HashMap<>(20);
        String[] split = voucherAmount.split(",");
        for (String str : split) {
            if(str.contains("-")){
                String[] split1 = str.split("=");
                MtCouponIdEnum couponIdEnum = MtCouponIdEnum.getEnumByMoney(Integer.valueOf(split1[1]));
                String[] split2 = split1[0].split("-");
                int start = Integer.valueOf(split2[0]);
                int end = Integer.valueOf(split2[1]);
                for (int i = start; i <=end ; i++) {
                    map.put(i,couponIdEnum);
                }
            }else{
                String[] split1 = str.split("=");
                map.put(Integer.valueOf(split1[0]),MtCouponIdEnum.getEnumByMoney(Integer.valueOf(split1[1])));
            }
        }

        System.out.println(map);
    }

    @Test
    public void test07(){

        Calendar calendar1 = Calendar.getInstance();

        System.out.println(getMinDateMonth(sdf.format(calendar1.getTime())));
        System.out.println(getMaxDateMonth(sdf.format(calendar1.getTime())));
        calendar1.setTime(calendar1.getTime());
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.add(Calendar.DATE, -1);
        System.out.println(getMinDateMonth(sdf.format(calendar1.getTime())));
        System.out.println(getMaxDateMonth(sdf.format(calendar1.getTime())));
        calendar1.setTime(calendar1.getTime());
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        calendar1.add(Calendar.DATE, -1);
        System.out.println(getMinDateMonth(sdf.format(calendar1.getTime())));
        System.out.println(getMaxDateMonth(sdf.format(calendar1.getTime())));
    }
    private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
    private static Calendar calendar=Calendar.getInstance();


    public static Date getMinDateMonth(String month){
        try {
            Date nowDate=sdf.parse(month);
            calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
            return calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
        输入日期字符串，返回当月最后一天的Date
    */
    public static Date getMaxDateMonth(String month){
        try {
            Date nowDate=sdf.parse(month);
            calendar = Calendar.getInstance();
            calendar.setTime(nowDate);
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
            calendar.set(Calendar.MILLISECOND,0);
            calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
            return calendar.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getFileName(String urlStr) throws IOException {
        BufferedInputStream bis = null;
        HttpURLConnection urlconnection = null;
        URL url = null;
        url = new URL(urlStr);
        urlconnection = (HttpURLConnection) url.openConnection();
        urlconnection.connect();
        bis = new BufferedInputStream(urlconnection.getInputStream());
        System.out.println("file type:"+HttpURLConnection.guessContentTypeFromStream(bis));

        return HttpURLConnection.guessContentTypeFromStream(bis);
    }
}
