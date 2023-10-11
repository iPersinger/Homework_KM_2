package KM2;

import lombok.Data;

import java.util.*;

@Data
public class TripletDeque<E> implements Deque<E>,Containerable {
    private Container<E> first/* = null*/;
    private Container<E> last/* = null*/;
    private int siz = 0;
    private int iteratorsiz;
    private Container<E> Iterator = new Container<E>(null, null);



   public TripletDeque(){
       Container<E> zerocontainer = new Container<>(null, null);
       this.first = zerocontainer;
       this.last = zerocontainer;

   }
    public void Сonclusion(){
        boolean flag = true;
        System.out.println("Количество элементов в коллекции = " + siz);
        while (flag){
            if (first != null){
                System.out.println(first);
                first = first.next;
            }
            else {
                flag = false;
            }
        }
    }

    @Override
    public void addFirst(E e) {
        if (e == null) {
            throw new NullPointerException();
        } else if (siz >= 1000) {
            throw new IllegalStateException();
        } else {
            int j = 0;
            for (int i = 4; i >= 0; i--) {
                if (first.mass[i] == null) {
                    first.mass[i] = e;
                    siz++;
                    iteratorsiz = siz;
                    break;
                }
                else {
                    j++;
                }
            }
            if (j>=5){
                Container<E> newcontainer = new Container<>(first,null);
                first.prev = newcontainer;
                first = newcontainer;
                siz++;
                iteratorsiz = siz;
                newcontainer.mass[4] = e;
            }
        }
    }

    @Override
    public void addLast(E e) {
        if (e == null) {
            throw new NullPointerException();
        } else if (siz >= 1000) {
            throw new IllegalStateException();
        } else {
            int j = 0;
            for (int i = 0; i < 4; i++) {
                if (last.mass[i] == null) {
                    last.mass[i] = e;
                    siz++;
                    iteratorsiz = siz;
                    break;
                }
                else {
                    j++;
                }
            }
            if (j>=5){
                Container<E> newcontainer = new Container<>(null,last);
                last.next = newcontainer;
                last = newcontainer;
                siz++;
                iteratorsiz = siz;
                newcontainer.mass[0] = e;
            }
        }

    }

    @Override
    public boolean offerFirst(E e) {
       int flag = siz;
        try {
            addFirst(e);
        } catch (IllegalStateException k){
            return false;
        }
        if (flag != siz){
            return true;
        }
        else {
            return false;
        }
   }

    @Override
    public boolean offerLast(E e) {
        int flag = siz;
        try {
            addLast(e);
        } catch (IllegalStateException k){
            return false;
        }
        if (flag != siz){
            return true;
        }
        else {
            return false;
        }
   }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }


    @Override
    public E pollFirst() {
        try {
            return removeFirst();
        } catch (NoSuchElementException k) {
            return null;
        }
    }

    @Override
    public E pollLast() {
        try {
            return removeLast();
        } catch (NoSuchElementException k) {
            return null;
        }
    }

    @Override
    public E getFirst() {
       if (first != null){
            int j = 0;
            for (int i = 0; i <= 4; i++) {
                if (first.mass[i] != null) {
                    return (E) first.mass[i];
                }
                else {
                    j++;
                }
            }
            if (j>=5){
                if (first.next == null) {
                    throw new NoSuchElementException();
                } else {
                    Container<E> newcontainer = first.next;
                    newcontainer.prev = null;
                    first = newcontainer;
                    Iterator = first;
                    return (E) first.mass[0];

                }
            }
        }
        return null;
   }

    @Override
    public E getLast() {
       if (last != null){
            int j = 0;
            for (int i = 0; i <= 4; i++) {
                if (last.mass[i] != null) {
                    return (E) last.mass[i];
                }
                else {
                    j++;
                }
            }
            if (j>=5){
                if (last.prev == null) {
                    throw new NoSuchElementException();
                } else {
                    Container<E> newcontainer = last.prev;
                    newcontainer.next = null;
                    last = newcontainer;
                    return (E) last.mass[4];

                }
            }
        }
        return null;
    }

    @Override
    public E peekFirst() {
        try {
            return getFirst();
        } catch (NoSuchElementException k){
            return  null;
        }
    }

    @Override
    public E peekLast() {
        try {
            return getLast();
        } catch (NoSuchElementException e){
            return  null;
        }
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return siz;
    }

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new SkillIterator ();
    }
    public class SkillIterator implements Iterator{
        @Override
        public boolean hasNext() {
            if (iteratorsiz == 1){
                iteratorsiz = siz;
                return false;
            }
            if (iteratorsiz > 0) {
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if (iteratorsiz <= 0){
                throw new NoSuchElementException();
            }
            Object k;
            ArrayList<E> e2 =  It();
            for (int i = siz - iteratorsiz ; i < siz; i++){
                if (e2.get(i) != null){
                    k = e2.get(i);
                    iteratorsiz--;

                return k;
                }
            }
            return null;
        }
    }
    public ArrayList<E> It(){
        ArrayList<E> I = new ArrayList<>();
        Container<E> e = first;
        while (e != null){
            for (int i = 0 ; i < e.mass.length ; i ++){
                if(e.mass[i] != null) {
                    I.add((E) e.mass[i]);
                }
            }
            e = e.next;
        }
        return I;
    }

    @Override
    public Iterator descendingIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }



    @Override
    public boolean containsAll(Collection c) {
        return false;
    }


    @Override
    public Object[] getContainerByIndex(int cIndex) {
        return new Object[0];
    }
}

class Container<E>{
    Container<E> next;
    Container<E> prev;
    E e;
    Object[] mass;

    public Container(Container<E> next, Container<E> prev) {
        this.next = next;
        this.prev = prev;
        this.mass = new Object[5];

    }
    @Override
    public String toString() {
        return "Контейнер"
                + Arrays.toString(mass);
    }
}
