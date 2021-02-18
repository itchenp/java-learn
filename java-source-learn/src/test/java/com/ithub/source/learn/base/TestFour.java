package com.ithub.source.learn.base;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFour {

    @Test
    public void test01(){
        // 正则匹配
        String str ="";
        String patten = "^(1)|(2)|(3)|(4)|(5)|(6)|$";

        Pattern p=Pattern.compile(patten);
        Matcher m=p.matcher(str);
        System.out.println(m.matches());
    }

    @Test
    public void test02(){
        BigDecimal one = new BigDecimal(-0.02);
        BigDecimal two = new BigDecimal(0);
        System.out.println(one.compareTo(two));
    }

    @Test
    public void test03(){
        List<String> list = Arrays.asList("a","ab","abc","abcd");
    }

    @Test
    public void test04() throws UnsupportedEncodingException {
        String message = "[{\"id\":\"2112020082527747\",\"desc\":\"银联单品测试联调-满减\",\"type\":\"CP01\",\"spnsrId\":\"00010000\",\"offstAmt\":\"1000\"}]";
        System.out.println(URLEncoder.encode(message,"UTF-8"));

        String encodingMessage = "acqCode%3D48430000%26certId%3D68759529225%26couponInfo%3D%5B%7B%22id%22%3A%222112020082527747%22%2C%22desc%22%3A%22%E9%93%B6%E8%81%94%E5%8D%95%E5%93%81%E6%B5%8B%E8%AF%95%E8%81%94%E8%B0%83-%E6%BB%A1%E5%87%8F%22%2C%22type%22%3A%22CP01%22%2C%22spnsrId%22%3A%2200010000%22%2C%22offstAmt%22%3A%221000%22%7D%5D%26currencyCode%3D156%26issAddnData%3D%7B%22dctDetail%22%3A%5B%7B%22id%22%3A%22testsp000001%22%2C%22dctQuantity%22%3A%222%22%2C%22dctPrice%22%3A%22500%22%2C%22dctId%22%3A%222112020082527747%22%7D%2C%7B%22id%22%3A%22testsp000002%22%2C%22dctQuantity%22%3A%222%22%2C%22dctPrice%22%3A%22500%22%2C%22dctId%22%3A%222112020082527747%22%7D%5D%7D%26orderNo%3D20201113100000804344%26orderTime%3D20201113113304%26origOrderNo%3D20201113100000804328%26origOrderTime%3D20201113110053%26reqType%3D0340000903%26signature%3DV1TwsYk2xwmnJ9abNhKVAkHu0r5RmKn4Z00tI9e4ZT3%252BsGgfczSsQMv1A9SbyzujdPndN6Yb65rR%252FNyuU2nMlCdNMTACwNDkXdBfq0%252BPgeLmukQwXpKEArRrmIgUxTTrQ1JXn6nVKG%252BP4cQ8B6TwVIuIPgo4NFgk2XWVFgK8dBLWO7sCC9670cEoQEOM9q7zsBrbfPDjk%252Bg67p4YzSM%252BQPADISANKdcSjDVJRXnAljaewnhdylvvOPWD7woVehJMpzXCCie4vlqfcxNqXxPUPUTIJDsPmcRVe%252B%252B%252FXaHEkg84VfjfIxn%252F5sGf8fymxmH13GHt2TKQBt%252FvDP006e1Ofw%253D%253D%26txnAmt%3D4200%26version%3D1.0.0";
        System.out.println(URLDecoder.decode(encodingMessage));


    }
}
