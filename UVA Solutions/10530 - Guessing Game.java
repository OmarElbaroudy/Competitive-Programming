import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        StringBuilder sb = new StringBuilder();
        int maxLow = - 1;
        int minHigh = 11;
        while (true){
            int guess = sc.nextInt();
            if (guess == 0) break;

            sc.next();
            String second = sc.next();
            if (second.charAt(0) == 'h') minHigh = Math.min(minHigh , guess);
            else if (second.charAt(0) == 'l') maxLow = Math.max(maxLow , guess);
            else {
                if (maxLow >= guess || minHigh <= guess)
                    sb.append("Stan is dishonest\n");
                else sb.append("Stan may be honest\n");
                maxLow = - 1;
                minHigh = 11;
            }
        }
        out.print(sb.toString());
        out.flush();
        out.close();
    }




















    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }


    }
}
