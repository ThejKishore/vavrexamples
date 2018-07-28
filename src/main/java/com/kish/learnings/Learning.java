package com.kish.learnings;

import io.vavr.Function1;
import io.vavr.collection.List;
import lombok.val;

import java.util.stream.Collectors;

public class Learning {


    public void learning1(){

    }


    //vavr function composition sample
    public void functionCompositionSample(){
        Function1<Integer, Integer> plusOne = a -> a + 1;
        Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

        Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);

        System.out.println(add1AndMultiplyBy2.apply(2).longValue() == 6 );

    }

    public static void main(String[] args) {
        Learning library = new Learning();
        library.functionCompositionSample();

        Person p = new Person(1,"Shanaya","shanaya1110@gmail.com",List.of("Something1","Something2","Something3"));
        val p2 = p.withAge(2);

        System.out.println(p);
        System.out.println(p2);


        val names = List.of(new Person(33,"Thej","kishores1984@gmail.com",List.of("Test1","Test2","Test3")),
                new Person(25,"Abirami","abiramibcse@gmail.com",List.of("Abi1","Abi2","Abi3")))
                .filter( p1 -> p1.getAge() > 30)
                .flatMap(d -> d.getAddress().toStream())
                .filter(v -> v.contains("1"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        names.forEach(System.out::println);


        Function1<Integer,Integer> mul = (value) -> {
            System.out.println("I am here");
            return value * 2;
        };

        val mul2memoized = mul.memoized();

        System.out.println( mul2memoized.apply(1));
        System.out.println(mul2memoized.apply(1));
        System.out.println(mul2memoized.apply(3));



    }
}
