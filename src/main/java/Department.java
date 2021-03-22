import javax.print.Doc;
import java.io.Serializable;
import java.util.ArrayList;

public class Department implements Serializable {
    private final Specialization specialization;
    public ArrayList<Doctor> doctorsDepartment;

    public Department(Specialization specialization,ArrayList<Doctor> doctorsSelected) {
        this.specialization = specialization;
        this.doctorsDepartment = doctorsSelected;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctorsDepartment;
    }

    public void addDoctor(Doctor doctor) {
        this.doctorsDepartment.add(doctor);
    }

    @Override
    public String toString() {
        return "Department{" +
                "Специализация: " + specialization +
                ",Доктора: " + doctorsDepartment +
                '}';
    }
}
