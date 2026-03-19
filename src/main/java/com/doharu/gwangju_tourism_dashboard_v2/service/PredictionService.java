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

        List<Integer> data = ((List<?>) request.get("series"))
                .stream()
                .map(value -> (Integer) value)
                .toList();
        int n = Math.min(14, data.size()); // 최근 14개만 사용
        List<Integer> recent = data.subList(data.size() - n, data.size());
        double sumX = 0;
        double sumY = 0;
        double sumXY = 0;
        double sumXX = 0;

        for (int i = 0; i < n; i++) {
            double x = i;               // 시간 (0,1,2,...)
            double y = recent.get(i);  // 방문자 수

            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumXX += x * x;
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumXX - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        List<Integer> predictions = new ArrayList<>();

        for (int i = 0; i < daysInMonth; i++) {
            double x = n + i; // 미래 시간
            int predicted = (int) (slope * x + intercept);
            predictions.add(predicted);
        }


        return Map.of(
                "predictions", predictions,
                "message", "AI 분석 결과 증가 추세"
        );
    }
}