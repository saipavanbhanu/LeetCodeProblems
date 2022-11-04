/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<Integer> list;
    
    public NestedIterator(List<NestedInteger> in) {
        list = new ArrayDeque<>();
        for(int i = 0; i < in.size(); i++){
            insert(in.get(i));
        }
    }
    
    void insert(NestedInteger no){
        if(no.isInteger()){
            list.addLast(no.getInteger());
        }else{
            for(int i = 0; i < no.getList().size(); i++){
                insert(no.getList().get(i));
            }
        }
    }

    @Override
    public Integer next() {
        return list.removeFirst();
    }

    @Override
    public boolean hasNext() {
        if(!list.isEmpty()){
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */