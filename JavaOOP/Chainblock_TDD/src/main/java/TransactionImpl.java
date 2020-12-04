import java.util.Objects;

public class TransactionImpl implements Comparable<TransactionImpl>, Transaction{

    private int id;      //unique transaction id
    private TransactionStatus status;  //enumeration for transaction status
    private String from;   //the sender of the transaction
    private String to;    //the receiver of the transaction
    private double amount;  //the amount of the transaction

    public TransactionImpl(int id, TransactionStatus status, String from, String to, double amount) {
        this.id = id;
        this.status = status;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public int compareTo(TransactionImpl o) {
        int result = Integer.compare(this.id, o.id);
        if (result == 0){
            result  = this.status.compareTo(o.status);
        }
        if (result == 0){
            result = this.from.compareTo(o.from);
        }
        if (result == 0){
            result = this.to.compareTo(o.to);
        }
        if (result == 0){
            result = Double.compare(this.amount, o.amount);
        }

        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionImpl that = (TransactionImpl) o;
        return id == that.id &&
                Double.compare(that.amount, amount) == 0 &&
                status == that.status &&
                Objects.equals(from, that.from) &&
                Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, from, to, amount);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    @Override
    public TransactionStatus getStatus() {
        return status;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
