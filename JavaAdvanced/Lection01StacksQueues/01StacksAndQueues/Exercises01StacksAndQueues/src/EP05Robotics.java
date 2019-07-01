import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EP05Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        String[] robotsTokens = scanner.nextLine().split(";");

        List<String> robotsNames = new ArrayList<>();
        List<LocalDateTime> robotsNextAvailableTime = new ArrayList<>();
        List<Integer> robotsProcessingTime = new ArrayList<>();

        String[] time = scanner.nextLine().split(":");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");


        LocalTime startTime = LocalTime.of(Integer.parseInt(time[0]), Integer.parseInt(time[1]), Integer.parseInt(time[2]));
        LocalDate startDate = LocalDate.of(1999,01,01);
        LocalDateTime start = LocalDateTime.of(startDate, startTime);

        for (int i = 0; i < robotsTokens.length; i++) {

            String name = robotsTokens[i].split("-")[0];
            // pt = processing time
            int pt = Integer.parseInt(robotsTokens[i].split("-")[1]);

            robotsNames.add(name);
            robotsProcessingTime.add(pt);
            robotsNextAvailableTime.add(start);

        }

        String line;
        while (!(line = scanner.nextLine()).equals("End")) {
            queue.offer(line);
        }

        LocalDateTime current = start;
        while (queue.size()>0) {
            current = current.plusSeconds(1);

            boolean foundRobot = false;

            for (int i = 0; i < robotsNames.size(); i++){


                if (robotsNextAvailableTime.get(i).isAfter(current)){
                    continue;
                }else{
                    System.out.println(robotsNames.get(i) + " - " + queue.poll() + " [" + current.format(dtf) + "]");
                    robotsNextAvailableTime.set(i, current.plusSeconds(robotsProcessingTime.get(i)));
                    foundRobot = true;
                    break;
                }
            }

            if (!foundRobot){
                queue.offer(queue.poll());
            }


        }

    }
}


