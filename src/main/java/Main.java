public class Main {
    public static void main(String[] args) {

        System.out.println(StudyProfile.MEDICINE.getProfileName());

        University university = new University(); // шаблон Builder
        university.setId("1")
                  .setFullName("Belorussian State University")
                  .setShortName("BSU")
                  .setYearOfFoundation(1920)
                  .setProfileName(StudyProfile.PHILOSOPHY);

        Student student1 = new Student("Vitali Dabryian", "2", 1,99);
        Student student2 = new Student("Anton Ivanich", "1", 2,95);

        System.out.println(university);
        System.out.println(student1);
    }
}
