import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private Map<Integer, ArrayList<Integer>> inscripciones;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.inscripciones = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        if (estudiantes.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está matriculado.");
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!cursos.contains(curso)) {
            cursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Integer> inscritos = inscripciones.get(idCurso);
        if (inscritos == null) {
            inscritos = new ArrayList<>();
            inscripciones.put(idCurso, inscritos);
        }
        if (inscritos.contains(estudiante.getId())) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
        }
        inscritos.add(estudiante.getId());
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Integer> inscritos = inscripciones.get(idCurso);
        if (inscritos == null || !inscritos.contains(idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso.");
        }
        inscritos.remove(Integer.valueOf(idEstudiante));
    }

    public ArrayList<Integer> obtenerEstudiantesInscritos(int idCurso) {
        return inscripciones.getOrDefault(idCurso, new ArrayList<>());
    }
}

