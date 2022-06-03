import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class EP09UserLogs {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

		String line = "";
		while (!"end".equals(line = scanner.nextLine())) {
			String[] parts = line.split(" ");
			String ipAddress = parts[0].split("=")[1];
			String user = parts[2].split("=")[1];

			logs.putIfAbsent(user, new LinkedHashMap<String, Integer>());
			logs.get(user).putIfAbsent(ipAddress, 0);
			logs.get(user).put(ipAddress, logs.get(user).get(ipAddress) + 1);

		}

		for (String name : logs.keySet()) {
			System.out.println(name + ":");
			String log = "";
			for (String ip : logs.get(name).keySet()) {
				log = log + ip + " => " + logs.get(name).get(ip) + ", ";
			}
			log = log.substring(0, log.length() - 2) + ".";
			System.out.println(log);
		}

	}
}
