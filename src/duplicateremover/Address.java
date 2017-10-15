package duplicateremover;

public class Address {
    private int index;
    private String address;

    public Address(int index, String address) {
        this.index = index;
        this.address = address;
    }

    @Override
    public String toString() {
        return "duplicateremover.Address{" +
                "index=" + index +
                ", address='" + address + '\'' +
                '}';
    }

    public int getIndex() {
        return index;
    }

    public String getAddress() {
        return address;
    }
}
