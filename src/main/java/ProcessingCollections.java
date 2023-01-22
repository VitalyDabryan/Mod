import java.util.ArrayList;

public class ProcessingCollections {
    ArrayList <Statistics> statistics = new ArrayList<>();
    StudyProfile mainProfile;
    double avgExamScore;
    int amountOfStudentsByProfile;
    int amountOfUniversitiesByProfile;
    String UniversitiesFullName;

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
        String universitiesFullName = "";

        Statistics statistic = new Statistics(StudyProfile.PHYSICS, statAvgExamScore[0],
                amountOfStudentsByProfile[0], amountOfUniversitiesByProfile[0], universitiesFullName);
        statistics.add(statistic);

        Statistics statistic1 = new Statistics(StudyProfile.MEDICINE, statAvgExamScore[1],
                amountOfStudentsByProfile[1], amountOfUniversitiesByProfile[1], universitiesFullName);
        statistics.add(statistic1);

        Statistics statistic2 = new Statistics(StudyProfile.MATHEMATICS, statAvgExamScore[2],
                amountOfStudentsByProfile[2], amountOfUniversitiesByProfile[2], universitiesFullName);
        statistics.add(statistic2);

        Statistics statistic3 = new Statistics(StudyProfile.LINGUISTICS, statAvgExamScore[3],
                amountOfStudentsByProfile[3], amountOfUniversitiesByProfile[3], universitiesFullName);
        statistics.add(statistic3);

        for (University university: universities){
            if (university.getMainProfile() == StudyProfile.PHYSICS) {
                amountOfUniversitiesByProfile[0]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[0] = statAvgExamScore[0] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[0];

                    }
                }
            }

            if (university.getMainProfile() == StudyProfile.MEDICINE) {
                amountOfUniversitiesByProfile[1]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[1] = statAvgExamScore[1] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[1];

                    }
                }
            }

            if (university.getMainProfile() == StudyProfile.MATHEMATICS) {
                amountOfUniversitiesByProfile[2]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[2] = statAvgExamScore[2] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[2];

                    }
                }
            }

            if (university.getMainProfile() == StudyProfile.LINGUISTICS) {
                amountOfUniversitiesByProfile[3]++;
                for (Student student : students) {
                    if (university.getId().equals(student.getUniversityId())) {
                        statAvgExamScore[3] = statAvgExamScore[3] + student.getAvgExamScore();
                        ++amountOfStudentsByProfile[3];

                    }
                }
            }

            statistic = new Statistics(StudyProfile.PHYSICS,
                    statAvgExamScore[0] / amountOfStudentsByProfile[0],
                    amountOfStudentsByProfile[0],
                    amountOfUniversitiesByProfile[0],
                    universitiesFullName);
            statistics.set(0, statistic);

            statistic = new Statistics(StudyProfile.MEDICINE,
                    statAvgExamScore[1] / amountOfStudentsByProfile[1],
                    amountOfStudentsByProfile[1],
                    amountOfUniversitiesByProfile[1],
                    universitiesFullName);
            statistics.set(1, statistic);

            statistic = new Statistics(StudyProfile.MATHEMATICS,
                    statAvgExamScore[2] / amountOfStudentsByProfile[2],
                    amountOfStudentsByProfile[2],
                    amountOfUniversitiesByProfile[2],
                    universitiesFullName);
            statistics.set(2, statistic);

            statistic = new Statistics(StudyProfile.LINGUISTICS,
                    statAvgExamScore[3] / amountOfStudentsByProfile[3],
                    amountOfStudentsByProfile[3],
                    amountOfUniversitiesByProfile[3],
                    universitiesFullName);
            statistics.set(3, statistic);


        }



        return statistics;
    }
}
