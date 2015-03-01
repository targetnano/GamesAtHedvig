package games.core;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V>
{
    private class DListNode<V>
    {
        private V t_;
        private DListNode<V> prev_;
        private DListNode<V> next_;
        
        public DListNode(V t)
        {
            t_ = t;
        }
        
        public void setValue(V v)
        {
            t_ = v;    
        }
        
        public void setPrev(DListNode<V> n)
        {
            prev_ = n;
        }
        
        public void setNext(DListNode<V> n)
        {
            next_ = n;
        }
        
        public V value()
        {
            return t_;    
        }
        
        public DListNode<V> prev()
        {
            return prev_;
        }
        
        public DListNode<V> next()
        {
            return next_;
        }
    }
    
    Map<K, DListNode<V>> map = new HashMap<K, DListNode<V>>();
    DListNode<V> head_ = null;
    DListNode<V> tail_ = null;

    private void setHead(DListNode<V> node)
    {
        node.setNext(head_);
        
        if(head_ != null)
            head_.setPrev(node);
        
        if(tail_ == null)
            tail_ = node;
            
        head_ = node;
    }
    
    private void removeNode(DListNode<V> node)
    {
        DListNode<V> prev = node.prev();
        DListNode<V> next = node.next();
        
        if(prev == null)
            head_ = next;
        else
            prev.setNext(next);

        if(next == null)
            tail_ = prev;
        else
            next.setPrev(prev);
    }
    
    public void put(K k, V v)
    {
        if(map.containsKey(k))
        {
            DListNode<V> node = map.get(k);
            node.setValue(v);
            removeNode(node);
            setHead(node);
        }
        else
        {
            DListNode<V> node = new DListNode<V>(v);
            setHead(node);
            map.put(k, node);
        }
    }
    
    public V get(K k)
    {
        if(!map.containsKey(k))
            return null;
        else
        {
            DListNode<V> node = map.get(k);
            removeNode(node);
            setHead(node);
            return node.value();
        }
    }
}