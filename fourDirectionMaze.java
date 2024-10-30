package backtracking;

public class fourDirectionMaze {
    private static void print(int sr , int sc , int er , int ec , String s , boolean vis[][] ){
        
        if(sr<0 || sc<0){
            return;
        }
        if(sr>er || sc> ec ){
            return;
        }
        if(vis[sr][sc] == true){
            return; // very important
        }
      
        if(sr == er && ec == sc){
            System.out.println(s);
            return;
        } 
      
        vis[sr][sc] = true;
        //go right
        print(sr, sc+1, er, ec, s+"R" , vis);
        // go down
        print(sr+1, sc, er, ec, s+"D" ,vis);
        //go left
        print(sr, sc-1, er, ec, s+"L" , vis);
        //go up
        print(sr-1, sc, er, ec, s+"U" , vis);

        vis[sr][sc] = false;
    }
    public static void main(String[] args) {
       
            int rows = 3; 
            int columns = 3;
            boolean vis[][] = new boolean[rows][columns]; // by default false hi bhara pada hoga
           print(0,0,rows-1,columns-1, " " , vis);
    }
}
