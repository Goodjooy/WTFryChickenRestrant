package err;

public class OverdraftSortOutException extends RuntimeException {
    String info;

    @Override
    public String toString() {
        return info;
    }

    public OverdraftSortOutException(String string) {
        info = string;
    }

    /**
     *
     */
    private static final long serialVersionUID = 1L;

}
