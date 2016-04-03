package TheInternetPages.Utils;

/**
 * Created by Moreno on 03/04/2016.
 */
public class RowContactDataTable {
    public String lastName;
    public String firstName;
    public String email;
    public String due;
    public String webSite;

    public RowContactDataTable() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RowContactDataTable that = (RowContactDataTable) o;

        if (!lastName.equals(that.lastName)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!email.equals(that.email)) return false;
        if (!due.equals(that.due)) return false;
        return webSite.equals(that.webSite);

    }

    @Override
    public int hashCode() {
        int result = lastName.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + due.hashCode();
        result = 31 * result + webSite.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "RowContactDataTable{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", due='" + due + '\'' +
                ", webSite='" + webSite + '\'' +
                '}';
    }

    public RowContactDataTable(String lastName, String firstName, String email, String due, String webSite) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.due = due;
        this.webSite = webSite;
    }
}
