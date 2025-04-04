package davidrodriguez.com.uniquora.mockEntities.date;

import java.util.Date;

public class MockDates {
    public static final Date CREATED_AT = new Date();
    private static Date UPDATED_AT = CREATED_AT;

    public static Date getCreatedAt() {
        return CREATED_AT;
    }

    public static Date getUpdatedAt() {
        return UPDATED_AT;
    }

    public static void update() {
        UPDATED_AT = new Date();
    }
}
