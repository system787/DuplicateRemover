package duplicateremover;

public class Address {
    private int vendor_id;
    private String vendor_details;

    public Address(int vendor_id, String vendor_details) {
        this.vendor_id = vendor_id;
        this.vendor_details = vendor_details;
    }

    @Override
    public String toString() {
        return "duplicateremover.Address{" +
                "vendor_id=" + vendor_id +
                ", vendor_details='" + vendor_details + '\'' +
                '}';
    }

    public int getVendor_id() {
        return vendor_id;
    }

    public String getVendor_details() {
        return vendor_details;
    }
}
