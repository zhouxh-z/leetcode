package algorithm.实现;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class TextEditor {
    public Deque<Character> left = new LinkedList<>() ;
    public Deque<Character> right = new LinkedList<>() ;
    int cursor = 0;

    public TextEditor() {

    }

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++) {
            this.left.addLast(text.charAt(i));
        }
        cursor += text.length();
    }

    public int deleteText(int k) {
        int delNum;
        if (this.cursor > k){
            delNum = k;
        }else {
            delNum = this.cursor;
        }
        for (int i = 0; i < delNum; i++) {
            this.left.pollLast();
        }
        this.cursor -= delNum;
        return delNum;
    }

    public String cursorLeft(int k) {
        int leftNum = Math.min(k,this.cursor);

        for (int i = 0; i < leftNum; i++) {
            Character character = this.left.pollLast();
            this.right.addFirst(character);
            this.cursor --;
        }

        return getBuilder();
    }

    public String cursorRight(int k) {
        int rightNum = Math.min(k,this.right.size());
        for (int i = 0; i < rightNum; i++) {
            Character character =this.right.poll();
            this.left.addLast(character);
            this.cursor ++;
        }
        return getBuilder();
    }

    private String getBuilder() {
        int min = Math.min(10, this.cursor);
        StringBuilder stringBuffer = new StringBuilder();
        Iterator<Character> characterIterator = this.left.descendingIterator();
        while (min > 0){
            stringBuffer.append(characterIterator.next());
            min -- ;
        }
        return stringBuffer.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */

