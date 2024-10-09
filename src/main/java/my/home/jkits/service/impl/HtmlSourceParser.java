package my.home.jkits.service.impl;


import my.home.jkits.model.Content;
import my.home.jkits.model.Pattern;
import my.home.jkits.service.SourceParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HtmlSourceParser implements SourceParser {
    @Override
    public List<Content> parse(String url, List<Pattern> patterns) {
        List<Content> result = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            for(Pattern pattern: patterns) {
                Elements elements = doc.select(pattern.getStartTag());
                for(Element element: elements) {
                    result.add(Content.builder()
                            .type(pattern.getTitle())
                            .text(element.text())
                            .build()
                    );
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
