package dev.luisoliveira.teste.tinnova.testes;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;

public class Main {

    public static void main(String[] args){

        final ZonedDateTime input = ZonedDateTime.now();
        System.out.println(input);
        final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
        System.out.println(startOfLastWeek);
        final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
        System.out.println(endOfLastWeek);

    }

}
