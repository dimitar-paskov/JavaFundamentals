package EP04RawData;
public class Tyre {
    Double pressure;
    Integer age;

    public Tyre(Double pressure, Integer age) {
        this.pressure = pressure;
        this.age = age;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
