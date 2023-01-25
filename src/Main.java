import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Oleg",18);
        Person person2 = new Person("Rick",40);
        Person person3 = new Person("Vlad", 13);
        Person person4 = new Person("Jack",50);

        List <Person> people=new ArrayList<>();
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        for(Person person : people){
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

        // не очень понимаю как вывести в консоль consumer? через people.  или как вообще?
        //как его использовать? например его нужно использовать чтобы сделать что то конкретное и один раз?чтоб не рассписывать отделный класс?
        //можно ли его использовать например для помещения "выполненых задач" в отделный список в предстоящей курсовой?(так как он не возвращает значение)
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println( "Привет мое имя" + person.getName() + " Возраст "+ person.getAge());
            }
        };
        System.out.println(consumer);

        Consumer<Person> consumer1 = person -> System.out.println( "Привет мое имя" + person.getName() + " Возраст "+ person.getAge());


        // По поводу задания 3 Function не много не понял...нужно создать переменные типа double и longe?  или только double? а потом поменять тип?
//        Function<double,long> function = new Function<double, long>() {
//            @Override
//            public long apply(double v) {
//                return 0;
//            }
//        };
        System.out.println("------");

          //Такой же вопрос...не могу вывести...да и правильно ли вообще ранодом реализован оносительно Person?
        // А если пытаюсь положить другой тип кроме Person то все красное...
        Supplier <Person> personSupplier = new Supplier<Person>() {
            @Override
            public Person get() {
                double a = Math.random();
                return people.get((int) a);
            }
        };
        System.out.println(personSupplier);

         // 5е задание вообще не понял...при копировании текста все красное...если пересоздать то что за параметры <T U> ? я понял что нужно написать метод))
//       Function <T, U> Function<T, U> ternaryOperator(
//                Predicate<? super T> condition,
//                Function<? super T, ? extends U> ifTrue,
//                Function<? super T, ? extends U> ifFalse) {
//
//
//
//        }


    }
}