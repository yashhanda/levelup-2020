import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.List;

public class hashmap{
    public static void freqmap1(String str){
        int n=str.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        for(char ch:map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static void freqmap2(String str){
        int n=str.length();
        HashMap<Character,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static void freqmap3(String str){
        int n=str.length();
        HashMap<Character,ArrayList<Integer>>map=new HashMap<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);

            // if(!map.containsKey(ch)){
            //     map.put(ch,new ArrayList<Integer>());
            // }
            map.putIfAbsent(ch,new ArrayList<Integer>());

            ArrayList<Integer>arr=map.get(ch);
            arr.add(i);
        }
        for(char ch:map.keySet()){
            System.out.println(ch + " -> " + map.get(ch));
        }
    }
    public static int[] intersection(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        int n=arr1.length;
        for(int i=0;i<n;i++){
            int ch=arr1[i];
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        HashSet<Integer>arr=new HashSet<>();
        n=arr2.length;
        for(int i=0;i<n;i++){
            int ch=arr2[i];
            if(map1.containsKey(ch) && map1.get(ch)!=0){
                arr.add(ch);
                map1.put(ch,map1.get(ch)-1);
            }
        }
        n=arr.size();
        int[]ans=new int[n];
        int i=0;
        for(int ele :arr)
        ans[i++]=ele;

        return ans;
    }
    public static int[] intersect(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer>map1=new HashMap<>();
        int n=arr1.length;
        for(int i=0;i<n;i++){
            int ch=arr1[i];
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        ArrayList<Integer>arr=new ArrayList<>();
        n=arr2.length;
        for(int i=0;i<n;i++){
            int ch=arr2[i];
            if(map1.containsKey(ch) && map1.get(ch)!=0){
                arr.add(ch);
                map1.put(ch,map1.get(ch)-1);
            }
        }
        n=arr.size();
        int[]ans=new int[n];

        for(int i=0;i<n;i++)
        ans[i]=arr.get(i);

        return ans;
    }
    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            int ch=arr[i];
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer>pq=new PriorityQueue<>(( a,  b)->{
            return map.get(b)-map.get(a);
        });

        for(int ele:map.keySet())
        pq.add(ele);

        int[]ans=new int[k];
        while(k-->0){
            ans[k]=pq.remove();
        }
        return ans;
    }
    public static List<List<String>> groupAnagrams(String[] arr) {
        HashMap<String,ArrayList<String>>map=new HashMap<>();
        for(String str :arr){

            int[]ar=new int[26];
            for(int i=0;i<26;i++){
                char ch=str.charAt(i);
                ar[ch-'a']++;
            }

                String a="";
                for(int i=0;i<26;i++){
                    if(ar[i]>0)
                    a=a+('a'+i)+ar[i];
                }
                map.putIfAbsent(a,new ArrayList<String>());
            ArrayList<String>ans=map.get(a);
                ans.add(str);
                map.put(a,ans);
        }
        List<List<String>>ans=new ArrayList<>();
        for(String a:map.keySet()){
            ans.add(map.get(a));
        }
        return ans;
    }
    class RandomizedSet {
        HashMap<Integer,Integer>map;
        ArrayList<Integer>arr;
        public RandomizedSet() {
            map=new HashMap<Integer,Integer>();
            arr=new ArrayList<Integer>();
        }
        
        public boolean insert(int val) {
            if(map.containsKey(val))
            return false;
            arr.add(val);
            map.put(val,arr.size()-1);
            return true;
        }
        
        public boolean remove(int val) {
            if(!map.containsKey(val))
            return false;
            int a=map.get(val);
            map.remove(val);
            swap(a,arr.size()-1);
            arr.remove(arr.size()-1);
            map.put(arr.get(a),a);
            return true;
        }
        public void swap(int a,int b){
            int temp=arr.get(a);
            arr.add(a,arr.get(b));
            arr.add(b,temp);
        }
        
        public int getRandom() {
            int a=(int)(Math.random()*arr.size());
            return arr.get(a);
        }
    }
    
    public static void main(String[]args){
        // String str= "aasbaabababababccc";
        // freqmap3(str);

        int[]ans=topKFrequent(new int []{1,1,1,2,2,3},2);
       
        for(int ele :ans)
        System.out.print(ele+" , ");
    }
}