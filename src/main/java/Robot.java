import lombok.Data;
import lombok.NoArgsConstructor;
import Constants.Direction;

import java.util.HashMap;
import java.util.Map;

import static Constants.Direction.*;

//@Data
//@NoArgsConstructor
public class Robot {

    private Integer x;
    private Integer y;
    private Direction direction;

    public Robot() {
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


}
