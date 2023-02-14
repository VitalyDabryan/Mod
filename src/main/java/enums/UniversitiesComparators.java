package enums;

public enum UniversitiesComparators {
    IdComparator,
    UniFullNameComparator,
    UniProfileNameComparator,
    UniShortNameComparator,
    UniYearOfFoundationComparator,

    allComparator;

    String universitiesComparator;

    UniversitiesComparators() {}

    UniversitiesComparators(String universitiesComparator){

        this.universitiesComparator = universitiesComparator;
    }
}
