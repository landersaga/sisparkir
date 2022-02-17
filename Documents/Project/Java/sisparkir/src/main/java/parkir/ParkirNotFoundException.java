package parkir;

public class ParkirNotFoundException extends RuntimeException {
    public ParkirNotFoundException(Long id) {
        super("Could Not Found Parkir " + id);
    }
}
