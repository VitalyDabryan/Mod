package MarshDemarshOperation;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.sun.xml.bind.v2.runtime.IllegalAnnotationsException;
import model.University;

import static readWriteFile.ReadFile.log;


public class MarshUniversity {
    static LocalDateTime current = LocalDateTime.now();
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("_dd_MM_yyyy");
    static String formatedDate = current.format(format);

    private ArrayList<University> marshUniversity;

    @XmlElementWrapper (name="universityEntry")  private University university;

    public static void marshUniversity(ArrayList<University> universities) {

        for (model.University university : universities) {
            System.out.println(university);
            log.info("Mаршаллинг объекта for" + university + "в xml файл");
            // сохраняем объект в XML файл
            convertObjectToXml(university);
        }
    }

    // сохраняем объект в XML файл
    @XmlElementWrapper (name="universityEntry")
    private static void convertObjectToXml(University university) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\100nout\\Downloads\\xmlReqs\\universityInfo" + formatedDate + ".xml", true);
            JAXBContext context = JAXBContext.newInstance(University.class);
            Marshaller marshaller = context.createMarshaller();

            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(university, writer);
            log.info("Mаршаллинг объекта" + university + "в xml файл");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}