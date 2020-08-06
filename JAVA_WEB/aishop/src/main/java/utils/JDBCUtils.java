package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource source = null;
    private static ThreadLocal<Connection> tl=new ThreadLocal<>();
    static {
        try {
            final InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties prop = new Properties();
            prop.load(is);

            // 获取数据源
            source = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取数据源
    public static DataSource getDataSource() {
        return source;
    }
    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection() throws SQLException {
        // 从线程中获取 conn
        Connection conn = tl.get();
        if(conn == null) {
            conn = source.getConnection();
            // 和当前线程绑定
            tl.set(conn);
        }
        return conn;
    }
    // 释放资源
    public static void closeResource(Statement st, ResultSet rs) {
        closeResultSet(rs);
        closeStatement(st);
    }

    // 释放资源
    public static void closeResource(Connection conn, Statement st, ResultSet rs) {
        closeResource(st, rs);
        closeConn(conn);
    }

    // 释放 connection
    public static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
                //和线程解绑
                tl.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    // 释放 statement ctrl + shift + f 格式化代码
    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            st = null;
        }
    }

    // 释放结果集
    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
    }


    //开启事务
    public static void startTransaction() throws SQLException{
        getConnection().setAutoCommit(false);
    }

    /**
     * 事务提交且释放连接
     */
    public static void commitAndClose(){
        Connection conn = null;
        try {
            conn=getConnection();
            //事务提交
            conn.commit();
            //关闭资源
            conn.close();
            //解除版定
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 事务回滚且释放资源
     */
    public static void rollbackAndClose(){
        Connection conn = null;
        try {
            conn=getConnection();
            //事务回滚
            conn.rollback();
            //关闭资源
            conn.close();
            //解除版定
            tl.remove();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }
}
