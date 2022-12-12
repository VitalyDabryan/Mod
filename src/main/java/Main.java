public class Main {
    public static void main(String[] args) {

        System.out.println(StudyProfile.MEDICINE.getProfileName());

        University university1 = new University("1", "Belorussian State University", "BSU", 1929, StudyProfile.PHILOSOPHY);
        University university2 = new University("2", "Belorussian State University of Transport", "BelSUT", 1953, StudyProfile.TELECOMMUNICATIONS);

        Student student1 = new Student("Vitali Dabryian", "2", 1,99);
        Student student2 = new Student("Anton Ivanich", "1", 2,95);

        System.out.println(university2);
        System.out.println(student1);
    }
}
