
import java.io.Serializable;

public enum Specialization implements Serializable {
    ORTHOPEDIC("Ортопедическое"),
    SURGICAL("Хирургическое"),
    THERAPEUTIC("Терапевтическое"),
    PERIODONTAL("Пародонтологическое");
    private final String name;

    Specialization(String name) {
        this.name = name;
    }
}
