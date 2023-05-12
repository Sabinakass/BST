public class Main {
    public static void main(String[] args) {
    BST <Integer, String> mybst= new BST<>();
    mybst.put(2, "Sabina");
    mybst.put(1, "Dilnaz");
    mybst.put(3, "Yernazar");
    mybst.put(4, "Aisultan");
    mybst.put(0, "Sultan");
    mybst.put(7, "Madi");
    mybst.put(5, "Rulan");
    for(var elem: mybst){
        System.out.println(elem);
    }
    }
}