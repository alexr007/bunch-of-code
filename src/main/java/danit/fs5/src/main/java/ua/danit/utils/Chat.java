package ua.danit.utils;

import ua.danit.model.Messege;

import java.util.List;
import java.util.TreeMap;

public class Chat {

    public TreeMap<Long, Messege> getChat(List<Messege> inner, List<Messege> output, String myLogin) {
        TreeMap<Long, Messege> chatMap = new TreeMap<>();

        for (Messege messege : inner) {
            chatMap.put(messege.getTime(), messege);
        }

        for (Messege messege : output) {
            chatMap.put(messege.getTime(), messege);
        }

        return chatMap;
    }
}
