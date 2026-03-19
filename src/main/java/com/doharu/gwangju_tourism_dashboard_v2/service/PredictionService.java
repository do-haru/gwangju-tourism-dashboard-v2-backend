package com.doharu.gwangju_tourism_dashboard_v2.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PredictionService {

    public Map<String, Object> predict(Map<String, Object> request) {
        return Map.of(
                "predictions", List.of(155, 160, 158, 162, 165),
                "message", "AI 분석 결과 증가 추세"
        );
    }
}