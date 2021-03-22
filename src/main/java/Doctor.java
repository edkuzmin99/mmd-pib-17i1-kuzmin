
import java.io.Serializable;

public class Doctor implements Serializable {
    private String name;

    public Doctor(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                '}';
    }
}
