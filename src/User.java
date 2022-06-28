import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class User {
    String name;
    int age;
    LocalDate date;

    public User(String name, int age, LocalDate date) {
        this.name = name;
        this.age = age;
        this.date = date;

    }

    public int getAge() {
        return age;
    }

    public String getDate() {
        return date.toString();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Alexey", 37,LocalDate.of(2011,12,25)));
        list.add(new User("Eugene", 39,LocalDate.of(1975,12,25)));
        list.add(new User("Veronika", 25,LocalDate.of(2012,12,25)));
        list.add(new User("Samuel", 45,LocalDate.of(2015,12,25)));
        list.add(new User("Alice", 49,LocalDate.of(2000,12,25)));
        list.add(new User("Bob", 68,LocalDate.of(2004,12,25)));
        list.add(new User("Kate", 19,LocalDate.of(1996,12,25)));
        list.add(new User("John", 37,LocalDate.of(1999,12,25)));
        list.add(new User("Donald", 38,LocalDate.of(2009,12,25)));
        list.add(new User("Benjamin", 34,LocalDate.of(2017,12,25)));
        list.add(new User("Ryan", 24,LocalDate.of(1989,12,25)));

AtomicInteger sum= new AtomicInteger();

       list.stream()
                .forEach(x-> sum.addAndGet(x.age));

        System.out.println("Сумма всех возрастов = "+ sum);
        System.out.println();
        System.out.println("Средний возраст сотруников = "+ (double)sum.get()/list.size());

        System.out.println();
        System.out.println("Список сотрудников старше 30 лет ");
        System.out.println();

        list.stream()
                .forEach(x-> sum.addAndGet(x.age));
        list.stream()
                .filter(p->p.age>30)
                .forEach(s-> System.out.println(s));

        System.out.println();
        System.out.println("Список дат приема на работу ");
        System.out.println();

        list.stream()
                .forEach(s-> System.out.println(s.date));
        System.out.println();
        System.out.println("Cортировка сотрудников по возрасту ");
        System.out.println();

        List<User> sortedByAge= list.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        sortedByAge.forEach(System.out::println);

        System.out.println();
        System.out.println("Cортировка сотрудников по дате приема на работу ");
        System.out.println();

        List<User> sortedByDate= list.stream()
                .sorted(Comparator.comparing(User::getDate))
                .collect(Collectors.toList());

        sortedByDate.forEach(System.out::println);

    }
}
