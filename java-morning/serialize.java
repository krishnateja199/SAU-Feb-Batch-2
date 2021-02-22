import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;

import org.w3c.dom.NodeList;

import org.w3c.dom.Node;

import org.w3c.dom.Element;

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
public class serialize {

    private static final String CSV_SEPARATOR = ",";
    static class res implements Serializable{
        int rollno,marks;
        res(int rollno,int marks){
            this.rollno=rollno;
            this.marks=marks;
        }
    }

    public static void main(String args[])
    {
       students s=new students();
        ArrayList<obj> a= new ArrayList<>();
        try{
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("top_students.csv"), "UTF-8"));
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
         //   System.out.println(items[8].marks);

            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<nList.getLength();i++){
                if(hm.containsKey(items[i].rollno)){
                    hm.put(items[i].rollno,hm.get(items[i].rollno)+items[i].marks);
                }else{
                    hm.put(items[i].rollno,items[i].marks);
                }
            }

            res[] arr =new res[nList.getLength()/3];
            int i=0;
            for(int key:hm.keySet()){
                arr[i++]=new res(key,hm.get(key));
            }

               //serialization

               FileOutputStream fout=new FileOutputStream("student.txt");
               ObjectOutputStream out = new ObjectOutputStream(fout);
               for(i=0;i<nList.getLength()/3;i++) {
                   out.writeObject(arr[i]);
   
               }
               out.flush();
               out.close();
   

             //deserialization


             FileInputStream fin = new FileInputStream("student.txt");
             ObjectInputStream in = new ObjectInputStream(fin);
 
             for(i=0;i<nList.getLength()/3;i++) {
                 arr[i] = (res) in.readObject();
               //  System.out.printl("hello "+Integer.parseInt(arr[i]));
             }
             in.close();
             fin.close();


         
            
            
           


            Arrays.sort(arr,new Comparator<res>() {
                @Override
                public int compare(res o1, res o2) {
                    if(o1.marks>o2.marks) return 1;
                    else if(o1.marks<o2.marks) return -1;
                    return 0;
                }
            });

                //System.out.println()
            StringBuffer oneLine = new StringBuffer();
            oneLine.append("Rank,Roll Number,Total Marks(out of 300)");
            bw.write(oneLine.toString());
            bw.newLine();
            for(int j=0;j<nList.getLength()/3;j++){
                oneLine = new StringBuffer();
                oneLine.append(j+1);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(arr[j].rollno);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(arr[j].marks);
                System.out.println(oneLine.toString());
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }}