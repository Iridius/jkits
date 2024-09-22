package my.home.jkits.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.home.jkits.model.Statistic;
import my.home.jkits.repository.StatisticMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StatisticService {
    private final StatisticMapper statisticMapper;
    public Statistic getStatistic(String text) {
        log.debug("service...");

        List<String> allowedTags = statisticMapper.getTags();
        List<String> words = List.of(text.split(" "));

        return getMostRecentTags(allowedTags, words);
    }

    private Statistic getMostRecentTags(List<String> tags, List<String> words) {
        Statistic result = new Statistic();

        words.stream()
                .filter(tags::contains)
                .forEach(result::putWord);

        return result;
    }
}