import AmazonOnlineAssessment.*;

import javax.jws.soap.SOAPBinding;
import java.util.*;
import java.io.*;

public class Main {

    public static final void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver();
        solver.solve(1, in, out);
        out.close();
    }

    /*********************************** Solution START *********************************/

    static class Solver {
        Random rand = new Random();
        final int max = (int) (1e5);

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            Solution obj = new Solution();
            int a[] = {1,2,3,1,2};
            int m = 2, k = 2;
            out.println(obj.containsPattern(a, m, k));
        }

        class Solution {
            public boolean containsPattern(int[] a, int m, int k) {
                Set<String> map = new HashSet<>();
                int n = a.length;
                if (n / m < k) return false;
                for (int i = 0; i < n; i++) {
                    String key = "";
                    int cnt = 0, ok = 0;
                    for (int j = i; j + m - 1 < n; j++) {
                        key += "" + a[j] + ",";
                        cnt++;
                        if (cnt == m) break;
                    }
                    System.out.println("i=" + i + " key="+key);
                    if (cnt == m) {
                        ok++;
                        String v = "";
                        int cnt1 = 0, prev = -1;
                        for (int j = 0; j < i - m + 1; j++) {
                            cnt1++;
                            if (prev == -1) prev = j;
                            v += "" + a[j] + ",";
                            if (cnt1 == m) {
                                System.out.println("v1="+v);

                                if (key.equals(v)) {
                                    ok++;
                                }
                                j = prev;
                                prev = -1;
                                v = "";
                                cnt1 = 0;
                            }
                        }
                        cnt1 = 0;
                        prev = -1;
                        for (int j = i + 1; j < n; j++) {
                            cnt1++;
                            if (prev == -1) prev = j;
                            v += "" + a[j] + ",";
                            if (cnt1 == m) {
                                if (key.equals(v)) {
                                    System.out.println("v="+v+" j=" + j);
                                    ok++;
                                }
                                j = prev;
                                prev = -1;
                                v = "";
                                cnt1 = 0;
                            }
                        }
                        if (ok >= k) return true;
                    }
                }
                return false;
            }
        }

        public int random(int min, int max) {
             return rand.nextInt(max - min) + min;
        }
    }

    /*********************************** Solution END *********************************/


    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }


}




