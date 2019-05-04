public interface StringCounter {

    /**
     * @param input String to save
     */
    void add(String input);

    /**
     * @param input String to retrieve information about
     * @return number of passed @param occurrences
     */
    int count(String input);

}
