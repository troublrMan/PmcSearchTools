package selleck.config.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * 连接mysql时，未指定
 */
public class MybatisFactory252NotUseDB {
    private static SqlSessionFactory sqlSessionFactory = null;  

    /** 
     * 初始化Session工厂 
     * @throws IOException 
     */  
    private static void initialFactory() throws IOException {  
        String resource = "selleck/config/mybatis/mybatisConfig252NotUseDB.xml";  
        InputStream inputStream = Resources.getResourceAsStream(resource);  
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);  
    }  
    
    /** 
     * 获取Session 
     * @return 
     */  
    public static SqlSession getSession() {  
        if(sqlSessionFactory == null) {  
            try {  
                initialFactory();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return  sqlSessionFactory.openSession(true);  
    }
    
    /**
     * 开始事务
     * @param sqlSession
     * @return
     */
    public static Transaction beginTransaction(SqlSession sqlSession){
    	TransactionFactory transactionFactory = new JdbcTransactionFactory();   //事务工厂
    	try {
			sqlSession.getConnection().setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return transactionFactory.newTransaction(sqlSession.getConnection());
    }
}
