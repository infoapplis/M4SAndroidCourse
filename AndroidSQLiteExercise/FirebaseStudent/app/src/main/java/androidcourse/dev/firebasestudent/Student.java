package androidcourse.dev.firebasestudent;

/**
 * Created by Kobe Kid Bi on 29/07/2016.
 */
public class Student {

    private String id;
    private String firstName;

    public Student(String id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    //public Student() {
    //    this.id = "1";
    //    this.firstName = "Biaye";
    //}

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

}
