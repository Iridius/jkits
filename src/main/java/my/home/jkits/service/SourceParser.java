package my.home.jkits.service;

import my.home.jkits.model.Content;
import my.home.jkits.model.Pattern;

import java.util.List;

public interface SourceParser {
    List<Content> parse(String url, List<Pattern> patterns);
}