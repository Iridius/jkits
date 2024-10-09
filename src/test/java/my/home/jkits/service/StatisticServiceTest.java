package my.home.jkits.service;

import my.home.jkits.model.Content;
import my.home.jkits.model.Pattern;
import my.home.jkits.model.Statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class StatisticServiceTest {
    private final StatisticService statisticService;
    private static TestData data;
    private static final String SOURCE_TYPE = "warspot.ru";
    private static final String URL = "https://warspot.ru/3707-desantniki-protiv-tankov-boy-na-ostrove-shumshu";

    StatisticServiceTest(@Autowired StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @BeforeAll
    public static void init() {
        data = new TestData();
    }

    @Test
    public void test_get_statistic_for_text() {
        String text = data.getSimpleParagraph();
        Statistic statistic = statisticService.getStatistic(text);

        int expected = 4;
        int actual = statistic.getTagCount("танк");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void set_type() {
        String text = "type_1";
        statisticService.setType(text);

        Assertions.assertTrue(statisticService.getTypes().contains(text));
    }

    @Test
    public void getPatterns() {
        List<Pattern> patterns = statisticService.getPatterns(SOURCE_TYPE);

        int expected = 2;
        int actual = patterns.size();

        Assertions.assertEquals(expected, actual, "Ожидалось, что будет получено другое число паттернов.");
    }

    @Test
    public void parse() {
        List<Pattern> patterns = statisticService.getPatterns(SOURCE_TYPE);
        List<Content> result = statisticService.parse(URL, patterns);

        Assertions.assertEquals(2, result.size(), "Ожидалось, что будет распознано другое количество элементов.");
    }
}