import java.util.*;

class FamilyForest {

    HashMap<String, String> parent = new HashMap<String, String>();
    HashMap<String, Integer> size = new HashMap<String, Integer>();

    public void make_family(String s)
    {
        parent.put(s,s);
        size.put(s,1);  //here size (num of elements in that set)  is equal to rank of set
    }

    public String union(String s, String t)
    { // by rank
        s = find(s);
        t = find(t);
            if (size.get(s) < size.get(t))
            {
                String temp = s;
                s = t;
                t = temp;
                // {OR} don't swap and write if else case
                //            parent.put(s, t);
                //            size.put(t, size.get(s) + size.get(t));
                //            return find(t);
            }
            parent.put(t, s);
            size.put(s, size.get(s) + size.get(t));
            return find(s);
    }

    public String find(String s)
    {  //by path compression
        if (s == parent.get(s))
            return s;
        return parent.put(s,find(parent.get(s)));
    }
}