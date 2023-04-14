public class Encoder {
    private char[] reference_table;
    private char offset;
    private int reference_table_length;

    public Encoder(char[] user_reference_table, char user_offset) {
        this.reference_table_length = user_reference_table.length;
        reference_table = new char[this.reference_table_length];
        System.arraycopy(user_reference_table, 0, reference_table, 0, reference_table_length);
        offset = user_offset;
    }

    public char get_offset() {
        return this.offset;
    }

    public void set_offset(char user_offset) {
        this.offset = user_offset;
    }

    public char[] get_reference_table() {
        return this.reference_table;
    }

    public void set_offset(char[] user_reference_table) {
        this.reference_table_length = user_reference_table.length;
        this.reference_table = new char[this.reference_table_length];
        System.arraycopy(user_reference_table, 0, reference_table, 0, reference_table_length);
    }

    public String encode(String plainText) {
        byte shift = (byte) new String(this.reference_table).indexOf(this.offset);
        byte new_index = 0;

        String encodedText = Character.toString(this.offset);

        for (char ch : plainText.toCharArray()) {
            ch = Character.toUpperCase(ch);
            if (char_array_contains_char(this.reference_table, ch)) {
                new_index = (byte) (new String(this.reference_table).indexOf(ch) - shift);
                if (new_index < 0){
                    new_index += this.reference_table_length;
                }

                encodedText += this.reference_table[new_index];
            } else {
                encodedText += ch;
            }

        }

        return encodedText;
    }

    public String decode(String encodedText) {
        byte shift = (byte) new String(this.reference_table).indexOf(encodedText.charAt(0));
        byte new_index = 0;

        String plainText = "";
        for (char ch : encodedText.substring(1).toCharArray()) {
            ch = Character.toUpperCase(ch);
            if (char_array_contains_char(this.reference_table, ch)) {
                new_index = (byte) (new String(this.reference_table).indexOf(ch) + shift);
                if (new_index >= this.reference_table_length){
                    new_index -= this.reference_table_length;
                }

                plainText += this.reference_table[new_index];
            } else {
                plainText += ch;
            }

        }

        return plainText;
    }
    
    private static boolean char_array_contains_char(char[] char_array, char ch){
        boolean contains = false;
        for (char elm_ch : char_array){
            if (elm_ch == ch){
                contains = true;
                break;
            }
        }

        return contains;
    }
}