package my.home.jkits.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class KitServiceTest {
    private final KitService kitService;

    KitServiceTest(@Autowired KitService kitService) {
        this.kitService = kitService;
    }

    @Test
    public void createTag() {
        String title = "tag1";

        int actual = kitService.createTag(title);

        Assertions.assertTrue(actual > 0, "Ожидалось, что будет создан тег...");
    }

    @Test
    public void createItem() {
        String name = "name1";

        int actual = kitService.createItem(name);

        Assertions.assertTrue(actual > 0);
    }
}