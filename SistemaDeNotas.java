import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private double[] grades = new double[5];
    private double attendance;
    private double averageGrade;

    public Student(String name, double[] grades, double attendance) {
        this.name = name;
        this.grades = grades;
        this.attendance = attendance;
        double sum = 0;
        for (double grade : grades) sum += grade;
        this.averageGrade = sum / grades.length;
    }

    public String getName() { return name; }
    public double[] getGrades() { return grades; }
    public double getAttendance() { return attendance; }
    public double getAverageGrade() { return averageGrade; }

    @Override
    public String toString() {
        return name + " | Média: " + String.format("%.2f", averageGrade) +
               " | Frequência: " + String.format("%.2f%%", attendance);
    }
}

public class SistemaDeNotas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        System.out.println("=== Sistema de Notas e Frequência ===");
        System.out.println("Digite os dados dos alunos no formato:");
        System.out.println("Nome nota1 nota2 nota3 nota4 nota5 frequência%");
        System.out.println("Digite 'fim' para encerrar a entrada de dados.\n");

        while (true) {
            System.out.print("Aluno: ");
            String line = sc.nextLine();
            if (line.equalsIgnoreCase("fim")) break;

            String[] parts = line.split(" ");
            if (parts.length != 7) {
                System.out.println("Entrada inválida! Formato correto: Nome nota1 nota2 nota3 nota4 nota5 frequência%\n");
                continue;
            }

            String name = parts[0];
            double[] grades = new double[5];
            try {
                for (int i = 0; i < 5; i++) {
                    grades[i] = Double.parseDouble(parts[i + 1]);
                    if (grades[i] < 0 || grades[i] > 10) throw new NumberFormatException("Nota fora do intervalo 0-10");
                }

                double attendance = Double.parseDouble(parts[6].replace("%", ""));
                if (attendance < 0 || attendance > 100) throw new NumberFormatException("Frequência fora do intervalo 0-100%");

                students.add(new Student(name, grades, attendance));
            } catch (NumberFormatException e) {
                System.out.println("Erro: " + e.getMessage() + "\n");
            }
        }

        if (students.isEmpty()) {
            System.out.println("\nNenhum aluno cadastrado. Encerrando sistema.");
            sc.close();
            return;
        }

        System.out.println("\n=== Dados dos Alunos ===");
        for (Student s : students) System.out.println(s);

        double[] classAverage = new double[5];
        for (Student s : students)
            for (int i = 0; i < 5; i++) classAverage[i] += s.getGrades()[i];
        for (int i = 0; i < 5; i++) classAverage[i] /= students.size();

        System.out.println("\n=== Média da Turma por Disciplina ===");
        for (int i = 0; i < 5; i++) System.out.println("Disciplina " + (i+1) + ": " + String.format("%.2f", classAverage[i]));

        double overallClassAverage = 0;
        for (double avg : classAverage) overallClassAverage += avg;
        overallClassAverage /= 5;

        List<String> aboveAverageStudents = new ArrayList<>();
        List<String> lowAttendanceStudents = new ArrayList<>();

        for (Student s : students) {
            if (s.getAverageGrade() > overallClassAverage) aboveAverageStudents.add(s.getName());
            if (s.getAttendance() < 75) lowAttendanceStudents.add(s.getName());
        }

        System.out.println("\n=== Alunos com Média Acima da Turma ===");
        if (aboveAverageStudents.isEmpty()) System.out.println("Nenhum aluno acima da média.");
        else aboveAverageStudents.forEach(System.out::println);

        System.out.println("\n=== Alunos com Frequência Abaixo de 75% ===");
        if (lowAttendanceStudents.isEmpty()) System.out.println("Nenhum aluno com frequência baixa.");
        else lowAttendanceStudents.forEach(System.out::println);

        sc.close();
        System.out.println("\n=== Fim do Sistema ===");
    }
}
