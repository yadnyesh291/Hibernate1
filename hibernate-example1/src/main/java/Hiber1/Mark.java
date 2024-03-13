package Hiber1;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int markId;
    private int subject1;
    private int subject2;
    private int subject3;

    public Mark() {}

    public Mark(int subject1, int subject2, int subject3) {
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    // Getters and setters
    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public int getSubject1() {
        return subject1;
    }

    public void setSubject1(int subject1) {
        this.subject1 = subject1;
    }

    public int getSubject2() {
        return subject2;
    }

    public void setSubject2(int subject2) {
        this.subject2 = subject2;
    }

    public int getSubject3() {
        return subject3;
    }

    public void setSubject3(int subject3) {
        this.subject3 = subject3;
    }
}