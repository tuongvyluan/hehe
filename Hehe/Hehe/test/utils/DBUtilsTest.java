/**
 * 
 */
package utils;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

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
	assertNotNull("Create connection failed!", DBUtils.getConnection());
    }

}