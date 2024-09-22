package my.home.jkits.service;

import lombok.extern.slf4j.Slf4j;
import my.home.jkits.model.Statistic;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Slf4j
@Service
public class StatisticService {
    public Statistic getStatistic(String text) {
        log.debug("service...");

        Statistic result = new Statistic();

        String[] parts = text.split(" ");
        Arrays.stream(parts).forEach(result::putWord);

        return result;
    }
}