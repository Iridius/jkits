package my.home.jkits.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.home.jkits.service.KitService;
import my.home.jkits.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class KitController {
    private final KitService kitService;
    @PostMapping("/tags")
    public ResponseEntity<?> createTag(String title) {
        log.debug("KitController.createTag...");

        kitService.createTag(title);
        return ResponseEntity.noContent().build();
    }
}
