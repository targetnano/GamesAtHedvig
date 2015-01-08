package games.utils;

public class Pair<K, V>
{
    private K k_;
    private V v_;
    
    public Pair()
    {
    }

    public Pair(K k, V v)
    {
        k_ = k;
        v_ = v;
    }
    
    public void k(K k)
    {
        k_ = k;
    }

    public K k()
    {
        return k_;
    }
    
    public V v()
    {
        return v_;
    }

    public void v(V v)
    {
        v_ = v;
    }
}
