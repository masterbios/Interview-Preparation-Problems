package AmazonOnlineAssessment;

import java.util.*;

public class FavoriteGenres {

    public void solve(Map<String, List<String>> usersongs,
                      Map<String, List<String>> songgenres) {
        Map<String, List<String>> map = go(usersongs, songgenres);
        for (String user : map.keySet()) {
            System.out.println(user + " " + map.get(user));
        }
    }

    private Map<String, List<String>> go(Map<String, List<String>> usersongs,
                                         Map<String, List<String>> songgenres) {

        Map<String, String> songsToGenre = new HashMap<>();
        Map<String, List<String>> favorite = new HashMap<>();

        for (String genre : songgenres.keySet()) {
            for (String song : songgenres.get(genre)) {
                songsToGenre.put(song, genre);
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int max = 0;

        for (String user : usersongs.keySet()) {
            for (String song : usersongs.get(user)) {
                String genre = songsToGenre.get(song);
                map.put(genre, map.getOrDefault(genre, 0) + 1);
                max = Math.max(max, map.get(genre));
            }
            favorite.put(user, new ArrayList<>());
            for (String key : map.keySet()) {
                if (map.get(key) == max) {
                    favorite.get(user).add(key);
                }
            }
            map.clear();
            max = 0;
        }

        return favorite;
    }

    // this is testcase for checking
    {
        Map<String, List<String>> map1 = new HashMap<>(); // user
        Map<String, List<String>> map2 = new HashMap<>(); // genre

        {
            String s[] = { "song1", "song2", "song3", "song4", "song8" };
            List<String> temp = Arrays.asList(s);
            map1.put("david", temp);
        }

        {
            String s[] = { "song5", "song6", "song7" };
            List<String> temp = Arrays.asList(s);
            map1.put("emma", temp);
        }

        {
            String s[] = { "song1", "song3" };
            List<String> temp = Arrays.asList(s);
            map2.put("Rock", temp);
        }

        {
            String s[] = { "song7" };
            List<String> temp = Arrays.asList(s);
            map2.put("dubstep", temp);
        }

        {
            String s[] = { "song2", "song4" };
            List<String> temp = Arrays.asList(s);
            map2.put("techno", temp);
        }

        {
            String s[] = { "song5", "song6" };
            List<String> temp = Arrays.asList(s);
            map2.put("pop", temp);
        }

        {
            String s[] = { "song8", "song9" };
            List<String> temp = Arrays.asList(s);
            map2.put("jazz", temp);
        }
        FavoriteGenres obj = new FavoriteGenres();
        obj.solve(map1, map2);
    }
}
