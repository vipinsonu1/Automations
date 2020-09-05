
package logical;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class puzzle {
    private static PrintWriter out;

    private static <T> void mprintln(T ... ar){
        for(T i: ar) out.print(i + " ");
        out.println();
    }

    public static void main(String[] args) throws FileNotFoundException{

        // Input from file
        // File inputFile = new File("JavaFile.txt");
        // File outputFile = new File("JavaOutputFile.txt");
        // FileReader fileReader = new FileReader(inputFile);
        // Here it ends

        MyScanner sc = new MyScanner();
        // MyScanner sc = new MyScanner(fileReader);

        out = new PrintWriter(new BufferedOutputStream(System.out)); // Output to console
        // out = new PrintWriter(new PrintStream(outputFile)); // Output to file

        getAns(sc);

        out.close();
    }

    private static void getAns(MyScanner sc){
        int t = sc.ni();

        HashMap<String, Integer> map = preprocess();
        while(t-- > 0){
            String cur = "";
            for(int i = 0; i < 9; i++) cur += sc.nn();

           // out.println(map.getOrDefault(cur, -1));
        }
    }

    private static HashMap<String, Integer> preprocess() {
        int[][] steps = {{0, 1}, {1, 2}, {3, 4}, {4, 5}, {6, 7}, {7, 8}, {0, 3}, {3, 6}, {1, 4}, {4, 7}, {2, 5}, {5, 8}};

        HashSet<Integer> set = new HashSet(){
            {
                add(2); add(3); add(5); add(7); add(11); add(13); add(17);
            }
        };

        HashMap<String, Integer> map = new HashMap();

        Queue<String> queue = new LinkedList();
        queue.add("123456789");
        map.put("123456789", 0);

        while(!queue.isEmpty()){
            String cur = queue.poll();

            for(int[] in: steps){
                int val = (cur.charAt(in[0]) - '0') + (cur.charAt(in[1]) - '0');
                if(set.contains(val)){
                    char[] ar = cur.toCharArray();
                    swap(ar, in[0], in[1]);
                    String toAdd = new String(ar);
                    if(!map.containsKey(toAdd)){
                        map.put(toAdd, 1 + map.get(cur));
                        queue.add(toAdd);
                    }
                }
            }
        }

        return map;
    }

    private static void swap(char[] ar, int in, int in0) {
        char temp = ar[in];
        ar[in] = ar[in0];
        ar[in0] = temp;
    }

    static class Node{
        String name;
        int points, goalDiff;

        Node(String name, int points, int goalDiff){
            this.name = name;
            this.points = points;
            this.goalDiff = goalDiff;

        }

        public String toString(){
            return name + " " + points + " " + goalDiff;
        }
    }

    static class MyScanner{
        BufferedReader br;
        StringTokenizer st;

        MyScanner(FileReader fileReader){
            br = new BufferedReader(fileReader);
        }

        MyScanner(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nn(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        String nextLine(){
            String ans = "";
            try {
                ans = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(puzzle.class.getName()).log(Level.SEVERE, null, ex);
            }
            return ans;
        }

        char nc(){
            return nn().charAt(0);
        }

        int ni(){
            return Integer.parseInt(nn());
        }

        long nl(){
            return Long.parseLong(nn());
        }

        double nd(){
            return Double.parseDouble(nn());
        }

        int[] niArr0(int n){
            int[] ar = new int[n];
            for(int i = 0; i < n; i++) ar[i] = ni();
            return ar;
        }

        int[] niArr1(int n){
            int[] ar = new int[n + 1];
            for(int i = 1; i <= n; i++) ar[i] = ni();
            return ar;
        }

        long[] nlArr0(int n){
            long[] ar = new long[n];
            for(int i = 0; i < n; i++) ar[i] = nl();
            return ar;
        }

        long[] nlArr1(int n){
            long[] ar = new long[n + 1];
            for(int i = 1; i <= n; i++) ar[i] = nl();
            return ar;
        }
    }
}
