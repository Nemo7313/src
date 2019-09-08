package com.domXML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class ParseXMLDemo {
    private Document document;

    //获得DOM树，Document对象
    public void getDom(){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            document = documentBuilder.parse("C:\\Users\\58262\\IdeaProjects\\MyMarket\\src\\com\\domXML\\Collection.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取手机品牌积型号
    public void showInfo(){
        NodeList brands = document.getElementsByTagName("Brand");
        for(int i=0; i<brands.getLength(); i++){
            Node node = brands.item(i);
            //遍历型号
            Element eleBrand = (Element)node;
            String brandName = eleBrand.getAttribute("name");
            System.out.println(brandName);
            //继续查找，找每个Brand的字节点chul
            NodeList types = eleBrand.getChildNodes();
            for(int j=0; j<types.getLength(); j++){
                Node typeNode = types.item(j);
                //判断当前节点为元素节点
                if(typeNode.getNodeType() == Node.ELEMENT_NODE){
                    Element typeEle = (Element)typeNode;
                    String typeName = typeEle.getAttribute("name");
                    System.out.println("\t"+typeName);
                }
            }
        }
    }

    //增加手机信息
    public void addEle(){
        //创建<Brand>
        Element brand = document.createElement("Brand");
        //为<Brand>设置属性，取值为三星
        brand.setAttribute("name","三星");
        //创建<Type name="Note2"/>
        Element type = document.createElement("type");
        type.setAttribute("name","Note2");
        //将type作为Brand的子元素
        brand.appendChild(type);
        //将Brand作为PhoneInfo的子元素
        document.getElementsByTagName("PhoneInfo").item(0).appendChild(brand);

        saveXML();
    }

    //修改元素
    public void updateEle(){
        //
        NodeList brands = document.getElementsByTagName("Brand");
        for(int i=0; i<brands.getLength(); i++){
            Node brand = brands.item(i);
            Element brandEle = (Element)brand;
            brandEle.setAttribute("id",i+"");
        }
        saveXML();
    }

    //删除华为手机
    public void deleteEle(){
        NodeList brands = document.getElementsByTagName("Brand");
        for(int i=0; i<brands.getLength(); i++){
            Node brand = brands.item(i);
            Element brandEle = (Element)brand;

            if(brandEle.getAttribute("name").equals("华为")){
                //找到父节点，父节点删除子节点
                brandEle.getParentNode().removeChild(brandEle);
            }
        }
        saveXML();
    }
    //保存变化的文件，借助输出流
    public void saveXML(){
        //转换器工厂
        TransformerFactory factort = TransformerFactory.newInstance();
        //设置缩进数目
        factort.setAttribute("indent-number",4);
        try {
            //转换器
            Transformer transformer = factort.newTransformer();
            //指定转换格式
            transformer.setOutputProperty(OutputKeys.ENCODING,"UTF8");
            transformer.setOutputProperty(OutputKeys.INDENT,"YES");
            //最新的DOM树 --> XML
            DOMSource source = new DOMSource(document);
            OutputStream out = new FileOutputStream("C:\\Users\\58262\\IdeaProjects\\MyMarket\\src\\com\\domXML\\Collection.xml");

            StreamResult result = new StreamResult(new OutputStreamWriter(out,"UTF8"));

            transformer.transform(source,result);
        } catch (TransformerConfigurationException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ParseXMLDemo pd = new ParseXMLDemo();
        pd.getDom();
        pd.deleteEle();
//        pd.updateEle();
//        pd.addEle();
        pd.showInfo();
    }
}
