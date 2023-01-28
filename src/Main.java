import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static sun.security.krb5.Confounder.longValue;



public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Oleg", 18);
        Person person2 = new Person("Rick", 40);
        Person person3 = new Person("Vlad", 13);
        Person person4 = new Person("Jack", 50);

        List<Person> people = new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("------------");
        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() > 18;
            }
        };
        people.removeIf(predicate);
        System.out.println(people);
        System.out.println("---------");

        Predicate<Person> predicate1 = person -> person.getAge() > 18;
        System.out.println(people);

        System.out.println("---------");

        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println("Привет мое имя " + person.getName() + " Возраст " + person.getAge());
            }
        };
        consumer.accept(person1);
        consumer.accept(person2);


        Consumer<Person> consumer1 = person -> System.out.println("Привет мое имя" + person.getName() + " Возраст " + person.getAge());
        consumer1.accept(person3);


        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return longValue();
            }
        };
        function.apply(1234.433);

        Function<Double, Long> function1 = aDouble -> longValue();

        System.out.println("------");

        Supplier<Person> personSupplier = new Supplier<Person>() {
            @Override
            public Person get() {
                double a = Math.random();
                return people.get((int) a);
            }
        };
        personSupplier.get();
    }
}

//       public static <T, U> Function<T, U> ternaryOperator(
//            Predicate<Integer> condition,
//            Function<? super T, ? extends U> ifTrue,
//            Function<? super T, ? extends U> ifFalse) {
//        if(condition.test(1)){
//            return (Function<T, U>) ifTrue;
//        }
//        else return (Function<T, U>) ifFalse;
//        condition.test(1).
//    }
//
//}



