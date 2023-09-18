package br.com.nicoletti.dp.usecase.strategy;

import java.util.StringJoiner;

/**
 *
 * @author nicoletti
 */
public class TesteString {

    public static void main(String[] args) {

        String message = message("um", "2", 3, 4, "cinco");
        System.out.println("message: " + message);

    }

    public static String message(Object... message) {
        StringJoiner builder = new StringJoiner(", ");
        for (Object obj : message) {
            builder.add(String.valueOf(obj));
        }
        return builder.toString();
    }

}
