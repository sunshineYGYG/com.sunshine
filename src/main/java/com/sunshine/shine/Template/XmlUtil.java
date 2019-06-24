package com.sunshine.shine.Template;

import com.sunshine.shine.Module.WxTextModel;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.junit.Test;

import javax.xml.bind.*;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class XmlUtil {

    @Test
    public void test(){
        WxTextModel wxTextModel=new WxTextModel();
        String txml=//"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xml>\n" +
                "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                "  <CreateTime>1348831860</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[this is a test]]></Content>\n" +
                "  <MsgId>1234567890123456</MsgId>\n" +
                "</xml>";

        String t2xml="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xml>\n" +
                "\t<content>sunshine is pig</content>\n" +
                "\t<createTime>1559115526559</createTime>\n" +
                "\t<fromUserName>cus</fromUserName>\n" +
                "\t<msgId>123</msgId>\n" +
                "\t<msgType>text</msgType>\n" +
                "\t<toUserName>tst</toUserName>\n" +
                "</xml>";

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(WxTextModel.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader stringReader = new StringReader(txml);
            WxTextModel unmarshal1 = (WxTextModel) unmarshaller.unmarshal(stringReader);
            System.out.println(unmarshal1.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){
        WxTextModel wxTextModel=new WxTextModel();
        wxTextModel.setMsgType("text");
        wxTextModel.setFromUserName("cus");
        wxTextModel.setToUserName("tst");
        wxTextModel.setMsgId("123");
        wxTextModel.setCreateTime(System.currentTimeMillis()+"");
        wxTextModel.setContent("sunshine is pig");
        String re="";
//        JAXB.marshal(wxTextModel, re);
//        System.out.println(re);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(WxTextModel.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            StringWriter writer=new StringWriter();
            marshaller.marshal(wxTextModel,writer);
            String s = writer.toString();
            System.out.println(s);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        String txml=//"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<xml>\n" +
                        "  <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
                        "  <FromUserName><![CDATA[fromUser]]></FromUserName>\n" +
                        "  <CreateTime>1348831860</CreateTime>\n" +
                        "  <MsgType><![CDATA[text]]></MsgType>\n" +
                        "  <Content><![CDATA[this is a test]]></Content>\n" +
                        "  <MsgId>1234567890123456</MsgId>\n" +
                        "</xml>";

        XStream xStream=new XStream();
        xStream.processAnnotations(WxTextModel.class);
        WxTextModel wxTextModel = (WxTextModel) xStream.fromXML(txml);
        System.out.println(wxTextModel.toString());
    }

    @Test
    public void test4(){

        WxTextModel wxTextModel=new WxTextModel();
        wxTextModel.setMsgType("text");
        wxTextModel.setFromUserName("cus");
        wxTextModel.setToUserName("tst");
        wxTextModel.setMsgId("123");
        wxTextModel.setCreateTime(System.currentTimeMillis()+"");
        wxTextModel.setContent("sunshine is pig");

        XStream xStream=new XStream(new XppDriver(new XmlFriendlyNameCoder("_-","_")));
        xStream.processAnnotations(WxTextModel.class);
        System.out.println(xStream.toXML(wxTextModel));
    }


    @Test
    public void test5(){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(1560221561), ZoneId.systemDefault());
        System.out.println(localDateTime);
    }
}
