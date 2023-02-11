package MarshDemarshOperation;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.ArrayList;

import com.sun.xml.bind.v2.runtime.IllegalAnnotationsException;
import model.University;


public class MarshUniversity {
    private ArrayList<University> marshUniversity;

    static String studentsInfo_XML = "C:\\Users\\100nout\\Downloads\\studentsInfo.xml";
    @XmlElementWrapper (name="universityEntry")  private University university;

    public static void marshUniversity(ArrayList<University> universities) {

        File file = new File("C:\\Users\\100nout\\Downloads\\studentsInfo.xml");

        for (model.University university : universities) {
            System.out.println(university);
            // сохраняем объект в XML файл
            convertObjectToXml(university, universities, studentsInfo_XML);
        }

    }
    public MarshUniversity() throws IllegalAnnotationsException {
    }
    // сохраняем объект в XML файл
    @XmlElementWrapper (name="universityEntry")
    private static void convertObjectToXml(University university, ArrayList<University> universities,
                                           String studentsInfo_XML) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\100nout\\Downloads\\xmlReqs\\studentsInfo.xml", true);
            JAXBContext context = JAXBContext.newInstance(University.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(university, writer);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}