package my.home.jkits.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.home.jkits.repository.KitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KitService {
    private final KitMapper kitMapper;

    public int createTag(String title) {
        return kitMapper.createTag(title);
    }

    public int createItem(String name) {
        return kitMapper.createItem(name);
    }
}
