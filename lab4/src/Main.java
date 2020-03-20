import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args){
        Resident[] r = IntStream.rangeClosed(0,3)
                                .mapToObj(i -> new Resident("R" + i))
                                .toArray(Resident[]::new);


        List<Resident> residentList = new ArrayList<>();

        for(Resident res : r){
            residentList.add(res);
        }

        List<Resident> newSortedList = residentList.stream()
                    .sorted(Comparator.comparing(Resident::getName))
                    .collect(Collectors.toList());

        var h = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new Hospital("H" + i))
                .toArray(Hospital[]::new);

        Set<Hospital> setClinic = new TreeSet<>();

        for(Hospital clinic : h){
            setClinic.add(clinic);
        }

        Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
        List<Hospital> prefList = new ArrayList<>();
        prefList.add(h[0]);
        prefList.add(h[1]);
        prefList.add(h[2]);

        resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[1], Arrays.asList(h[0], h[1], h[2]));
        resPrefMap.put(r[0], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[0], Arrays.asList(h[0], h[2]));

        Map<Hospital, List<Resident>> clinicPref = new TreeMap<>();

        clinicPref.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        clinicPref.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        clinicPref.put(h[2], Arrays.asList(r[0], r[1], r[3]));

        System.out.println(h.length);
        System.out.println("\n Rezidentii care prefera H0: \n");

        residentList.stream()
                .filter((res -> resPrefMap.get(res).contains(h[0])))
                .forEach(System.out::println);

        System.out.println("\n Rezidentii care prefera H2: \n");

        residentList.stream()
                .filter((res -> resPrefMap.get(res).contains(h[2])))
                .forEach(System.out::println);

        List<Hospital> topRes = setClinic.stream()
                .filter(clinic -> clinicPref.get(clinic).get(0).equals(r[0])).collect(Collectors.toList());

        System.out.println("\n Spitalele care au R0 ca preferinta sunt: \n");
        System.out.println(topRes);

    }
}
