
import java.io.Serializable;

public class PatientCard implements Serializable {
    private String name;

    public PatientCard(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PatientCard{" +
                "name='" + name + '\'' +
                '}';
    }
}
