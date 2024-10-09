package my.home.jkits.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.home.jkits.model.Statistic;
import my.home.jkits.service.StatisticService;
import org.jsoup.helper.HttpConnection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;
    @PostMapping("/statistic")
    public Statistic getStatistic(@RequestParam("text") String text) {
        log.debug("controller...");

        return statisticService.getStatistic(text);
    }

    @PostMapping("/types/add/{name}")
    public ResponseEntity<?> setType(String name) {
        log.debug("");

        statisticService.setType(name);
        return ResponseEntity.noContent().build();
    }
}
