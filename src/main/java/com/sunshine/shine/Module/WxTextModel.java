package com.sunshine.shine.Module;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.Value;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Data
@XStreamAlias(value = "xml")
//@XmlRootElement(name = "xml")
//@XmlAccessorType(XmlAccessType.FIELD)
public class WxTextModel {
    @XStreamAlias(value = "ToUserName")
    private String ToUserName;
    @XStreamAlias(value = "FromUserName")
    private String FromUserName;
    @XStreamAlias(value = "CreateTime")
    private String CreateTime;
    @XStreamAlias(value = "MsgType")
    private String MsgType;
    @XStreamAlias(value = "Content")
    private String Content;
    @XStreamAlias(value = "MsgId")
    private String MsgId;
}
