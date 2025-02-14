import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Task1
        Set<Set<String>> sets = new HashSet<>();
        Set<String> strings = new HashSet<>();
        strings.add("раз");
        strings.add("два");
        strings.add("три");
        Set<String> strings2 = new HashSet<>();
        strings2.add("Первое");
        strings2.add("Второеjkj;lkj;lkj;lkj;lkj;lj;lkj;l");
        strings2.add("Семьдесят шестое");
        Set<String> strings3 = new HashSet<>();
        strings3.add("12");
        strings3.add("783");
        strings3.add("37288736");
        Set<String> strings4 = new HashSet<>();
        strings4.add("Проверка");
        strings4.add("Струн");
        strings4.add("Раз-Два");

        sets.add(strings);
        sets.add(strings2);
        sets.add(strings3);
        sets.add(strings4);

        //todo Решение дз 1

        int sum = sets.stream().flatMap(set -> set.stream()).
                mapToInt(x -> x.length()).sum();
        System.out.println(sum);

        String maxLenght = sets.stream().flatMap(set -> set.stream()).max(Comparator.comparing(String::length)).get();
        System.out.println(maxLenght);


        //Task2
        List<Employee> employees = EmployeeFactory.createEmployee();
        //todo решения дз 2 тут
        Employee bestKpi = employees.stream().max(Comparator.comparing(Employee::getKpi)).get();
        System.out.println(bestKpi);

        employees.stream().filter(x->x.getAge()>65).forEach(x -> System.out.println(x));

        employees.stream().filter(x->x.getName().matches(".*[^а-яА-ЯёЁ].*")).forEach(System.out::println);

        Employee biggestSalary = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(biggestSalary);

        double averageKpi = employees.stream().mapToDouble(x -> x.getKpi()).average().getAsDouble();
        System.out.println("Average KPI - " + averageKpi);
        employees.stream().filter(x -> x.getKpi()>averageKpi).forEach(System.out::println);

        double avarageRusKpi = employees.stream().filter(x->!x.getName().matches(".*[^а-яА-ЯёЁ].*")).
                            filter(x->x.getAge()<45).
                            filter(x->x.getSalary()>20000).mapToDouble(x -> x.getKpi()).average().orElse(0.0);
        System.out.println("Значение среднего kpi у русских работников, которым меньше 45 лет и " +
                "зп которых больше 20000 " + avarageRusKpi);


        Map<String, Employee> mapa = employees.stream().
                                filter(x -> x.getAge()<35 && x.getSalary()>20000).
                                collect(Collectors.toMap(e->e.getName() + " " + e.getSurname(), e -> e));






    }
}