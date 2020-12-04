import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{
    private List<Transaction> transactionList = new LinkedList<>();

    public int getCount() {
        return transactionList.size();
    }

    public void add(Transaction transaction) {
        if(!this.contains(transaction)) {
            transactionList.add(transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    public boolean contains(int id) {
        for (Transaction transaction : transactionList) {
            if(transaction.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        boolean isContains = false;
        for (Transaction transaction : transactionList) {
            if (transaction.getId() == id) {
                isContains = true;
                transaction.setStatus(newStatus);
            }
        }
        if (!isContains) {
            throw new IllegalArgumentException("Transaction with this ID doesn't exist!");
        }
    }

    public void removeTransactionById(int id) {
        boolean isRemoved = transactionList.removeIf(transaction -> transaction.getId() == id);
        if (!isRemoved) {
            throw new IllegalArgumentException("Transaction with this ID doesn't exist!");
        }
    }

    public Transaction getById(int id) {
        Transaction trans = transactionList.stream().filter(transaction ->
                transaction.getId() == id).findFirst().orElse(null);
        if (trans == null) {
            throw new IllegalArgumentException("Transaction with this ID doesn't exist!");
        }
        return trans;
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> listOfTransWithGivenStatus = transactionList.stream()
                .filter(transaction -> transaction.getStatus() == status)
                .collect(Collectors.toList());

        if (listOfTransWithGivenStatus.size() == 0) {
            throw new IllegalArgumentException("This transaction status doesn't present");
        }
        listOfTransWithGivenStatus.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return listOfTransWithGivenStatus;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactions::add);
        return transactions.stream().map(Transaction::getFrom).collect(Collectors.toList());
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        getByTransactionStatus(status).forEach(transactions::add);
        return transactions.stream().map(Transaction::getTo).collect(Collectors.toList());
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactionList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> listOfTransWithGivenSender = transactionList.stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .collect(Collectors.toList());

        if (listOfTransWithGivenSender.size() == 0) {
            throw new IllegalArgumentException("Transactions with this sender doesn't present");
        }
        listOfTransWithGivenSender.sort(Comparator.comparing(Transaction::getAmount).reversed());
        return listOfTransWithGivenSender;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> listOfTransWithGivenReceiver = transactionList.stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (listOfTransWithGivenReceiver.size() == 0) {
            throw new IllegalArgumentException("Transactions with this receiver doesn't present");
        }
        return listOfTransWithGivenReceiver;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactionList.stream()
                .filter(transaction -> transaction.getStatus() == status)
                .filter(transaction -> transaction.getAmount() <= amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> listOfTransWithGivenSender = transactionList.stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .filter(transaction -> transaction.getAmount() > amount)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (listOfTransWithGivenSender.size() == 0) {
            throw new IllegalArgumentException("Transactions with this sender doesn't present");
        }
        return listOfTransWithGivenSender;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> listOfTransWithGivenReceiver = transactionList.stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .filter(transaction -> transaction.getAmount() >= lo)
                .filter(transaction -> transaction.getAmount() < hi)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (listOfTransWithGivenReceiver.size() == 0) {
            throw new IllegalArgumentException("Transactions with this sender doesn't present");
        }
        return listOfTransWithGivenReceiver;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactionList.stream()
                .filter(transaction -> transaction.getAmount() >=  lo)
                .filter(transaction -> transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return new Iterator<Transaction>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index > 0 && index < transactionList.size() - 1;
            }

            @Override
            public Transaction next() {
                if(hasNext()) {
                    index += 1;
                    return transactionList.get(index);
                }
                return null;
            }
        };
    }
}
