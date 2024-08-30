import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorAcademico {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private Map<Integer, ArrayList<Integer>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    // Métodos para añadir estudiantes y cursos

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    // Método para inscribir un estudiante en un curso
    public void inscribirEstudiante(int idEstudiante, int idCurso) {
        if (!inscripciones.containsKey(idCurso)) {
            inscripciones.put(idCurso, new ArrayList<>());
        }
        inscripciones.get(idCurso).add(idEstudiante);
    }

    // Otros métodos como obtener estudiantes inscritos en un curso, etc.

    public ArrayList<Integer> obtenerEstudiantesInscritos(int idCurso) {
        return inscripciones.getOrDefault(idCurso, new ArrayList<>());
    }
}
