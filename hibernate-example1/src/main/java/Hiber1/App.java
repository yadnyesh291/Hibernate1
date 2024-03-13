package Hiber1;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // Create a mark
        Mark mark = new Mark(80, 85, 90);
        saveMark(mark);

        // Create a student with the mark
        Student student = new Student("ngrj Doe", "john@example.com", mark);
        saveStudent(student);

        // Read operation
        Student retrievedStudent = getStudentByName("ngrj Doe");
        System.out.println("Retrieved Student: " + retrievedStudent.getName() +
                ", Subject 1: " + retrievedStudent.getMark().getSubject1() +
                ", Subject 2: " + retrievedStudent.getMark().getSubject2() +
                ", Subject 3: " + retrievedStudent.getMark().getSubject3());

        // Update operation
        updateStudentMarks(retrievedStudent, 85, 90, 95);

        // Read updated data
        retrievedStudent = getStudentByName("ngrj Doe");
        System.out.println("Retrieved Student after update: " + retrievedStudent.getName() +
                ", Subject 1: " + retrievedStudent.getMark().getSubject1() +
                ", Subject 2: " + retrievedStudent.getMark().getSubject2() +
                ", Subject 3: " + retrievedStudent.getMark().getSubject3());

        // Delete operation
        deleteStudent(retrievedStudent);
        deleteMark(mark);
    }

    private static void saveStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    private static Student getStudentByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Student> query = session.createQuery("FROM Student WHERE name = :name", Student.class);
        query.setParameter("name", name);
        Student student = query.uniqueResult();
        session.close();
        return student;
    }

    private static void updateStudentMarks(Student student, int subject1, int subject2, int subject3) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        student.getMark().setSubject1(subject1);
        student.getMark().setSubject2(subject2);
        student.getMark().setSubject3(subject3);
        session.update(student);
        transaction.commit();
        session.close();
    }

    private static void deleteStudent(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    private static void saveMark(Mark mark) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(mark);
        transaction.commit();
        session.close();
    }

    private static void deleteMark(Mark mark) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(mark);
        transaction.commit();
        session.close();
    }
}
