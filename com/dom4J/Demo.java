package com.dom4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;

public class Demo {
    private Document document;

    //获得document对象
    public void loadDocument(){
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(new File("C:\\Users\\58262\\IdeaProjects\\MyMarket\\src\\com\\dom4J\\Collection.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    //遍历品牌和型号
    public void showPhoneInfo(){
        //获取根节点
        Element root = document.getRootElement();
        //获取所有<Brand>
        Iterator eleBrands = root.elementIterator();
        while(eleBrands.hasNext()){
           Element brand = (Element)eleBrands.next();
           System.out.println(brand.attributeValue("name"));
           Iterator eleTypes = brand.elementIterator();
           while(eleTypes.hasNext()){
               Element type = (Element)eleTypes.next();
               System.out.println("\t"+type.attributeValue("name"));
           }
        }
    }

    //增加新的手机品牌信息
    public void addNewPhone(){
        Element root = document.getRootElement();
        Element eleBrand = root.addElement("Brand");
        eleBrand.addAttribute("name","三星");
        Element eleType = eleBrand.addElement("Type");
        eleType.addAttribute("name","Note2");
        saveXML();
    }

    //修改Brand
    public void updatePhone(){
        Element root = document.getRootElement();
        Iterator brands = root.elementIterator();
        int i=1;
        while(brands.hasNext()){
           Element brand = (Element)brands.next();
           brand.addAttribute("id",i+"");
           i++;
        }
        saveXML();
    }
    //删除节点
    public void deletePhone(){
        Element root = document.getRootElement();
        Iterator brands = root.elementIterator();
        while(brands.hasNext()){
            Element brand = (Element)brands.next();
           if(brand.attributeValue("name").equals("华为")){
               brand.getParent().remove(brand);
           }
        }
        saveXML();
    }

    public void saveXML(){
        String path = "C:\\Users\\58262\\IdeaProjects\\MyMarket\\src\\com\\dom4J\\Collection.xml";
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = null;
        try {
            writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(path)),format);
            writer.write(document);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.loadDocument();
//        demo.addNewPhone();
//        demo.updatePhone();
        demo.deletePhone();
        demo.showPhoneInfo();
    }
}
