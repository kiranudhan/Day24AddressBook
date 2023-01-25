import java.util.Comparator;

public class Sort {
    static Comparator<Contact> compareFirstName = new Comparator<>() {
        public int compare(Contact one, Contact two) {
            return one.getFirstname().compareTo(two.getFirstname());
        }
    };

    static Comparator<Contact> compareCity = new Comparator<>() {
        public int compare(Contact one, Contact two) {
            return one.getCity().compareTo(two.getCity());
        }
    };

    static Comparator<Contact> compareState = new Comparator<>() {
        public int compare(Contact one, Contact two) {
            return one.getState().compareTo(two.getState());
        }
    };

}
