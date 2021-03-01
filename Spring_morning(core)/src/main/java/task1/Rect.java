package task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Rect {
        @Autowired
        @Qualifier("point 1")
        private point p1;

        @Autowired
        @Qualifier("point 2")
        private point p2;

        @Autowired
        @Qualifier("point 3")
        private point p3;

        public List<String> getcolors() {
            return colors;
        }

        @Autowired
        @Qualifier("point 4")
        private point p4;

        // Passing a list as well
        private List<String> colors;

        public Rect(point p1, point p2, point p3, point p4, List<String> colors) {
            this.p1 = p1;
            this.p2 = p2;
            this.p3 = p3;
            this.p4 = p4;
            this.colors = colors;
        }

        int height, width;

        public point getP1() {
            return p1;
        }

        public void setP1(point p1) {
            this.p1 = p1;
        }

        public void setP2(point p2) {
            this.p2 = p2;
        }

        public void setP3(point p3) {
            this.p3 = p3;
        }

        public void setP4(point p4) {
            this.p4 = p4;
        }

        public point getP2() {
            return p2;
        }

        public point getP3() {
            return p3;
        }

        public point getP4() {
            return p4;
        }

        public int getHeight() {
            this.height = p1.getY() - p4.getY();
            return this.height;
        }

        public int getWidth() {
            this.width = p2.getX() - p1.getX();
            return this.width;
        }


    }

