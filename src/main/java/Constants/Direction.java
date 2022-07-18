package Constants;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public enum Direction {

    WEST, EAST, NORTH, SOUTH;

    private static Logger LOGGER = LoggerFactory.getLogger(Direction.class);

    public static List<Direction> getall() {
        return Arrays.asList(Direction.values());
    }

    public static Direction convert(String direction) {
        try {
            return Direction.valueOf(direction);
        } catch (Exception exception) {
            LOGGER.error("direction is invalid string");
        }
        return null;
    }
}
