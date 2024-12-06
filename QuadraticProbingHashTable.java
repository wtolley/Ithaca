public class QuadraticProbingHashTable {
    private String[] table;  // The hash table
    private int size;        // Current number of elements
    private int capacity;    // Current capacity of the hash table

    // Constructor to initialize the hash table
    public QuadraticProbingHashTable(int initialCapacity) {
        this.capacity = initialCapacity;
        this.table = new String[capacity];
        this.size = 0;
    }

    // Hash function
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // Insert method
    public void insert(String key) {
        // TODO: Implement the insert method using quadratic probing.
        // 1. Compute the hash value of the key.
        // 2. Probe using quadratic intervals to find an available slot.
        // 3. Insert the key into the table.
        // 4. Check the load factor after insertion and resize if necessary.
    }

    // Search method
    public boolean search(String key) {
        // TODO: Implement the search method using quadratic probing.
        // 1. Compute the hash value of the key.
        // 2. Probe using quadratic intervals to locate the key.
        // 3. Return true if the key is found, otherwise return false.
        return false; // Placeholder
    }

    // Resize method
    private void resize() {
        // TODO: Implement the resize method.
        // 1. Create a new table with a larger prime capacity.
        // 2. Rehash all existing keys into the new table.
        // 3. Replace the old table with the new one.
    }

    // Utility method to find the next prime number
    private int nextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    // Utility method to check if a number is prime
    private boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Print the hash table for debugging
    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(i + ": " + table[i]);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        QuadraticProbingHashTable hashTable = new QuadraticProbingHashTable(7);

        // TODO: Add test cases for insert, search, and resize once implemented.
        hashTable.printTable();
    }
}
