/**
 * 
 */
package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

/**
 * @author Tuong Vy Luan
 *
 */
class DBUtilsTest {

    /**
     * Test method for {@link utils.DBUtils#getConnection()}.
     * @throws SQLException 
     * @throws ClassNotFoundException 
     */
    @Test
    void testGetConnection() throws ClassNotFoundException, SQLException {
	assertNull(DBUtils.getConnection(), "Create connection failed!");
    }

}