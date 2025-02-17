import java.awt.*;
import java.util.List;

/**
 * This class has been copied from <br>
 * https://github.com/gabrielarchanjo/marvinproject/blob/master/marvinproject/dev/MarvinFramework/src/marvin/image/MarvinSegment.java <br>
 * It has been copied over in order to reduce dependency on the Marvin framework.
 *
 * @author Betalord
 */
public class MarvinSegment {

    public int width;
    public int height;
    int x1,
            x2,
            y1,
            y2;
    private int area;

    public MarvinSegment() {
        this(-1, -1, -1, -1);
    }

    MarvinSegment(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.width = (x2 - x1) + 1;
        this.height = (y2 - y1) + 1;
        this.area = this.width * this.height;
    }

    public static void segmentMinDistance(List<MarvinSegment> segments, double minDistance) {
        MarvinSegment s1, s2;
        for (int i = 0; i < segments.size() - 1; i++) {
            for (int j = i + 1; j < segments.size(); j++) {
                s1 = segments.get(i);
                s2 = segments.get(j);

                if (Point.distance((s1.x1 + s1.x2) / 2, (s1.y1 + s1.y2) / 2, (s2.x1 + s2.x2) / 2, (s2.y1 + s2.y2) / 2) < minDistance) {
                    segments.remove(s2);
                    j--;
                }
            }
        }
    }

    public String toString() {
        return "{x1:" + x1 + ", x2:" + x2 + ", y1:" + y1 + ", y2:" + y2 + ", width:" + width + ", height:" + height + ", area:" + area + "}";
    }
}