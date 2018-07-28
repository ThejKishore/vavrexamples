package com.kish.learnings;


import io.vavr.collection.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Wither
public class Person {
    private int age;
    private String name;
    private String mailId;
    private List<String> address;

}
