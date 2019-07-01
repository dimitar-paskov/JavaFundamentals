import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.io.*;
import java.util.*;

public class JavaPingExampleProgram {
    public static void main(String args[])
            throws IOException
    {
        // create the ping command as a list of strings
        JavaPingExampleProgram ping = new JavaPingExampleProgram();
        List<String> commands = new ArrayList<String>();
        commands.add("ping");
        commands.add("-c");
        commands.add("5");
        commands.add("194.153.145.104");
        ping.doCommand(commands);
    }

    public void doCommand(List<String> command)
            throws IOException
    {
        String s = null;

        ProcessBuilder pb = new ProcessBuilder(command);
        Process process = pb.start();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // read the output from the command
        System.out.println("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null)
        {
            System.out.println(s);
        }

        // read any errors from the attempted command
        System.out.println("Here is the standard error of the command (if any):\n");
        while ((s = stdError.readLine()) != null)
        {
            System.out.println(s);
        }
    }
}
