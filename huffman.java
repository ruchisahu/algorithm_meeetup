import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

class Node implements Comparable<Node> {
 int val;
 char ch;
 Node left;
 Node right; 

 public Node(int v, char c) {
  val = v;
  ch = c;
  left = right = null;
 }

 public Node() {
  left = right = null;
  val = 0;
 }

 @Override
 public String toString() {
  return ch + " = " + val;
 }

 @Override
 public int compareTo(Node n) {
  if (this.val < n.val) {
   return -1;
  }
  if (this.val > n.val) {
   return 1;
  }
  return Character.compare(this.ch, n.ch);
 }
}

public class huffman {


 public static void main(String args[]) {

  //Inputs - chars and their frequency  
  char chars[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
  int array[] = { 100, 10, 500, 20, 10, 15, 17, 210 };

  //Create an object 
  HuffmanEncoding hEncode = new HuffmanEncoding();

  //huffmanTable will hold the Huffman code for each char 
  Map<Character, String> huffmanTable = new HashMap<Character, String>();

  //Generate Huffman codes and return the binary tree formed 
  Node huffmanTree = hEncode.createHuffmanTable(huffmanTable, array, chars);

  //Print generated codes
  printCodes(huffmanTable);

  Random r = new Random();
  //Build a sample random string of length 'lenOfInputString' using only chars
  int lenOfInputString = r.nextInt(1000); 
  String randomString = hEncode.buildRandomString(lenOfInputString, chars);
  System.out.println("Random String : " + randomString);

  //Encode the Randomly generated String
  String encodedString = hEncode.encode(randomString, huffmanTable);
  System.out.println("Encoded String: " + encodedString);

  //Given the codes, decode the encoded string
  String decodedString = hEncode.decode(encodedString, huffmanTree);
  System.out.println("Decoded String: " + decodedString);
  System.out.println("Length : " + lenOfInputString);

  //Run some test cases for given input
  testCases(randomString, decodedString); 
 }

 private static void testCases(String randomString, String decodedString) { 
  //Test Case 1:
  if(randomString.length() != decodedString.length()) {
   System.out.println("Test Case 1 - Lengths are not same!");
  } else {
   System.out.println("Test Case 1 - passed.");
  }

  //Test Case 2:
  boolean pass = true;
  for(int i = 0; i < randomString.length() && i < decodedString.length(); i++) {
   if(randomString.charAt(i) != decodedString.charAt(i)) {
    System.out.println(randomString.charAt(i) + ", " + decodedString.charAt(i));
    pass = false;
   }   
  }
  if(pass) {
   System.out.println("Test Case 2 - passed.");
  } else {
   System.out.println("Test Case 2 - characters differ!.");
  }

  //Test Case 3:
  if(randomString.compareTo(decodedString) == 0) {
   System.out.println("Test Case 3 - passed.");
  } else {
   System.out.println("Test Case 3 - Decoded String is not same as input!");
  } 
 }

 private static void printCodes(Map<Character, String> hCode) {
  System.out.println("----------Huffman Table----------");
  for(Character c : hCode.keySet()) {
   String cd = hCode.get(c);
   System.out.println(c + " = " + cd);
  }
  System.out.println("---------------------------------\n");
 }
}

class HuffmanEncoding {

 //It uses a helper function to generate the codes
 public Node createHuffmanTable(Map<Character, String> huffmanTable, int array[], char[] chars) { 

  //Create a heap and eventually a binary tree utilizing the char 
  //frequency. Use this binary tree to generate codes
  Node nTree = buildHuffmanTree(array, chars);

  //Generate code for each input char and store it as a Map for easy encoding
  StringBuilder dummy = new StringBuilder();
  buildHuffmanTable(nTree, dummy, huffmanTable);

  //Return the binary tree to be used during decoding
  return nTree;
 }

 private Node buildHuffmanTree(int array[], char[] chars) {
  PriorityQueue<Node> heap = new PriorityQueue<Node>();
  
  //After this step, we have a min heap of all the char frequencies
  for (int i = 0; i < array.length; i++) {
   Node n = new Node(array[i], chars[i]);
   heap.add(n);  
  }

  //Combine two min nodes (from the heap) at a time and keep building a binary tree.
  while (heap.size() > 1) {
   Node n1 = heap.remove();
   Node n2 = heap.remove();

   char c;
   Node nTemp = new Node();

   //Keep node with smaller val on the left. If val is same, pick either.
   if (n1.compareTo(n2) < 0) {
    nTemp.left = n1;
    nTemp.right = n2;
   } else if (n1.compareTo(n2) > 0) {
    nTemp.left = n2;
    nTemp.right = n1;
   } else {
    nTemp.left = n1;
    nTemp.right = n2;
   }

   //choose smaller char to represent internal nodes
   if(n1.ch <= n2.ch) {
    c = n1.ch;
   } else {
    c = n2.ch;
   }

   //Val of internal nodes is sum of the nodes
   nTemp.val = n1.val + n2.val;
   
   //Assign the lower char found above
   nTemp.ch = c;
   
   //Add the new internal node back to the heap
   heap.add(nTemp);
  }

  //Return the only element in the heap, which is a binary 
  //tree representing the codes.
  return heap.peek();
 }

 //InorderTraversal of the Huffman Tree created, to build the Huffman Table
 private void buildHuffmanTable(Node n, StringBuilder code, Map<Character, String> huffmanTable) {
  if (n != null) {

   //If we go left, append "0"
   buildHuffmanTable(n.left, code.append("0"), huffmanTable);
   code = code.deleteCharAt(code.length()-1);

   //If leaf, add the code to the table for current char
   if(n.left == null && n.right == null) {
    huffmanTable.put(new Character(n.ch), new String(code));
   }

   //If we go right, append "1"
   buildHuffmanTable(n.right, code.append("1"), huffmanTable);
   code = code.deleteCharAt(code.length()-1);
  }
 }

 //Generate a biased random string of given length using characters from chars array
 public String buildRandomString(int length, char[] chars) {
  StringBuilder sb = new StringBuilder();   
  Random r = new Random();
  for(int i = 1; i <= length; i++) {
   int random = r.nextInt(8);
   sb.append(chars[random]);
  }  
  return sb.toString();
 }

 //Use the Huffman table to encode the string
 public String encode(String s, Map<Character, String> huffmanTable) {
  StringBuilder sb = new StringBuilder();  
  for(Character c : s.toCharArray()) {
   sb.append(huffmanTable.get(c));
  }  
  return sb.toString();
 }

 //Decode the encoded string using the BT
 public String decode(String encodedString, Node huffmanTree) {
  StringBuilder sb = new StringBuilder();
  decode(encodedString, 0, 0, huffmanTree, huffmanTree, sb);
  return sb.toString();
 }

 private void decode(String s, int startIndex, int currIndex, Node huffmanTree, Node n, StringBuilder sb) {
  if(n != null) {   
   if(n.left == null && n.right == null) {
    sb.append(n.ch);    
    
    //If string is completely processed, return
    if(s.length() == currIndex) {
     return;
    }
    startIndex = currIndex;
    n = huffmanTree;
   }

   //Part of the string is yet to be processed, then
   if(currIndex < s.length()) {     
    if(s.charAt(currIndex) == '0') {
     decode(s, startIndex, ++currIndex, huffmanTree, n.left, sb); //If 0 - go left
    } else {
     decode(s, startIndex, ++currIndex, huffmanTree, n.right, sb); //If 1 - go right
    }    
   }
  }
 }
}