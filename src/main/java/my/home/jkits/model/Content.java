package my.home.jkits.model;

import lombok.Builder;
import lombok.Data;

@Builder
public class Content {
    String type;
    String data;
    String text;
}
