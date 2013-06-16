package misc;

interface IStudent {
    String getName();

    int getStudentId();
}
interface IFacultyMember {
    int getFacultyId();
}
class Student implements IStudent {
    String name;
    int id;

    public Student(String cName, int cId) {
        name = cName;
        id = cId;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return id;
    }
}
class Tutor implements IStudent, IFacultyMember {
    Student student;
    int facultyId;

    public Tutor(Student student, int facultyId) {
        this.student = student;
        this.facultyId = facultyId;
    }

    public String getName() {
        return student.getName();
    }

    public int getStudentId() {
        return student.getStudentId();
    }

    public int getFacultyId() {
        return facultyId;
    }
;
}

public class Intr {
    public static void main(String[] args) {

        Student s = new Student("Fred", 1);

        Tutor t = new Tutor(s, 1);
        System.out.println(t.getName() + t.getFacultyId());
    }
}