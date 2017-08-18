import java.util.ArrayList;
/**
 * Write a description of class Backtracking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Backtracking {
    public static ArrayList<Integer> recorrido(Graph g, int source)
     {
       ArrayList<Integer> output = new ArrayList<Integer>();
       boolean [] visited = new boolean[g.size];
       for (int i=0; i<visited.length; i++){
           visited[i]=false;
       }
       
       LinkedList cola = new LinkedList<Integer>();
       cola.addFirst(source);
       visited[source]=true;
       while(!cola.isEmpty()){
           int var=(int)cola.removeFirst();
           output.add(var);
           LinkedList suc = new LinkedList(g.getSuccessors(var));
           for(int i=suc.size()-1; i>=0; i--){
               if(!visited[(int)suc.get(i)]){
                   cola.addFirst((int)suc.get(i));
                   visited[(int)suc.get(i)]=true;
                }
            }
        }
        return output;
     }
}