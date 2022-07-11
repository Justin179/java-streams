package com.amigoscode.openhome;

import java.util.function.Supplier;
/*
    Eager evaluation means expression is evaluated as soon as it is encountered where as lazy evaluation
    refers to evaluation of an expression when needed. See the following example to under the concept.
    Here checkInEagerWay() function first evaluated the parameters then executes its statement.
    Whereas checkInLazyWay() executes its statement and evaluates the parameter on need basis.

    As && is a short-circuit operator, checkInLazyWay only evaluated first parameter
    which comes as false and does not evaluate the second parameter at all.
 */
public class EagerEval {
    public static void main(String[] args) {
        String queryString = "password=test";

        System.out.println(checkInEagerWay(hasName(queryString), hasPassword(queryString)));

        System.out.println(checkInLazyWay(() -> hasName(queryString), () -> hasPassword(queryString)));
    }

    private static boolean hasName(String queryString){
        System.out.println("Checking name: ");
        return queryString.contains("name");
    }

    private static boolean hasPassword(String queryString){
        System.out.println("Checking password: ");
        return queryString.contains("password");
    }

    private static String checkInEagerWay(boolean result1, boolean result2){
        return (result1 && result2) ? "all conditions passed": "failed.";
    }

    private static String checkInLazyWay(Supplier<Boolean> result1, Supplier<Boolean> result2){
        return (result1.get() && result2.get()) ? "all conditions passed": "failed.";
    }
}
