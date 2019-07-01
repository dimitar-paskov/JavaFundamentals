package pr01HarvestingFields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Field[] fields = RichSoilLand.class.getDeclaredFields();

        Consumer<Field> printer = f-> System.out.println(String.format("%s %s %s",
                Modifier.toString(f.getModifiers()),
                f.getType().getSimpleName(),
                f.getName()));

        String command = "";

        while (!"HARVEST".equals(command = reader.readLine())){
            String finalCommand = command;
            Field[] requestedFields = Arrays.stream(fields).filter(
                    f->Modifier.toString(f.getModifiers()).equals(finalCommand)
            ).toArray(Field[]::new);

            if (requestedFields.length != 0){
                Arrays.stream(requestedFields).forEach(printer);
            }else{
                Arrays.stream(fields).forEach(printer);
            }

        }

    }
}

