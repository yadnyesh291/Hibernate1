package Hiber1;



import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int regno;
    private String name;
    private String emailId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "markId")
    private Mark mark;

    public Student() {}

    public Student(String name, String emailId, Mark mark) {
        this.name = name;
        this.emailId = emailId;
        this.mark = mark;
    }

    // Getters and setters
    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Mark getMark() {
        return mark;
    }

    public void setMark(Mark mark) {
        this.mark = mark;
    }
}

