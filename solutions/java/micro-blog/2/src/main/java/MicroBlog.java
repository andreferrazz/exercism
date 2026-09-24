class MicroBlog {
    public String truncate(String input) {

        int[] arr = input.codePoints().limit(5).toArray();
        return new String(arr,0,arr.length);
    }
}
