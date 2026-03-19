package com.doharu.gwangju_tourism_dashboard_v2.service;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PredictionService {

    public Map<String, Object> predict(Map<String, Object> request) {
        return Map.of(
                "prediction", 12345,
                "message", "AI 분석 결과: 방문자 수 증가 예상"
        );
    }
}