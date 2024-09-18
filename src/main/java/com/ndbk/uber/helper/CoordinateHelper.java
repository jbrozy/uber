package com.ndbk.uber.helper;

import com.ndbk.uber.model.Waypoint;

public class CoordinateHelper {
  public static int distance(Waypoint p1, Waypoint p2){
    int xDiff = (int)Math.pow(p1.getLatitude() - p2.getLatitude(), 2);
    int yDiff = (int)Math.pow(p1.getLongitude() - p2.getLongitude(), 2);

    return (int)Math.sqrt(xDiff + yDiff);
  }
}
