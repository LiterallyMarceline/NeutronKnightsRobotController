//package org.firstinspires.ftc.neutronknightscode.main.field;
//
//import android.graphics.RectF;
//import android.graphics.PointF;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ITDField {
//
//
//
//    public class ShortestPathAvoidingRectangle {
//        public static List<LineSegment> shortestPath(RectF rectStart, RectF rectEnd, RectF rectObstacle) {
//            List<LineSegment> pathLines = new ArrayList<>();
//
//            PointF[] startCorners = {
//                    new PointF(rectStart.left, rectStart.top),
//                    new PointF(rectStart.right, rectStart.top),
//                    new PointF(rectStart.left, rectStart.bottom),
//                    new PointF(rectStart.right, rectStart.bottom)
//            };
//
//            PointF[] endCorners = {
//                    new PointF(rectEnd.left, rectEnd.top),
//                    new PointF(rectEnd.right, rectEnd.top),
//                    new PointF(rectEnd.left, rectEnd.bottom),
//                    new PointF(rectEnd.right, rectEnd.bottom)
//            };
//
//            List<LineSegment> bestPath = new ArrayList<>();
//            double minDistance = Double.MAX_VALUE;
//
//            for (PointF startCorner : startCorners) {
//                for (PointF endCorner : endCorners) {
//                    if (!intersectsRectangle(startCorner, endCorner, rectObstacle)) {
//                        double pathDistance = distance(startCorner, endCorner);
//                        if (pathDistance < minDistance) {
//                            minDistance = pathDistance;
//                            bestPath.clear();
//                            bestPath.add(new LineSegment(startCorner, endCorner));
//                        }
//                    }
//                }
//            }
//            return bestPath;
//        }
//
//        private static boolean intersectsRectangle(PointF start, PointF end, RectF rectObstacle) {
//            return rectObstacle.contains(start.x, start.y) || rectObstacle.contains(end.x, end.y);
//        }
//
//        private static double distance(PointF p1, PointF p2) {
//            return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
//        }
//
//        public static class LineSegment {
//            PointF start, end;
//
//            public LineSegment(PointF start, PointF end) {
//                this.start = start;
//                this.end = end;
//            }
//
//            @Override
//            public String toString() {
//                return "From (" + start.x + ", " + start.y + ") to (" + end.x + ", " + end.y + ")";
//            }
//        }
//
//        public static void main(String[] args) {
//            RectF rectStart = new RectF(1, 1, 2, 2);
//            RectF rectEnd = new RectF(8, 8, 9, 9);
//            RectF rectObstacle = new RectF(3, 3, 7, 7);
//
//            List<LineSegment> path = shortestPath(rectStart, rectEnd, rectObstacle);
//            System.out.println("Path Lines:");
//            for (LineSegment line : path) {
//                System.out.println(line);
//            }
//        }
//    }


//}