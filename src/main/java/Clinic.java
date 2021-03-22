import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Clinic implements Serializable {
    private List<Department> listDepartment = new ArrayList<>();
    private List<PatientCard> listPatientCard = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Visit> visit = new ArrayList<>();

    public List<Department> getListDepartment() {
        return listDepartment;
    }

    public List<PatientCard> getListPatientCard() {
        return listPatientCard;
    }

    public void addDepartment(Specialization specialization, ArrayList<Doctor> doctors) {
        Department department = new Department(specialization, doctors);
        this.listDepartment.add(department);
    }

    public void addVisit(String date, String time, PatientCard patient, Department department, Doctor doctor) {
        Visit visit = new Visit(date,time,patient,department,doctor);
        this.visit.add(visit);
    }

    public void addDoctor(String name) {
        Doctor doctor = new Doctor(name);
        this.doctors.add(doctor);

    }

    public ArrayList<Visit> getVisit() {
        return visit;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void addPatientCard(String name) {
        PatientCard patient = new PatientCard(name);
        this.listPatientCard.add(patient);
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "listDepartment=" + listDepartment +
                ", listPatientCard=" + listPatientCard +
                '}';
    }
}
