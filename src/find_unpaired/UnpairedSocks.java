package find_unpaired;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UnpairedSocks {

    public static void main(String[] args) {
        UnpairedSocks solution = new UnpairedSocks();

        List<String> socks = Arrays.asList("red", "blue", "red", "green", "blue", "blue");
        List<String> result = solution.findUnpairedSocks(socks);
        System.out.println(result);  // [blue, green]

        List<String> socks2 = Arrays.asList("red", "blue", "red", "green", "blue", "blue", "yellow");
        List<String> result2 = solution.findUnpairedSocksStream(socks2);
        System.out.println(result2);  // [blue, green, yellow]
    }

    private List<String> findUnpairedSocks(List<String> socks) {
        Map<String, Integer> countMap = new HashMap<>();

        // count each color
        for (String color : socks) {
            countMap.put(color, countMap.getOrDefault(color, 0) + 1);
        }

        List<String> unpaired = new ArrayList<>();

        // add only unpaired socks
        for (Map.Entry<String, Integer> stringIntegerEntry : countMap.entrySet()) {
            if (stringIntegerEntry.getValue() % 2 != 0) {
                unpaired.add(stringIntegerEntry.getKey());
            }
        }

        return unpaired;
    }

    public static List<String> findUnpairedSocksStream(List<String> socks) {
        return socks.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList())
        ;
    }

}
