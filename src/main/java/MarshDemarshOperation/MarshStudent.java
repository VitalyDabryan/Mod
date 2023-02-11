package MarshDemarshOperation;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.sun.xml.bind.v2.runtime.IllegalAnnotationsException;
import javax.xml.bind.annotation.*;
import model.Student;

import static readWriteFile.ReadFile.log;

public class MarshStudent {
    static LocalDateTime current = LocalDateTime.now();
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("_dd_MM_yyyy");
    static String formatedDate = current.format(format);
    static String studentsInfo_XML = "C:\\Users\\100nout\\Downloads\\studentsInfo.xml";
    @XmlElementWrapper (name="studentEntry")  private Student student;

     public static void marshStudents(ArrayList<Student> students) {

        File file = new File("C:\\Users\\100nout\\Downloads\\studentsInfo.xml");

        for (model.Student student : students) {
            System.out.println(student);
            // сохраняем объект в XML файл
            convertObjectToXml(student, students, studentsInfo_XML);
       }

    }
    public MarshStudent() throws IllegalAnnotationsException {
    }
    // сохраняем объект в XML файл
    @XmlElementWrapper (name="studentEntry")  private static void convertObjectToXml(Student student, ArrayList<Student> students,
                                           String studentsInfo_XML) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\100nout\\Downloads\\xmlReqs\\studentsInfo" + formatedDate + ".xml", true);
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(student, writer);
            log.info("Mаршаллинг объекта" + student + "в xml файл");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    // восстанавливаем объект из XML файла
    public static Student fromXmlToObject(String studentsInfo_XML) {
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

 //           return (Student) un.unmarshal(new File(studentsInfo_XML));
            Student unmarshStudent = (Student) un.unmarshal(new File(studentsInfo_XML));
//            for(Student student1 : unmarshStudent)
//            {
//                System.out.println(student1.getFullName());
//                System.out.println(student1.getUniversityId());
//                System.out.println(student1.getAvgExamScore());
//            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}

