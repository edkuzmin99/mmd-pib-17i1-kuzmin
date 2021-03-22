import javax.print.Doc;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        if (ClinicDAO.isFileExists()) {
            Clinic clinic = ClinicDAO.readClinic();
            for (; ; ) {
                System.out.println("Стоматологическая клиника");
                System.out.println("1.Добавить пациента");
                System.out.println("2.Добавить отделение");
                System.out.println("3.Добавить врача");
                System.out.println("4.Записаться к врачу");
                System.out.println("5.Отчет по посещениям пациентами врачей");
                System.out.println("6.Просмотр врачей по отделениям");
                System.out.println("7.Сохранить");
                System.out.println("8.Выйти");
                System.out.println("Выберите пункт меню:");
                Scanner in = new Scanner(System.in);
                int num = in.nextInt();
                switch (num) {
                    case (1):
                        System.out.println("Введите имя пациента");
                        String name;
                        name = in.next();
                        clinic.addPatientCard(name);
                        System.out.println("Новый пациент создан!");
                        break;
                    case (2):
                        System.out.println("Выберите специализацию");
                        int specializeModelI = 0;
                        for (Specialization specializationModel : EnumSet.allOf(Specialization.class)) {
                            System.out.println("[" + specializeModelI + "]" + specializationModel);
                            specializeModelI++;
                        }
                        int specializationModelIndex = in.nextInt();
                        Specialization specializationModel = Specialization.values()[specializationModelIndex];
                        System.out.println("Выберите врачей");
                        List<Doctor> doctors = clinic.getDoctors();
                        ArrayList<Doctor> doctorsSelected = new ArrayList<>();
                        int vrach = 1;
                        while (vrach == 1) {
                            System.out.println("1.Добавить врача");
                            System.out.println("2. Продолжить");
                            int n = in.nextInt();
                            switch (n) {
                                case (1):
                                    int doctorIndex = 0;
                                    for (Doctor doctor : clinic.getDoctors()) {
                                        System.out.println("[" + doctorIndex + "]" + "Врач: " + doctor);
                                        doctorIndex++;
                                    }
                                    Doctor doctorSelect = doctors.get(in.nextInt());
                                    doctorsSelected.add(doctorSelect);
                                    break;
                                case (2):
                                    vrach = 0;
                            }
                        }
                        System.out.println("Новое отделение создано");
                        clinic.addDepartment(specializationModel, doctorsSelected);
                        break;
                    case (3):
                        System.out.println("Введите имя врача");
                        String nameDoctor;
                        nameDoctor = in.next();
                        clinic.addDoctor(nameDoctor);
                        System.out.println("Врач успешно добавлен");
                        break;
                    case (4):
                        System.out.println("Запись к врачу");
                        System.out.println("Выберите пациента:");
                        List<PatientCard> patients = clinic.getListPatientCard();
                        List<Department> departments = clinic.getListDepartment();
                        int patientIndex = 0;
                        for (PatientCard patient : clinic.getListPatientCard()) {
                            System.out.println("[" + patientIndex + "]" + "Пациент: " + patient);
                            patientIndex++;
                        }
                        PatientCard patientSelect = patients.get(in.nextInt());
                        //Выбор отделения
                        int departmentIndex = 0;
                        for (Department department : clinic.getListDepartment()) {
                            System.out.println("[" + departmentIndex + "]" + "Отделение: " + department);
                            departmentIndex++;
                        }
                        Department departmentSelect = departments.get(in.nextInt());
                        //Выбор врача
                        List<Doctor> doctorsList = departmentSelect.getDoctors();
                        int doctorInd = 0;
                        for (Doctor doctor : departmentSelect.getDoctors()) {
                            System.out.println("[" + doctorInd + "]" + "Врач: " + doctor);
                            doctorInd++;
                        }
                        Doctor doctorSel = doctorsList.get(in.nextInt());
                        System.out.println("Выберите дату:");
                        String dateVisit = in.next();
                        System.out.println("Выберите время:");
                        String timeVisit = in.next();
                        clinic.addVisit(dateVisit, timeVisit, patientSelect, departmentSelect, doctorSel);
                        System.out.println("Вы успешно записались к врачу");
                        break;
                    case (5):
                        for (Visit visit : clinic.getVisit()) {
                            System.out.println("Посещение: " + visit.toString());
                        }
                        break;
                    case (6):
                        for (Department department : clinic.getListDepartment()) {
                            System.out.println(department.toString());
                        }
                        break;
                    case (7):
                        ClinicDAO.writeClinic(clinic);
                        break;
                    case (8):
                        System.exit(0);

                }
            }
        } else {
            Clinic clinic = new Clinic();
            ClinicDAO.writeClinic(clinic);
        }
    }
}
