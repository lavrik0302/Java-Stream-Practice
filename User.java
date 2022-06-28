import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }

    public static int ageSum(List<User> list) {
        Stream<User> userStream = list.stream();
        int sum = userStream.reduce(0,
                (x, y) -> {
                    return x + y.getAge();
                }, (x, y) -> x + y);
        return sum;
    }

    public static double avgAge(List<User> list) {
        Stream<User> userStream = list.stream();
        int sum = userStream.reduce(0,
                (x, y) -> {
                    return x + y.getAge();
                }, (x, y) -> x + y);
        int count = (int) list.stream().count();
        return (double) sum / count;
    }

    public static List<User> moreThan30(List<User> list) {
        List<User> moreThan30list =
                list.stream()
                        .filter(p -> p.age > 30)
                        .collect(Collectors.toList());
        return moreThan30list;
    }

    public static List<User> sortedByAge(List<User> list) {
        List<User> sortedByAge= list.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());
        return sortedByAge;
    }

    public static List<User> sortedByDate(List<User>list){
        List<User> sortedByDate= list.stream()
                .sorted(Comparator.comparing(User::getDate))
                .collect(Collectors.toList());import java.time.LocalDate;
2
import java.util.ArrayList;
3
import java.util.Comparator;
4
import java.util.List;
5
import java.util.stream.Collectors;
6
import java.util.stream.Stream;
7
​
8
public class User {
9
    String name;
10
    int age;
11
    LocalDate date;
12
​
13
    public User(String name, int age, LocalDate date) {
14
        this.name = name;
15
        this.age = age;
16
        this.date = date;
17
    }
18
​
19
    public int getAge() {
20
        return age;
21
    }
22
​
23
    public LocalDate getDate() {
24
        return date;
25
    }
26
​
27
    @Override
28
    public String toString() {
29
        return "User{" +
30
                "name='" + name + '\'' +
31
                ", age=" + age +
32
                ", date=" + date +
33
                '}';
34
    }
35
​
36
    public static int ageSum(List<User> list) {
37
        Stream<User> userStream = list.stream();
38
        int sum = userStream.reduce(0,
39
                (x, y) -> {
40
                    return x + y.getAge();import java.time.LocalDate;
2
import java.util.ArrayList;
3
import java.util.Comparator;
4
import java.util.List;
5
import java.util.stream.Collectors;
6
import java.util.stream.Stream;
7
​
8
public class User {
9
    String name;
10
    int age;
11
    LocalDate date;
12
​
13
    public User(String name, int age, LocalDate date) {
14
        this.name = name;
15
        this.age = age;
16
        this.date = date;
17
    }
18
​
19
    public int getAge() {
20
        return age;
21
    }
22
​
23
    public LocalDate getDate() {
24
        return date;
25
    }
26
​
27
    @Override
28
    public String toString() {
29
        return "User{" +
30
                "name='" + name + '\'' +
31
                ", age=" + age +
32
                ", date=" + date +
33
                '}';
34
    }
35
​
36
    public static int ageSum(List<User> list) {
37
        Stream<User> userStream = list.stream();
38
        int sum = userStream.reduce(0,
39
                (x, y) -> {
40
                    return x + y.getAge();
41
                }, (x, y) -> x + y);
42
        return sum;
43
    }
44
​
45
    public static double avgAge(List<User> list) {
41
                }, (x, y) -> x + y);
42
        return sum;
43
    }
44
​
45
    public static double avgAge(List<User> list) {

        return sortedByDate;
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Alexey", 61, LocalDate.of(2011, 12, 25)));
        list.add(new User("Eugene", 39, LocalDate.of(1975, 12, 25)));
        list.add(new User("Veronika", 25, LocalDate.of(2012, 12, 25)));
        list.add(new User("Samuel", 45, LocalDate.of(2015, 12, 25)));
        list.add(new User("Alice", 49, LocalDate.of(2000, 12, 25)));
        list.add(new User("Bob", 68, LocalDate.of(2004, 12, 25)));
        list.add(new User("Kate", 19, LocalDate.of(1996, 12, 25)));
        list.add(new User("John", 37, LocalDate.of(1999, 12, 25)));
        list.add(new User("Donald", 38, LocalDate.of(2009, 12, 25)));
        list.add(new User("Benjamin", 34, LocalDate.of(2017, 12, 25)));
        list.add(new User("Ryan", 24, LocalDate.of(1989, 12, 25)));

        System.out.println(ageSum(list));
        System.out.println(avgAge(list));
        System.out.println(moreThan30(list));
        System.out.println(sortedByAge(list));
        System.out.println(sortedByDate(list));
    }
}
