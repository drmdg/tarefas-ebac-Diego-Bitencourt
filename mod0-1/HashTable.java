import java.util.ArrayList;
import java.util.List;

public class HashTable<K, V> {

    private static final int CAPACIDADE = 10;
    private static final double FATOR = 0.75;

    private List<List<Entry<K, V>>> buckets;
    private int size;

    public HashTable() {
        this(CAPACIDADE);
    }

    public HashTable(int capacidadeInicial) {
        this.buckets = new ArrayList<>(capacidadeInicial);
        for (int i = 0; i < capacidadeInicial; i++) {
            this.buckets.add(new ArrayList<>());
        }
        this.size = 0;
    }

    public V put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (key.equals(entry.getKey())) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;

        if (size > FATOR * buckets.size()) {
            resize();
        }

        return null;
    }

    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Chave não deve ser nula");
        }

        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (key.equals(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }

    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Chave não deve ser nula");
        }

        int index = getIndex(key);
        List<Entry<K, V>> bucket = buckets.get(index);

        for (Entry<K, V> entry : bucket) {
            if (key.equals(entry.getKey())) {
                bucket.remove(entry);
                size--;
                return entry.getValue();
            }
        }

        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.size();
    }

    private void resize() {
        List<List<Entry<K, V>>> oldBuckets = buckets;
        buckets = new ArrayList<>(2 * oldBuckets.size());

        for (int i = 0; i < buckets.size(); i++) {
            buckets.add(new ArrayList<>());
        }

        for (List<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                int index = getIndex(entry.getKey());
                buckets.get(index).add(entry);
            }
        }
    }

    public void clear() {
        for (List<Entry<K, V>> bucket : buckets) {
            bucket.clear();
        }
        size = 0;
    }
    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashtable = new HashTable<>();

        hashtable.put("Um", 1);
        hashtable.put("Dois", 2);
        hashtable.put("Três", 3);

        System.out.println("Valor para key 'Dois': " + hashtable.get("Dois"));

        System.out.println("Remover valor da key 'Dois': " + hashtable.remove("Dois"));

        System.out.println("valor para key 'Two' após remoção: " + hashtable.get("Dois"));

        hashtable.put("Quatro", 4);
        hashtable.put("Cinco", 5);
        hashtable.put("Seis", 6);

        System.out.println("Imprimindo tabela: ");
        for (List<Entry<String, Integer>> bucket : hashtable.buckets) {
            for (Entry<String, Integer> entry : bucket) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }

        hashtable.clear();
        System.out.println("Hashtable depois do clear:");
        for (List<Entry<String, Integer>> bucket : hashtable.buckets) {
            for (Entry<String, Integer> entry : bucket) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }
        }
    }
}
