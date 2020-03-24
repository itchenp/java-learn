package com.ithub.source.learn.certificate;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CertManager {

    public static void main(String[] args) throws Exception {

        readX509CerFile("D:\\TEMP\\CP\\JF\\doc\\acp_test_verify_sign.cer");


    }

    public static void readX509CerFile(String path) throws Exception{
        try {
            // 读取证书文件

            File file = new File(path);
            InputStream inStream = new FileInputStream(file);
            // 创建X509工厂类
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            //CertificateFactory cf = CertificateFactory.getInstance("X509");
            // 创建证书对象
            X509Certificate oCert = (X509Certificate) cf
                    .generateCertificate(inStream);
            inStream.close();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
            String info = null;
            // 获得证书版本
            info = String.valueOf(oCert.getVersion());
            System.out.println("证书版本:" + info);
            // 获得证书序列号
            info = new BigInteger(oCert.getSerialNumber().toString(), 10).toString(16);
            System.out.println("证书序列号:" + info);
            // 获得证书有效期
            Date beforedate = oCert.getNotBefore();
            info = dateformat.format(beforedate);
            System.out.println("证书生效日期:" + info);
            Date afterdate = oCert.getNotAfter();
            info = dateformat.format(afterdate);
            System.out.println("证书失效日期:" + info);
            // 获得证书主体信息
            info = oCert.getSubjectDN().getName();
            System.out.println("证书拥有者:" + info);
            // 获得证书颁发者信息
            info = oCert.getIssuerDN().getName();
            System.out.println("证书颁发者:" + info);
            // 获得证书签名算法名称
            info = oCert.getSigAlgName();
            System.out.println("证书签名算法:" + info);

        } catch (Exception e) {
            System.out.println("解析证书出错！");
            e.printStackTrace();
        }
    }

}
