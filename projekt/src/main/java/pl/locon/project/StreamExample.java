package pl.locon.project;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

    private List<String> list =  new ArrayList<String>();

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

    public List<String> getProcessedList() {
        //TODO return filtered list using stream
        //używając strumieni zwrócić listę słów zaczynających się na samogłoskę, z małej litery, bez pustych znaków posortowaną alfabetycznie
        return list;
    }


    public static void main(String[] args) {
        StreamExample streamExample = new StreamExample();
        List<String> filteredList = streamExample.getProcessedList();

        System.out.println(StringUtils.join(filteredList, " "));

    }
}
