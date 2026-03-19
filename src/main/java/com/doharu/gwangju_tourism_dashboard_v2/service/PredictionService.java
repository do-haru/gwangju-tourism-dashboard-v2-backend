package com.doharu.gwangju_tourism_dashboard_v2.service;

import org.springframework.stereotype.Service;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PredictionService {

    public Map<String, Object> predict(Map<String, Object> request) {
        System.out.println(request);

        String year = (String) request.get("year");
        String month = (String) request.get("month");

        int yearInt = Integer.parseInt(year);
        int monthInt = Integer.parseInt(month);

        YearMonth yearMonth = YearMonth.of(yearInt, monthInt);
        int daysInMonth = yearMonth.lengthOfMonth();

        System.out.println("days: " + daysInMonth);
        System.out.println("year: " + year);
        System.out.println("month: " + month);

        List<Integer> predictions = new ArrayList<>();

        for (int i = 0; i < daysInMonth; i++) {
            // 간단한 더미 데이터 (랜덤 or 증가형)
            int value = 150 + (int)(Math.random() * 50);
            predictions.add(value);
        }

        return Map.of(
                "predictions", predictions,
                "message", "AI 분석 결과 증가 추세"
        );
    }
}