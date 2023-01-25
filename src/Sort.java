import java.util.Comparator;

public class Sort {
    static Comparator<Contact> compareFirstName = new Comparator<>() {
        public int compare(Contact one, Contact two) {
            return one.getFirstname().compareTo(two.getFirstname());
        }
    };
}
