public class Request {
    private int numRequest = 0;
    private static ThreadLocal<Request> tlRequest = new ThreadLocal<>();
    private Request() {

    }

    public synchronized static void setNewRequest() {
        var request = getRequest();
        if(request == null) {
            request = new Request();
            tlRequest.set(request);
        }
        request.numRequest++;
    }

    public static Request getRequest() {
        return tlRequest.get();
    }

    @Override
    public String toString() {
        return "Request{" +
                numRequest +
                '}';
    }
}
