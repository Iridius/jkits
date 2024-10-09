package my.home.jkits.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.home.jkits.model.Content;
import my.home.jkits.model.Pattern;
import my.home.jkits.model.Statistic;
import my.home.jkits.repository.StatisticMapper;
import my.home.jkits.service.impl.HtmlSourceParser;
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

    public void setType(String text) {
        statisticMapper.setType(text);
    }

    public List<String> getTypes() {
        return statisticMapper.getTypes();
    }

    private Statistic getMostRecentTags(List<String> tags, List<String> words) {
        Statistic result = new Statistic();

        words.stream()
                .filter(tags::contains)
                .forEach(result::putWord);

        return result;
    }

    public String getSource(int id) {
        return statisticMapper.getSource(id);
    }

    public List<Pattern> getPatterns(String sourceType) {
        return statisticMapper.getPatterns(sourceType);
    }

    public List<Content> parse(String url, List<Pattern> patterns) {
        SourceParser parser = new HtmlSourceParser();
        List<Content> result = parser.parse(url, patterns);

        return result;
    }
}