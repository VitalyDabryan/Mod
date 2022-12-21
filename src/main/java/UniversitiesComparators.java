public enum UniversitiesComparators {
    IdComparator,
    UniFullNameComparator,
    UniProfileNameComparator,
    UniShortNameComparator,
    UniYearOfFoundationComparator;

    String universitiesComparator;

    UniversitiesComparators() {}

    UniversitiesComparators(String universitiesComparator){

        this.universitiesComparator = universitiesComparator;
    }
}
