package interview.booking;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem1 {
  static class Pair<A, B> {
    final A a;
    final B b;

    Pair(A a, B b) {
      this.a = a;
      this.b = b;
    }
  }

  public static String getShiftedString(String s, int leftShifts, int rightShifts) {
    int total = (rightShifts - leftShifts) % s.length();
    if (total > 0) {
      String part1 = s.substring(0, s.length() - total);
      String part2 = s.substring(s.length() - total);
      return part2.concat(part1);
    }
    if (total < 0) {
      String part1 = s.substring(0, -total);
      String part2 = s.substring(-total);
      return part2.concat(part1);
    }
    return s;
  }

  public static long carParkingRoof(List<Long> cars, int k) {
    List<Long> sorted = cars.stream().sorted().collect(Collectors.toList());
    return IntStream.rangeClosed(0, cars.size() - k)
        .mapToObj(idx -> sorted.get(idx + k -1) - sorted.get(idx) +1)
        .min(Comparator.naturalOrder()).orElseThrow(()->new RuntimeException("shouldn't be here"));
  }

  public static void main1(String[] args) {
    List<Long> cars = Arrays.asList(249800826575L, 295335922427L, 403621070057L, 463759248160L, 634832404000L);
    System.out.println(cars);
    long l = carParkingRoof(cars, 4);
    System.out.println(l);
//    System.out.println(getShiftedString("abcd", 1, 2));
//    System.out.println(getShiftedString("abcd", 4, 3));
  }

  static Map<String, Long> split(String feedback) {
    return Arrays.stream(feedback.split("[,.\\s+]"))
        .map(String::toLowerCase)
        .filter(s -> !s.isEmpty())
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
  }

  public static List<Integer> awardTopKHotels(
      String positiveKeywords,
      String negativeKeywords,
      List<Integer> hotelIds,
      List<String> reviews,
      int k) {
    Set<String> positive = Arrays.stream(positiveKeywords.split(" ")).collect(Collectors.toSet());
    Set<String> negative = Arrays.stream(negativeKeywords.split(" ")).collect(Collectors.toSet());

    Map<Integer, Long> review_score = IntStream.range(0, reviews.size())
        .mapToObj(rev_id -> new Pair<>(rev_id, split(reviews.get(rev_id))))
        .map(p -> {
          long total = 0;
          for (Map.Entry<String, Long> e : p.b.entrySet()) {
            String word = e.getKey();
            Long number = e.getValue();
            if (positive.contains(word)) total += number * 3;
            else if (negative.contains(word)) total -= number;
          }
          return new Pair<>(p.a, total);
        })
        .collect(Collectors.toMap(p -> p.a, p -> p.b));

    List<Pair<Integer, List<Integer>>> indexes = IntStream.range(0, hotelIds.size())
        .mapToObj(idx -> new Pair<>(idx, hotelIds.get(idx))) // Pair<Index, Hotel_ID>
        .collect(Collectors.groupingBy(
            p -> p.b, // hotel_id
            Collectors.mapping(p -> p.a, Collectors.toList())
        )) // Map<HotelID, List<ReviewIndexes>>
        .entrySet().stream().map(e -> new Pair<>(e.getKey(), e.getValue()))
        .collect(Collectors.toList()); // List<HotelID, List<ReviewIndexes>>

    List<Pair<Integer, Long>> hotel_id_score = indexes.stream().map(p -> new Pair<>(
        p.a,
        p.b.stream().map(review_score::get).mapToLong(score -> score).sum()
    )).collect(Collectors.toList());

    /*
     * ----------------------------
     * k < total, return everything
     * ----------------------------
     */
    if (hotel_id_score.size() <= k)
      return hotel_id_score.stream()
          .map(p -> p.a)                            // hotel_id
          .collect(Collectors.toList());
    // check for distinct ratings
    List<Long> distinct_ratings = hotel_id_score.stream().map(p -> p.b).distinct().collect(Collectors.toList());
    /*
     * -----------------------------------------------
     * all distinct, we don't need to filter duplicates
     * -----------------------------------------------
     */
    if (distinct_ratings.size() == hotel_id_score.size())
      return hotel_id_score.stream()
          .sorted((p1, p2) -> p2.b.compareTo(p1.b)) // sorting in reverse order (rating)
          .map(p -> p.a)                            // hotel_id
          .limit(k)
          .collect(Collectors.toList());
    /*
     * --------------------------------------------------------------
     * regroup to pick only particular hotel id in case of duplicates
     * --------------------------------------------------------------
     */
    return hotel_id_score.stream()
        .collect(Collectors.groupingBy(
            p -> p.b,
            Collectors.mapping(p -> p.a, Collectors.toList())
        ))                            // grouped to Map<Score, List<HotelId>>
        .entrySet().stream()
        .map(e -> new Pair<>(
            e.getKey(),
            e.getValue().stream()
                .min(Comparator.comparingInt(h -> h)) // pick the smallest hotel id
                .orElseThrow(() -> new RuntimeException("shouldn't be here"))
        ))                                            // Pair<Score, HotelId>
        .map(p -> p.b)                                // HotelId
        .limit(k)
        .collect(Collectors.toList());
  }

}
