package com.asiabill.common.utils;

import com.asiabill.form.QueryOrderResultForm;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Xiongyancong
 * @create: 2020-07-03 11:52
 * 解析返回订单信息xml格式数据
 */

@Slf4j
public class XmlUtil {

    /**
     * 解析查询订单结果方法
     * @param clazz 解析结果对象
     * @param resultXml 解析xml格式数据
     * @param orderSign 每个订单标签的标志
     * @return
     * @throws InstantiationException
     */
    public static List<Object> parseResultXml(Class<?> clazz, String resultXml, String orderSign) throws InstantiationException {
        if (StringUtils.isBlank(resultXml)) {
            log.error("解析xml数据为空");
            return null;
        }
        resultXml = resultXml.replaceAll("\\n", "").replaceAll("\\r","");
        List<String> orderList = getOrderInfo(resultXml,orderSign);
        List<Object> objects = new ArrayList<>();

        Field[] farray = clazz.getDeclaredFields();

        //获取对象数据
        orderList.forEach(order -> {
            Object newobj = null;
            try {
                newobj = clazz.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                log.error("通过Class获得实例异常[{}]", clazz.getName());
                log.error(StringHandleUtils.getExceptionInfo(e));
                return;
            }

            //遍历对象属性
            for (Field field : farray) {
                //获取字段名字
                String fieldName = field.getName();

                //获取xml节点值
                String elementValue = getParaByName(order,fieldName);
                log.info("解析属性{} = {}",fieldName,elementValue);

                //设置值
                if (StringUtils.isNotEmpty(elementValue)) {
                    //获取字段值
                    field.setAccessible(true);
                    try {
                        field.set(newobj,elementValue);
                    } catch (IllegalAccessException e) {
                        log.error("解析xml组装新对象设值异常[fieldName={}, value={}]", fieldName, elementValue);
                        log.error(StringHandleUtils.getExceptionInfo(e));
                    }
                }
            }
            objects.add(newobj);
        });
        return objects;
    }

    private static List<String> getOrderInfo(String resultxml, String orderSign) {
        List<String> orderList = new ArrayList<String>();

        Pattern pattern = Pattern.compile("(<" + orderSign + ">)(.*?)(/" + orderSign + ">)");
        Matcher matcher = pattern.matcher(resultxml);
        while (matcher.find()) {
            orderList.add(matcher.group(2));
        }
        return orderList;
    }
    /**
     * 根据节点名称获取相应值
     * @param xml
     * @param name
     * @return
     */
    private static String getParaByName(String xml, String name){
        return getParaByReg(xml, "<"+name+">(.*)</"+name+">");
    }

    /**
     * 根据正则表达式拿取匹配的字符串
     * @param  xml
     * @param reg "<sign>(.*)</sign>"
     * @return
     */
    private static String getParaByReg(String xml, String reg) {
        String r = "";
        try{
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(xml);
            if(m.find()) {
                r = m.group(1).trim();
            }
        }catch (Exception e) {
            log.error("根据正则表达式拿取匹配的字符串异常[{}]", reg);
            log.error(StringHandleUtils.getExceptionInfo(e));
        }
        return r;
    }


    public static void main(String[] args) {
        String xmlStr = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<response>\n" +
                "<tradeinfo>\n" +
                "<merNo>12259</merNo>\n" +
                "<gatewayNo>12259001</gatewayNo>\n" +
                "<orderNo>1700218799364</orderNo>\n" +
                "<tradeNo>2020070112250803460679</tradeNo>\n" +
                "<tradeDate></tradeDate>\n" +
                "<tradeAmount>0.01</tradeAmount>\n" +
                "<tradeCurrency>USD</tradeCurrency>\n" +
                "<authStatus>0</authStatus>\n" +
                "<sourceWebSite></sourceWebSite>\n" +
                "<queryResult>0</queryResult>\n" +
                "<barcode></barcode>\n" +
                "<paytime></paytime>\n" +
                "<clearStatus></clearStatus>\n" +
                "</tradeinfo>\n" +
                "\n" +
                "\n" +
                "<tradeinfo>\n" +
                "<merNo>12259</merNo>\n" +
                "<gatewayNo>12259001</gatewayNo>\n" +
                "<orderNo>1593488161062</orderNo>\n" +
                "<tradeNo>2020063011461226181887</tradeNo>\n" +
                "<tradeDate>2020-06-30 11:47:20</tradeDate>\n" +
                "<tradeAmount>0.01</tradeAmount>\n" +
                "<tradeCurrency>USD</tradeCurrency>\n" +
                "<authStatus>0</authStatus>\n" +
                "<sourceWebSite>https://sandbox-pay.asiabill.com/pages/PayTest.jsp</sourceWebSite>\n" +
                "<queryResult>1</queryResult>\n" +
                "<barcode></barcode>\n" +
                "<paytime></paytime>\n" +
                "<clearStatus>0</clearStatus>\n" +
                "</tradeinfo>\n" +
                "\n" +
                "\n" +
                "</response>";

        try {
            System.out.println(XmlUtil.parseResultXml(QueryOrderResultForm.class, xmlStr,"tradeinfo").toString());
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
