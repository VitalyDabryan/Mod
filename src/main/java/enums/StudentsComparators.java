package enums;

public enum StudentsComparators {
    AvgExamScoreComparator,
    CurrentCourseNumberComparator,
    FullNameComparator,
    UniversityIdComparator;
    String studComparator;

    StudentsComparators() {}

    StudentsComparators(String studComparator){

        this.studComparator = studComparator;
    }

}
