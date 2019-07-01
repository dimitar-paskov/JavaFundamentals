import java.util.List;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url :
                this.urls) {
            if (!url.matches(".*\\d+.*")){
                sb.append("Browsing: ").append(url).append("!").append(System.getProperty("line.separator"));
            }else{
                sb.append("Invalid URL!").append(System.getProperty("line.separator"));
            }
        }

        return sb.toString();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number :
                this.numbers) {
            String regex = "\\d+";
            if (number.matches(regex)){
                sb.append("Calling... ").append(number).append(System.getProperty("line.separator"));
            }else{
                sb.append("Invalid number!").append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }


}
