package MarshDemarshOperation;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.xml.bind.v2.runtime.IllegalAnnotationsException;
import enums.StudyProfile;
import model.Student;
import model.University;

import java.io.File;

@XmlRootElement(name = "StudentsInfo")
@XmlType(propOrder = { "fullName", "universityId", "avgExamScore" })
public class StudentsInfo {
    static String studentsInfo_XML = "C:\\Users\\100nout\\Downloads\\studentsInfo.xml";
//    @XmlElement(name = "studentName")    private String fullName;
//    @XmlElement(name = "universityId")    private String universityId;
//    @XmlElement(name = "avgScore") private double avgExamScore;
    @XmlElementWrapper (name="studentEntry")  private ArrayList<Student> students;



    public static void marshStudents(ArrayList<Student> students){
        for (model.Student student : students) {
            System.out.println(student);
            // сохраняем объект в XML файл
            convertObjectToXml(student, studentsInfo_XML);
       }

    }




    public StudentsInfo() throws IllegalAnnotationsException {
    }
    // сохраняем объект в XML файл
    private static void convertObjectToXml(Student student, String studentsInfo_XML) {
        try {
            JAXBContext context = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(student, new File(studentsInfo_XML));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }}

