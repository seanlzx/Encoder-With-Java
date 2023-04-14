public class App {
    public static void main(String[] args) throws Exception {
        char[] reference_table = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, '(', ')', '*', '+', ',', '-', '.', '/'};
        Encoder encoder = new Encoder(
           reference_table,
            'F'            
        );

        System.out.println(encoder.encode("HELLOW WORLD"));
        System.out.println(encoder.decode("FC/ggj Rjmg."));
    }
}

