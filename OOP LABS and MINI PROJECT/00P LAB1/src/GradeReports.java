import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Learner(String name, int roll, double gpa) {
    static Learner fromCsv(String line) {
        String[] p = line.split(",");
        return new Learner(p[0].trim(), Integer.parseInt(p[1].trim()), Double.parseDouble(p[2].trim()));
    }
}

public class GradeReports {

    // Grade band from GPA (4.0 scale): A >= 3.5, B >= 3.0, otherwise C
    static String band(Learner l) {
        if (l.gpa() >= 3.5) return "A";
        if (l.gpa() >= 3.0) return "B";
        return "C";
    }

    public static void main(String[] args) throws IOException {
        Path csv = Path.of("learners.csv");

        // Create sample data on first run so the program always has something to load
        if (!Files.exists(csv)) {
            Files.write(csv, List.of(
                    "Tariro,101,3.8", "Farai,102,3.1", "Rudo,103,3.9",
                    "Kuda,104,2.4", "Ada,105,3.5", "Tendai,106,2.9", "Nomsa,107,3.0"));
            System.out.println("learners.csv not found - created a sample file.");
        }

        // LOAD
        List<Learner> learners = new ArrayList<>();
        for (String line : Files.readAllLines(csv)) {
            if (!line.isBlank()) learners.add(Learner.fromCsv(line));
        }
        System.out.println(learners.size() + " learners loaded");

        // GROUP: Map<band, List<Learner>>; TreeMap keeps the bands in order A, B, C
        Map<String, List<Learner>> byBand = learners.stream()
                .collect(Collectors.groupingBy(GradeReports::band, TreeMap::new, Collectors.toList()));

        // WRITE one report file per band
        for (Map.Entry<String, List<Learner>> entry : byBand.entrySet()) {
            String band = entry.getKey();
            List<String> report = new ArrayList<>();
            report.add("Band " + band + " report (" + entry.getValue().size() + " learners)");
            report.add("----------------------------------");
            entry.getValue().stream()
                    .sorted((a, b) -> Double.compare(b.gpa(), a.gpa()))   // highest GPA first
                    .forEach(l -> report.add(String.format("%-10s roll=%d  gpa=%.1f", l.name(), l.roll(), l.gpa())));

            Path out = Path.of("report_" + band + ".txt");
            Files.write(out, report);
            System.out.println("Wrote " + out + " (" + entry.getValue().size() + " learners)");
        }
    }
}
