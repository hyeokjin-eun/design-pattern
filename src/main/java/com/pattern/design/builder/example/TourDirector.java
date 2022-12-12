package com.pattern.design.builder.example;

import java.time.LocalDate;

public class TourDirector {

    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan seoulTour() {
        return tourPlanBuilder.title("서울")
                .nightsAndDays(1, 2)
                .startDate(LocalDate.of(2022, 1, 15))
                .whereToStay("호텔")
                .addPlan(0, "체크 인")
                .addPlan(1, "체크 아웃")
                .getPlant();
    }
}
