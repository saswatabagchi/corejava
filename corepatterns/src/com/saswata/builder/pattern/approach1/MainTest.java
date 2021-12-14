package com.saswata.builder.pattern.approach1;

public class MainTest {

    public static void main(String[] args) {
        Task task = new TaskBuilder().setId(5L).setDescription("Hello").setSummary("Test").build();
        System.out.println(task);
    }

}
