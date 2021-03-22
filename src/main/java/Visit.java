
import javax.print.Doc;
import java.io.Serializable;

public class Visit implements Serializable {
    private final String date;
    private final String time;
    private final PatientCard patient;
    private final Department department;
    private final Doctor doctor;

    public Visit(String date, String time, PatientCard patient, Department department, Doctor doctor) {
        this.date = date;
        this.time = time;
        this.patient = patient;
        this.department = department;
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", patient=" + patient +
                ", department=" + department +
                ", doctor=" + doctor +
                '}';
    }
}
