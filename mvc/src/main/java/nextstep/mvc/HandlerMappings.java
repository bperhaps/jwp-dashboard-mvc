package nextstep.mvc;

import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HandlerMappings {

    private final List<HandlerMapping> values;

    public HandlerMappings() {
        this.values = new ArrayList<>();
    }

    public HandlerMappings(List<HandlerMapping> values) {
        this.values = values;
    }

    public void add(HandlerMapping handlerMapping) {
        this.values.add(handlerMapping);
    }

    public Object get(HttpServletRequest request) {
        return values.stream()
            .map(handlerMapping -> handlerMapping.getHandler(request))
            .filter(Objects::nonNull)
            .findAny()
            .orElseThrow();
    }

    public void initialize() {
        values.forEach(HandlerMapping::initialize);
    }
}
