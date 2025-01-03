import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Historial {
    private final String archivoHistorial;

    public Historial(String archivoHistorial) {
        this.archivoHistorial = archivoHistorial;
    }

    public void guardarHistorial(String conversion) {
        try {
            List<String> historial = leerHistorial();
            historial.add(conversion);

            Gson gson = new Gson();
            FileWriter writer = new FileWriter(archivoHistorial);
            gson.toJson(historial, writer);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al guardar el historial: " + e.getMessage());
        }
    }

    public List<String> leerHistorial() {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(archivoHistorial);

            Type listType = new TypeToken<ArrayList<String>>() {}.getType();
            List<String> historial = gson.fromJson(reader, listType);
            reader.close();

            if (historial == null) {
                return new ArrayList<>();
            }

            return historial;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
