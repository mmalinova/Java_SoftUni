import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {
    private Chainblock chainblock;
    List<Transaction> transactionsList;

    @Before
    public void createTransaction() {
        chainblock = new ChainblockImpl();
        this.createTransactions();
    }

    private void createTransactions() {
        transactionsList  = new LinkedList<>();
        transactionsList.add(new TransactionImpl(1, TransactionStatus.FAILED,
                "Pesho", "Gosho", 1000));
        transactionsList.add(new TransactionImpl(2, TransactionStatus.ABORTED,
                "Gosho", "Mimi", 230));
        transactionsList.add(new TransactionImpl(3, TransactionStatus.UNAUTHORIZED,
                "Mariika", "Ivan", 100.90));
        transactionsList.add(new TransactionImpl(4, TransactionStatus.SUCCESSFUL,
                "Ivan", "Spas", 150));

    }

    private void fillChainblock() {
        for (Transaction transaction : transactionsList) {
            chainblock.add(transaction);
        }
    }

    @Test
    public void testAddMethodShouldAddUniqueTransactions() {
        chainblock.add(transactionsList.get(0));
        assertTrue(chainblock.contains(transactionsList.get(0)));
        chainblock.add(transactionsList.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContainsMethodIfReturnTrueWhenTransactionPresent() {
        chainblock.add(transactionsList.get(0));
        assertTrue(chainblock.contains(transactionsList.get(0)));
    }

    @Test
    public void testContainsMethodIfReturnFalseWhenTransactionNotPresent() {
        assertFalse(chainblock.contains(transactionsList.get(0)));
    }

    @Test
    public void testCountMethodShouldReturnCorrectValue() {
        assertEquals(0, chainblock.getCount());
        chainblock.add(transactionsList.get(0));
        assertEquals(1, chainblock.getCount());
        chainblock.add(transactionsList.get(0));
        assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testChangeTransactionStatusShouldChangeStatusIfTransactionPresent() {
        chainblock.add(transactionsList.get(0));
        chainblock.changeTransactionStatus(1, TransactionStatus.ABORTED);
        assertEquals(TransactionStatus.ABORTED, chainblock.getById(1).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusShouldThrowExIfTransactionNotPresent() {
        chainblock.changeTransactionStatus(2, TransactionStatus.UNAUTHORIZED);
    }

    @Test
    public void testRemoveTransactionByIdShouldRemoveTransactionIfPresent() {
        fillChainblock();
        assertEquals(4, chainblock.getCount());
        chainblock.removeTransactionById(transactionsList.get(0).getId());
        assertEquals(3, chainblock.getCount());
        assertFalse(chainblock.contains(transactionsList.get(0).getId()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdShouldRThrowExIfTransactionNotPresent() {
        fillChainblock();
        chainblock.removeTransactionById(chainblock.getCount() + 1);
    }

    @Test
    public void testGetByIdShouldReturnCorrectTransactionIfPresent() {
        fillChainblock();
        Transaction expectedTransaction = transactionsList.get(1);
        Transaction actualTransaction = chainblock.getById(expectedTransaction.getId());
        assertEquals(expectedTransaction, actualTransaction);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdShouldThrowExIfTransactionNotPresent() {
        fillChainblock();
        chainblock.getById(chainblock.getCount() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusShouldThrowExIfTransactionNotPresent() {
        fillChainblock();
        chainblock.removeTransactionById(2);
        chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByTransactionStatusShouldReturnCorrectTransactions() {
        fillChainblock();
        List<Transaction> expectedList = transactionsList.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.ABORTED)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(result);

        List<Transaction> actualList = new ArrayList<>();
        result.forEach(actualList::add);

        assertEquals(expectedList.size(), actualList.size());
        for (Transaction transaction : actualList) {
            assertEquals(TransactionStatus.ABORTED, transaction.getStatus());
        }
    }

    @Test
    public void testGetByTransactionStatusShouldReturnCorrectTransactionsInCorrectOrder() {
        fillChainblock();
        List<Transaction> expectedList = transactionsList.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.ABORTED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(result);

        List<Transaction> actualList = new ArrayList<>();
        result.forEach(actualList::add);

        assertEquals(expectedList.size(), actualList.size());
        assertEquals(expectedList, actualList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusShouldThrowExIfTransactionNotPresent() {
        fillChainblock();
        chainblock.removeTransactionById(2);
        chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldReturnCorrectSendersInCorrectOrder() {
        fillChainblock();
        List<String> expectedList = transactionsList.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.ABORTED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> senders = chainblock.getAllSendersWithTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(senders);

        List<String> actualList = new ArrayList<>();
        senders.forEach(actualList::add);

        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
        assertEquals(expectedList, actualList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusShouldThrowExIfTransactionNotPresent() {
        fillChainblock();
        chainblock.removeTransactionById(2);
        chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusShouldReturnCorrectReceiversInCorrectOrder() {
        fillChainblock();
        List<String> expectedList = transactionsList.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.ABORTED)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        Iterable<String> receivers = chainblock.getAllReceiversWithTransactionStatus(TransactionStatus.ABORTED);
        assertNotNull(receivers);

        List<String> actualList = new ArrayList<>();
        receivers.forEach(actualList::add);

        assertEquals(expectedList.size(), actualList.size());
        for (int i = 0; i < expectedList.size(); i++) {
            assertEquals(expectedList.get(i), actualList.get(i));
        }
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> all = chainblock.getAllOrderedByAmountDescendingThenById();
        assertNotNull(all);

        List<Transaction> actual = new ArrayList<>();
        all.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingShouldThrowExIfSenderNotPresent() {
        fillChainblock();
        chainblock.getBySenderOrderedByAmountDescending("Spas");
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .filter(transaction -> transaction.getFrom().equals("Pesho"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getBySenderOrderedByAmountDescending("Pesho");
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdShouldThrowExIfReceiverNotPresent() {
        fillChainblock();
        chainblock.getByReceiverOrderedByAmountThenById("Mariika");
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .filter(transaction -> transaction.getTo().equals("Ivan"))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByReceiverOrderedByAmountThenById("Ivan");
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnEmptyCollection() {
        fillChainblock();
        //chainblock.removeTransactionById(2);

        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(
                TransactionStatus.ABORTED, 20);

        List<Transaction> listResult = new ArrayList<>();
        result.forEach(listResult::add);
        assertEquals(0, listResult.size());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .filter(transaction -> transaction.getStatus() == TransactionStatus.ABORTED)
                .filter(transaction -> transaction.getAmount() <= 320)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByTransactionStatusAndMaximumAmount(
                TransactionStatus.ABORTED, 320);
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingShouldThrowExIfNotPresent() {
        fillChainblock();
        chainblock.getBySenderAndMinimumAmountDescending("Gosho", 2000);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .filter(transaction -> transaction.getFrom().equals("Gosho"))
                .filter(transaction -> transaction.getAmount() > 20)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getBySenderAndMinimumAmountDescending(
                "Gosho", 20);
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeShouldThrowExIfNotPresent() {
        fillChainblock();
        chainblock.getByReceiverAndAmountRange("Mimi", 250, 300);
    }

    @Test
    public void testGetByReceiverAndAmountRangeShouldShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .filter(transaction -> transaction.getTo().equals("Mimi"))
                .filter(transaction -> transaction.getAmount() >= 200)
                .filter(transaction -> transaction.getAmount() < 300)
                .sorted(Comparator.comparing(Transaction::getAmount).reversed()
                        .thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getByReceiverAndAmountRange("Mimi", 200, 300);
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnEmptyCollection() {
        fillChainblock();

        Iterable<Transaction> result = chainblock.getAllInAmountRange(250, 300);

        List<Transaction> listResult = new ArrayList<>();
        result.forEach(listResult::add);
        assertEquals(0, listResult.size());
    }

    @Test
    public void testGetAllInAmountRangeShouldReturnCorrectValues() {
        fillChainblock();
        List<Transaction> expected = transactionsList.stream()
                .filter(transaction -> transaction.getAmount() >=  200)
                .filter(transaction -> transaction.getAmount() <= 300)
                .collect(Collectors.toList());

        Iterable<Transaction> result = chainblock.getAllInAmountRange(200, 300);
        assertNotNull(result);

        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
        assertEquals(expected, actual);
    }
}
