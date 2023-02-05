import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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

        System.out.println(function.apply(1234.433));


        Function<Double, Long> function1 = aDouble -> longValue();

        System.out.println("------");

        Supplier<Person> personSupplier = new Supplier<Person>() {
            @Override
            public Person get() {
                double a = Math.random();
                return people.get((int) a);
            }
        };

        System.out.println(personSupplier.get());


    }

    Predicate<Integer> condition = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer > 0;
        }

        Function<Integer, Integer> ifTrue = integer -> * 10;
        Function<Integer, Integer> ifFalse = integer -> * -10;
        Function<Integer, Integer> ternOperator = Lesson10.ternaryOperator(condition, ifTrue, ifFalse);
    System.out.println();

    };
}
   class Lesson10 {
       public static void main(String[] args) {

       }

       public static <T, U> Function<T, U> ternaryOperator(
               Predicate<? super T> condition,
               Function<? super T, ? extends U> ifTrue,
               Function<? super T, ? extends U> ifFalse) {
           Function<T, U> buildedFunction = x -> {
               if (condition.test(x)) {
                   return ifTrue.apply(x);
               } else {
                   return ifFalse.apply(x);
               }
           };

           return buildedFunction;
       }
   }








