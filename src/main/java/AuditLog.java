import java.time.LocalDate;

public interface AuditLog {

    void printToAuditLog(String name, LocalDate date, int data);



}
