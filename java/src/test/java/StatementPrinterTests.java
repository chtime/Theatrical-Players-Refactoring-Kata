import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.approvaltests.Approvals.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {
        final Play hamlet = new Play("Hamlet", "tragedy");
        final Play as_like = new Play("As You Like It", "comedy");
        final Play othello = new Play("Othello", "tragedy");

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance(hamlet, 55),
                new Performance(as_like, 35),
                new Performance(othello, 40)));

        StatementPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice);

        verify(result);
    }

    @Test
    void statementWithNewPlayTypes() {
        final Play henry_v = new Play("Henry V", "history");
        final Play as_like = new Play("As You Like It", "pastoral");

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance(henry_v, 53),
                new Performance(as_like, 55)));

        StatementPrinter statementPrinter = new StatementPrinter();
        Assertions.assertThrows(Error.class, () -> statementPrinter.print(invoice));
    }
}
