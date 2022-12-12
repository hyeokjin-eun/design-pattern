package com.pattern.design.builder.example;

public class App {

    public static void main(String[] args) {
        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan seoulTour = director.seoulTour();
    }
}
