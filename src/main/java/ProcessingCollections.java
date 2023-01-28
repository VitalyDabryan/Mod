import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.math3.util.Precision;
import java.util.ArrayList;

public class ProcessingCollections {


    static void listSudentAvgScoreMoreFoure(ArrayList<Student> students) {
        ArrayList <Student> studentsAvgExamScoreMoreFour = new ArrayList<>();
        for (Student student: students) {
            if (student.getAvgExamScore() > 4) {
                studentsAvgExamScoreMoreFour.add(student);
            }
        }
        studentsAvgExamScoreMoreFour.stream()
                .forEach(System.out::println);
    }

    static ArrayList<Statistics> StatisticOfStudyProfile(ArrayList<University> universities, ArrayList<Student> students, ArrayList<Statistics> statistics) {
        StudyProfile mainStatProfile = StudyProfile.PHYSICS;
        double[] statAvgExamScore = {0.0, 0.0, 0.0, 0.0};
        int[] amountOfStudentsByProfile = {0, 0, 0, 0};
        int[] amountOfUniversitiesByProfile = {0, 0, 0, 0};
        String[] mostPopularUniversity = {"", "", "", ""};
        int[] count = {0, 0, 0, 0};
        int[] lastCount = {0, 0, 0, 0};

        Statistics statistic = new Statistics(StudyProfile.PHYSICS, statAvgExamScore[0],
                amountOfStudentsByProfile[0], amountOfUniversitiesByProfile[0], mostPopularUniversity[0]);
        statistics.add(statistic);

        Statistics statistic1 = new Statistics(StudyProfile.MEDICINE, statAvgExamScore[1],
                amountOfStudentsByProfile[1], amountOfUniversitiesByProfile[1], mostPopularUniversity[1]);
        statistics.add(statistic1);

        Statistics statistic2 = new Statistics(StudyProfile.MATHEMATICS, statAvgExamScore[2],
                amountOfStudentsByProfile[2], amountOfUniversitiesByProfile[2], mostPopularUniversity[2]);
        statistics.add(statistic2);

        Statistics statistic3 = new Statistics(StudyProfile.LINGUISTICS, statAvgExamScore[3],
                amountOfStudentsByProfile[3], amountOfUniversitiesByProfile[3], mostPopularUniversity[3]);
        statistics.add(statistic3);

        for (University university: universities){
            if (university.getMainProfile() == StudyProfile.PHYSICS) {
                amountOfUniversitiesByProfile[0]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[0] = statAvgExamScore[0] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[0];
                        count[0]++;
                        if (count[0] > lastCount[0]) mostPopularUniversity[0] = university.getFullName();

                    }
                } lastCount[0] = count[0]; count[0] = 1;
            }

            if (university.getMainProfile() == StudyProfile.MEDICINE) {
                amountOfUniversitiesByProfile[1]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[1] = statAvgExamScore[1] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[1];
                        count[1]++;
                        if (count[1] > lastCount[1]) mostPopularUniversity[1] = university.getFullName();

                    }
                } lastCount[1] = count[1]; count[1] = 1;
            }

            if (university.getMainProfile() == StudyProfile.MATHEMATICS) {
                amountOfUniversitiesByProfile[2]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[2] = statAvgExamScore[2] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[2];
                        count[2]++;
                        if (count[2] > lastCount[2]) mostPopularUniversity[2] = university.getFullName();

                    }
                } lastCount[2] = count[2]; count[2] = 1;
            }

            if (university.getMainProfile() == StudyProfile.LINGUISTICS) {
                amountOfUniversitiesByProfile[3]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[3] = statAvgExamScore[3] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[3];
                        count[3]++;
                        if (count[3] > lastCount[3]) mostPopularUniversity[3] = university.getFullName();

                    }
                } lastCount[3] = count[3]; count[3] = 1;
            }

            statistic = new Statistics(StudyProfile.PHYSICS,
                    Precision.round(statAvgExamScore[0] / amountOfStudentsByProfile[0], 3),
                    amountOfStudentsByProfile[0],
                    amountOfUniversitiesByProfile[0],
                    mostPopularUniversity[0]);
            statistics.set(0, statistic);

            statistic = new Statistics(StudyProfile.MEDICINE,
                    Precision.round(statAvgExamScore[1] / amountOfStudentsByProfile[1], 3),
                    amountOfStudentsByProfile[1],
                    amountOfUniversitiesByProfile[1],
                    mostPopularUniversity[1]);
            statistics.set(1, statistic);

            statistic = new Statistics(StudyProfile.MATHEMATICS,
                    Precision.round(statAvgExamScore[2] / amountOfStudentsByProfile[2], 3),
                    amountOfStudentsByProfile[2],
                    amountOfUniversitiesByProfile[2],
                    mostPopularUniversity[2]);
            statistics.set(2, statistic);

            statistic = new Statistics(StudyProfile.LINGUISTICS,
                    Precision.round(statAvgExamScore[3] / amountOfStudentsByProfile[3], 3),
                    amountOfStudentsByProfile[3],
                    amountOfUniversitiesByProfile[3],
                    mostPopularUniversity[3]);
            statistics.set(3, statistic);
        }
        return statistics;
    }
}
