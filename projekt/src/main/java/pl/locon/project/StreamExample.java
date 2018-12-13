package pl.locon.project;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {

    private List<String> list = new ArrayList<String>();

    public StreamExample() {
        fillList();
    }

    private void fillList() {
        list.add("Ala");
        list.add(" projektów ");
        list.add("P2PSessionStartRequest  ");
        list.add("CALLBACK_LOOP_STATUS_OK");
        list.add("  Ostrzeżenia");
        list.add("incydent");
        list.add("wszystkim ");
        list.add("inne ");
        list.add(" sanktuarium");
        list.add("cameraUid");
        list.add("ACK_LOOP_SESSION_START");
    }

    public static String VOWELS = "AEIOUY";

    private static boolean isVowel(char c) {
        return VOWELS.indexOf(Character.toUpperCase(c)) >= 0;
    }

    public List<String> getProcessedList() {
        //TODO return filtered list using stream
        //używając strumieni zwrócić listę słów zaczynających się na samogłoskę, z małej litery, bez pustych znaków posortowaną alfabetycznie

        return list.stream()
                .map(StringUtils::trim)
                .map(StringUtils::capitalize)
                .filter(s -> isVowel(s.charAt(0)))
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        StreamExample streamExample = new StreamExample();
        List<String> filteredList = streamExample.getProcessedList();
        System.out.println(StringUtils.join(filteredList, ", "));
    }
}
