package my.home.jkits.service;

import my.home.jkits.model.Statistic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StatisticServiceTest {
    private final StatisticService statisticService;
    private static TestData data;

    StatisticServiceTest(@Autowired StatisticService service) {
        this.statisticService = service;
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
}