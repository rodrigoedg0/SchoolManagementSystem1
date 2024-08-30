import java.util.Date;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancias de GestorAcademico
            GestorAcademico gestor = new GestorAcademico();

            // Crear algunos estudiantes y cursos
            Estudiante estudiante1 = new Estudiante(1, "Rodrigo", "Pérez", new Date(), "matriculado");
            Estudiante estudiante2 = new Estudiante(2, "Laura", "Gómez", new Date(), "matriculado");
            Curso curso1 = new Curso(101, "Matemáticas", "Curso de matemáticas básicas", 5, "v1.0");

            // Matricular estudiantes y agregar curso
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);
            gestor.agregarCurso(curso1);

            // Inscribir estudiantes en curso
            gestor.inscribirEstudianteCurso(estudiante1, curso1.getId());
            gestor.inscribirEstudianteCurso(estudiante2, curso1.getId());

            // Intentar desinscribir a un estudiante
            gestor.desinscribirEstudianteCurso(estudiante1.getId(), curso1.getId());

            // Verificar estudiantes inscritos
            System.out.println("Estudiantes inscritos en el curso " + curso1.getNombre() + ": " + gestor.obtenerEstudiantesInscritos(curso1.getId()));

        } catch (EstudianteYaInscritoException | EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }
    }
}
