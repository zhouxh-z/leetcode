package algorithm.实现;

import java.util.*;

public class FoodRatings {

    Map<String,Node> names = new HashMap<>();
    Map<String, Node> ratings = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Node node = new Node(foods[i], cuisines[i], ratings[i]);
            this.names.put(foods[i], node);
            setNode(node);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Node node = this.names.get(food);
        int oldRating = node.rating;
        node.rating = newRating;
        if (oldRating>newRating){
            Node next = node.next;
            if (next != null){
                while (true){
                    if (next.rating > newRating) {
                        if (next.next!=null){
                            next = next.next;
                        }else {
                            break;
                        }
                    }else {
                        if (next.rating == newRating){
                            if (next.food.compareTo(node.food)>0) {
                                if (next.next!=null){
                                    next = next.next;
                                }else {
                                    break;
                                }
                            }
                        }else {
                            break;
                        }
                    }
                }
                if (node.pre != null){
                    node.pre.next = node.next;
                }

                node.next.pre = node.pre;
                if (next.rating > newRating){
                    next.next = node;
                    node.pre = next;
                }
                node.pre = next.pre;
                next.pre = node;
                node.next = next;
                if (node.pre!= null){
                    node.pre.next = node;
                }
            }
        }else {
            Node pre = node.pre;
            if (pre != null){
                while (true){
                    if (pre.rating < newRating) {
                        if (pre.pre!=null){
                            pre = pre.pre;
                        }else {
                            break;
                        }
                    }else {
                        if (pre.rating == newRating){
                            if (pre.food.compareTo(node.food)<0) {
                                if (pre.pre!=null){
                                    pre = pre.pre;
                                }else {
                                    break;
                                }
                            }else {
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                }
                if (node.next != null ){
                    node.next.pre = node.pre;
                }
                node.pre.next = node.next;

                if (pre.rating > newRating){
                    if (pre.next!=null){
                        pre.next.pre = node;
                    }
                    node.next = pre.next;
                    pre.next = node;
                    node.pre = pre;

                }else  if (pre.rating == newRating && pre.food.compareTo(node.food)<0){
                    if (pre.next!=null){
                        pre.next.pre = node;
                    }
                    node.next = pre.next;
                    pre.next = node;
                    node.pre = pre;
                }else {
                    node.next = pre;
                    node.pre = pre.pre;
                    pre.pre = node;
                    if (node.pre == null){
                        this.ratings.put(node.cuisine, node);
                    }
                }

            }
        }

    }

    private void setNode(Node node) {
        if (this.ratings.containsKey(node.cuisine)){
            Node root = this.ratings.get(node.cuisine);
             // 判断根节点是否需要变更
            if (root.rating < node.rating) {
                node.next = root;
                root.pre = node;
                this.ratings.put(node.cuisine,node);
            }else if (root.rating == node.rating) {
                if (root.food.compareTo(node.food) > 0) {
                    node.next = root;
                    root.pre = node;
                    this.ratings.put(node.cuisine,node);
                }
            } else {
                if (root.next != null){
                    Node next = root.next;
                    while (true){
                        // 先按评分、再按字母
                        if (next.rating > node.rating) {
                            if (next.next!=null){
                                next = next.next;
                            }else {
                                break;
                            }
                        }else if (next.rating == node.rating){
                            if (next.food.compareTo(node.food)>0) {
                                if (next.next!=null){
                                    next = next.next;
                                }else {
                                    break;
                                }
                            }else {
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                    node.pre = next.pre;
                    next.pre = node;
                    node.next = next;
                }else {
                    root.next = node;
                    node.pre = root;
                }
            }

        }else {
            this.ratings.put(node.cuisine, node);
        }
    }

    public String highestRated(String cuisine) {
        return this.ratings.get(cuisine).food;
    }

    class Node {
        String food;
        String cuisine;
        int rating;

        Node pre = null;
        Node next = null;

        public Node(String food, String cuisine, int rating) {
            this.food = food;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    public static void main(String[] args) {
//        int miso = "ramen".compareTo("miso");
        FoodRatings obj = new FoodRatings(new String[]{"pwdgjvphy","tiwlr","mqpdbl","jjhmgnxt","dmlymzufx"}, new String[]{"dsyujtjljz","eluxblkt","dsyujtjljz","dsyujtjljz","eluxblkt"}, new int[]{15,10,5,16,18});
        String param_1 = obj.highestRated("dsyujtjljz");
        String param_2 = obj.highestRated("eluxblkt");
        obj.changeRating("dmlymzufx",14);
        obj.changeRating("tiwlr",11);
        String param_3 = obj.highestRated("eluxblkt");
        obj.changeRating("tiwlr",8);
        String param_4 = obj.highestRated("eluxblkt");
        System.out.println();
    }
}