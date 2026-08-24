// class Solution {
//     public boolean isValidSudoku(char[][] board) {
//         boolean flag=true;
//         for(int i=0;i<=8;i++){
//             for(int j=0;j<=8;j++){
//                 char digit=board[i][j];
//                 if(digit!='.'){
//                     //Column
//                     for(int a=0;a<=8;a++){
//                         if(a!=j && board[i][a]==digit){
//                             flag= false;
//                             break;
//                         }
//                     }
//                     //row
//                     for(int b=0;b<=8;b++){
//                         if(b!=i && board[b][j]==digit){
//                             flag= false;
//                             break;
//                         }
//                     }
//                     //grid
//                     int sr=(i/3)*3;
//                     int sc=(j/3)*3;
//                     for(int c=sr;c<sr+3;c++){
//                         for(int d=sc;d<sc+3;d++){
//                             if((c!=i || d!=j) && board[c][d]==digit){
//                                 flag= false;
//                                 break;
//                             }
//                         }
//                     }
//                 }
//             }
            
//         }
//         return flag;
        
//     }
// }

class Solution {
    public boolean isValidSudoku(char[][] board) {
        
       
        

        for(int i=0;i<board.length;i++){
            HashSet<Character> row=new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(row.contains(board[i][j])){
                        return false;
                    }
                    row.add(board[i][j]);
                }
            }
        }

        for(int j=0;j<board[0].length;j++){
            HashSet<Character> col=new HashSet<>();
            for(int i=0;i<board.length;i++){
                if(board[i][j]!='.'){
                    if(col.contains(board[i][j])){
                        return false;
                    }
                    col.add(board[i][j]);
                }
            }
        }

        for(int i = 0; i < board.length; i += 3){
            for(int j = 0; j < board[0].length; j += 3){
                HashSet<Character> box = new HashSet<>();
                for(int rows = i; rows < i + 3; rows++){
                    for(int cols = j; cols < j + 3; cols++){
                        if(board[rows][cols] != '.'){
                            if(box.contains(board[rows][cols])){
                                return false;
                            }
                            box.add(board[rows][cols]);
                        }
                    }
                }
            }
        }
        return true;
    }
}