

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ParseXMLwithDOM2 {

    public static void main(String[] args) {

        try {
            File inputFile = new File("reich.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("glassProfile");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("inventoryID : "
                            + eElement
                            .getElementsByTagName("inventoryID")
                            .item(0)
                            .getTextContent());
                    System.out.println("supplyKg : "
                            + eElement
                            .getElementsByTagName("supplyKg")
                            .item(0)
                            .getTextContent());
                    System.out.println("colorName : "
                            + eElement
                            .getElementsByTagName("colorName")
                            .item(0)
                            .getTextContent());
                    System.out.println("physicalForm : "
                            + eElement
                            .getElementsByTagName("physicalForm")
                            .item(0)
                            .getTextContent());
                    System.out.println("reducingProp : "
                            + eElement
                            .getElementsByTagName("reducingProp")
                            .item(0)
                            .getTextContent());
                    System.out.println("strikingProp : "
                            + eElement
                            .getElementsByTagName("strikingProp")
                            .item(0)
                            .getTextContent());
                    System.out.println("colorTransparency : "
                            + eElement
                            .getElementsByTagName("colorTransparency")
                            .item(0)
                            .getTextContent());
                    System.out.println("adventurineType : "
                            + eElement
                            .getElementsByTagName("adventurineType")
                            .item(0)
                            .getTextContent());
                    System.out.println("costPerKg : "
                            + eElement
                            .getElementsByTagName("costPerKg")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}