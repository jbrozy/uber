package com.ndbk.uber.helper;

import com.ndbk.uber.model.Waypoint;

public class CoordinateHelper {
  public static int distance(Waypoint p1, Waypoint p2){
    int xDiff = (int)Math.pow(p1.getLatitude() - p2.getLatitude(), 2);
    int yDiff = (int)Math.pow(p1.getLongitude() - p2.getLongitude(), 2);

    return (int)Math.sqrt(xDiff + yDiff);
  }

  private static final double EARTH_RADIUS = 6371;

  // Method to calculate the Haversine distance between two points (lat1, lon1) and (lat2, lon2)
  public static double haversine(double lat1, double lon1, double lat2, double lon2) {
    // Convert degrees to radians
    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);

    // Apply Haversine formula
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
            Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                    Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);

    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    // Return the distance
    return EARTH_RADIUS * c;
  }
}
