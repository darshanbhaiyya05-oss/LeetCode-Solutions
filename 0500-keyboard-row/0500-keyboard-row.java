class Solution {
    public String[] findWords(String[] words) {

        HashSet<Character> row1 = new HashSet<>();
        HashSet<Character> row2 = new HashSet<>();
        HashSet<Character> row3 = new HashSet<>();

        for (char ch : "qwertyuiop".toCharArray()) {
            row1.add(ch);
        }
        for (char ch : "asdfghjkl".toCharArray()) {
            row2.add(ch);
        }
        for (char ch : "zxcvbnm".toCharArray()) {
            row3.add(ch);
        }
        ArrayList<String> result = new ArrayList<>();
        for (String word : words) {
            String w = word.toLowerCase();
            HashSet<Character> row;
            if (row1.contains(w.charAt(0))) {
                row = row1;
            } else if (row2.contains(w.charAt(0))) {
                row = row2;
            } else {
                row = row3;
            }

            boolean possible = true;

            for (char ch : w.toCharArray()) {
                if (!row.contains(ch)) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}