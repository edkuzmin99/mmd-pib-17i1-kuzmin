
import java.io.*;

public class ClinicDAO {
    private static final String FILENAME = "kuzmin";

    public static boolean isFileExists() {
        return new File(FILENAME).exists();
    }

    public static Clinic readClinic() throws Exception {
        try (
                FileInputStream fileInputStream = new FileInputStream(FILENAME);
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
                ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream)
        ) {
            return (Clinic) objectInputStream.readObject();
        }
    }

    public static void writeClinic(Clinic clinic) throws Exception {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream)
        ) {
            objectOutputStream.writeObject(clinic);
        }
    }
}

