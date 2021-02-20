import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import org.w3c.dom.Node;

import org.w3c.dom.Element;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

class obj{
    int rollno;
    int marks;
    String subject;
    obj(int rollno, int marks, String subject)
    {
        this.rollno=rollno;
        this.marks=marks;
        this.subject=subject;
    }
}
public class students implements Serializable {
    static class res implements Serializable{
        int rollno,marks;
        res(int rollno,int marks){
            this.rollno=rollno;
            this.marks=marks;
        }
    }

   
    public static void main(String args[])throws Exception
    {
        System.out.println("success");
        students s=new students();
        ArrayList<obj> a= new ArrayList<>();
        try{

            File inputFile = new File("info.txt");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.parse(inputFile);

            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("student");
            obj[] items =new obj[nList.getLength()];

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);


                Element eElement = (Element) nNode;

                int roll=Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());
                int marks=Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent());
                String subject=(eElement.getElementsByTagName("subject").item(0).getTextContent());
                items[temp]=new obj(roll,marks,subject);
            }
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<nList.getLength();i++){
                if(hm.containsKey(items[i].rollno)){
                    hm.put(items[i].rollno,hm.get(items[i].rollno)+items[i].marks);
                }else{
                    hm.put(items[i].rollno,items[i].marks);
                }
            }

            res[] arr =new res[3];
            int i=0;
            for(int key:hm.keySet()){
                arr[i++]=new res(key,hm.get(key));
            }


            //serialization

            FileOutputStream fout=new FileOutputStream("student.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            for(i=0;i<3;i++) {
                out.writeObject(arr[i]);
               
            }
            out.flush();
            out.close();
            System.out.println("success");


        }
        catch(Exception e){
            e.printStackTrace();
        }
    }}

