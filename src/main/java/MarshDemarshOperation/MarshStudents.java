package MarshDemarshOperation;
import model.Student;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "students")
public class MarshStudents {
    private ArrayList<Student> marshStudents;

    @XmlElement(name = "person")
    public ArrayList<Student> getMarshStudents() {
        return marshStudents;
    }

    public void setMarshStudents(ArrayList<Student> marshStudents) {
        this.marshStudents = marshStudents;
    }

    @Override
    public String toString() {
        return "MarshStudents{" +
                "marshStudents=" + marshStudents +
                '}';
    }
}
