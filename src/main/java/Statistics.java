public class Statistics {
    StudyProfile mainProfile;
    double avgExamScore;
    int amountOfStudentsByProfile;
    int amountOfUniversitiesByProfile;
    String UniversitiesFullName;

    public Statistics(StudyProfile mainProfile, double avgExamScore, int amountOfStudentsByProfile,
                      int amountOfUniversitiesByProfile, String universitiesFullName) {
        this.mainProfile = mainProfile;
        this.avgExamScore = avgExamScore;
        this.amountOfStudentsByProfile = amountOfStudentsByProfile;
        this.amountOfUniversitiesByProfile = amountOfUniversitiesByProfile;
        this.UniversitiesFullName = universitiesFullName;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getAmountOfStudentsByProfile() {
        return amountOfStudentsByProfile;
    }

    public void setAmountOfStudentsByProfile(int amountOfStudentsByProfile) {
        this.amountOfStudentsByProfile = amountOfStudentsByProfile;
    }

    public int getAmountOfUniversitiesByProfile() {
        return amountOfUniversitiesByProfile;
    }

    public void setAmountOfUniversitiesByProfile(int amountOfUniversitiesByProfile) {
        this.amountOfUniversitiesByProfile = amountOfUniversitiesByProfile;
    }

    public String getUniversitiesFullName() {
        return UniversitiesFullName;
    }

    public void setUniversitiesFullName(String universitiesFullName) {
        UniversitiesFullName = universitiesFullName;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "mainProfile=" + mainProfile +
                ", avgExamScore=" + avgExamScore +
                ", amountOfStudentsByProfile=" + amountOfStudentsByProfile +
                ", amountOfUniversitiesByProfile=" + amountOfUniversitiesByProfile +
                ", UniversitiesFullName='" + UniversitiesFullName + '\'' +
                '}';
    }
}
