package variant5_userpermissions;
import java.util.List;
import java.util.Objects;

public class Variant5_UserPermissions {

    //Value Objects з Guard Clauses (Fail-fast)
    public record Username(String value) {   // незмінний об'єкт
        public Username {
            Objects.requireNonNull(value, "Username must not be null");
            if (value.isBlank()) throw new IllegalArgumentException("Username must not be blank");
        }
    }

    public record Email(String value) {
        public Email {
            Objects.requireNonNull(value, "Email must not be null");
            if (value.isBlank() || !value.contains("@"))
                throw new IllegalArgumentException("Invalid email: " + value);
        }
    }

    public record PasswordHash(String value) {
        public PasswordHash {
            Objects.requireNonNull(value, "Password hash must not be null");
            if (value.isBlank()) throw new IllegalArgumentException("Password hash must not be blank");
        }

        public boolean matches(String candidate) {
            return value.equals(candidate);
        }

        @Override
        public String toString() { return "PasswordHash[***]"; } // секрет не потрапляє в логи
    }

    public record ApiKey(String value) {
        public ApiKey {
            Objects.requireNonNull(value, "API key must not be null");
            if (value.isBlank()) throw new IllegalArgumentException("API key must not be blank");
        }

        public boolean matches(String candidate) {
            return value.equals(candidate);
        }

        @Override
        public String toString() { return "ApiKey[***]"; }
    }

    // ---------- Рольові контракти ----------

    public interface Account {
        String getUsername();
        String getEmail();
    }

    public interface PasswordProtected extends Account {
        void changePassword(String oldPassword, String newPassword);
        void resetPassword(String temporaryPassword);
    }

    public interface Deactivatable extends Account {
        boolean isActive();
        void deleteAccount();
    }

    // ---------- Реалізації ----------
    public static class HumanUserAccount implements PasswordProtected, Deactivatable {
        private final Username username;
        private final Email email;
        private PasswordHash passwordHash;
        private boolean active = true;

        public HumanUserAccount(Username username, Email email, PasswordHash passwordHash) {
            this.username = Objects.requireNonNull(username, "username");
            this.email = Objects.requireNonNull(email, "email");
            this.passwordHash = Objects.requireNonNull(passwordHash, "passwordHash");
        }

        @Override public String getUsername() { return username.value(); }
        @Override public String getEmail() { return email.value(); }
        @Override public boolean isActive() { return active; }

        @Override
        public void changePassword(String oldPassword, String newPassword) {
            ensureActive();
            if (!passwordHash.matches(oldPassword)) throw new IllegalArgumentException("Invalid old password");
            this.passwordHash = new PasswordHash(newPassword);
            System.out.println("Password updated for user " + username.value());
        }

        @Override
        public void resetPassword(String temporaryPassword) {
            ensureActive();
            this.passwordHash = new PasswordHash(temporaryPassword);
            System.out.println("Password reset for user " + username.value());
        }

        @Override
        public void deleteAccount() {
            ensureActive();
            this.active = false;
            System.out.println("Account " + username.value() + " deactivated.");
        }

        // Інваріант: у деактивованого акаунта не можна змінювати стан.
        private void ensureActive() {
            if (!active) throw new IllegalStateException("Account " + username.value() + " is deactivated.");
        }
    }

    public static class ServiceAccount implements Account {
        private final Username username;
        private final Email email;
        private final ApiKey apiKey;

        public ServiceAccount(Username username, Email email, ApiKey apiKey) {
            this.username = Objects.requireNonNull(username, "username");
            this.email = Objects.requireNonNull(email, "email");
            this.apiKey = Objects.requireNonNull(apiKey, "apiKey");
        }

        @Override public String getUsername() { return username.value(); }
        @Override public String getEmail() { return email.value(); }

        public boolean verifyApiKey(String candidate) { return apiKey.matches(candidate); }
    }

    //Клієнтський код
    public static class AdminUserMaintenance {
        public void forcePasswordReset(PasswordProtected user, String temporaryPassword) {
            Objects.requireNonNull(user, "user");
            user.resetPassword(temporaryPassword);
        }

        // Масова обробка змішаного списку: Pattern Matching замість try/catch.
        public void resetAll(List<? extends Account> accounts, String temporaryPassword) {
            for (Account account : accounts) {
                if (account instanceof PasswordProtected protectedAccount) {
                    forcePasswordReset(protectedAccount, temporaryPassword);
                } else {
                    System.out.println("Skipped " + account.getUsername() + " (no password)");
                }
            }
        }
    }

    //Демонстрація
    public static void main(String[] args) {
        var admin = new AdminUserMaintenance();

        var user = new HumanUserAccount(
                new Username("ivan"), new Email("ivan@example.com"), new PasswordHash("old-hash"));
        var service = new ServiceAccount(
                new Username("backup-bot"), new Email("bot@example.com"), new ApiKey("key-123"));

        admin.resetAll(List.of(user, service), "temp-pass-1");

        user.changePassword("temp-pass-1", "new-pass");
        user.deleteAccount();

        try {
            admin.forcePasswordReset(user, "again");
        } catch (IllegalStateException e) {
            System.out.println("Fail-fast: " + e.getMessage());
        }

        try {
            new Email("not-an-email");
        } catch (IllegalArgumentException e) {
            System.out.println("Fail-fast: " + e.getMessage());
        }
    }
}