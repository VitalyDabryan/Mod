package enums;

public enum StudentsComparators {
    AvgExamScoreComparator,
    CurrentCourseNumberComparator,
    FullNameComparator,
    UniversityIdComparator, allComparator, StudAvgExamScoreComparator;
    String studComparator;

    StudentsComparators() {}

    StudentsComparators(String studComparator){

        this.studComparator = studComparator;
    }

}
