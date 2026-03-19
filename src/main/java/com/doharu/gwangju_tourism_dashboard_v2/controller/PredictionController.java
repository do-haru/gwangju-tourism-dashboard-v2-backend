package com.doharu.gwangju_tourism_dashboard_v2.controller;

import com.doharu.gwangju_tourism_dashboard_v2.service.PredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/predict")
@RequiredArgsConstructor
public class PredictionController {
    private final PredictionService predictionService;

    @PostMapping
    public Map<String, Object> predict(@RequestBody Map<String, Object> request) {
        return predictionService.predict(request);
    }
}
