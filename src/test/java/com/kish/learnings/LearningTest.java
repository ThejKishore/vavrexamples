package com.kish.learnings;

import io.vavr.*;
import io.vavr.collection.List;
import io.vavr.collection.Stream;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Test;

import java.net.URI;
import java.util.stream.Collectors;

import static io.vavr.API.*;
import static io.vavr.Predicates.*;

public class LearningTest {

    /***
     * Function1
     * Function2
     * Function3
     * Function4
     * Function5
     * Function6
     * Function7
     * Function8
     *
     * CheckedFunction0
     * CheckedFunction1
     * CheckedFunction2
     * CheckedFunction3
     * CheckedFunction4
     * CheckedFunction5
     * CheckedFunction6
     * CheckedFunction7
     * CheckedFunction8
     *
     *
     * Tuple4
     * Tuple5 ... N 
     *
     * List.of();
     * API.List();
     * @throws Exception
     */

    @Test
    public void example_1() throws Exception {
        System.out.println("Test running");

        List<Integer> value = API.List(1, 2, 3, 4);

        Function1<Integer,String> add2 = (value1) -> value1 + " " + 2;
        System.out.println(add2.apply(4));


    }


    @Test
    public void example_2() throws Exception {
        System.out.println("Test running");
        Option.of("42")
                .map(String::toUpperCase)
                .forEach(System.out::print);

    }


    @Test
    public void example_3() throws Exception {
        System.out.println("Test running");

        List.of(Option.of(42), Option.of(52))
                .flatMap(o -> o).forEach(System.out::println);

    }


    @Test
    public void example_4() throws Exception {
        System.out.println("Test running");

        String asd = Try.of(() -> new URI(""))
                .map(uri -> uri.toString())
                .filter(i -> true)
                .getOrElse("something");

    }

    @Test
    public void example_5() throws Exception {

        Lazy<Integer> lazy = Lazy.of(() -> {
            System.out.println("Computing");
            return 42;
        });


        lazy.get();
        lazy.get();
        lazy.get();
    }

    // persistent collection

    @Test
    public void example_6() throws Exception {
        List<Integer> list = List.of(1, 2, 3);
        List<Integer> integers  = list.drop(1);
        list.tail();


        System.out.println(integers);
        System.out.println(list);

        System.out.println(list.zipWithIndex());

        list.collect(Collectors.toList()).forEach(System.out::println);
    }

    @Test
    public void example_9() throws Exception {

         Stream.iterate(0, integer -> integer + 1)
                .take(10)
                .forEach(System.out::println);

    }

    @Test
    public void example_10() throws Exception {
        List.of(1,2,3).asJava();
    }

    @Test
    public void example_11() throws Exception {
        Tuple2<String, Integer> tuple2 = Tuple.of("Java", 8);

        System.out.println(tuple2._1);
        System.out.println(tuple2._2);
        String date = tuple2.apply((s,integer) -> s+integer);
        System.out.println(date);
    }



    @Test
    public void example_12() throws Exception {
        List.of("")
                .map(unchecked(s -> new URI(s)));
    }

    @Test
    public void example_13() throws Exception {
        Object a = 42;
        String s = Match(a).of(
                Case($(instanceOf(String.class)),"String"),
                Case($(instanceOf(Integer.class)),"int"));

        System.out.println(s);
    }
}