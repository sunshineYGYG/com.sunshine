package com.sunshine.shine;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;
import org.assertj.core.util.DateUtil;
import org.junit.Test;
import sun.security.provider.MD5;

import javax.xml.crypto.Data;
import java.lang.reflect.Constructor;
import java.net.InterfaceAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class MyTest {

    @Test
    public void test() {
        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        List<Integer> list = intList.stream().filter(i -> i > 3).collect(Collectors.toList());
        System.out.println(list);
        list.forEach(i -> {
            System.out.println(i);
        });
    }

    @Test
    public void test2() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person("A", "B", "male");
        personList.add(person);
        Map<String, Person> collect = personList.stream().collect(toMap(Person::getNinename, p -> p));
//        if(collect.containsKey("B")){
//            System.out.println("yes");
//        }
        Person p1 = collect.get("B");
        System.out.println(p1.getName());
        System.out.println(p1.getNinename());
        System.out.println(p1.getSex());
        Person p2 = collect.get("A");
        System.out.println(p2);
    }

    @Test
    public void test3() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person("A", "B", "male");
        personList.add(person);
        person = new Person("AA", "B", "male");
        personList.add(person);
        person = new Person("AAA", "BBB", "female");
        personList.add(person);

        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getNinename, Function.identity(), (v1, v2) -> v1));
        System.out.println(personMap.get("B").getName());


        List<Person> collect1 = personList.stream().distinct().collect(Collectors.toList());
        collect1.forEach(c->{
            System.out.print(c.getName()+"  ");
            System.out.print(c.getSex()+"  ");
            System.out.println(c.getNinename());
        });


        //Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        //System.out.println(collect.size());

    }

    @Test
    public void test4() {
        List<Person> personList = new ArrayList<>();
        Person person = new Person("A", "B", "male");
        Phone phone = new Phone(3, "17862970426", "oneplus");
        person.setPhone(phone);
        personList.add(person);
        person = new Person("AA", "B", "male");
        phone = new Phone(1, "18765160064", "xiaomi");
        personList.add(person);
//        person=new Person("AAA","BBB","female");
//        personList.add(person);
        Map<String, List<Person>> collect = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(collect.size());



    }

    @Test
    public void test5() {
        try {
            int i=1/0;
        }catch (Exception e){
            System.out.println("toString(==  "+e.toString());
            System.out.println("getClass()==  "+e.getClass());
            System.out.println("getClass().getName()==  "+e.getClass().getName());
        }

    }
    @Test
    public void test6() {
        Integer i=0;
        System.out.println(i.getClass());
        System.out.println(i.getClass().getName());
    }

    @Test
    public void test7() {
        String str="abcdefghijklmn";
        System.out.println(str.length());
        if(str.length()<14){
            System.out.println(str);
        }else{
            System.out.println(str.substring(10,14));
        }

    }

    @Test
    public void test8() {
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDate.now());
        int num=2;
        int all=10;
        System.out.println(num * 1.0 / all*100);


    }

    @Test
    public void test9() {
        String s="19:30:00";

        //System.out.println(LocalTime.o);
        System.out.println(LocalTime.parse(s)+"");
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.parse(s,DateTimeFormatter.ofPattern("HH:mm",Locale.CHINA))+"");
        //System.out.println(LocalTime.parse(LocalTime.now()+"",DateTimeFormatter.ofPattern("HH:mm")));
    }

    @Test
    public void test10() {
        //Arrays.asList(null);
//        DecimalFormat myFormatter = new DecimalFormat("#######");
//        System.out.println(myFormatter.format(3));
//        System.out.println(String.format("%1$-7s",4));
        Double s=12222.2323;
        System.out.println(String.format("% 15.2f",s));
        //System.out.println(String.format("% 7 d",4));
        System.out.println(LocalDate.parse("2018-02"));

    }

    @Test
    public void test11() {
        String date="2018-06-16";
        Pattern pattern=Pattern.compile("20[0-9]{2}-(0[0-9]|1[0|1|2])-([0|1|2][0-9]|3[0|1])");
        Matcher matcher = pattern.matcher(date);
        boolean b = matcher.matches();
        System.out.println(b);
    }

    @Test
    public void test12() {
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
    }

    @Test
    public void test13() {
        String s="{\"isAddFeedBack\":\"0\",\"evaluations\":[{\"key\":\"\\u8bfe\\u524d\\u56de\\u987e\",\"values\":[\"\\u767b\\u5802\\u5165\\u5ba4\"]}," +
                "{\"key\":\"\\u542c\\u8bfe\\u72b6\\u6001\",\"values\":[\"\\u79ef\\u6781\\u914d\\u5408\"]},{\"key\":\"\\u8bfe\\u5802\\u7ec3\\u4e60\"," +
                "\"values\":[\"\\u521d\\u51fa\\u8305\\u5e90\"]}],\"knowledges\":[{\"id\":\"8793359d377b4556a8b2b5ce7c62096f\",\"knowledge\":\"\\u7b49" +
                "\\u91cf\\u4ee3\\u6362\\u7684\\u5b9a\\u4e49\",\"desList\":[{\"key\":\"\\u91cd\\u70b9\\u5b9a\\u4f4d\",\"values\":[\"\\u4f4e\\u9891\"]}," +
                "{\"key\":\"\\u638c\\u63e1\\u60c5\\u51b5\",\"values\":[\"\\u7565\\u77e5\\u4e00\\u4e8c\"]}]},{\"id\":\"pkid-286\",\"knowledge\":\"\\u4e09" +
                "\\u5e74\\u7ea7\\u8bfe\\u5185\\u7cfb\\u7edf\\u590d\\u4e60\",\"desList\":[{\"key\":\"\\u91cd\\u70b9\\u5b9a\\u4f4d\",\"values\":[\"\\u96be" +
                "\\u70b9\",\"\\u91cd\\u70b9\",\"\\u6838\\u5fc3\"]},{\"key\":\"\\u638c\\u63e1\\u60c5\\u51b5\",\"values\":[\"\\u7565\\u6709\\u5c0f\\u6210\"]}]}]," +
                "\"message\":\"\\u8be6\\u7ec6\\u53cd\\u9988\\u5185\\u5bb9\\u5c06\\u57281\\u5468\\u5185\\u8865\\u5199\"," +
                "\"module_id\":\"8a990d955b8055b8015c7beea7e71877\",\"channel\":\"its\",\"outline_order\":\"2\",\"outline_name\":" +
                "\"\\u7b49\\u91cf\\u4ee3\\u6362\\uff08\\u76ee\\u6807\\uff09\",\"curriculum_id\":\"74752017122517371129701305427\",\"stu_id\":" +
                "\"ff808081605e17ba01605e34738111ec\",\"class_id\":\"76762017122517371128601305422\",\"signature_url\":\"0c34751df742e1e12b8c36ae50721c50\"," +
                "\"module_name\":\"2017\\u5317\\u4eac\\u4e09\\u5e74\\u7ea7\\u6570\\u5b66\\u79cb\\u5b63(\\u76ee\\u6807\\u8bfe\\u7a0b)\",\"tea_id\":\"60602017121518192787401326968\"}";

        String ss="%7B%22tea_id%22%3A%22ff8080815b58488e015b6111cd63269f%22%2C%22channel%22%3A%22its%22%2C%22stu_id%22%3A%22ff8080815964a61a01596921b24e1593%22%2C%22class_id%22%3A%2229272018050712342603201508878%22%2C%22curriculum_id%22%3A%2212602018050712342604101508881%22%2C%22signature_url%22%3A%227ab1419d1e9ea49f0953ed027cdd34e5%22%2C%22message%22%3A%22%E8%AF%BE%E5%A0%82%E5%90%B8%E6%94%B6%E6%95%88%E6%9E%9C%E8%BF%98%E5%8F%AF%E4%BB%A5%EF%BC%8C%E5%BC%80%E6%80%BF%E4%B8%8A%E8%AF%BE%E7%8A%B6%E6%80%81%E4%B8%8D%E9%94%99%F0%9F%91%8D%22%2C%22module_id%22%3A%22e25e974589464d07b08bc53b8dd978ed%22%2C%22module_name%22%3A%222018%E9%83%91%E5%B7%9E%E5%88%9D%E4%B8%89%E8%AF%AD%E6%96%87%E6%9A%91%E6%9C%9F%28%E7%9B%AE%E6%A0%87%E8%AF%BE%E7%A8%8B%29%22%2C%22outline_id%22%3Anull%2C%22outline_name%22%3A%22%E8%AF%AD%E6%96%87%E9%87%8D%E7%82%B9%E6%A8%A1%E5%9D%97%E8%A7%A3%E8%AF%BB%EF%BC%88%E4%B8%80%EF%BC%89%22%2C%22outline_order%22%3A%221%22%2C%22course_plan%22%3Anull%2C%22area%22%3A%220371%22%2C%22knowledges%22%3A%5B%7B%22id%22%3A%22c91ac33d04fc430188b8e8e9c890eb0c%22%2C%22knowledge%22%3A%22%E8%AF%95%E5%8D%B7%E6%A8%A1%E5%9D%97%E8%A7%A3%E8%AF%BB%22%2C%22desList%22%3A%5B%7B%22key%22%3A%22%E9%87%8D%E7%82%B9%E5%AE%9A%E4%BD%8D%22%2C%22values%22%3A%5B%22%E9%87%8D%E7%82%B9%22%5D%7D%2C%7B%22key%22%3A%22%E6%8E%8C%E6%8F%A1%E6%83%85%E5%86%B5%22%2C%22values%22%3A%5B%22%E7%95%A5%E7%9F%A5%E4%B8%80%E4%BA%8C%22%5D%7D%5D%2C%22alreadyFeedback%22%3A0%7D%5D%2C%22evaluations%22%3A%5B%7B%22key%22%3A%22%E8%AF%BE%E5%89%8D%E5%9B%9E%E9%A1%BE%22%2C%22values%22%3A%5B%22%E8%BE%BE%E6%A0%87%22%5D%7D%2C%7B%22key%22%3A%22%E5%90%AC%E8%AF%BE%E7%8A%B6%E6%80%81%22%2C%22values%22%3A%5B%22%E4%BC%98%E7%A7%80%22%5D%7D%2C%7B%22key%22%3A%22%E8%AF%BE%E5%A0%82%E7%BB%83%E4%B9%A0%22%2C%22values%22%3A%5B%22%E4%BC%98%E7%A7%80%22%5D%7D%5D%2C%22isAddFeedBack%22%3A0%7D";
        String sss="%7B%22tea_id%22%3A%22ff8080815b58488e015b6111cd63269f%22%2C%22channel%22%3A%22its%22%2C%22stu_id%22%3A%22ff8080815964a61a01596921b24e1593%22%2C%22class_id%22%3A%2229272018050712342603201508878%22%2C%22curriculum_id%22%3A%2212602018050712342604101508881%22%2C%22signature_url%22%3A%227ab1419d1e9ea49f0953ed027cdd34e5%22%2C%22message%22%3A%22%E8%AF%BE%E5%A0%82%E5%90%B8%E6%94%B6%E6%95%88%E6%9E%9C%E8%BF%98%E5%8F%AF%E4%BB%A5%EF%BC%8C%E5%BC%80%E6%80%BF%E4%B8%8A%E8%AF%BE%E7%8A%B6%E6%80%81%E4%B8%8D%E9%94%99%F0%9F%91%8D%22%2C%22module_id%22%3A%22e25e974589464d07b08bc53b8dd978ed%22%2C%22module_name%22%3A%222018%E9%83%91%E5%B7%9E%E5%88%9D%E4%B8%89%E8%AF%AD%E6%96%87%E6%9A%91%E6%9C%9F%28%E7%9B%AE%E6%A0%87%E8%AF%BE%E7%A8%8B%29%22%2C%22outline_id%22%3Anull%2C%22outline_name%22%3A%22%E8%AF%AD%E6%96%87%E9%87%8D%E7%82%B9%E6%A8%A1%E5%9D%97%E8%A7%A3%E8%AF%BB%EF%BC%88%E4%B8%80%EF%BC%89%22%2C%22outline_order%22%3A%221%22%2C%22course_plan%22%3Anull%2C%22area%22%3A%220371%22%2C%22knowledges%22%3A%5B%7B%22id%22%3A%22c91ac33d04fc430188b8e8e9c890eb0c%22%2C%22knowledge%22%3A%22%E8%AF%95%E5%8D%B7%E6%A8%A1%E5%9D%97%E8%A7%A3%E8%AF%BB%22%2C%22desList%22%3A%5B%7B%22key%22%3A%22%E9%87%8D%E7%82%B9%E5%AE%9A%E4%BD%8D%22%2C%22values%22%3A%5B%22%E9%87%8D%E7%82%B9%22%5D%7D%2C%7B%22key%22%3A%22%E6%8E%8C%E6%8F%A1%E6%83%85%E5%86%B5%22%2C%22values%22%3A%5B%22%E7%95%A5%E7%9F%A5%E4%B8%80%E4%BA%8C%22%5D%7D%5D%2C%22alreadyFeedback%22%3A0%7D%5D%2C%22evaluations%22%3A%5B%7B%22key%22%3A%22%E8%AF%BE%E5%89%8D%E5%9B%9E%E9%A1%BE%22%2C%22values%22%3A%5B%22%E8%BE%BE%E6%A0%87%22%5D%7D%2C%7B%22key%22%3A%22%E5%90%AC%E8%AF%BE%E7%8A%B6%E6%80%81%22%2C%22values%22%3A%5B%22%E4%BC%98%E7%A7%80%22%5D%7D%2C%7B%22key%22%3A%22%E8%AF%BE%E5%A0%82%E7%BB%83%E4%B9%A0%22%2C%22values%22%3A%5B%22%E4%BC%98%E7%A7%80%22%5D%7D%5D%2C%22isAddFeedBack%22%3A0%7D";

        String s1="{\"isAddFeedBack\":\"0\",\"evaluations\":[{\"key\":\"\\u8bfe\\u524d\\u56de\\u987e\",\"values\":[\"\\u767b\\u5802\\u5165\\u5ba4\"]},{\"key\":\"\\u542c\\u8bfe\\u72b6\\u6001\",\"values\":[\"\\u79ef\\u6781\\u914d\\u5408\"]},{\"key\":\"\\u8bfe\\u5802\\u7ec3\\u4e60\",\"values\":[\"\\u521d\\u51fa\\u8305\\u5e90\"]}],\"knowledges\":[{\"id\":\"5fecb6a21a0d4b508bf25babd95260b9\",\"knowledge\":\"\\u77e5\\u8bc6\\u8bb2\\u89e3\",\"desList\":[{\"key\":\"\\u91cd\\u70b9\\u5b9a\\u4f4d\",\"values\":[\"\\u57fa\\u7840\",\"\\u91cd\\u70b9\"]},{\"key\":\"\\u638c\\u63e1\\u60c5\\u51b5\",\"values\":[\"\\u7565\\u6709\\u5c0f\\u6210\"]}]},{\"id\":\"24bab933f65f467da65c89648004c096\",\"knowledge\":\"\\u4f8b\\u9898\\u7cbe\\u8bb2\",\"desList\":[{\"key\":\"\\u91cd\\u70b9\\u5b9a\\u4f4d\",\"values\":[\"\\u96be\\u70b9\",\"\\u91cd\\u70b9\"]},{\"key\":\"\\u638c\\u63e1\\u60c5\\u51b5\",\"values\":[\"\\u7565\\u6709\\u5c0f\\u6210\"]}]}],\"message\":\"\\u5bb6\\u957f\\u60a8\\u597d\\uff0c\\u7531\\u4e8e\\u7cfb\\u7edf\\u66f4\\u65b0\\u6240\\u4ee5\\u8fd9\\u8fb9\\u6682\\u65f6\\u6ca1\\u529e\\u6cd5\\u8c03\\u6574\\u7cfb\\u7edf\\u91cc\\u7684\\u8bb2\\u4e49\\uff0c\\u672c\\u8282\\u8bfe\\u4e3b\\u8981\\u8bb2\\u89e3\\u4e86\\u9e1f\\u5934\\u6a21\\u578b\\u7684\\u5ef6\\u4f38\\u5e94\\u7528\\uff0c\\u5305\\u62ec\\u4e00\\u4e9b\\u51e0\\u4f55\\u7684\\u89e3\\u9898\\u601d\\u60f3\\uff0c\\u5b69\\u5b50\\u4e0a\\u8bfe\\u72b6\\u6001\\u8fd8\\u4e0d\\u9519\\uff0c\\u4f46\\u89e3\\u9898\\u601d\\u8def\\u4e0d\\u5bbd\\u6cdb\\uff0c\\u9700\\u8981\\u5e73\\u65f6\\u591a\\u505a\\u4e9b\\u4e60\\u9898\\uff0c\\u591a\\u89d2\\u5ea6\\u89c2\\u5bdf\\uff0c\\u63d0\\u9ad8\\u89e3\\u9898\\u6280\\u5de7\",\"module_id\":\"8a990d955b8055b8015c7becd9d7186f\",\"channel\":\"its\",\"outline_order\":\"13\",\"outline_name\":\"\\u5206\\u6570\\u5e94\\u7528\\u9898\\u2014\\u7edf\\u4e00\\u5355\\u4f4d1\\uff08\\u63d0\\u9ad8\\uff09\",\"curriculum_id\":\"e5160f891056e1c1866de5df8cf049b2\",\"stu_id\":\"ff8080815ed33a33015ef13a3fcf19c1\",\"class_id\":\"ff8080815ed33a33015ef16831ed1d02\",\"signature_url\":\"cccf2d51de93e0491e1e9c03ed8904f2\",\"module_name\":\"2017\\u5317\\u4eac\\u4e94\\u5e74\\u7ea7\\u6570\\u5b66\\u79cb\\u5b63(\\u63d0\\u9ad8\\u8bfe\\u7a0b)\",\"tea_id\":\"ff80808159a2ec710159aae1c8bb6fd5\"}";
        System.out.println(sss.split("%22knowledge%22").length-1);
        try {
            String val=URLDecoder.decode("%22knowledges%22%3A","UTF-8");
            System.out.println(val);
            String v2=URLDecoder.decode(ss,"UTF-8");
            System.out.println(v2);
        }catch (Exception e){

        }
        double avg=(212019 *1+112514 *2+76643 *3+47200 *4+27483 *5+15459 *6)*1.0/(212019 +112514 +76643 +47200 +27483 +15459 );
        System.out.println(avg);

        double avg2=(1254 *2+ 467*3+275*4+ 107*5+147 *6)*1.0/(1254+ 467+275+ 107+147);
        System.out.println("2=="+avg2);

        //1.9231

        double avg3=((2250-996)*2+(996-529)*3+(529-254)*4+(254-147)*5+147*6)*1.0/2250;
        System.out.println(avg3);


        double avg4=((2250-996)*2+(996-529)*3+(529-254)*4+(254-147)*5)*1.0/2103;
        System.out.println(avg4);
    }

    @Test
    public void test14() {
        System.out.println(String.format("%5s","俩字"));
        System.out.println(LocalDate.now().minusDays(6));

        String [] dd={
                "021","022"
        };
        System.out.println(dd[0].compareTo(dd[1]));

        List<String> s=new ArrayList<>();
        s.add("021");
        s.add("022");
        s.stream().sorted((o1, o2) -> {
            if(o1.compareTo(o2)<0){
                return 1;
            }
            return -1;
        }).forEach(System.out::println);
    }

    @Test
    public void test15() {
        List<String> s=new ArrayList<>();
        s.add(null);
        s.stream().forEach(System.out::println);
        System.out.println(new Date()+"");
        Date date = new Date();
//        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date.toString()));
    }

    @Test
    public void test16() {
        Set<String> s = new HashSet<>();
        s.add("22");
        s.add("22");
        s.add("22");
        s.add("22");
        s.forEach(System.out::println);
        System.out.println(s.size());
    }
    @Test
    public void test17() {
        Map<String,Set<String>> ms=new HashMap<>();
        Set<String> s=new HashSet<>();
        s.add("sunshine");
        ms.put("ss",s);
        Iterator<Map.Entry<String, Set<String>>> iterator = ms.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Set<String>> next = iterator.next();
            Set<String> value = next.getValue();
            value.forEach(System.out::println);
            System.out.println();
        }

        Set<String> ss = ms.get("ss");
        ss.add("fox");

        Iterator<Map.Entry<String, Set<String>>> it = ms.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Set<String>> next = it.next();
            Set<String> value = next.getValue();
            value.forEach(System.out::println);
            System.out.println();
        }

    }

    @Test
    public void test18() {
        List<String> mm=new ArrayList<>();
        mm.add("22");
        mm.add("2233");
        mm.add("223");
        printList(mm);
        System.out.println();
        List<String> rm=new ArrayList<>();
        rm.add("22");
        rm.add("22");
        rm.remove("111");
        mm.removeAll(rm);
        printList(mm);

    }
    private void printList(List<String> s){
        s.stream().forEach(System.out::println);
    }

    @Test
    public void test19() {
        System.out.println('6');
        System.out.println(0xF);
        System.out.println('6'&0xF);
        System.out.println('6'&15);
    }
    @Test
    public void test20() {
        Person person=new Person();
        System.out.println(person.getClass().getName().hashCode());
        System.out.println("--------------");
        System.out.println(Person.class+"   "+person.getClass());
        System.out.println(Person.class.getName());
        System.out.println(Person.class.getSuperclass());
        System.out.println(Person.class.getInterfaces());
        System.out.println("===============");
        System.out.println(System.getSecurityManager());
//        Constructor
    }
    private static ThreadLocal<String> simulationTime=new ThreadLocal();
    private static ThreadLocal<String> simulationTime2=new ThreadLocal();
    @Test
    public void test21() {
//        Person p=null;
//        System.out.println(p+"");
        simulationTime.set("2");
        System.out.println(simulationTime.get());
        System.out.println(simulationTime2.get());
        System.out.println(Locale.ENGLISH);


        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter defaultDateFormatter = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
        String curDateTime = defaultDateFormatter.format(localDateTime);
        System.out.println(curDateTime);

//        System.out.println(System.getProperties("com.sunshine.shine"));
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void test22(){
        Class<Person> personClass = Person.class;
        ClassLoader loader = personClass.getClassLoader();
        System.out.println(personClass);
        System.out.println(loader);
        System.out.println(getPerson().toString());

        Person p=null;
        System.out.println(p);
    }

    private Constructor<?> getPerson() {
        try {
            return Person.class.getConstructor();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test23(){
        List<Integer> arr=new ArrayList<>();
        Collections.addAll(arr, 5, 3, 1);
        arr.forEach(System.out::println);
    }

    @Test
    public void test24(){
        System.out.println(new Object());
        Map<String,String> m=new HashMap();
        m.put("key","value");
//        System.out.println(m["key"]);
        System.out.println(m.get("key"));
        try {
            System.out.println(URLDecoder.decode("%7B%22tea_id%22%3A%2225862018061720183102901325487%22%2C%22channel%22%3A%22its%22%2C%22stu_id%22%3A%22ff808081643b1018016453eb3a1841dd%22%2C%22class_id%22%3A%2207742018070116404568701323267%22%2C%22curriculum_id%22%3A%2271162018070116404570401323270%22%2C%22signature_url%22%3A%229999f7700720732d00dc77f39798749e%22%2C%22message%22%3A%22%E5%85%86%E9%98%B3%E5%A6%88%E5%A6%88%EF%BC%8C%E7%A7%8B%E5%AD%A3%E6%88%91%E4%BB%AC%E8%AF%AD%E6%96%87%E8%AF%BE%E7%A8%8B%E6%98%AF%E6%8A%8A%E6%9C%89%E5%85%B3%E8%81%94%E7%9A%84%E4%B8%93%E9%A2%98%E6%94%BE%E5%9C%A8%E4%B8%80%E8%B5%B7%E6%95%99%E6%8E%88%EF%BC%8C%E6%96%B9%E4%BE%BF%E5%AD%A9%E5%AD%90%E8%BF%9B%E8%A1%8C%E5%AF%B9%E6%AF%94%E5%92%8C%E7%9B%B8%E5%85%B3%E8%AE%B0%E5%BF%86%E3%80%82%E6%AF%94%E5%A6%82%E7%AC%AC%E4%B8%80%E8%8A%82%E8%AF%BE%E6%88%91%E4%BB%AC%E5%AD%A6%E4%B9%A0%E7%9A%84%E6%98%AF%E5%9B%9B%E5%B9%B4%E7%BA%A7%E5%86%99%E6%99%AF%E7%B1%BB%E9%98%85%E8%AF%BB%EF%BC%8C%E5%86%99%E6%99%AF%E7%B1%BB%E9%98%85%E8%AF%BB%E5%AD%A6%E5%AE%8C%E5%90%8E%EF%BC%8C%E7%B4%A7%E6%8E%A5%E7%9D%80%E5%B0%B1%E6%98%AF%E5%86%99%E6%99%AF%E7%B1%BB%E4%BD%9C%E6%96%87%EF%BC%8C%E8%AE%A9%E5%AD%A9%E5%AD%90%E6%8E%8C%E6%8F%A1%E5%86%99%E6%99%AF%E7%B1%BB%E4%BD%9C%E6%96%87%E6%96%B9%E6%B3%95%E3%80%82%E7%84%B6%E5%90%8E%E4%B9%8B%E5%90%8E%E4%B9%9F%E6%98%AF%E4%BC%9A%E6%8A%8A%E5%8F%A4%E8%AF%97%E5%92%8C%E6%96%87%E8%A8%80%E6%96%87%E6%94%BE%E5%9C%A8%E4%B8%80%E8%B5%B7%E5%AD%A6%E4%B9%A0%E3%80%82%E4%B9%8B%E5%90%8E%E6%88%91%E4%BC%9A%E5%8F%91%E4%B8%80%E4%BB%BD%E7%A7%8B%E5%AD%A3%E8%A7%84%E5%88%92%E5%88%B0%E7%BE%A4%E9%87%8C%E9%9D%A2%EF%BC%8C%E6%82%A8%E5%8F%AF%E4%BB%A5%E7%9C%8B%E4%B8%80%E4%B8%8B%E3%80%82%5Cn%E5%8F%A6%E5%A4%96%EF%BC%8C%E6%88%91%E7%BB%99%E5%85%86%E9%98%B3%E5%87%86%E5%A4%87%E4%BA%86%E9%94%99%E9%A2%98%E6%9C%AC%E5%92%8C%E7%AC%94%E8%AE%B0%E6%9C%AC%EF%BC%8C%E7%9B%B8%E5%85%B3%E8%AE%B0%E5%BD%95%E8%A6%81%E6%B1%82%E4%B9%9F%E5%B7%B2%E7%BB%8F%E5%92%8C%E5%85%86%E9%98%B3%E8%AF%B4%E6%98%8E%E4%BA%86%E3%80%82%22%2C%22module_id%22%3A%22b331011d6f2b4fd6920f6cacf6b94bbb%22%2C%22module_name%22%3A%222018%E5%8C%97%E4%BA%AC%E5%9B%9B%E5%B9%B4%E7%BA%A7%E8%AF%AD%E6%96%87%E7%A7%8B%E5%AD%A3%28%E7%9B%AE%E6%A0%87%E8%AF%BE%E7%A8%8B%29%22%2C%22outline_id%22%3Anull%2C%22outline_name%22%3A%22%E5%86%99%E6%99%AF%E9%98%85%E8%AF%BB%E4%B9%8B%E8%87%AA%E7%84%B6%E5%A5%87%E6%99%AFB%22%2C%22outline_order%22%3A%221%22%2C%22course_plan%22%3Anull%2C%22area%22%3A%220571%22%2C%22knowledges%22%3A%5B%7B%22id%22%3A%226b5b943f65ad428f8ab1c0225c4e3c63%22%2C%22knowledge%22%3A%22%E5%86%99%E6%99%AF%E6%96%87%E7%AB%A0%E7%9A%84%E6%80%9D%E6%83%B3%E6%84%9F%E6%83%85%22%2C%22desList%22%3A%5B%7B%22key%22%3A%22%E9%87%8D%E7%82%B9%E5%AE%9A%E4%BD%8D%22%2C%22values%22%3A%5B%22%E9%87%8D%E7%82%B9%22%5D%2C%22describe%22%3Anull%7D%2C%7B%22key%22%3A%22%E6%8E%8C%E6%8F%A1%E6%83%85%E5%86%B5%22%2C%22values%22%3A%5B%22%E7%95%A5%E7%9F%A5%E4%B8%80%E4%BA%8C%22%5D%2C%22describe%22%3Anull%7D%5D%2C%22alreadyFeedback%22%3A0%7D%5D%2C%22evaluations%22%3A%5B%7B%22key%22%3A%22%E8%AF%BE%E5%89%8D%E5%9B%9E%E9%A1%BE%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3Anull%7D%2C%7B%22key%22%3A%22%E5%90%AC%E8%AF%BE%E7%8A%B6%E6%80%81%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3Anull%7D%2C%7B%22key%22%3A%22%E8%AF%BE%E5%A0%82%E7%BB%83%E4%B9%A0%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3Anull%7D%5D%2C%22isAddFeedBack%22%3A0%2C%22experienceFbId%22%3Anull%2C%22studentAbility%22%3A%5B%7B%22key%22%3A%22%E8%AF%86%E8%AE%B0%E8%83%BD%E5%8A%9B%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3A%221%E3%80%81%E5%A4%A7%E4%BD%93%E8%83%BD%E5%A4%9F%E8%83%8C%E8%AF%B5%E9%BB%98%E5%86%99%E5%90%8D%E5%8F%A5%E5%90%8D%E7%AF%87%E3%80%82%5Cn2%E3%80%81%E5%B8%B8%E8%A7%81%E5%AD%97%E9%9F%B3%E5%AD%97%E5%BD%A2%E5%9F%BA%E6%9C%AC%E8%BF%87%E5%85%B3%EF%BC%8C%E9%83%A8%E5%88%86%E5%AD%97%E8%AF%8D%E5%AD%98%E5%9C%A8%E9%94%99%E8%AF%AF%E3%80%82%5Cn3%E3%80%81%E6%9C%89%E5%9F%BA%E7%A1%80%E6%96%87%E5%AD%A6%E5%B8%B8%E8%AF%86%EF%BC%8C%E9%83%A8%E5%88%86%E5%86%85%E5%AE%B9%E6%9C%89%E7%BC%BA%E6%BC%8F%E3%80%82%22%7D%2C%7B%22key%22%3A%22%E5%9F%BA%E7%A1%80%E9%98%85%E8%AF%BB%E8%83%BD%E5%8A%9B%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3A%221%E3%80%81%E9%98%85%E8%AF%BB%E9%87%8F%E3%80%81%E9%98%85%E8%AF%BB%E9%9D%A2%E3%80%81%E7%9F%A5%E8%AF%86%E5%82%A8%E5%A4%87%E8%BE%BE%E5%88%B0%E5%B9%B3%E5%9D%87%E6%B0%B4%E5%B9%B3%E3%80%82%5Cn2%E3%80%81%E9%98%85%E8%AF%BB%E9%80%9F%E5%BA%A6%E8%BF%87%E5%85%B3%EF%BC%8C%E5%9F%BA%E6%9C%AC%E8%83%BD%E5%9C%A8%E8%A7%84%E5%AE%9A%E6%97%B6%E9%97%B4%E5%86%85%E5%AE%8C%E6%88%90%E5%AE%9A%E9%87%8F%E9%98%85%E8%AF%BB%E3%80%82%5Cn3%E3%80%81%E9%98%85%E8%AF%BB%E8%BF%87%E7%A8%8B%E4%B8%AD%E8%83%BD%E5%A4%9F%E5%AF%B9%E4%BF%A1%E6%81%AF%E8%BF%9B%E8%A1%8C%E6%8F%90%E5%8F%96%E3%80%81%E7%AD%9B%E9%80%89%E5%8F%8A%E6%95%B4%E5%90%88%EF%BC%8C%E6%87%82%E5%BE%97%E5%88%9D%E6%AD%A5%E5%88%86%E6%9E%90%E6%96%87%E7%AB%A0%E7%BB%93%E6%9E%84%EF%BC%8C%E8%83%BD%E5%A4%9F%E5%A4%A7%E8%87%B4%E6%8A%8A%E6%8F%A1%E6%96%87%E7%AB%A0%E4%B8%BB%E9%A2%98%E5%8F%8A%E4%B8%AD%E5%BF%83%E6%80%9D%E6%83%B3%EF%BC%8C%E4%BD%86%E5%9D%87%E9%9C%80%E8%A6%81%E5%80%9F%E5%8A%A9%E5%A4%96%E7%95%8C%E5%BC%95%E5%AF%BC%E3%80%82%22%7D%2C%7B%22key%22%3A%22%E5%8F%A4%E8%AF%97%E6%96%87%E9%98%85%E8%AF%BB%E8%83%BD%E5%8A%9B%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3A%221%E3%80%81%E8%83%BD%E5%A4%9F%E8%83%8C%E9%BB%98%E9%87%8D%E7%82%B9%E7%AF%87%E7%9B%AE%EF%BC%8C%E4%BD%86%E9%83%A8%E5%88%86%E5%AD%97%E5%8F%A5%E4%B8%8D%E5%A4%9F%E7%86%9F%E7%BB%83%E3%80%82%5Cn2%E3%80%81%E5%9F%BA%E6%9C%AC%E8%83%BD%E5%A4%9F%E6%8A%8A%E6%8F%A1%E8%AF%97%E6%AD%8C%E5%A4%A7%E6%84%8F%E3%80%82%22%7D%2C%7B%22key%22%3A%22%E7%8E%B0%E4%BB%A3%E6%96%87%E9%89%B4%E8%B5%8F%E5%88%86%E6%9E%90%E8%83%BD%E5%8A%9B%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3A%221%E3%80%81%E8%83%BD%E5%A4%9F%E7%90%86%E8%A7%A3%E4%BD%93%E4%BC%9A%E8%AF%AD%E5%8F%A5%E7%9A%84%E5%9F%BA%E6%9C%AC%E5%90%AB%E4%B9%89%EF%BC%8C%E4%BD%86%E9%9A%BE%E4%BB%A5%E6%B7%B1%E6%8C%96%E6%B7%B1%E5%B1%82%E5%90%AB%E4%B9%89%E3%80%82%E8%AF%AD%E8%A8%80%E7%89%B9%E8%89%B2%E5%88%86%E6%9E%90%E5%AD%98%E5%9C%A8%E7%96%8F%E6%BC%8F%E3%80%82%E6%96%87%E7%AB%A0%E7%BB%93%E6%9E%84%E6%8A%8A%E6%8F%A1%E4%B8%8A%E5%AD%98%E5%9C%A8%E9%97%AE%E9%A2%98%E3%80%82%5Cn2%E3%80%81%E5%A4%A7%E4%BD%93%E8%83%BD%E5%A4%9F%E7%BB%93%E5%90%88%E7%94%9F%E6%B4%BB%E5%AE%9E%E9%99%85%EF%BC%8C%E5%AF%B9%E6%96%87%E5%AD%A6%E5%BD%A2%E8%B1%A1%E8%BF%9B%E8%A1%8C%E9%89%B4%E8%B5%8F%E3%80%82%5Cn3%E3%80%81%E5%9F%BA%E6%9C%AC%E8%83%BD%E5%A4%9F%E6%8A%8A%E6%8F%A1%E4%BD%9C%E8%80%85%E5%86%99%E4%BD%9C%E6%84%8F%E5%9B%BE%EF%BC%8C%E4%BD%86%E4%B8%8D%E5%96%84%E4%BA%8E%E6%8F%90%E5%87%BA%E6%8E%A2%E7%A9%B6%E9%97%AE%E9%A2%98%E5%B9%B6%E5%9B%9E%E7%AD%94%E3%80%82%22%7D%2C%7B%22key%22%3A%22%E5%8F%A3%E5%A4%B4%E8%A1%A8%E8%BE%BE%E8%83%BD%E5%8A%9B%22%2C%22values%22%3A%5B%22%E4%BC%98%E7%A7%80%22%5D%2C%22describe%22%3A%221%E3%80%81%E6%99%AE%E9%80%9A%E8%AF%9D%E6%B5%81%E5%88%A9%E6%A0%87%E5%87%86%EF%BC%8C%E5%8F%A3%E9%BD%BF%E6%B8%85%E6%99%B0%EF%BC%8C%E8%A1%A8%E8%BE%BE%E6%97%B6%E5%A4%A7%E6%96%B9%E8%87%AA%E4%BF%A1%E3%80%82%5Cn2%E3%80%81%E9%80%BB%E8%BE%91%E6%B8%85%E6%99%B0%EF%BC%8C%E5%8F%8D%E5%BA%94%E6%95%8F%E6%8D%B7%EF%BC%8C%E8%83%BD%E5%A4%9F%E5%87%86%E7%A1%AE%E7%90%86%E8%A7%A3%E4%BB%96%E4%BA%BA%E7%9A%84%E6%84%8F%E6%80%9D%E5%B9%B6%E6%98%8E%E7%A1%AE%E8%A1%A8%E8%BE%BE%E8%87%AA%E5%B7%B1%E7%9A%84%E8%A7%82%E7%82%B9%E3%80%82%5Cn3%E3%80%81%E8%AF%AD%E8%A8%80%E8%A1%A8%E8%BE%BE%E8%BF%9E%E8%B4%AF%E5%BE%97%E4%BD%93%E3%80%81%E9%B2%9C%E6%98%8E%E7%94%9F%E5%8A%A8%E3%80%82%22%7D%2C%7B%22key%22%3A%22%E5%86%99%E4%BD%9C%E5%BA%94%E7%94%A8%E8%83%BD%E5%8A%9B%22%2C%22values%22%3A%5B%22%E8%89%AF%E5%A5%BD%22%5D%2C%22describe%22%3A%221%E3%80%81%E8%83%BD%E5%A4%9F%E6%AD%A3%E7%A1%AE%E4%BD%BF%E7%94%A8%E8%AF%8D%E8%AF%AD%E5%92%8C%E5%8F%A5%E5%AD%90%EF%BC%8C%E4%BD%86%E6%9C%89%E6%97%B6%E4%BC%9A%E5%87%BA%E7%8E%B0%E4%B8%80%E5%AE%9A%E9%94%99%E8%AF%AF%E5%8F%8A%E7%97%85%E5%8F%A5%EF%BC%8C%E4%B9%A6%E5%86%99%E4%B8%8D%E5%A4%9F%E5%B7%A5%E6%95%B4%EF%BC%8C%E5%8D%B7%E9%9D%A2%E4%B8%8D%E5%A4%9F%E6%95%B4%E6%B4%81%E3%80%82%5Cn2%E3%80%81%E8%AF%AD%E8%A8%80%E8%A1%A8%E8%BE%BE%E8%BF%9E%E8%B4%AF%E6%80%A7%E6%9C%89%E5%BE%85%E5%8A%A0%E5%BC%BA%EF%BC%8C%E5%8F%99%E4%BA%8B%E9%80%BB%E8%BE%91%E4%B8%8D%E5%A4%9F%E4%B8%A5%E8%B0%A8%EF%BC%8C%E5%9C%A8%E5%86%85%E5%AE%B9%E5%85%B7%E4%BD%93%E7%A8%8B%E5%BA%A6%E3%80%81%E7%BB%93%E6%9E%84%E7%9A%84%E4%B8%A5%E8%B0%A8%E6%80%A7%E4%B8%8E%E8%AF%AD%E8%A8%80%E8%BF%90%E7%94%A8%E4%B8%8A%E6%9C%89%E6%8F%90%E5%8D%87%E7%A9%BA%E9%97%B4%E3%80%82%5Cn3%E3%80%81%E8%A1%A8%E8%BE%BE%E6%96%B9%E5%BC%8F%E8%BE%83%E4%B8%BA%E5%8D%95%E4%B8%80%EF%BC%8C%E9%9C%80%E8%A6%81%E5%BC%BA%E5%8C%96%E5%A4%9A%E7%A7%8D%E8%A1%A8%E8%BE%BE%E6%96%B9%E5%BC%8F%E7%9A%84%E8%BF%90%E7%94%A8%E8%83%BD%E5%8A%9B%E3%80%82%5Cn4%E3%80%81%E4%B8%AD%E5%BF%83%E8%BE%83%E4%B8%BA%E7%AA%81%E5%87%BA%EF%BC%8C%E5%86%99%E4%BD%9C%E7%B4%A0%E6%9D%90%E6%AF%94%E8%BE%83%E5%8D%95%E4%B8%80%E3%80%81%E6%96%87%E7%AB%A0%E6%9C%89%E4%B8%80%E5%AE%9A%E7%9A%84%E6%96%87%E5%8F%A5%E8%A1%A8%E7%8E%B0%E5%8A%9B%E3%80%82%22%7D%5D%2C%22expKnowledges%22%3A%22%E7%8E%B0%E4%BB%A3%E6%96%87%E9%98%85%E8%AF%BB%22%2C%22isFirstCur%22%3A1%2C%22isShare%22%3A1%2C%22className%22%3A%22%E5%B0%8F%E5%9B%9B%E8%AF%AD%E6%96%87%E7%A7%8B%E5%AD%A3%E6%A0%87%E5%87%86%E8%AF%BE%22%2C%22term%22%3A%22%E7%A7%8B%E5%AD%A3%22%7D","UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void test25(){
        LocalDateTime localDateTime=LocalDateTime.now();
        LocalDate localDate=LocalDate.now();
        LocalTime localTime=LocalTime.now();
        System.out.println(localDateTime);
        System.out.println(localDate);
        System.out.println(localTime);
    }
    @Test
    public void test26(){
        String s="1234";
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i));
        }


    }

    @Test
    public void test27(){
        testSTring(null);
        String ss=null;
        testVarStringParam(ss);
        if(ss instanceof String){
            System.out.print("yess");
        }
        System.out.println("ss="+ss);
        System.out.println(ss.getClass());

    }
    private void testSTring(String str){
        testVarStringParam(str);
    }
    private void testVarStringParam(String... strs){
        testArrString(strs);
    }
    private void testArrString(String[] strs){
        for(String s:strs){
            if(s instanceof String){
                System.out.print("yes");
            }
            System.out.println(s);
        }
    }

    @Test
    public void test28(){
        System.out.println(new Date());
    }

    @Test
    public void test29(){
        Map<String,String> mm=new HashMap<>();
        mm.putIfAbsent("key1","val1");
        mm.putIfAbsent("key11",null);
        mm.putIfAbsent("key11","val11");
        mm.putIfAbsent("key11","val12");
        mm.putIfAbsent("key111",null);
        mm.putIfAbsent("key112",null);

        mm.computeIfAbsent("key2",v->{return "val2";});
        mm.computeIfAbsent("key22",v->{return null;});
        mm.computeIfAbsent("key22",v->{return "val22";});
        mm.computeIfAbsent("key22",v->{return "val23";});
        mm.computeIfAbsent("key222",v->{return null;});
        mm.computeIfAbsent("key112",v->{return "val112";});

        mm.computeIfAbsent("key3",v->{return "val3";});
        mm.computeIfAbsent("key4",v->{return "val4";});
        mm.computeIfAbsent("key5",v->{return "val5";});
        mm.computeIfAbsent("key5",v->{return "val555";});
        mm.computeIfAbsent("key6",v->{return null;});
        printMap(mm);
        System.out.println();

        mm.computeIfPresent("key1",(k,v)->{return "test1";});
//        mm.put("key1",null);
        mm.computeIfPresent("key100",(k,v)->{return "Test2";});
        mm.computeIfPresent("key3",(k,v)->{return null;});


        mm.compute("key4",(k,v)->{return "Test3";});
        mm.compute("key5",(k,v)->{return null;});
        mm.compute("key55",(k,v)->{return null;});
        mm.compute("key555",(k,v)->{return "val555";});
        printMap(mm);


    }

    private void printMap(Map<String,String> mm){
        Iterator<Map.Entry<String, String>> iterator = mm.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key:"+next.getKey()+"  value:"+next.getValue());
        }
    }


    @Test
    public void test30(){
        HashMap<String, String> data = new HashMap<>();
        data.put("studentId","sss");
        data.put("sex","ss");
        data.put("schoolName","sss");
//        JsonBinder.toJson(data);
        ObjectMapper mapper=new ObjectMapper();
        try {
            String s = mapper.writeValueAsString(data);
            System.out.println(s);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void test31(){
        HashMap<String, String> data = new HashMap<>();
        data.put("studentId","sss");
        data.put("sex","ss");
        data.put("schoolName","sss");

        String ss = data.get("ss");
        System.out.println(ss);
    }
    @Test
    public void test32(){
        int a=5;
        int b=4;
        System.out.println(division(a,b));
    }

    public static int division(int a ,int b){
        String result = "";
        float num =(float)a/b;

        DecimalFormat df = new DecimalFormat("0");

        result = df.format(num);
        int roud = Integer.parseInt(result);
        return roud;

    }

    @Test
    public void test33(){
        int a=5;
        int b=2;
        System.out.println((int)(a*1.0/b+0.5));
    }


    @Test
    public void test34(){
        String s = DigestUtils.md5Hex("phone=15011232529&timestamp=1551175770269&sign=teacherService");
        System.out.println(s.toUpperCase());
    }

    @Test
    public void test35(){
        String s = DigestUtils.md5Hex("phone=15011232529&timestamp=1551175770269&sign=teacherService");

        System.out.println(s.toUpperCase());
    }

    @Test
    public void test36(){
        String s="false";
        String ss="true";
        String sss="1";

        System.out.println(Boolean.valueOf(s));
        System.out.println(Boolean.valueOf(ss));
        System.out.println(Boolean.valueOf(sss));
    }
}
