import java.util.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


// ---------------------- CODE -----------------------------------

public class validity_checking_exp {
    private static int compareDates(String expDate) throws ParseException {
        SimpleDateFormat sdfo = new SimpleDateFormat("dd/MM/yyyy");

       Date d1 = sdfo.parse(expDate);
        Date d2 = sdfo.parse(getTodaysDate());

        if (d1.compareTo(d2) > 0) {
            return 1;
        }
      else if (d1.compareTo(d2) < 0) {
            return -1;
        }
    return 0;

    }

    private static String getTodaysDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now).toString();
    }
    private static void writeToFile(Document outputDoc, Element rootElement, Element curr_license) {
        try {
            // append first child element to root element
            Node valid_license = outputDoc.importNode(curr_license, true);
            rootElement.appendChild(valid_license);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static boolean isLicenseExpired(Element currSubElement) throws ParseException {
        String expDate = currSubElement.getAttribute("License_Expiration_Date");
        return compareDates(expDate) < 0 ? true : false;
    }

   

    public static void main(String[] args)throws Exception {

        try {

            // INPUT FILE
            File input1 = new File("license1.xml");
            File input2 = new File("license2.xml");
   DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc1 = dBuilder.parse(input1);
            Document doc2 = dBuilder.parse(input2);

            Document outputDoc = dBuilder.newDocument();
           Element rootElement = outputDoc.createElement("CSR_Producer");
             outputDoc.appendChild(rootElement);
           doc1.getDocumentElement().normalize();
            NodeList allCSRProducerNodes1 = doc1.getElementsByTagName("CSR_Producer");

            for (int i = 0; i < allCSRProducerNodes1.getLength(); i++) {
                Node nNode = allCSRProducerNodes1.item(i);
                Element currElement = (Element) nNode;
                NodeList currentLiscences = currElement.getElementsByTagName("License");
          
                for (int j = 0; j < currentLiscences.getLength(); j++) {
                    Node nnNode = currentLiscences.item(j);
                    Element currSubElement = (Element) nnNode;
                     boolean isExpiredLicense = isLicenseExpired(currSubElement);
                    if (isExpiredLicense) {
                        writeToFile(outputDoc, rootElement, currSubElement);
                    }
                }
           }
            doc2.getDocumentElement().normalize();
            NodeList allCSRProducerNodes2 = doc1.getElementsByTagName("CSR_Producer");
          
            for (int i = 0; i < allCSRProducerNodes2.getLength(); i++) {
                Node nNode = allCSRProducerNodes2.item(i);
                Element currElement = (Element) nNode;
                NodeList currentLiscences = currElement.getElementsByTagName("License");
              
                for (int j = 0; j < currentLiscences.getLength(); j++) {
                    Node nnNode = currentLiscences.item(j);
                    Element currSubElement = (Element) nnNode;
                   boolean isExpiredLicense = isLicenseExpired(currSubElement);
                    if (isExpiredLicense) {
                        writeToFile(outputDoc, rootElement, currSubElement);
                    }}}
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

             transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(outputDoc);
             StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("expiredLicense.xml"));
            transformer.transform(source, console);
            transformer.transform(source, file);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}