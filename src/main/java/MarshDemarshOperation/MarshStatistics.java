package MarshDemarshOperation;
import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import com.sun.xml.bind.v2.runtime.IllegalAnnotationsException;
import model.Statistics;
import static readWriteFile.ReadFile.log;


public class MarshStatistics {
    static LocalDateTime current = LocalDateTime.now();
    static DateTimeFormatter format = DateTimeFormatter.ofPattern("_dd_MM_yyyy");
    static String formatedDate = current.format(format);

    @XmlElementWrapper (name="statisticEntry")  private Statistics statistics;

    public static void marshStatistics(ArrayList<Statistics> statistics) {

         for (model.Statistics statistic : statistics) {
            System.out.println(statistic);
            // сохраняем объект в XML файл
            convertObjectToXml(statistic);
        }

    }
    public MarshStatistics() throws IllegalAnnotationsException {
    }
    // сохраняем объект в XML файл
    @XmlElementWrapper (name="statisticsEntry")  private static void convertObjectToXml(Statistics statistic) {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\100nout\\Downloads\\xmlReqs\\statisticsInfo" + formatedDate + ".xml", true);
            JAXBContext context = JAXBContext.newInstance(Statistics.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(statistic, writer);
            log.info("Mаршаллинг объекта" + statistic + "в xml файл");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
