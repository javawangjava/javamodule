package com.wang.webrequest;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;


/*
 *
 * 在Java中已经为我们提供了编码和解码的API工具类可以让我们更快速的进行编码和解码:
 * Class URLEncoder：HTML表单编码的实用程序类。
 *       1.static String encode(String s, String enc)：第二个参数是编码格式，使用特定编码方案将字符串转换为 application/x-www-form-urlencoded格式。
 *       2.static String encode(String s, Charset charset)： 使用特定的Charset将字符串转换为application/x-www-form-urlencoded格式。
 *
 * Class URLDecoder：用于HTML表单解码的实用程序类。
 *       1.static String decode(String s, String enc) 使用特定编码方案解码 application/x-www-form-urlencoded字符串。
 *       2.static String decode(String s, Charset charset) 使用特定的Charset解码application/x-www-form-urlencoded字符串。
 *
 * ISO-8859-1:是单字节编码，它总共能表示256个字符。
 * UTF-8:采用了一种变长技术，每个编码区域有不同的字码长度。不同类型的字符可以由1~6个字节组成。
 *
 * * */


public class URLCoder {
    public static void main(String[] args) throws UnsupportedEncodingException {

        // 编码和解码的指定格式一样，这样信息传递才会正确
        System.out.println("=========编码和解码的指定格式一样，这样信息传递才会正确==========");
        String str1 ="荣耀笔记本";
        // URL编码
        String str1Encode = URLEncoder.encode(str1, "UTF-8");
        System.out.println("荣耀笔记本:UTF-8:"+str1Encode);
        // URL解码
        String str1Decode = URLDecoder.decode(str1Encode, "UTF-8");
        System.out.println("荣耀笔记本:UTF-8:"+str1Decode);
        System.out.println(str1.equals(str1Decode));
        System.out.println("==========================");


        // 编码和解码的指定格式不一样，这样信息传递不会正确
        System.out.println("=========编码和解码的指定格式一样，这样信息传递才会正确==========");
        String str2 ="荣耀笔记本";
        // URL编码
        String str2Encode = URLEncoder.encode(str2, "UTF-8");
        System.out.println("荣耀笔记本:UTF-8:"+str2Encode);
        // URL解码
        String str2Decode = URLDecoder.decode(str2Encode, "GBK");
        System.out.println("荣耀笔记本:GBK:"+str2Decode);
        System.out.println(str2.equals(str2Decode));
        System.out.println("==========================");



        // ISO-8859-1编码不支持中文，所以即使对于中文的编码和解码都指定ISO-8859-1格式，中文显示都会乱码。
        System.out.println("=========ISO-8859-1编码不支持中文，所以即使对于中文的编码和解码都指定ISO-8859-1格式，中文显示都会乱码==========");
        String str3 ="荣耀笔记本";
        // URL编码
        String str3Encode = URLEncoder.encode(str3, "ISO-8859-1");
        System.out.println(str3Encode);
        // URL解码
        String str3Decode = URLDecoder.decode(str3Encode, "ISO-8859-1");
        System.out.println(str3Decode);
        System.out.println("==========================");


        // 下面这个就是GET请求中文参数乱码解决方案。
        // ISO-8859-1:是单字节编码，它总共能表示256个字符。
        // 【GET请求中文参数乱码解决方案】：
        //*      1.在进行编码和解码的时候，不管使用的是哪个字符集，同一个数据编码后和解码前对应的表示形式是一样的【就是URL编码后的那个数据形式】
        //*      【URL编码:具体编码过程分两步:(1)将字符串按照编码方式转为二进制;(2)每个字节转为2个16进制数并在前边加上%】
        //*      2.将按照ISO-8859-1的URL解码后得到的数据再按照ISO-8859-1编码转换为对应的字节数组；
        //*      3.将上面的字节数组按照UTF-8编码转换为对应的字符串；
        System.out.println("==========================");
        String username = "荣耀笔记本";
        // 1.URL编码，并指定编码格式为UTF-8
        String encodeUtf = URLEncoder.encode(username, "UTF-8");
        System.out.println(encodeUtf);
        // 2.URL解码,并指定解码格式为ISO-8859-1。ISO-8859-1编码不支持中文，所以会乱码
        String decodeIso = URLDecoder.decode(encodeUtf, "ISO-8859-1");
        System.out.println(decodeIso);

        //3. 将按照ISO-8859-1解码后的字符串按照ISO-8859-1编码格式转换为字节数据，编码
        byte[] bytes=decodeIso.getBytes("ISO-8859-1");

        //4. 将按照ISO-8859-1编码的字节数组转为字符串，解码
        String str=new String(bytes,"UTF-8");
        System.out.println(str);
        System.out.println("==========================");



    }
}
