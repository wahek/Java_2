import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "Начало работы");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt");
            fileHandler.setFormatter((formatter));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String string = "{{'фамилия':'Иванов','оценка':'5','предмет':'Математика'},{'фамилия':'Петрова','оценка':'4','предмет':'Информатика'},{'фамилия':'Краснов','оценка':'5','предмет':'Физика'}}";
        string = string.replace("фамилия", "");
        string = string.replace("оценка", "");
        string = string.replace("предмет", "");
        string = string.replace("{", "");
        string = string.replace("}", "");
        string = string.replace(":", "");
        string = string.replace("'", "");
        try {
            FileWriter fileWriter = new FileWriter("log.txt");
            fileWriter.write("Удалили ненужные символы");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == ',') {
                count++;
            }
        }
        StringBuilder sb = new StringBuilder(string);
        sb.insert(0, ",");
        for (int i = 0; i < count; i += 3) {
            int index = sb.indexOf(",");
            sb.deleteCharAt(index);
            sb.insert(index, ". Студент ");
            index = sb.indexOf(",");
            sb.deleteCharAt(index);
            sb.insert(index, " получил оценку ");
            index = sb.indexOf(",");
            sb.deleteCharAt(index);
            sb.insert(index, " по предмету ");
        }
        sb.deleteCharAt(0);
        string = sb.toString();
        System.out.println(string.trim());
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        System.out.println("Execution time in milliseconds: " + timeElapsed);
        logger.log(Level.INFO, "Конец работы");
    }

}

